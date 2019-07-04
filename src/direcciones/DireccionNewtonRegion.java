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
 * Éste es un adaptador de una dirección Newton sujeta al radio de confianza
 * usado en los algoritmos de región de confianza
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
	 * Asigna la función usada para calcular la dirección
	 * @param f
	 */
	public void setF(Funcion f) {
		F = f;
	}

	/**
	 * Devuelve la función usada para calcular la dirección
	 * @return
	 */

	public Funcion getF() {
		return F;
	}

}
