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


package algebralineal;


/**
 *Esta clase es parte de un patrón Visitante encargado de dar flexibilidad para
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
