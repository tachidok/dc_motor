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


package funciones;

import arquitecturabase.Funcion;

public class ParaboloideEliptico2 extends Funcion{

	private double c; //parámetro para aplastar o ensanchar la funcion en el eje z
	private double a; //parámetro para aplastar o ensanchar la funcion en el eje x
	private double b; //parámetro para aplastar o ensanchar la funcion en el eje y

	public ParaboloideEliptico2() {
		super(2, 1);
		// TODO Auto-generated constructor stub

		c=50.0;
		a=50.0;
		b=5.0;
	}

	@Override
	protected double[] evaluar(double[] t) {
		// TODO Auto-generated method stub

		double x=t[0];// eje x
		double y=t[1];// eje y

		//z= c*( x^2 / a^2  +  y^2 / b^2 )

		double f[]=new double[1];

		f[0]=c* (Math.pow(x, 2)/Math.pow(a, 2) + Math.pow(y, 2)/Math.pow(b, 2) );

		return f;
	}

}
