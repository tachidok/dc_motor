/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
 *
 *										por 
 *			   				   Ricardo Serrato Barrera
 *
 *								     Asesores:
 *			  			     Dr. Gustavo Rodr�guez G�mez
 *			 		         Dr. Sa�l Pomares Hern�ndez
 *			
 *			     				 1ro de diciembre 2011
 *
 *						Programador: Ricardo Serrato Barrera
 * 	
 */

package algebralineal;


/**
 *
 * Esta clase es una interfaz para utilizar paqueter�as de algebra lineal que implementen operaciones con matrices
 *
 * @author Ricardo Serrato
 * @version 1.0  29/08/2010
 * @see AdaptadorJaMaMatrix
 *
 *
 */

public interface   Matriz {


	/**
	 * Multiplicaci�n de matrices
	 *
	 * @param B Matriz a multiplicar
	 * @return A*B
	 */
	public abstract Matriz por(Matriz B);
	/**
	 * Multiplicaci�n de una matriz y un escalar
	 *
	 * @param s
	 * @return A*s
	 */
	public abstract Matriz por(double s);
	/**
	 *Suma de matrices
	 *
	 * @param B Matriz a sumar
	 * @return A+B
	 */
	public abstract Matriz mas(Matriz B);

	/**
	 *Devuelve el elemento de la fila i, columna j
	 *
	 * @param i
	 * @param j
	 * @return Elemento Aij
	 */
	public abstract double getElemento(int i, int j);

	/**
	 * Devuelve el n�mero de filas de la matriz
	 *
	 * @return n�mero de filas de la matriz
	 */

	public abstract int numeroFilas();

	/**
	 * Devuelve el n�mero de columnas de la matriz
	 *
	 * @return n�mero de columnas de la matriz
	 */
	public abstract int numeroColumnas();

	/**
	 * Devuelve el arreglo de la matriz
	 * @return
	 */

	public abstract double[][] getArreglo();

	/** Convierte la matriz en una cadena de caracteres
	 *
	 * @return cadena
	 */

	public abstract String toString();

	/**
	 * Norma 1
	 *
	 * @return suma de columna m�xima
	 */

	public abstract double norma1();

	/**
	 * Norma 2
	 *
	 * @return m�ximo valor singular
	 */
	public abstract double norma2();


	/**
	 * Norma Frobenius
	 *
	 * @return ra�z cuadrada de todos los elementos al cuadrado
	 */
	public abstract double normaF();

	/**
	 * Norma infinito
	 *
	 * @return m�ximo de la suma filas
	 */
	public abstract double normaInfinito();

	/**
	 *  Realiza la tranpuesta de la matriz
	 *
	 * @return Matriz transpuesta
	 */
	public abstract Matriz transpuesta();

	/**
	 * Se usa para obtener una submatriz
	 *
	 * @param filas es un arreglo con los �ndices de las filas
	 * @param columnas es un arreglo con los �ndices de las columnas
	 * @return una submatriz con con las filas especificadas ne el arreglo filas y
	 * las columnas especificadas con el arreglo columnas
	 */
	public abstract Matriz subMatriz(int filas[],int columnas[]);


	/**
	 *Se utiliza para obtener una submatriz
	 * @param fInicial es el �ndice de la fila inicial
	 * @param fFinal  es el �ndice de la fila final
	 * @param cInicial es el �ndice de la columna inicial
	 * @param cFinal es el �ndice de la columna final
	 *
	 * @return devuelve la sub matriz que va de las filas fInical a fFinal, y las
	 * columnas que van de cInicial a cFinal
	 */
	public abstract Matriz subMatriz(int fInicial, int fFinal, int cInicial, int cFinal);

	/**
	 *  Asigna a valor como el elemento ij de la matriz
	 * @param i
	 * @param j
	 * @param valor
	 */
	public abstract void set(int i, int j, double valor);

	/**
	 * Realiza la resta A - B
	 * @param B
	 * @return A - B
	 */
	public abstract Matriz menos(Matriz B);

	/**
	 * Devuelve el rango de la matriz
	 * @return el rango de la matriz
	 */
	public abstract int rango();

	/**
	 *  Realiza la comparaci�n entre dos matrices
	 * @param B es la matriz a comparar
	 * @return verdadero si las dos matrices son iguales, sino falso
	 */
	public boolean equals(Matriz B);

	public abstract void aceptarVisitante(NormaFlexible normaFlexible);

	public abstract double normaFlexible();


	public abstract double getCondicional();

	public abstract int getRango();

	public abstract double getDeterminante();
}
