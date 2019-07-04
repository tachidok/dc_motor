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
 * Esta clase es la ra�z para la familia de algoritmos para
 * reducir la dimensi�n de una matriz por medio de
 * t�cnicas aleatorias
 *
 * @author Administrator
 *
 */
public abstract class MatrizAproximada {


	/**
	 * Este valor es para cambiar el tama�o esperado
	 * de la matriz aproximada.
	 * La matriz resultante ser� de dimensi�n n x reduccion
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
