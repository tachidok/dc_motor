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
 * Ésta es una función para hacer pruebas, su derivada está en la clase DMiFuncion
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
