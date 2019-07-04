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


import problemasnolineales.MiPortaPapeles;
import fabricaabstracta.Fabricas;
import algebralineal.Matriz;
import algebralineal.ResSistemaLineal;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * �sta es una implementaci�n de la direcci�n Newton usada en
 * la resoluci�n de sistemas no lineales
 *
 *   J x = F , donde J es la jacobiana de la funci�n y F es la funci�n evaluada
 *   en la iteraci�n actual
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
