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

package problemasnolineales;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import derivadas.DerivadaPrimerOrden;
import derivadas.DerivadaSegundoOrden;
import fabricaabstracta.Fabricas;

/**
 * Esta clase es la raíz para los distintos problemas no lineales. ProblemaNoLineal es
 * parte del patrón Estado junto con Función. Una clase concreta de ProblemaNoLineal es
 * un estado en el que se puede encontrar la función.
 *
 * @author Ricardo
 * @version 1.0
 * @see Funcion, MinimosCuadrados, OptimizacionSinRestricciones, SistemasNoLineales
 */

public abstract class ProblemaNoLineal {

	/**
	 *	Algoritmo para calcular la primera derivada de la función, o bien, la derivada
	 *  en forma analítica.
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
	 *  Devuelve un escalar que representa el calor de la funciï¿½on F en el punto x, de acuerdo
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
