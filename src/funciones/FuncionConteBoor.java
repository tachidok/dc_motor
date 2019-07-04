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

/**
 * Ésta es la función utilizada para probar un newton
 * Amortiguado. Aparece en el libro de Conte y Boor "Elementary
 * numerical analysis".
 *
 * @author Administrator
 *
 */


public class FuncionConteBoor extends Funcion{

	public FuncionConteBoor() {
		super(2, 2);
	}



	@Override
	protected double[] evaluar(double[] x) {
		// TODO Auto-generated method stub
		double X1=x[0];
		double X2=x[1];

		double F[]=new double[2];


		F[0]=X1+3.0*Math.log(Math.abs(X1))-X2*X2;
		F[1]=2.0*X1*X1-X1*X2-5.0*X1+1.0;



		return F;

	}

}
