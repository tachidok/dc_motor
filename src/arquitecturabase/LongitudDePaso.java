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

package arquitecturabase;

import algebralineal.Matriz;

/**
 * Esta clase es la ra�z de las clases que definen las distintas formas de
 * calcular la longitud de paso en el m�todo Newton
 *
 * @author Ricardo
 * @version 1.0
 */
public abstract class LongitudDePaso {

	/**
	 * Devuelve la longitud de paso para el m�todo Newton
	 * @return
	 */
	public abstract double getLongitudDePaso(Matriz direccion, Matriz x);

}
