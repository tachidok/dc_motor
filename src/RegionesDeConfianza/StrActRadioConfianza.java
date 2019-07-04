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

package RegionesDeConfianza;
import algebralineal.Matriz;

/**
 *  Esta clases es parte del patrón estrategia. Sirve para utilizar distintas estrategias para
 *  actualizar el radio de confianza.
 */

public  abstract class StrActRadioConfianza {

	public abstract double getRadioConfianza();
	public abstract boolean actualizarRadioConfianza(double concoordancia, Matriz direccion);

}
