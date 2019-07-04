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
package derivadas;
import algebralineal.Matriz;
import arquitecturabase.Funcion;



/**
 * Esta clase es la ra�z para una familia de clases que implementen algoritmos para calcular
 * gradiente, matriz jacobiana, matrices Quasi-Newton, etc. Tambi�n sirve como base para
 * implementar la derivada de una funci�n de forma anal�tica.
 *
 * @author Ricardo
 * @version 1.0
 *
 */

public abstract class DerivadaPrimerOrden {


	private double incremento;

	/**
	 * Funci�n a derivar
	 */
    private Funcion F;



    /**
     * Constructor para calcular la derivada de F
     * @param F
     */

	public DerivadaPrimerOrden(Funcion F)
	{
		this.F=F;
	}

	/**
	 * Devuelve la primera derivada de F en el punto x
	 * @param x
	 * @return Matriz
	 */
	public Matriz evaluar(Matriz x)
	{
		double d[]=new double[x.numeroFilas()];

		for(int i=0;i<x.numeroFilas();i++)
			d[i]=x.getElemento(i, 0);

		Matriz jacobiana= evaluar(d);
		return jacobiana;
	}

	public abstract Matriz evaluar(double x[]);

	/**
	 * Asigna la funci�n que se va a derivar
	 * @param f
	 */
	public void setF(Funcion f) {
		F = f;
	}

	/**
	 * Devuelve la funci�n que se est� derivando
	 * @return
	 */
	public Funcion getF() {
		return F;
	}

	/**
	 * Asigna el incremento
	 * @param incremento
	 */
	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}

	/**
	 * Devuelve el incremento
	 * @return
	 */
	public double getIncremento() {
		return incremento;
	}

}
