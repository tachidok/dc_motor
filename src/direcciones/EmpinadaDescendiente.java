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

package direcciones;

import algebralineal.Matriz;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * �sta es una implementaci�n de un gradiente descendiente usado en
 *
 * los problemas de sistemas no lineales, m�nimos cuadrados y
 * optimizaci�n sin restricciones.
 *
 * Puede tomar la forma de:
 *
 *
 *  d= - g , donde g es el gradiente de una funci�n con dominio en R^n y rango en R
 *
 *  y
 *
 *  d= - J F , donde J es la Jacobiana y F es la funci�n evaluada en el punto actual. J*F es el gradiente
 *  			de una funci�n con dominio en R^n y rango en R^m, m>n
 *
 */

public class EmpinadaDescendiente extends DireccionNewton{

	public EmpinadaDescendiente(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz Xn) {

		//Funci�n de evaluaci�n
		Funcion F=getF();

		//trato la funci�n como un problema de m�nimos cuadrados
		// si se trata de una funci�n F: R^n -> R^m, m>1
		if(F.getNumFunciones()>1)
			//cambio la funci�n al estado de MC
			F.cambiaraMC();
		else
			//cambio la funci�n a el estado OSR
			F.cambiarMSR();

		//Obtengo el gradiente y cambio su direcci�n
		Matriz gradiente=F.primeraDerivada(Xn);
		gradiente=gradiente.por(-1.0);

		//Cambio de estado hacia el estado original
		F.retornarAlEstadoPrevio();

		return gradiente;
	}

}
