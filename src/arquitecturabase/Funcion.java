/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package arquitecturabase;
import fabricaabstracta.Fabricas;
import problemasnolineales.MinimosCuadrados;
import problemasnolineales.OptimizacionSinRestricciones;
import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import algebralineal.Matriz;

/**
 * Esta clase es la raíz para una función F:R^n -> R^m
 *
 */


public abstract class Funcion {

	/**
	 * Número de variables de la función F
	 */
	private int numVariables;
	/**
	 * Número de funciones componente de la función F
	 */
	private int numFunciones;

	/**
	 * El tipo de problema a tratar. La función será evaluada de distintas maneras
	 * de acuerdo al problema no lineal a tratar. La clase ProblemaNoLineal
	 * es el contexto en el que se encuentra la función
	 */
	private ProblemaNoLineal problemaActual;
	private ProblemaNoLineal problemaAnterior;

	protected int contadorDeEvaluaciones;


	/**
	 *  Constructor que instancia una función
	 *
	 */
	public Funcion(int numVariables, int numFunciones)
     {
	   setNumVariables(numVariables);
	   setNumFunciones(numFunciones);
	   contadorDeEvaluaciones=0;
     }

	public void instanciarProblema()
	{
	  setProblemaActual(Fabricas.fabricaProblemaNoLineal.crearInstancia(this) );
	}



	/**
	 * Devuelve un escalar que representa el valor de la función, en el punto x, según el problema tratado
	 * @param x
	 * @return ||F||^2 ó ||F|| ó  F  dependiendo el problema no lineal en el que se encuentre la función
	 */

	public double evaluarDeAcuerdoAlProblema(Matriz x)
	{
	  return problemaActual.evaluarDeAcuerdoAlProblema(this,x);
	}

	/**
	 * Devuelve el valor de la primera derivada en el punto x, según el problema tratado.
	 * @param x
	 * @return Matriz DFx
	 */

	public Matriz primeraDerivada(Matriz x)
	{
		return problemaActual.primerDerivada(this, x);
	}

	/**
	 * Devuelve el valor de la primera derivada en el punto x, según el problema tratado.
	 * @param x
	 * @return Matriz DFx
	 */

	public Matriz primeraDerivada(double x[])
	{
		Matriz a=Fabricas.fabricaAlgebraLineal.crearInstancia(x);
		return problemaActual.primerDerivada(this, a);
	}

	/**
	 * Devuelve el tipo de problema con el que se trata la función
	 * @return Matriz
	 */

	public ProblemaNoLineal getProblemaActual() {
		return problemaActual;
	}

	/**
	 * Asigna el tipo de problema con el que se debe tratar la función
	 * @param tipoProblema
	 */

	public void setProblemaActual(ProblemaNoLineal tipoProblema) {
		this.problemaActual = tipoProblema;
	}

	/**
	 * Asigna el número de variables de la función
	 * @param numVariables
	 */

	public void setNumVariables(int numVariables) {
		this.numVariables = numVariables;
	}

	/**
	 * Devuelve el número de variables de la función
	 * @return número de variables
	 */

	public int getNumVariables() {
		return numVariables;
	}

	/**
	 * Asigna el número de funciones componente de la función
	 * @param numFunciones
	 */

	public void setNumFunciones(int numFunciones) {
		this.numFunciones = numFunciones;
	}

	/**
	 * Devuelve el número de funciones componente de la función
	 */

	public int getNumFunciones() {
		return numFunciones;
	}

	/**
	 *  Evalua a la función en el punto x
	 * @param x es una matriz (vector) de n x 1 elementos
	 * @return el valor de la función en el punto x
	 */
	public  Matriz evaluar(Matriz x){

		Matriz r=evaluarFuncion(x);
		return r;
	}


	/**
	 *  Este método será sobreescrito por el usuario para definir su función
	 * @param x
	 * @return
	 */
	protected abstract double [] evaluar(double []x);




	public double[] evaluarFuncion(double [] x)
	{
		contadorDeEvaluaciones++;
		return evaluar(x);
	}

	/**
	 * La función de este método es hacer una transición de el objeto Matriz x a un arreglo x[],
	 * esto para facilitar la evaluación de la función por parte del usuario
	 * @param x
	 * @return
	 */
	public Matriz evaluarFuncion(Matriz x)
	{
		double d[]=new double[x.numeroFilas()];

		for(int i=0;i<x.numeroFilas();i++)
			d[i]=x.getElemento(i, 0);

		double F[]=evaluarFuncion(d);
		double t[][]=new double[F.length][1];

		for(int i=0;i<F.length;i++)
			t[i][0]=F[i];

		return Fabricas.fabricaAlgebraLineal.crearInstancia(t);
	}

	/**
	 * Devuelve el valor del modelo lineal M = Fx + DFx * direccion, donde direccion es (x - xn)
	 *
	 * @param x
	 * @param direccion es el valor x - xn
	 * @return una Matriz que tiene el valor del modelo lineal M = Fx + DFx * direccion, donde direccion es (x - xn)
	 */
	public Matriz modeloLineal(Matriz x, Matriz direccion)
	{
		return problemaActual.modeloLineal(this, x, direccion);
	}

	/**
	 * Devuelve el modelo cuadrático M = Fx + DFx direccion + direccion DDFx direccion
	 * @param x
	 * @param direccion
	 * @return una Matriz con el valor del  modelo cuadrático M = Fx + DFx direccion + direccion DDFx direccion
	 */
	public Matriz modeloCuadratico(Matriz x, Matriz direccion)
	{
		return problemaActual.modeloCuadratico(this, x, direccion);
	}

	/**
	 * Devuelve la segunda derivada de la función F dependiendo del problema no lineal tratado
	 * @param x
	 * @return
	 */
	public Matriz segundaDerivada(Matriz x)
	{
		return problemaActual.segundaDerivada(this, x);
	}

	/**
	 * Devuelve el número de llamadas a la función
	 * @return número de llamadas a F
	 */

	public int getContadorDeEvaluaciones() {
		return contadorDeEvaluaciones;
	}


	/**
	 * Asigna el valor del contador de evaluaciones
	 *
	 * @param contadorDeEvaluaciones
	 */
	public void setContadorDeEvaluaciones(int contadorDeEvaluaciones) {
		this.contadorDeEvaluaciones = contadorDeEvaluaciones;
	}

	/**
	 * Cambia el contexto de la función hacia un problema de mínimos cuadrados
	 */
	public void cambiaraMC()
	{
		problemaAnterior=problemaActual;
		problemaActual=new MinimosCuadrados(this);
	}

	/**
	 * Cambia el contexto de la fución hacia un problema de ecuaciones no lineales
	 */
	public void cambiaraASNL()
	{
		problemaAnterior=problemaActual;
		problemaActual=new SistemasNoLineales(this);
	}

	/**
	 * Cambia el contexto de la función hacia un problema de minimización sin rectricciones
	 */

	public void cambiarMSR()
	{
		problemaAnterior=problemaActual;
		problemaActual=new OptimizacionSinRestricciones(this);
	}

	/**
	 * Cambia el contexto de la función hacia un estado anterior
	 */
	public void retornarAlEstadoPrevio()
	{
		problemaActual=problemaAnterior;
	}

}
