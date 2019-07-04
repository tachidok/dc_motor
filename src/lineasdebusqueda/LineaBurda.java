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


package lineasdebusqueda;


import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Ésta es una línea de búsqueda "burda" tan sólo sirve para facilitar la evaluación
 * de métodos con y sin línea de búsqueda
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
