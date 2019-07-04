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
 * Esta clase es un panel que contiene la gr�fica de el tiempo de ejecuci�n contra log 10 ||Fx ||
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Grafica3 extends Grafica{



	public Grafica3(String title, Controlador controlador, String ejeY,
			String ejeX) {
		super(title, controlador, ejeY, ejeX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void puntoAgregado(double[][] puntoActual, double punto,
			int iteracion, int numEvaluaciones, long tiempoEjecucion,
			double normaDFx) {
		// TODO Auto-generated method stub
		agregarPunto(tiempoEjecucion*1.0e-6,Math.log10(punto));

	}
}
