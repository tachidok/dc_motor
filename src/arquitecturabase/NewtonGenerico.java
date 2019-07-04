/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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
package arquitecturabase;

import fabricaabstracta.Fabricas;
/**
 * Esta clase es la abstracci�n dentro del Patr�n Bridge. Sirve como una caja negra
 * que facilita el uso de m�todos Newton para el cliente.
 * @author Administrator
 *
 */
public class NewtonGenerico extends Newton {

 	public NewtonGenerico()
	{
		setImplementacion(Fabricas.fabricaTiposNewton.crearInstancia());
	}

 	public NewtonGenerico(NewtonImp metodo, double x0[], Funcion F)
 	{
 		setImplementacion(metodo);
 		metodo.setFuncion(F);
 		metodo.setXn(x0);
 		metodo.setX0(x0);
 	}



}
