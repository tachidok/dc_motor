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


package algebralineal;


/**
 *Esta clase es parte de un patr�n Visitante encargado de dar flexibilidad para
 *instanciar diversas normas en la arquitectura.
 *
 *
 */

public class NormaEuclidiana extends NormaFlexible{

	@Override
	public double evaluarNorma(Matriz matriz) {
		// TODO Auto-generated method stub

		return matriz.normaF();
	}

}
