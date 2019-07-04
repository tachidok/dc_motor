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

package derivadas;

import fabricaabstracta.Fabricas;

import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Esta clase contiene la derivada de arc tan x
 * @author Administrator
 *
 */

public class DMiFuncion extends DerivadaPrimerOrden
{



	public DMiFuncion(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz evaluar(double x[]) {
		// TODO Auto-generated method stub

		double d[][] = new double[1][1];

		d[0][0]=1.0/(1+Math.pow(x[0],2.0));
		//d[0][0]=2*x[0];

		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);
	}


}
