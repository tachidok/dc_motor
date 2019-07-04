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
import algebralineal.Matriz;

/**
 * Esta clase representa el nivel más alto de abstracción en la arquitectura Newton. La clase
 * Newton es la abstracción dentro del patrón Bridge.
 * @author Ricardo
 * @version 1.0
 * @see NewtonImp
 *
 */

public abstract class Newton {

	/**
	 * Implementación dentro del patrón Bridge
	 */
	private NewtonImp implementacion;

	public Matriz getXn()
	{
		return implementacion.getXn();
	}

	/**
	 * Resuelve el problema no lineal utilizando el método dado por NewtonImp
	 */
	public void resolver(){
		implementacion.resolver();
	}

	/**
	 * Realiza una iteración para resolver el  problema no lineal utilizando el método dado por NewtonImp
	 */
	public void itera(){
		implementacion.itera();

	}


	public boolean iteraUsandoCriterio()
	{
		return implementacion.iteraUsandoCriterio();
	}

	/**
	 * Asigna la implemntación dentro del patrón Bridge
	 * @param implementacion
	 */

	public void setImplementacion(NewtonImp implementacion){
		this.implementacion=implementacion;
	}

	/**
	 * Devuelve la implementación dentro del patrón Bridge
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
