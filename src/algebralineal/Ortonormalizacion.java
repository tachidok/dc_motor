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
 *Esta clase es una interface que define una familia de algoritmos para hacer la ortonormalización de
 *una matriz A
 *
 */

public interface Ortonormalizacion {

	/**
	 * Devuelve la base ortonormal de A
	 * @param A
	 * @return la base ortonormal de A
	 */
	Matriz evaluar(Matriz A);
}
