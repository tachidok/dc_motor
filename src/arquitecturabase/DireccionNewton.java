/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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

package arquitecturabase;


import algebralineal.Matriz;

/**
 * Esta clase es la ra�z de las clases que definen los distintas formas de calcular la direcci�n Newton
 *
 * @author Ricardo
 * @version 1.0
 */

public abstract class DireccionNewton {

	/**
	 * La funci�n utilizada en el m�todo Newton
	 */
	private Funcion F;

	/**
	 * Constructor para instanciar una DireccionNewton
	 * @param F
	 */
	public DireccionNewton(Funcion F)
	{

		this.F=F;

	}

	/**
	 * Devuelve la direcci�n Newton en el punto Xn. Xn es representando como una matriz de una columna.
	 * @param Xn
	 * @return Matriz
	 */

	public abstract Matriz getDireccion(Matriz Xn);

	/**
	 * Asigna la funcion f para calcular la direccion de Newton
	 * @param f
	 */
	public void setF(Funcion f) {
		F = f;
	}

	/**
	 * Devuelve la Funcion utilizar para calcular la direcci�n Newton
	 * @return Funcion
	 */
	public Funcion getF() {
		return F;
	}



}
