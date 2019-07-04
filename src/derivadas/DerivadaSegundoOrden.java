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
 *
 * �sta es la clase ra�z de una familia de clases para aproximar una derivada de segundo orden, ya sea
 * por una actualizaci�n Quasi-Newton, diferencias finitas o anal�ticamente
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
	 * Este m�todo es un adaptador para que se le facilite al usuario
	 * la implementaci�n de su criterio para aproximar derivadas de segundo orden.
	 *
	 * Hace la transici�n del objeto Matriz x a un arreglo x[]
	 *
	 * @param x vector a evaluar
	 *
	 * @return un objeto Matriz de n x n elementos (generalmente ser� una aproximaci�n de una matriz hessiana)
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
	 * Este m�todo es la interfaz para que el usuario codifique su criterio para
	 * calcular segundas derivadas
	 *
	 * @param x es el vector a evaluar
	 *
	 * @return un objeto Matriz que generalmente ser� una paroximaci�n a la matriz hessiana
	 */
	public abstract Matriz evaluar(double x[]);



	public void setF(Funcion f) {
		F = f;
	}



	public Funcion getF() {
		return F;
	}

}
