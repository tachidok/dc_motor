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

import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import derivadas.DerivadaPrimerOrden;
import derivadas.DiferenciasGustavo;
import fabricaabstracta.Fabricas;
import funciones.Chebyquad;
import algebralineal.EsquemaGeneralMatrizAleatoria;
import algebralineal.Matriz;
import algebralineal.MatrizAproximada;
import arquitecturabase.Funcion;
/**
 * En esta clase se encuetran algunas pruebas para reducir una matriz por medio de
 * un muestreo aleatorio.
 *
 * La matriz reducida es la matriz jacobiana en el problema Chebyquad.
 *
 * @author Ricardo Serrato
 *
 */

public class ProbandoReduccionMatriz {

	private Funcion funcion;
	private DerivadaPrimerOrden estrategiaDF;
	private ProblemaNoLineal problema;
	private double[] x0;
	private MatrizAproximada esqAproxMatriz;


	/**
	 * En el constructor se especifica:
	 *
	 * 1)La Función a tratar.
	 * 2)El problema no lineal.
	 * 3)La manera de calcular las derivadas.
	 * 4) El esquema de aproximación con matrices aleatorias.
	 *
	 */

	public ProbandoReduccionMatriz()
	{

		int n=100;
		Fabricas.crearFabrica();
		funcion=new Chebyquad(n,n);
		estrategiaDF=new DiferenciasGustavo(funcion);
		problema=new SistemasNoLineales();
		esqAproxMatriz= new EsquemaGeneralMatrizAleatoria();

		//selecciono como quiero que se trate la funcion
		funcion.setProblemaActual(problema);

		//asigno la estrategia para diferencias finitas
		problema.setPrimeraDerivada(estrategiaDF);

		//  Punto inicial estándar
		x0=new double[n];
		for(int i=0;i<n;i++)
			x0[i]=((double)(i+1))/(n+1);

	}

	public void correrPrueba()
	{

		//Obtengo la derivada de la función
		Matriz jacobiana=funcion.primeraDerivada(x0);

		//obtengo matriz aleatoria reducida

		//Asigno la matriz que se quiere reducir
		esqAproxMatriz.setMatrizOriginal(jacobiana);

		//formato de salida de datos
		NumberFormat formato= new DecimalFormat("0.0000E0");


		System.out.println("k"+"\t"+"||Q||"+"\t"+"\t"+"Original ||A||"+"\t"+"Aprox. ||QQ'A||"+"\t"+"Error Absoluto"+"\t"+"Error relativo");


		for(int k=3;k<=jacobiana.numeroColumnas();k++)
		{
			//si quiero una matriz de k x n, uso setReduccion(k)
			esqAproxMatriz.setReduccion(k);

			try{

				//Obtengo la matriz ortonormal
				Matriz Q=esqAproxMatriz.getBaseOrtonormal();

				Matriz aproximada=Q.por(Q.transpuesta()).por(jacobiana);

				double normaOriginal=jacobiana.normaF();
				double normaAproximada=aproximada.normaF();
				double absoluto=jacobiana.menos(aproximada).normaF();
				double relativo=absoluto/normaOriginal;

				System.out.println(k+"\t"+formato.format(Q.normaF())+"\t"+formato.format(normaOriginal)+"\t"+formato.format(normaAproximada)+"\t"+formato.format(absoluto)+"\t"+formato.format(relativo));

			   }
			catch(Exception e)
			{
				System.out.print(e.getMessage());
				System.out.print(e.toString());
			}
		}

	}


	public static void main(String h[])
	{
		ProbandoReduccionMatriz prueba=new ProbandoReduccionMatriz();

		//prueba con punto standar
		prueba.correrPrueba();

/*
		//prueba con punto malo (lejos de la solución y mal condicionada)
		double xmalo[]={0.8340,0.8416,0.9510,0.9534,0.9645,0.9659,0.9877,0.9982,1.0053};
		prueba.setX0(xmalo);

		prueba.correrPrueba();

		//con este punto es rango deficiente
		double xmasmalo[]={0.8340,0.8340,0.9510,0.9534,0.9645,0.9659,0.9877,0.9982,1.0053};
		prueba.setX0(xmasmalo);

		prueba.correrPrueba();*/

	}







		//gets y sets


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

	public void setEsqAproxMatriz(MatrizAproximada esqAproxMatriz) {
		this.esqAproxMatriz = esqAproxMatriz;
	}

	public MatrizAproximada getEsqAproxMatriz() {
		return esqAproxMatriz;
	}

}
