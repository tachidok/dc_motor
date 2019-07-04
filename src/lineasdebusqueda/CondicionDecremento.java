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
 * Esta clase es parte del patrón Estrategia usado para intercambiar distintas
 * condiciones de decremento en líneas de búsqueda"
 */
public  class CondicionDecremento {

	private Funcion F;
	private EstrgsCondicionDecremento estrategia;

	public CondicionDecremento(Funcion F)
	{
		this.F=F;
	}

/**
 *
 * @param alfa es la longitud de paso a evaluar
 * @param derivada es la primera derivada evaluada en el punto x
 * @param punto x
 * @return
 */

	public boolean evaluar(double alfa, Matriz direccion, double Fx, Matriz x)
	{
		return estrategia.evaluar(alfa,  direccion, Fx,x);
	}

	public void setEstrategia(EstrgsCondicionDecremento estrategia) {
	this.estrategia = estrategia;
	}

	public EstrgsCondicionDecremento getEstrategia() {
	return estrategia;
	}

	public void setF(Funcion f) {
		F = f;
	}

	public Funcion getF() {
		return F;
	}

}
