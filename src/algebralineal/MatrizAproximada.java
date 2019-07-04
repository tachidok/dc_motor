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
/**
 *
 * Esta clase es la raíz para la familia de algoritmos para
 * reducir la dimensión de una matriz por medio de
 * técnicas aleatorias
 *
 * @author Administrator
 *
 */
public abstract class MatrizAproximada {


	/**
	 * Este valor es para cambiar el tamaño esperado
	 * de la matriz aproximada.
	 * La matriz resultante será de dimensión n x reduccion
	 */
	private int reduccion;
	private Matriz matrizOriginal;
	private Matriz baseOrtonormal;

	public abstract Matriz reducirMatriz() throws Exception;

	public MatrizAproximada()
	{

	}

	public MatrizAproximada(Matriz A) {
		setMatrizOriginal(A);
	}

	public void setReduccion(int reduccion) {
		this.reduccion = reduccion;
	}

	public int getReduccion() {
		return reduccion;
	}


	public void setMatrizOriginal(Matriz matrizOriginal) {
		this.matrizOriginal = matrizOriginal;
	}


	public Matriz getMatrizOriginal() {
		return matrizOriginal;
	}

	public void setBaseOrtonormal(Matriz baseOrtonormal) {
		this.baseOrtonormal = baseOrtonormal;
	}

	public Matriz getBaseOrtonormal() {
		return baseOrtonormal;
	}








}
