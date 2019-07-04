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
/**
 * Esta clase es la raíz de las clases que definen los distintos criterios de paro en el método Newton
 *
 * @author Ricardo
 * @version 1.0
 */
public abstract class CriterioDeParo {

	public abstract boolean evaluar();
	public abstract double errorActual();

}
