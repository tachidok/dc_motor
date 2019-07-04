package NewtonArmijoBFGS;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import algebralineal.Matriz;
import arquitecturabase.ComponentesNewton;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.Funcion;
import arquitecturabase.LongitudDePaso;
import arquitecturabase.NewtonImp;
import criteriosdeparo.CriterioErrorRelativo;
import derivadas.BFGS;
import derivadas.DerivadaPrimerOrden;
import derivadas.DerivadaSegundoOrden;
import derivadas.DiferenciasGustavo;
import direcciones.DireccionOptimizacion;
import fabricaabstracta.Fabricas;
import funciones.MotorDC;
import lineasdebusqueda.LBReglaArmijo;
import lineasdebusqueda.LineaDeBusqueda;
import problemasnolineales.OptimizacionSinRestricciones;
import problemasnolineales.ProblemaNoLineal;




public class NewtonArmijoBFGS {

	private int numVariables=3;
	
	public static void main(String args[]) 	
	{
		NewtonArmijoBFGS newton= new NewtonArmijoBFGS();
		newton.Correr();
	}
	
	
	public void Correr()
	{
		Fabricas.crearFabrica();
		NewtonImp newton= CrearNewton();
		CorrerNewton(newton);
	}

	public NewtonImp CrearNewton() 
	{
		//Creo el punto de inicio
		double x0[] = obtenerPuntoDeInicio();
			
		//Creo la función
		Funcion funcion = new MotorDC();

		//Estrategia para derivadas
		DerivadaPrimerOrden estrategiaGustavo=new DiferenciasGustavo(funcion);
		
		//Estrategia para segundas derivadas
		Matriz puntoInicio=Fabricas.fabricaAlgebraLineal.crearInstancia(x0);
		DerivadaSegundoOrden bfgs= new BFGS(funcion, puntoInicio);
		
		//Creo el problema
		ProblemaNoLineal problema = new OptimizacionSinRestricciones(funcion);
		problema.setPrimeraDerivada(estrategiaGustavo);
		problema.setSegundaDerivada(bfgs);
		
		

		//Voy a usar este Newton que es una especie de cascarón al cual se le asignan los componentes
		NewtonImp newton = new NewtonVacio(funcion, problema);		
		ComponentesNewton componente=newton.getComponentes();
		
		//Asigno la dirección
		DireccionOptimizacion dir= new DireccionOptimizacion(funcion);
		componente.setDireccionNewton(dir);
		
		
		//Asigno la longitud de paso
		LineaDeBusqueda longitudDePaso=new LineaDeBusqueda(funcion);
		longitudDePaso.setEstrategia(new LBReglaArmijo(funcion));
		componente.setLongitudDePaso(longitudDePaso);
		
		//Criterio de paro
		CriterioDeParo criterioParo=new CriterioErrorRelativo();
		componente.setCriterioDeParo(criterioParo);
		
		//Asigno el punto de inicio
		newton.setX0(x0);
		newton.setXn(x0);
		
		return newton;
		
	}
	
	
    public void CorrerNewton(NewtonImp newton)
    {    	
		CriterioDeParo criterio=newton.getComponentes().getCriterioDeParo();
		boolean continuar=true;
		int iteracion=0;

		continuar=true;

       /* imprimirNombresColumnas(numVariables);
        Matriz f0=newton.getFuncion().evaluarFuncion(newton.getXn());
        imprimir(0,0,f0,newton.getXn(), criterio.errorActual());*/
        
        long tiempoInicio=System.currentTimeMillis( );
		while(continuar)
		{
			//long tiempoInicio=System.nanoTime();
			continuar=newton.iteraUsandoCriterio();
			//long tiempoFinal=System.nanoTime()-tiempoInicio;
			iteracion++;
			//imprimir(iteracion,tiempoFinal, newton.Fn(), newton.getXn(), criterio.errorActual());
	

		}
		long tiempoFinal=(System.currentTimeMillis( )-tiempoInicio);
		imprimir(iteracion,tiempoFinal, newton.Fn(), newton.getXn(), criterio.errorActual());
    	
    }
    
	public void imprimir(int iteracion,long tiempo, Matriz fn, Matriz xn, double error)
	{
		NumberFormat formato= new DecimalFormat("0.0000000E0");

		String t="";

		for(int i=0;i<xn.numeroFilas();i++)
				t+="\t"+formato.format(xn.getElemento(i, 0));
		
		try {	
		BufferedWriter writer = new BufferedWriter(new FileWriter("DatosMotor.txt", true));
		writer.append(' ');
		writer.append(iteracion+"\t"+formato.format(tiempo)+"\t"+formato.format(fn.normaFlexible())+t+"\t"+formato.format(error));
		writer.newLine();
		 
		writer.close();
		}
		catch(Exception e){}

		System.out.println(iteracion+"\t"+formato.format(tiempo)+"\t"+formato.format(fn.normaFlexible())+t+"\t"+formato.format(error));
	}
	
	
	public void imprimirNombresColumnas(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
			s+="\t\t"+"K"+i;

		System.out.println("iter"+"\ttiempo"+"\t\t||f||"+ s + "\t\tE. relativo");
	}

    

	public double[] obtenerPuntoDeInicio() {
		return new double[] { 10.0, 10.0, 10.0 };
	}

}
