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
 * Esta funci�n es utilizada para probar el algoritmo de powell del art�culo
 * "a hybrid method for non linear equations" y
 * "a Fortran subroutine for solving systems of non linear algebraic equations"
 *
 *  ambos art�culos vienen en el libro
 *
 *  "numerical methods for non linear algebraic equations"
 * @author Administrator
 *
 */


public class FuncionPowell extends Funcion {

	public FuncionPowell() {
		super(2, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double [] evaluar(double[] x) {
		// TODO Auto-generated method stub


		double x1,x2;

		x1=x[0];
		x2=x[1];

		double d[]=new double[2];

		d[0]=-13.0 + x1 + (( -x2 +5)*x2 - 2.0)*x2;
		d[1]= -29.0 + x1 + ((x2+1)*x2 - 14)*x2;


		return d;
	}

}
