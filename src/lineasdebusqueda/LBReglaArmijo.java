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
 * Esta clase define una línea de búsqueda que usa la regla armijo.
 * @author Administrator
 *
 */
public class LBReglaArmijo extends EstrgsLineasBusqueda{

	private Backtracking backtracking;

	public LBReglaArmijo(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub

		backtracking=new Backtracking(F);
		CondicionDecremento c=backtracking.getCondicionDecrecimiento();
		c.setEstrategia(new CondicionArmijo(F));

	}

	@Override
	public double getLongitudDePaso(Matriz direccion, Matriz Fx) {
		// TODO Auto-generated method stub
		return backtracking.getLongitudDePaso(direccion, Fx);
	}

}
