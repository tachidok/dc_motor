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

package fabricaabstracta;
import java.util.ArrayList;

/**
 * �sta es una f�brica abstracta que sirve como ra�z para las diversas f�bricas encargadas de instanciar
 * la arquitectura para m�todos del tipo Newton
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
	 *  Crea y devuelve el objeto creado por la f�brica
	 * @return
	 */
	public abstract Object crearInstancia();

	/**
	 * Agrega una nueva instancia en la f�brica.
	 *
	 * Al sobrecargar este m�todo se debe notificar a los observadores que se ha agregado
	 * una nueva instancia en la f�brica.
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
	 * Devuelve la instancia que la f�brica est� instanciando
	 * @return
	 */

	public int getInstancia() {
		return instancia;
	}

}
