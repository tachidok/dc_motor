/*					Código realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
 *
 *										por
 *			   				   Ricardo Serrato Barrera
 *
 *								     Asesores:
 *			  			     Dr. Gustavo Rodríguez Gómez
 *			 		         Dr. Saúl Pomares Hernández
 *
 *			     				 1ro de diciembre 2011
 *
 *						Programador: Ricardo Serrato Barrera
 *
 */

package pruebasnewtonbluealeatorio;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import newtonsconcretos.NewtonClasico;
import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import vistas.VistaSobria;
import algebralineal.Matriz;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.Funcion;
import arquitecturabase.Newton;
import arquitecturabase.NewtonGenerico;
import arquitecturabase.NewtonImp;
import derivadas.DerivadaPrimerOrden;
import derivadas.DiferenciasGustavo;
import direcciones.PseudoDireccionRangoDinamico;
import direcciones.PseudoDireccionSVD;
import fabricaabstracta.Fabricas;
import funciones.Chebyquad;
/**
 * En esta clase se encuentran algunas pruebas usando una variante de la dirección Newton propuesta en
 * el artículo "Robust Methods for Non linear Equations" de J L Blue.
 *
 * La variante consiste en sustituir a la matriz Jacobiana por una matriz más pequeña
 * obtenida con un muestreo aleatorio.
 *
 * @author Administrator
 *
 */
public class ProbandoNewtonSDVAleatorio {

	private Funcion funcion;
	private DerivadaPrimerOrden estrategiaDF;
	private ProblemaNoLineal problema;
	private double[] x0;
	private NewtonImp metodo;
	private Newton newtonGenerico;
	private static int numVariables=9;
	private VistaSobria vista;




	public ProbandoNewtonSDVAleatorio()

	{
	//  Punto inicial estándar
		x0 = new double[numVariables];
		for(int i = 0; i< numVariables; i++)
			x0[i]=((double)(i+1))/(numVariables+1);

		Fabricas.crearFabrica();
		funcion=new Chebyquad(numVariables,numVariables);
		estrategiaDF=new DiferenciasGustavo(funcion);
		problema=new SistemasNoLineales();

		//asigno la estrategia para diferencias finitas
		problema.setPrimeraDerivada(estrategiaDF);

		//creo al Newton
		metodo=new NewtonClasico(funcion,problema);
		newtonGenerico=new NewtonGenerico(metodo, x0, funcion);

	}



	public void correr()
	{

		CriterioDeParo criterio=metodo.getComponentes().getCriterioDeParo();
		boolean continuar=true;
		int iteracion=0;

		continuar=true;

        imprimirNombresColumnas(numVariables);

		while(continuar)
		{
			long tiempoInicio=System.nanoTime();
			continuar=newtonGenerico.iteraUsandoCriterio();
			long tiempoFinal=System.nanoTime()-tiempoInicio;
			iteracion++;
			imprimir(iteracion,tiempoFinal, newtonGenerico.Fn(), newtonGenerico.getXn(), criterio.errorActual());
			dibujarEnGrafica(iteracion,tiempoFinal, newtonGenerico.Fn(), newtonGenerico.getXn(), criterio.errorActual());

		}
	}


	public void crearNuevaGrafica(String nombre)
	{
		vista.agregarFuncion(nombre);
	}


	public void imprimir(int iteracion,long tiempo, Matriz fn, Matriz xn, double error)
	{
		NumberFormat formato= new DecimalFormat("0.0000E0");
		//System.out.println(k+"\t"+formato.format(Q.normaF())+"\t"+formato.format(normaOriginal)+"\t"+formato.format(normaAproximada)+"\t"+formato.format(absoluto)+"\t"+formato.format(relativo));

		String t="";

		for(int i=0;i<xn.numeroFilas();i++)
				t+="\t"+formato.format(xn.getElemento(i, 0));

		System.out.println(iteracion+"\t"+formato.format(tiempo)+"\t"+formato.format(fn.normaFlexible())+"\t"+formato.format(error));
	}

	public void dibujarEnGrafica(int iteracion,long tiempo, Matriz fn, Matriz xn, double error)
	{
		if(vista!=null)
		vista.agregarPunto(iteracion, Math.log10(fn.normaFlexible()));
	}

	public void imprimirNombresColumnas(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
			s+="\t\t"+"X"+i;

		System.out.println("iter"+"\ttiempo"+"\t\t||f||"+"\t\tE. relativo");
	}





	public static void main(String g[])
	{
		ProbandoNewtonSDVAleatorio prueba;
		PseudoDireccionSVD pseudodireccion;
		VistaSobria vista=new VistaSobria("Gráfica",  "iteracion","||F||");


        //Newton clásico
        System.out.println("Newton clásico");
        prueba=new ProbandoNewtonSDVAleatorio();
        prueba.setVista(vista);
        vista.agregarFuncion("Newton clásico");
        prueba.correr();


        for(int k=0;k<4;k++){
        //Newton con pseudo dirección de rango completo
        System.out.println("Newton con pseudo dirección de rango:"+(numVariables-k));
        prueba=new ProbandoNewtonSDVAleatorio();
        prueba.setVista(vista);
        vista.agregarFuncion("Newton-pseudo-dirección-rango:"+(numVariables-k));
        pseudodireccion=new PseudoDireccionSVD(prueba.getFuncion());
        pseudodireccion.setRangoAproximado(numVariables-k);
        prueba.getMetodo().getComponentes().setDireccionNewton(pseudodireccion);
        prueba.correr();
        }

      //Newton psudodireccion rango dinámico
        System.out.println("Newton rango dinámico");
        prueba=new ProbandoNewtonSDVAleatorio();
        prueba.setVista(vista);
        vista.agregarFuncion("Newton rango dinámico");
        PseudoDireccionRangoDinamico pseudodirecciondinamica=new PseudoDireccionRangoDinamico(prueba.getFuncion());
        prueba.getMetodo().getComponentes().setDireccionNewton(pseudodirecciondinamica);
        prueba.correr();

	}









	///////////// GETS Y SETS/////////

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setEstrategiaDF(DerivadaPrimerOrden estrategiaDF) {
		this.estrategiaDF = estrategiaDF;
	}

	public DerivadaPrimerOrden getEstrategiaDF() {
		return estrategiaDF;
	}

	public void setProblema(ProblemaNoLineal problema) {
		this.problema = problema;
	}

	public ProblemaNoLineal getProblema() {
		return problema;
	}

	public void setX0(double[] x0) {
		this.x0 = x0;
	}

	public double[] getX0() {
		return x0;
	}

	public void setMetodo(NewtonImp metodo) {
		this.metodo = metodo;

		newtonGenerico.setImplementacion(metodo);
	}

	public NewtonImp getMetodo() {
		return metodo;
	}

	public VistaSobria getVista() {
		return vista;
	}



	public void setVista(VistaSobria vista) {
		this.vista = vista;
	}



}
