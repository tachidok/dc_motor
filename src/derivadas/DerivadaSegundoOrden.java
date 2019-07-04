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
 *
 * Ésta es la clase raíz de una familia de clases para aproximar una derivada de segundo orden, ya sea
 * por una actualización Quasi-Newton, diferencias finitas o analíticamente
 * @author Ricardo
 *
 */
public abstract class DerivadaSegundoOrden {
	private Funcion F;


/**
 * Constructor para los distintos criterios para calcular derivadas de segundo orden
 * @param F
 */
	public DerivadaSegundoOrden(Funcion F)
	{
		this.F=F;
	}

	/**
	 * Este método es un adaptador para que se le facilite al usuario
	 * la implementación de su criterio para aproximar derivadas de segundo orden.
	 *
	 * Hace la transición del objeto Matriz x a un arreglo x[]
	 *
	 * @param x vector a evaluar
	 *
	 * @return un objeto Matriz de n x n elementos (generalmente será una aproximación de una matriz hessiana)
	 */
	public Matriz evaluar(Matriz x)
	{
		double d[]=new double[x.numeroFilas()];

		for(int i=0;i<x.numeroFilas();i++)
			d[i]=x.getElemento(i, 0);

		Matriz jacobiana= evaluar(d);
		return jacobiana;
	}

	/**
	 * Este método es la interfaz para que el usuario codifique su criterio para
	 * calcular segundas derivadas
	 *
	 * @param x es el vector a evaluar
	 *
	 * @return un objeto Matriz que generalmente será una paroximación a la matriz hessiana
	 */
	public abstract Matriz evaluar(double x[]);



	public void setF(Funcion f) {
		F = f;
	}



	public Funcion getF() {
		return F;
	}

}
