package EjemplosNewtons;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import criteriosdeparo.CriterioErrorRelativo;
//import criteriosdeparo.CriterioKelley;
import lineasdebusqueda.LineaDeBusqueda;
import algebralineal.Matriz;
import arquitecturabase.ComponentesNewton;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
import arquitecturabase.LongitudDePaso;
import arquitecturabase.NewtonImp;
import derivadas.DerivadaPrimerOrden;
import derivadas.DiferenciasGustavo;
import direcciones.DireccionSistemaNoLineal;
import fabricaabstracta.Fabricas;
import funciones.Chebyquad;
import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;

public class EjemploNewtonBasico {
	
	private int numVariables=9;
	
    public static void main(String args[]) {
    	
    	EjemploNewtonBasico ejemploNewtonBasico=new EjemploNewtonBasico();
    	
    	ejemploNewtonBasico.correr();
    }
    
    
    public void correr(){
    	
    	/*
    	 * Primero creo las fábricas para instanciar los objetos en la arquitectura.
    	 */
    	Fabricas.crearFabrica();
    	
    	/*
    	 * Enseguida lo que se tiene que hacer es elegir la función y la estrategia para
    	 * calcular su derivada. Usaré una de las que ya tengo.
    	 */    	
    	Funcion funcionChebyquad=new Chebyquad(numVariables,numVariables);
    	//Funcion funcionMotorDC = new MotorDC();
    	
    	DerivadaPrimerOrden estrategiaGustavo=new DiferenciasGustavo(funcionChebyquad);
    	
    	/*
    	 * Luego se escoge el problema no lineal a tratar y se le indica la estrategia para
    	 * calcular la derivada
    	 */
    	
    	ProblemaNoLineal problema = new SistemasNoLineales();    	
    	problema.setPrimeraDerivada(estrategiaGustavo);
    	       		   		
    	/*
    	 * Ahora creo el método que voy a usar. En este caso uso uno "vacio" que hice y luego cambiaré los componentes 
    	 * (la longitud de paso, dirección, etc.) dependiendo de lo que necesite
    	 * 
    	 */
    	
    	NewtonImp newton=new NewtonVacio(funcionChebyquad, problema);
    	ComponentesNewton componentes=newton.getComponentes();
    	/*
    	 * Le asigno el punto de inicio
    	 */
    	double x0[]=obtenerPuntoDeInicio();
    	newton.setX0(x0);
    	newton.setXn(x0);
    	
    	/*
    	 * Le asigno al newton la dirección. Usaré una que ya tengo.
    	 */
    	
    	DireccionNewton direccionNewton=new DireccionSistemaNoLineal(funcionChebyquad);
    	componentes.setDireccionNewton(direccionNewton);
    	
    	/*
    	 * Para la longitud de paso voy a usar una línea de búsqueda
    	 */    	
    	LongitudDePaso longitudDePaso=new LineaDeBusqueda(funcionChebyquad);
    	componentes.setLongitudDePaso(longitudDePaso);
    	
    	/*
    	 * Ahora asigno el criterio de paro. 
    	 */
    	
    	CriterioDeParo criterioParo=new CriterioErrorRelativo();
    	componentes.setCriterioDeParo(criterioParo);
    	
    	
    	CorrerNewton(newton);
    	
    }
    
    public void CorrerNewton(NewtonImp newton)
    {
    	
		CriterioDeParo criterio=newton.getComponentes().getCriterioDeParo();
		boolean continuar=true;
		int iteracion=0;

		continuar=true;

        imprimirNombresColumnas(numVariables);

		while(continuar)
		{
			long tiempoInicio=System.nanoTime();
			continuar=newton.iteraUsandoCriterio();
			long tiempoFinal=System.nanoTime()-tiempoInicio;
			iteracion++;
			imprimir(iteracion,tiempoFinal, newton.Fn(), newton.getXn(), criterio.errorActual());
	

		}
    	
    }
    
	public void imprimir(int iteracion, long tiempo, Matriz fn, Matriz xn, double error)
	{
		NumberFormat formato= new DecimalFormat("0.0000E0");
		//System.out.println(k+"\t"+formato.format(Q.normaF())+"\t"+formato.format(normaOriginal)+"\t"+formato.format(normaAproximada)+"\t"+formato.format(absoluto)+"\t"+formato.format(relativo));

		String t="";

		for(int i=0;i<xn.numeroFilas();i++)
				t+="\t"+formato.format(xn.getElemento(i, 0));

		System.out.println(iteracion+"\t"+formato.format(tiempo)+"\t"+formato.format(fn.normaFlexible())+"\t"+formato.format(error)+"\t"+t);
	}
	
	
	public void imprimirNombresColumnas(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
			s+="\t\t"+"X"+i;

		System.out.println("iter"+"\ttiempo"+"\t\t||f||"+"\t\tE. relativo");
	}

    
    
    
    
    public double[] obtenerPuntoDeInicio(){
    	/*
    	 * Declaro el punto de inicio y le asigno valores   	
    	 */
    	double 	x0[]=new double[numVariables];
    		for(int i=0;i<numVariables;i++)
    			x0[i]=((double)(i+1))/(numVariables+1);
    		
    		return x0;
    }
    
    


}
