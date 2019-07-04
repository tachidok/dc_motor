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


package lineasdebusqueda;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * Esta clase es una interfaz para la familia de clases que definen distintas condiciones de
 * decremento en líneas de búsqueda. Es parte de un patrón Estrategia.
 */
public abstract class EstrgsCondicionDecremento {

	private Funcion F;

	public  EstrgsCondicionDecremento(Funcion F)
	{
		this.F=F;
	}

	public abstract boolean evaluar(double alfa, Matriz direccion, double Fx, Matriz Xn);

	public void setF(Funcion f) {
		F = f;
	}

	public Funcion getF() {
		return F;
	}
}
