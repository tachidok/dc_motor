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
 * Ésta es una interfaz para adaptar paquetes de algebra lineal que
 * realicen la descomposición de valores singulares (SVD)
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
