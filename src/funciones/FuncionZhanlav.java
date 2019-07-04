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
 * Esta función aparece en el paper "on newton type mewthods with four and fifth
 * order convergence" de Zhanlav
 * @author Administrator
 *
 */



public class FuncionZhanlav extends  Funcion{


	public FuncionZhanlav() {
		super(6, 6);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] evaluar(double [] x) {
		// TODO Auto-generated method stub

		double x1,x2,x3,x4,x5,x6;

		x1=x[0];
		x2=x[1];
		x3=x[2];
		x4=x[3];
		x5=x[4];
		x6=x[5];

		double d[]=new double[6];

		d[0]=x1 * x3 + x2 * x4 + x3 * x5 + x4 * x6;
		d[1]=  x1* x5 + x2* x6;
		d[2]=  x1           +x3+       x5       -1;
		d[3]= -x1   + x2    -x3 + x4 - x5 + x6;
		d[4]= -3*x1 - 2*x2 - x3      + x5 + 2*x6;
		d[5]=  3*x1 - 2*x2 + x3      - x5 + 2*x6;

		return d;
	}

}
