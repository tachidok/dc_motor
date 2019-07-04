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
/**
 * Esta clase es la ra�z de las clases que definen los distintos criterios de paro en el m�todo Newton
 *
 * @author Ricardo
 * @version 1.0
 */
public abstract class CriterioDeParo {

	public abstract boolean evaluar();
	public abstract double errorActual();

}
