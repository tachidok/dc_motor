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


package lineasdebusqueda;


import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * �sta es una l�nea de b�squeda "burda" tan s�lo sirve para facilitar la evaluaci�n
 * de m�todos con y sin l�nea de b�squeda
 * @author Administrator
 *
 */

public class LineaBurda extends EstrgsLineasBusqueda{

	public LineaBurda(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getLongitudDePaso(Matriz direccion, Matriz x) {
		// TODO Auto-generated method stub
		return 1;
	}

}
