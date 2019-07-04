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
package derivadas;
import algebralineal.Matriz;
import arquitecturabase.Funcion;



/**
 * Esta clase es la raíz para una familia de clases que implementen algoritmos para calcular
 * gradiente, matriz jacobiana, matrices Quasi-Newton, etc. También sirve como base para
 * implementar la derivada de una función de forma analítica.
 *
 * @author Ricardo
 * @version 1.0
 *
 */

public abstract class DerivadaPrimerOrden {


	private double incremento;

	/**
	 * Función a derivar
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
	 * Asigna la función que se va a derivar
	 * @param f
	 */
	public void setF(Funcion f) {
		F = f;
	}

	/**
	 * Devuelve la función que se está derivando
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
