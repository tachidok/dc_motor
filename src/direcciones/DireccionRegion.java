/*					Código realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package direcciones;

import algebralineal.Matriz;

/**
 * Esta clase sirve como un adaptador para "sujetar" una dirección newton al
 * radio de confianza usado en los algoritmos de regiones de confianza
 */


public abstract class DireccionRegion {

	public abstract Matriz getDireccion(Matriz Xn,double regionConfianza);

}
