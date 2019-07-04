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

/**
 * Esta clase es una fachada para las clases Funcion, LongitudDePaso, DireccionNewton y CriterioDeParo
 *
 * @author Ricardo
 * @version 1.0
 * @see Funcion, LongitudDePaso, DireccionNewton, CriterioDeParo
 *
 *
 */

public class ComponentesNewton {

	/**
	 * La funci�n utilizada por el m�todo Newton
	 */
	private Funcion funcion;
	/**
	 * La longitud de paso utilizada por el m�todo
	 */
	private LongitudDePaso longitudDePaso;
	/**
	 * La direcci�n utilizada por el m�todo Newton
	 */

	private DireccionNewton direccionNewton;

	/**
	 * El criterio de paro utilizado por el m�todo Newton
	 */

	private CriterioDeParo criterioDeParo;

	/**
	 * Devuelve la funcion utilizada por el m�todo Newton
	 * @return Funcion
	 */

	public Funcion getFuncion() {
		return funcion;
	}

	/**
	 * Asigna la funcion a utilizar en el m�todo Newton
	 * @param funcion
	 *
	 */

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	/**
	 * Devuelve la longitud de paso a utilizar para el m�todo Newton
	 * @return LongitudDePaso
	 */
	public LongitudDePaso getLongitudDePaso() {
		return longitudDePaso;
	}

	/**
	 * Asigna la longitud de paso a utilizar en el m�todo Newton
	 * @param longitudDePaso
	 */

	public void setLongitudDePaso(LongitudDePaso longitudDePaso) {
		this.longitudDePaso = longitudDePaso;
	}

	/**
	 * Devuelve la direcci�n a utilizar en el m�todo Newton
	 * @return DireccionNewton
	 */
	public DireccionNewton getDireccionNewton() {
		return direccionNewton;
	}

	/**
	 * Asigna la direcci�n a utilizar en el m�todo Newton
	 * @param direccionNewton DireccionNewton
	 */

	public void setDireccionNewton(DireccionNewton direccionNewton) {
		this.direccionNewton = direccionNewton;
	}

	/**
	 * Devuelve el criterio de paro utilizado por el m�todo Newton
	 * @return CriterioDeParo
	 */

	public CriterioDeParo getCriterioDeParo() {
		return criterioDeParo;
	}

	/**
	 * Asigna el criterio de paro utilizado por el m�todo Newton
	 * @param criterioDeParo
	 */
	public void setCriterioDeParo(CriterioDeParo criterioDeParo) {
		this.criterioDeParo = criterioDeParo;
	}
}
