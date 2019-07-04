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

package problemasnolineales;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import derivadas.DerivadaPrimerOrden;
import derivadas.DerivadaSegundoOrden;
import fabricaabstracta.Fabricas;

/**
 * Esta clase es la ra�z para los distintos problemas no lineales. ProblemaNoLineal es
 * parte del patr�n Estado junto con Funci�n. Una clase concreta de ProblemaNoLineal es
 * un estado en el que se puede encontrar la funci�n.
 *
 * @author Ricardo
 * @version 1.0
 * @see Funcion, MinimosCuadrados, OptimizacionSinRestricciones, SistemasNoLineales
 */

public abstract class ProblemaNoLineal {

	/**
	 *	Algoritmo para calcular la primera derivada de la funci�n, o bien, la derivada
	 *  en forma anal�tica.
	 */
	private DerivadaPrimerOrden primeraDerivada;
	private DerivadaSegundoOrden segundaDerivada;

	/**
	 * Constructor del problema no lineal
	 */
	public ProblemaNoLineal(Funcion F)
	{
		setPrimeraDerivada(Fabricas.fabricaDerivadasPrimerOrden.crearInstancia(F));
		setSegundaDerivada(Fabricas.fabricaDerivadasSegundoOrden.crearInstancia(F));
	}

	public ProblemaNoLineal()
	{

	}

	/**
	 *  Devuelve un escalar que representa el calor de la funci�on F en el punto x, de acuerdo
	 *  al tipo de problema
	 *
	 * @param F
	 * @param x
	 * @return
	 */

	public abstract double evaluarDeAcuerdoAlProblema(Funcion F, Matriz x);

	/**
	 * Devuelve el valor de la primera derivada de acuerdo al problema no lineal
	 * @param F
	 * @param x
	 * @return
	 */
	public abstract Matriz primerDerivada(Funcion F, Matriz x);


	public abstract Matriz segundaDerivada(Funcion F, Matriz x);

	/**
	 * Devuelve el objeto utilizado para calcular la primera derivada
	 * @return
	 */

	public DerivadaPrimerOrden getPrimeraDerivada() {
		return primeraDerivada;
	}

	/**
	 * Asigna el objeto para calcular la primera derivada
	 * @param primeraDerivada
	 */
	public void setPrimeraDerivada(DerivadaPrimerOrden primeraDerivada) {
		this.primeraDerivada = primeraDerivada;
	}

	public abstract Matriz modeloLineal(Funcion F, Matriz x, Matriz direccion);

	public abstract Matriz modeloCuadratico(Funcion F, Matriz x, Matriz direccion);

	public void setSegundaDerivada(DerivadaSegundoOrden segundaDerivada) {
		this.segundaDerivada = segundaDerivada;
	}

	public DerivadaSegundoOrden getSegundaDerivada() {
		return segundaDerivada;
	}




}
