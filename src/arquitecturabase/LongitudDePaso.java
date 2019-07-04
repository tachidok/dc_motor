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

package arquitecturabase;

import algebralineal.Matriz;

/**
 * Esta clase es la raíz de las clases que definen las distintas formas de
 * calcular la longitud de paso en el método Newton
 *
 * @author Ricardo
 * @version 1.0
 */
public abstract class LongitudDePaso {

	/**
	 * Devuelve la longitud de paso para el método Newton
	 * @return
	 */
	public abstract double getLongitudDePaso(Matriz direccion, Matriz x);

}
