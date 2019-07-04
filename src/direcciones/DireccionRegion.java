/*					C�digo realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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

package direcciones;

import algebralineal.Matriz;

/**
 * Esta clase sirve como un adaptador para "sujetar" una direcci�n newton al
 * radio de confianza usado en los algoritmos de regiones de confianza
 */


public abstract class DireccionRegion {

	public abstract Matriz getDireccion(Matriz Xn,double regionConfianza);

}
