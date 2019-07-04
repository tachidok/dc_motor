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


import problemasnolineales.MiPortaPapeles;
import fabricaabstracta.Fabricas;
import algebralineal.Matriz;
import algebralineal.ResSistemaLineal;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * Ésta es una implementación de la dirección Newton usada en
 * la resolución de sistemas no lineales
 *
 *   J x = F , donde J es la jacobiana de la función y F es la función evaluada
 *   en la iteración actual
 *
 */

public class DireccionSistemaNoLineal extends DireccionNewton {


	public DireccionSistemaNoLineal(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz x) {

		Matriz Fx=MiPortaPapeles.Fx;
		Matriz DFx=MiPortaPapeles.DFx;

		ResSistemaLineal r= (ResSistemaLineal) Fabricas.fabricaAlgebraLineal.LU(DFx);
		return r.resolver(Fx.por(-1.0));
	}



}
