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
package algebralineal;

import fabricaabstracta.Fabricas;
import Jama.*;

/**

 *
 *
 * Esta clase es un adaptador para la clase Matrix del paquete JAMA: Java Matrix Package
 *
 * @author Ricardo Serrato
 * @version 1.0  29/08/2010
 * @see Matriz
 *
 *
 */

public class AdaptadorJaMaMatrix implements Matriz {

	private NormaFlexible normaVisitante;
	private Matrix A;

	/**
	 * Crea una Matriz de n x 1 con los n elementos de x
	 */
	public AdaptadorJaMaMatrix(double x[])
	{
		A=new Matrix(x.length,1);

		for(int i=0;i<x.length;i++)
			A.set(i, 0, x[i]);

		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}


	/**
	 *  Crea un objeto Matriz de 0 filas y 0 columnas, a partir de un objeto Matriz del paquete JaMa
	 */
	public AdaptadorJaMaMatrix()
	{
		A=new Matrix(0,0);
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	/**
	 * Crea un objeto Matriz a partir de un objeto Matrix del paquete JaMa
	 * @param A
	 */

	public AdaptadorJaMaMatrix(Matrix A)
	{
		this.A=A;
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	/**
	 * Crea una matriz a partir de un arreglo 2D
	 * @param A
	 */

	public AdaptadorJaMaMatrix(double[][] A) {
		this.A=new Matrix(A);
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	/**
	 * Crea una matriz m x n
	 *
	 * @param A Valores de la matriz
	 * @param m Columnas
	 * @param n Filas
	 */
	public AdaptadorJaMaMatrix(double[][] A, int n, int m) {
		this.A=new Matrix(A,m,n);
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	/**
	 * Crea una matriz de ceros
	 * @param n Filas
	 * @param m Columnas
	 */

	public AdaptadorJaMaMatrix(int n, int m) {
		this.A=new Matrix(n,m);
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	/**
	 *  Crea una matriz de m x n
	 *
	 * @param n Filas
	 * @param m Columnas
	 * @param s
	 */
	public AdaptadorJaMaMatrix(int n, int m, double s) {
		this.A=new Matrix(n,m,s);
		normaVisitante=Fabricas.fabricaDeNormas.crearInstancia();
	}

	@Override
	public Matriz mas(Matriz B) {

		Matrix C=A.plus(((AdaptadorJaMaMatrix)B).getJaMaMatrix());
		return new AdaptadorJaMaMatrix(C);
	}

	@Override
	public Matriz por(Matriz B) {

		Matrix C=A.times(((AdaptadorJaMaMatrix)B).getJaMaMatrix());
		return new AdaptadorJaMaMatrix(C);
	}

	@Override
	public double getElemento(int i, int j) {
		return A.get(i,j);
	}

	@Override
	public int numeroFilas() {
		return A.getRowDimension();
	}

	@Override
	public int numeroColumnas() {
		return A.getColumnDimension();
	}

	private Matrix getJaMaMatrix()
	{
		return A;
	}

	@Override
	public Matriz por(double s) {
		Matrix C=A.times(s);
		return new AdaptadorJaMaMatrix(C);
	}

	@Override
	public double[][] getArreglo() {
		// TODO Auto-generated method stub
		return A.getArray();
	}


	/**
	 *  Devuelve una cadena de caracteres que representa la matriz
	 */

	public String toString()
	{
		String s="";
		double a[][]= A.getArray();

		for(int i=0;i<a.length;i++)
		{
			s+="\n";
			for(int j=0;j<a[0].length;j++)
			{
				s+=" "+a[i][j];
			}
		}

		return s;
	}

	@Override
	public double norma1() {

		return A.norm1();
	}

	@Override
	public double norma2() {
		// TODO Auto-generated method stub
		return A.norm2();
	}

	@Override
	public double normaF() {
		// TODO Auto-generated method stub
		return A.normF();
	}

	@Override
	public double normaInfinito() {
		// TODO Auto-generated method stub
		return A.normInf();
	}

	@Override
	public Matriz transpuesta() {
		// TODO Auto-generated method stub

		Matriz C=new AdaptadorJaMaMatrix(A.transpose());
		return C;
	}

	@Override
	public Matriz subMatriz(int[] filas, int[] columnas) {

		Matriz C=new AdaptadorJaMaMatrix(A.getMatrix(filas, columnas));

		return C;
	}

	@Override
	public Matriz subMatriz(int fInicial, int fFinal, int cInicial, int cFinal) {

		Matriz C=new AdaptadorJaMaMatrix(A.getMatrix(fInicial,fFinal,cInicial,cFinal));
		return C;
	}

	@Override
	public void set(int i, int j, double valor) {
		A.set(i, j, valor);
	}

	@Override
	public Matriz menos(Matriz B) {
		Matrix C=A.minus(((AdaptadorJaMaMatrix)B).getJaMaMatrix());
		return new AdaptadorJaMaMatrix(C);
	}

	@Override
	public int rango() {
		// TODO Auto-generated method stub
		return A.rank();
	}

	@Override
	public boolean equals(Matriz B) {
		// TODO Auto-generated method stub

		if(B.numeroColumnas()!=A.getColumnDimension() ||  B.numeroFilas()!=A.getRowDimension())
		return false;

		double a=0.0;
		for(int i=0;i<B.numeroFilas();i++)
			for(int j=0;j<B.numeroColumnas();j++)
			{
				a+=B.getElemento(i, j)-A.get(i, j);
			}

		if(a==0.0)
			return true;



		return false;
	}

	@Override
	public void aceptarVisitante(NormaFlexible normaFlexible) {
		// TODO Auto-generated method stub
		normaVisitante=normaFlexible;
	}

	@Override
	public double normaFlexible() {
		// TODO Auto-generated method stub
		return normaVisitante.evaluarNorma(this);
	}


	@Override
	public double getCondicional() {

		return A.cond();
	}


	@Override
	public int getRango() {
		// TODO Auto-generated method stub
		return A.rank();
	}


	@Override
	public double getDeterminante() {
		// TODO Auto-generated method stub
		return A.det();
	}






}
