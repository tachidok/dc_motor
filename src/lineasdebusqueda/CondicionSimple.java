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

import PrecisionNumerica.MiPrecisionNumerica;
import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Esta clase contiene una condición de decremento simple  Fxn < Fxn+1,
 * es usada para las líneas de búsqueda y es parte del patrón estrategia
 *
 */

public class CondicionSimple extends EstrgsCondicionDecremento {


	private double delta;

	public CondicionSimple(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
		delta=1.0;
	}



	@Override
	public boolean evaluar(double alfa, Matriz direccion, double Fx, Matriz x) {
		// TODO Auto-generated method stub

		Matriz t=direccion.por(alfa);
		t=t.mas(x);

		double Fsiguiente=getF().evaluarDeAcuerdoAlProblema(t);

		if(Fx-Fsiguiente>=MiPrecisionNumerica.EPSILON*delta)
			return true;
		else return false;
	}

}
