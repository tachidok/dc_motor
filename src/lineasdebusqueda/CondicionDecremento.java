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

package lineasdebusqueda;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * Esta clase es parte del patr�n Estrategia usado para intercambiar distintas
 * condiciones de decremento en l�neas de b�squeda"
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
