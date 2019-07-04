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

package vistas;
/**
 * Esta clase es un panel que contiene la gráfica que compara número de evaluaciones
 * de la función objetivo y log 10 ||Fx ||
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Grafica2 extends Grafica{

	public Grafica2(String title, Controlador controlador, String ejeY,
			String ejeX) {
		super(title, controlador, ejeY, ejeX);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void puntoAgregado(double[][] puntoActual, double punto,
			int iteracion, int numEvaluaciones, long tiempoEjecucion,
			double normaDFx) {

		agregarPunto(numEvaluaciones,Math.log10(punto));
		// TODO Auto-generated method stub

	}
}
