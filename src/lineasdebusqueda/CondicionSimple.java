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

import PrecisionNumerica.MiPrecisionNumerica;
import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Esta clase contiene una condici�n de decremento simple  Fxn < Fxn+1,
 * es usada para las l�neas de b�squeda y es parte del patr�n estrategia
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
