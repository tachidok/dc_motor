/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package arquitecturabase;


import algebralineal.Matriz;

/**
 * Esta clase es la raíz de las clases que definen los distintas formas de calcular la dirección Newton
 *
 * @author Ricardo
 * @version 1.0
 */

public abstract class DireccionNewton {

	/**
	 * La función utilizada en el método Newton
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
	 * Devuelve la dirección Newton en el punto Xn. Xn es representando como una matriz de una columna.
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
	 * Devuelve la Funcion utilizar para calcular la dirección Newton
	 * @return Funcion
	 */
	public Funcion getF() {
		return F;
	}



}
