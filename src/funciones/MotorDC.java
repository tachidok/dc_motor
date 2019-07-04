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


package funciones;
import arquitecturabase.Funcion;
import motor.*;


/**
 * Esta clase es un adaptador para evaluar la funcion Costo del
 * Modelo de un MotorDC. Las clases de este modelo est�n en en paquete "motor"
 */


public class MotorDC extends Funcion {


	private BotonRojo botonrojo;//con este boton enciendo el motor (asigno par�metros al modelo)
								//asigno el m�todo numerico etc.
	private FuncionCosto funcion;

	public MotorDC() {
		super(3, 1);

		botonrojo=new BotonRojo();
		botonrojo.arracar();
		funcion=botonrojo.getFuncion();
	}



	@Override
	public double[] evaluar(double[] x) {
		// TODO Auto-generated method stub
		return funcion.evaluarFuncion(x);
	}

}
