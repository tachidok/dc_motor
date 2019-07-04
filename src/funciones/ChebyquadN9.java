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
 * Ésta es una implementación de la funcion Chebyquad n=9 usada en el artículo
 *
 * "Robust Methods for solving systems of nonlinear equations" de James L. Blue
 * @author Administrator
 *
 */


public class ChebyquadN9 extends Funcion {

	public ChebyquadN9() {
		super(9, 9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] evaluar(double [] x) {
		// TODO Auto-generated method stub

		double d[]=new double[9];
		double cons=1.0/this.getNumVariables();

		d[0]=cons*sumatoria(x,1)-1.0/2.0;
		d[1]=cons*sumatoria(x,2)+1.0/3.0;
		d[2]=cons*sumatoria(x,3)+1.0/2.0;
		d[3]=cons*sumatoria(x,4)+1.0/15.0;
		d[4]=cons*sumatoria(x,5)-1.0/6.0;
		d[5]=cons*sumatoria(x,6)+1.0/35.0;
		d[6]=cons*sumatoria(x,7)+1.0/6.0;
		d[7]=cons*sumatoria(x,8)+1.0/63.0;
		d[8]=cons*sumatoria(x,9)-1.0/10.0;

		return d;
	}

	public double sumatoria(double[] x, int i)
	{
		double suma=0;
		for(int n=0;n<this.getNumVariables();n++)
		{
			suma+=Math.cos(i*Math.acos(x[n]));
		}
		return suma ;
	}

}
