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

package fabricaabstracta;
import java.util.ArrayList;


/**
 * Esta clase es la raíz para los distintos modelos para la interfaz gráfica (no confundir con los modelos
 * lineales y  cuadráticos) utilizados en la arquitectura Newton.
 * Modelo forma parte del patrón modelo vista controlador.
 *
 *
 * @author Ricardo
 * @version 1.0
 * @see Modelo, ModeloNewton, Vista, InstanciadorNewton, Observador, Controlador
 *
 */

public abstract class Modelo {

	/**
	 * Observadores del modelo
	 */
	protected ArrayList <Observador> observadores;


	public ArrayList<Observador> getObservadores() {
		return observadores;
	}

	/**
	 * Agrega un observador al modelo
	 * @param o
	 */
	public void addObservador(Observador o)
	{
		observadores.add(o);
	}

	/**
	 * Quita al observador obs de la lista de observadores
	 * @param o
	 */

	public void removeObservador(Observador obs)
	{
		observadores.remove(obs);
	}

	/**
	 * asigna un conjunto de observadores al modelo
	 * @param o
	 */

	public void setObservadores(ArrayList<Observador> o)
	{
	   observadores=o;
	}

}
