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

package direcciones;

import algebralineal.Matriz;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * Ésta es una implementación de un gradiente descendiente usado en
 *
 * los problemas de sistemas no lineales, mínimos cuadrados y
 * optimización sin restricciones.
 *
 * Puede tomar la forma de:
 *
 *
 *  d= - g , donde g es el gradiente de una función con dominio en R^n y rango en R
 *
 *  y
 *
 *  d= - J F , donde J es la Jacobiana y F es la función evaluada en el punto actual. J*F es el gradiente
 *  			de una función con dominio en R^n y rango en R^m, m>n
 *
 */

public class EmpinadaDescendiente extends DireccionNewton{

	public EmpinadaDescendiente(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz Xn) {

		//Función de evaluación
		Funcion F=getF();

		//trato la función como un problema de mínimos cuadrados
		// si se trata de una función F: R^n -> R^m, m>1
		if(F.getNumFunciones()>1)
			//cambio la función al estado de MC
			F.cambiaraMC();
		else
			//cambio la función a el estado OSR
			F.cambiarMSR();

		//Obtengo el gradiente y cambio su dirección
		Matriz gradiente=F.primeraDerivada(Xn);
		gradiente=gradiente.por(-1.0);

		//Cambio de estado hacia el estado original
		F.retornarAlEstadoPrevio();

		return gradiente;
	}

}
