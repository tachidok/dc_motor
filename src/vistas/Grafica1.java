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

package vistas;
/**
 * Esta gr�fica compara el valor de la funci�n de evaluaci�n contra el n�mero de iteraciones
 * @author Administrator
 *
 */
public class Grafica1 extends Grafica{

	public Grafica1(String title, Controlador controlador, String ejeY,
			String ejeX) {
		super(title, controlador, ejeY, ejeX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void puntoAgregado(double[][] puntoActual, double punto,
			int iteracion, int numEvaluaciones, long tiempoEjecucion,
			double normaDFx) {
		// TODO Auto-generated method stub
		agregarPunto(iteracion,Math.log10(punto));

	}

}
