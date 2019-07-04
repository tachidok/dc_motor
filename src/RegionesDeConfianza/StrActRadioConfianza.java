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

package RegionesDeConfianza;
import algebralineal.Matriz;

/**
 *  Esta clases es parte del patr�n estrategia. Sirve para utilizar distintas estrategias para
 *  actualizar el radio de confianza.
 */

public  abstract class StrActRadioConfianza {

	public abstract double getRadioConfianza();
	public abstract boolean actualizarRadioConfianza(double concoordancia, Matriz direccion);

}
