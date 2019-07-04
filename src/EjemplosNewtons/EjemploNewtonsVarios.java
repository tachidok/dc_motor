package EjemplosNewtons;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import lineasdebusqueda.LineaDeBusqueda;
import criteriosdeparo.CriterioErrorRelativo;
import derivadas.DerivadaPrimerOrden;
import derivadas.DiferenciasGustavo;
import direcciones.DireccionSistemaNoLineal;
import direcciones.PseudoDireccionSVD;
import RegionesDeConfianza.HibridoDeBlue;
import algebralineal.Matriz;
import arquitecturabase.ComponentesNewton;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
import arquitecturabase.LongitudDePaso;
import arquitecturabase.NewtonImp;
import fabricaabstracta.Fabricas;
import funciones.Chebyquad;

public class EjemploNewtonsVarios {
	
	
	private Funcion funcion;
	private DerivadaPrimerOrden derivadaPrimerOrden;
	private ProblemaNoLineal problemaNoLineal;
	private int numVariables=9;
	
	 public static void main(String args[]) {
		 
		 EjemploNewtonsVarios ejemploNewtonsVarios=new EjemploNewtonsVarios();
		 ejemploNewtonsVarios.correr();
		 
	 }
	 
	 
	 public void correr(){
		 
		 //creo la fábrica
		 Fabricas.crearFabrica();
		 
		 //Creo la funcion, estrategia de derivadas y el problema no lineal
		 funcion=new Chebyquad(numVariables,numVariables);
		 derivadaPrimerOrden=new DiferenciasGustavo(funcion);;
		 problemaNoLineal=new SistemasNoLineales();    	
		 problemaNoLineal.setPrimeraDerivada(derivadaPrimerOrden);
		 
		 
		 // agrego los diferentes newtons a una lista
		 ArrayList<NewtonImp> listaNewtonsList=new ArrayList<>();		 
		 listaNewtonsList.add(instanciarNewtonBasico());
		 listaNewtonsList.add(instanciarNewtonHibridoBlue());
		 listaNewtonsList.add(instanciarNewtonSVDAleatoria());
		 
		 
		 //los corro e imprimo
		 for (NewtonImp newton : listaNewtonsList) {
			CorrerNewton(newton);
			
			System.out.println("\n");
		}
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
	    
		public void imprimir(int iteracion,long tiempo, Matriz fn, Matriz xn, double error)
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

	 
	 
	 /*
	  * Los siguientes métodos, son métodos fábricas en donde hago diversas instancias de newtons
	  */
	 
	 public NewtonImp instanciarNewtonBasico(){
		 
		 NewtonImp newton=instanciarNewtonVacio();
		 	ComponentesNewton componentes=newton.getComponentes();
		 			
		 	//dirección		
	    	DireccionNewton direccionNewton=new DireccionSistemaNoLineal(newton.getFuncion());
	    	componentes.setDireccionNewton(direccionNewton);

	    	//longitud
	    	LongitudDePaso longitudDePaso=new LineaDeBusqueda(newton.getFuncion());
	    	componentes.setLongitudDePaso(longitudDePaso);
	    	
	    	//criterio
	    	CriterioDeParo criterioParo=new CriterioErrorRelativo();
	    	componentes.setCriterioDeParo(criterioParo);
	    	
	    	
	    	return newton;
	 }
	 
	 
	 
	 public NewtonImp instanciarNewtonHibridoBlue(){
		 NewtonImp newton=instanciarNewtonVacio();
		 	ComponentesNewton componentes=newton.getComponentes();
		 			
		 	//dirección		
	    	DireccionNewton direccionNewton= new HibridoDeBlue(newton.getFuncion());
	    	componentes.setDireccionNewton(direccionNewton);

	    	//longitud
	    	LongitudDePaso longitudDePaso=new LineaDeBusqueda(newton.getFuncion());
	    	componentes.setLongitudDePaso(longitudDePaso);
	    	
	    	//criterio
	    	CriterioDeParo criterioParo=new CriterioErrorRelativo();
	    	componentes.setCriterioDeParo(criterioParo);
	    	
	    	
	    	return newton;
	 }
	 
	 public NewtonImp instanciarNewtonSVDAleatoria(){
		 NewtonImp newton=instanciarNewtonVacio();
		 	ComponentesNewton componentes=newton.getComponentes();
		 			
		 	//dirección		
	    	DireccionNewton direccionNewton= new PseudoDireccionSVD(newton.getFuncion());
	    	componentes.setDireccionNewton(direccionNewton);

	    	//longitud
	    	LongitudDePaso longitudDePaso=new LineaDeBusqueda(newton.getFuncion());
	    	componentes.setLongitudDePaso(longitudDePaso);
	    	
	    	//criterio
	    	CriterioDeParo criterioParo=new CriterioErrorRelativo();
	    	componentes.setCriterioDeParo(criterioParo);
	    	
	    	return newton;
	 }
	 
	 
	 public NewtonImp instanciarNewtonVacio(){
		 NewtonImp newton=new NewtonVacio(funcion, problemaNoLineal);
			double x0[]=obtenerPuntoDeInicio();
	    	newton.setX0(x0);
	    	newton.setXn(x0);
		 
		 return newton;
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
