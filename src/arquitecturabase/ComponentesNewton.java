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
	 * La función utilizada por el método Newton
	 */
	private Funcion funcion;
	/**
	 * La longitud de paso utilizada por el método
	 */
	private LongitudDePaso longitudDePaso;
	/**
	 * La dirección utilizada por el método Newton
	 */

	private DireccionNewton direccionNewton;

	/**
	 * El criterio de paro utilizado por el método Newton
	 */

	private CriterioDeParo criterioDeParo;

	/**
	 * Devuelve la funcion utilizada por el método Newton
	 * @return Funcion
	 */

	public Funcion getFuncion() {
		return funcion;
	}

	/**
	 * Asigna la funcion a utilizar en el método Newton
	 * @param funcion
	 *
	 */

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	/**
	 * Devuelve la longitud de paso a utilizar para el método Newton
	 * @return LongitudDePaso
	 */
	public LongitudDePaso getLongitudDePaso() {
		return longitudDePaso;
	}

	/**
	 * Asigna la longitud de paso a utilizar en el método Newton
	 * @param longitudDePaso
	 */

	public void setLongitudDePaso(LongitudDePaso longitudDePaso) {
		this.longitudDePaso = longitudDePaso;
	}

	/**
	 * Devuelve la dirección a utilizar en el método Newton
	 * @return DireccionNewton
	 */
	public DireccionNewton getDireccionNewton() {
		return direccionNewton;
	}

	/**
	 * Asigna la dirección a utilizar en el método Newton
	 * @param direccionNewton DireccionNewton
	 */

	public void setDireccionNewton(DireccionNewton direccionNewton) {
		this.direccionNewton = direccionNewton;
	}

	/**
	 * Devuelve el criterio de paro utilizado por el método Newton
	 * @return CriterioDeParo
	 */

	public CriterioDeParo getCriterioDeParo() {
		return criterioDeParo;
	}

	/**
	 * Asigna el criterio de paro utilizado por el método Newton
	 * @param criterioDeParo
	 */
	public void setCriterioDeParo(CriterioDeParo criterioDeParo) {
		this.criterioDeParo = criterioDeParo;
	}
}
