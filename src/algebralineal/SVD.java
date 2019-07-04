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
 * �sta es una interfaz para adaptar paquetes de algebra lineal que
 * realicen la descomposici�n de valores singulares (SVD)
 */


public interface SVD {
	/**
	 * Devuelve los vectores singulares izquierdos
	 */
	public abstract Matriz  getV();


	/**
	 * Devuelve la matriz diagonal de valores singulares
	 */
	public abstract Matriz getS();


	/**
	 * Devuelve los vectores singulares derechos
	 */
	public abstract Matriz getU();

	/**
	 * Devuelve los valores singulares en un arreglo
	 *
	 * @return un arreglo con los valores singulares
	 */
	public abstract double[] getValoresSingulares();


}
