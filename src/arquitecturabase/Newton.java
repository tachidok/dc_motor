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
import algebralineal.Matriz;

/**
 * Esta clase representa el nivel m�s alto de abstracci�n en la arquitectura Newton. La clase
 * Newton es la abstracci�n dentro del patr�n Bridge.
 * @author Ricardo
 * @version 1.0
 * @see NewtonImp
 *
 */

public abstract class Newton {

	/**
	 * Implementaci�n dentro del patr�n Bridge
	 */
	private NewtonImp implementacion;

	public Matriz getXn()
	{
		return implementacion.getXn();
	}

	/**
	 * Resuelve el problema no lineal utilizando el m�todo dado por NewtonImp
	 */
	public void resolver(){
		implementacion.resolver();
	}

	/**
	 * Realiza una iteraci�n para resolver el  problema no lineal utilizando el m�todo dado por NewtonImp
	 */
	public void itera(){
		implementacion.itera();

	}


	public boolean iteraUsandoCriterio()
	{
		return implementacion.iteraUsandoCriterio();
	}

	/**
	 * Asigna la implemntaci�n dentro del patr�n Bridge
	 * @param implementacion
	 */

	public void setImplementacion(NewtonImp implementacion){
		this.implementacion=implementacion;
	}

	/**
	 * Devuelve la implementaci�n dentro del patr�n Bridge
	 * @return
	 */
	public NewtonImp getImplementacion(){
		return implementacion;
	}


	public Matriz Fn()
	{
		return implementacion.Fn();
	}

	public void setImplementacion(NewtonImp metodo, double x0[], Funcion F)
 	{
 		setImplementacion(metodo);
 		metodo.setFuncion(F);
 		metodo.setX0(x0);
 		metodo.setXn(x0);
 	}






}
