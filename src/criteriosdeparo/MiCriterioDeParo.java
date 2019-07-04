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
package criteriosdeparo;
import arquitecturabase.CriterioDeParo;

/**
 *Esta clase es un criterio de paro burdo (no hace nada),
 *tan s�lo se creo para considerar este aspecto del m�todo Newton
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
