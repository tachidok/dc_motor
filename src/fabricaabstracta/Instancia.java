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

/**
 * Esta clase se utiliza para asociar a cada posible instancia, usada en la arquitectura,
 * con su fábrica correspondiente
 * @author Ricardo
 *
 */
public class Instancia {

	/**
	 * Fábrica  de la instancia
	 */
	private FabricaAbstracta instanciadorNewton;

	/**
	 *Identificador de la instancia
	 */
	private int idInstancia;

	/**
	 * Descripción de la instancia
	 */
	private String descripcion;

	/**
	 * Construye un objeto instancia a partir de su fábrica, identificador y descripcion
	 * @param i
	 * @param idInstancia
	 * @param descripcion
	 */
	public Instancia(FabricaAbstracta fabrica, int idInstancia, String descripcion)
	{
		this.instanciadorNewton=fabrica;
		this.idInstancia=idInstancia;
		this.descripcion=descripcion;
	}

	/**
	 * Asigna la fábrica asociada a la instancia
	 * @param instanciadorNewton
	 */
	public void setInstanciadorNewton(FabricaAbstracta instanciadorNewton) {
		this.instanciadorNewton = instanciadorNewton;
	}

	/**
	 * Devuelve la fábrica correspondiente a la instancia
	 * @return
	 */
	public FabricaAbstracta getInstanciadorNewton() {
		return instanciadorNewton;
	}

	/**
	 * Asigna el identificador de la instancia
	 *
	 * @param idInstancia
	 */

	public void setIdInstancia(int idInstancia) {
		this.idInstancia = idInstancia;
	}

	/**
	 * Devuelve el identificador de la instancia
	 * @return
	 */
	public int getIdInstancia() {
		return idInstancia;
	}

	/**
	 * Asigna la descripción de la instancia
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve la descripción de la instancia
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

    @Override
	public String toString()
	{
		return descripcion;
	}

}
