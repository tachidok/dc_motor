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
 *
 *
 *
 *	Ésta es la condición de decremento usada en la regla Armijo
 *  ver
 *
 *  el libro de  Kelley Solving nonlinear equations with Newton's Method página 11
 *
 *  y
 *  el paper
 *  MINIMIZATION OF FUNCTIONS HAVING LIPSCHITZ CONTINUOUS FIRST PARTIAL DERIVATIVES
 *	de Larry Armijo
 * @author Ricardo
 */

public class CondicionArmijo extends EstrgsCondicionDecremento{

	private double tolerancia;
	private double delta;


	public CondicionArmijo(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub

		tolerancia=1.0e-3;
		delta=/*1.0e-12;*/MiPrecisionNumerica.EPSILON;
	}

	@Override
	public boolean evaluar(double alfa, Matriz direccion, double Fx, Matriz Xn) {
		// TODO Auto-generated method stub

		//F(X  +  alfa *  d ) <= F(X) - alfa*tolerancia F(x)


		//obtengo el valor de la función con la longitud alfa
		//F(X  +  alfa *  d )
		Matriz t=direccion.por(alfa);
		t=t.mas(Xn);
		double Fsiguiente=getF().evaluarDeAcuerdoAlProblema(t);

		//obtengo  alfa*tolerancia F(x)

		double alfaTolFx=alfa*Fx*tolerancia;


		//al evaluar voy a reordenar para evitar la resta

		//en vez de hacer esto
		//F(X  +  alfa *  d ) <= F(X) - alfa*tolerancia F(x)

		//hago esto
		//F(X  +  alfa *  d ) +  alfa*tolerancia F(x) < F(X) + error

		if(Fsiguiente + alfaTolFx < Fx + delta)
			return true;
		return false;
	}

	public void setTolerancia(double tolerancia) {
		this.tolerancia = tolerancia;
	}

	public double getTolerancia() {
		return tolerancia;
	}

}
