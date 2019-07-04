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
 * �ste es un adaptador de una direcci�n Newton sujeta al radio de confianza
 * usado en los algoritmos de regi�n de confianza
 */


public class DireccionNewtonRegion extends DireccionRegion{

	private  DireccionNewton direccionNewton;
	private Funcion F;

	public DireccionNewtonRegion(Funcion F)
	{
		this.setF(F);
		direccionNewton=new DireccionSistemaNoLineal(F);
	}

	@Override
	public Matriz getDireccion(Matriz Xn, double regionConfianza) {
		// TODO Auto-generated method stub
		return direccionNewton.getDireccion(Xn);
	}

	/**
	 * Asigna la funci�n usada para calcular la direcci�n
	 * @param f
	 */
	public void setF(Funcion f) {
		F = f;
	}

	/**
	 * Devuelve la funci�n usada para calcular la direcci�n
	 * @return
	 */

	public Funcion getF() {
		return F;
	}

}
