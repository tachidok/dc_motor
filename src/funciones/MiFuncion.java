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

/**
 * �sta es una funci�n para hacer pruebas, su derivada est� en la clase DMiFuncion
 * @author Administrator
 *
 */

public class MiFuncion extends Funcion{


	public MiFuncion() {
		super(1, 1);
	}

	@Override
	public double[]  evaluar(double[] x) {


		double d[]= new double[getNumFunciones()];//


		//d[0]=x[0]*x[0]+x[1]*x[1];
		d[0]=x[0]*x[0];

	  // d[0]=Math.atan(x[0]);

		return d;
	}



}
