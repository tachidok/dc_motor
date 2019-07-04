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

/**
 * Esta clase es parte de un patr�n estrategia y sirve para variar distintos algoritmos de l�neas de b�squeda
 *
 */
import arquitecturabase.Funcion;
/**
 *  Esta clase es una interfaz para la familia de clases que definen distintas
 *  estrategias para buscar longitudes de paso en l�neas de b�squeda
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
