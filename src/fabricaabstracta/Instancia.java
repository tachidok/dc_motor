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

/**
 * Esta clase se utiliza para asociar a cada posible instancia, usada en la arquitectura,
 * con su f�brica correspondiente
 * @author Ricardo
 *
 */
public class Instancia {

	/**
	 * F�brica  de la instancia
	 */
	private FabricaAbstracta instanciadorNewton;

	/**
	 *Identificador de la instancia
	 */
	private int idInstancia;

	/**
	 * Descripci�n de la instancia
	 */
	private String descripcion;

	/**
	 * Construye un objeto instancia a partir de su f�brica, identificador y descripcion
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
	 * Asigna la f�brica asociada a la instancia
	 * @param instanciadorNewton
	 */
	public void setInstanciadorNewton(FabricaAbstracta instanciadorNewton) {
		this.instanciadorNewton = instanciadorNewton;
	}

	/**
	 * Devuelve la f�brica correspondiente a la instancia
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
	 * Asigna la descripci�n de la instancia
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve la descripci�n de la instancia
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
