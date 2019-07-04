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
 * Ésta es una fábrica abstracta que sirve como raíz para las diversas fábricas encargadas de instanciar
 * la arquitectura para métodos del tipo Newton
 *
 * @author Ricardo
 * @version 1.0
 *
 */

public  abstract class FabricaAbstracta extends Modelo{

	/**
	 * variable usada para identificar a cada instancia de cada familia
	 */
	protected int instancia;

	/**
	 *  Crea y devuelve el objeto creado por la fábrica
	 * @return
	 */
	public abstract Object crearInstancia();

	/**
	 * Agrega una nueva instancia en la fábrica.
	 *
	 * Al sobrecargar este método se debe notificar a los observadores que se ha agregado
	 * una nueva instancia en la fábrica.
	 *
	 * @param idInstancia
	 * @param descripcion
	 */
	public abstract void add(int idInstancia,String descripcion);

	/**
	 * Constructor que asigna los distintos observadores
	 * @param observadores
	 */
	public FabricaAbstracta(ArrayList <Observador> observadores)
	{
		setObservadores(observadores);
	}

	public FabricaAbstracta()
	{

	}

	/**
	 * Asigna la instancia que se debe de agregar
	 * @param instancia
	 */

	public void setInstancia(int instancia) {
		this.instancia = instancia;
	}


	/**
	 * Devuelve la instancia que la fábrica está instanciando
	 * @return
	 */

	public int getInstancia() {
		return instancia;
	}

}
