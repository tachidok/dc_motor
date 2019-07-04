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
 *Esta clase es una interface que define una familia de algoritmos para hacer la ortonormalizaci�n de
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
