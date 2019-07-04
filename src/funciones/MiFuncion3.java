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
 * �sta es una funci�n para hacer pruebas.
 *
 * @author Administrator
 *
 */




public class MiFuncion3 extends Funcion{

	public MiFuncion3 () {
		super(3, 3);
	}

	@Override
	public double[] evaluar(double[] x) {


		double d[]= new double[getNumFunciones()];

		double x1=x[0];
		double x2=x[1];
		double x3=x[2];

		/*
		 * x^2 + y^2 + z^2
		 * e^x  - 1 + xy
		 * sen x + xyz
		 */


		d[0]=x1*x1+x2*x2+x3*x3;
		d[1]=Math.exp(x1)-1+x1*x2;
		d[2]=Math.sin(x1) + x1*x2*x3;

		return d;
	}

}
