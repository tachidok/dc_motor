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

/**
 * Esta clase es parte de un patrón estrategia y sirve para variar distintos algoritmos de líneas de búsqueda
 *
 */
import arquitecturabase.Funcion;
/**
 *  Esta clase es una interfaz para la familia de clases que definen distintas
 *  estrategias para buscar longitudes de paso en líneas de búsqueda
 */


public abstract class EstrgsLineasBusqueda {

	private Funcion F;
	private CondicionDecremento condicionDecrecimiento;

	public EstrgsLineasBusqueda(Funcion F)
	{
		this.setF(F);
		condicionDecrecimiento= new CondicionDecremento(F);
	}



	public void setCondicionDecrecimiento(CondicionDecremento condicionDecrecimiento) {
		this.condicionDecrecimiento = condicionDecrecimiento;
	}

	public CondicionDecremento getCondicionDecrecimiento() {
		return condicionDecrecimiento;
	}
	public abstract double  getLongitudDePaso(Matriz direccion, Matriz Fx);

	public void setF(Funcion f) {
		F = f;
	}

	public Funcion getF() {
		return F;
	}
}
