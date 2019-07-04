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
package criteriosdeparo;
import arquitecturabase.CriterioDeParo;

/**
 *Esta clase es un criterio de paro burdo (no hace nada),
 *tan sólo se creo para considerar este aspecto del método Newton
 *dentro de la arquitectura
 * @author Administrator
 *
 */
public class MiCriterioDeParo extends CriterioDeParo{

	@Override
	public boolean evaluar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double errorActual() {
		// TODO Auto-generated method stub
		return 0;
	}

}
