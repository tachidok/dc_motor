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
 * Esta función es un paraboloide eliptico que se "ensancha" o "aplasta" con un factor k
 * @author Administrator
 *
 */
public class ParaboloideEliptico extends Funcion {

	private double k;

	public ParaboloideEliptico() {
		super(2,1);
		// TODO Auto-generated constructor stub
		k=0.1;
	}

	@Override
	public double[] evaluar(double[] x) {
		// TODO Auto-generated method stub


		double f[]=new double[1];
		//			z/c^2 = x^2 / a^2   +   y^2 / b^2
		//         aplasto la naranja con un factor k
		//		  z/(1/k)^2 = x^2 / k^2   +   y^2 / (1/k)^2


		f[0]= Math.pow((1.0/k), 2.0)*
				(Math.pow((x[0]),2.0) / Math.pow(k,2.0)   +
			    Math.pow(x[1],2.0) / Math.pow(1.0/k, 2.0));
		return f;
	}

}
