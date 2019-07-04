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

import algebralineal.Matriz;
import arquitecturabase.Funcion;

import fabricaabstracta.Fabricas;

/**
 * Derivada analítica de la función del libro de Conte -Boor especificada en la clase FuncionConteBoor
 * @author Ricardo
 *@see FuncionConteBoor
 */

public class DFuncionConteBoor extends DerivadaPrimerOrden
{



	public DFuncionConteBoor(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz evaluar(double [] x) {
		// TODO Auto-generated method stub

		double x1,x2;

		x1=x[0];
		x2=x[1];

		double d[][]=new double[2][2];

		d[0][0]=1.0+3.0/x1;
		d[0][1]=-2.0*x2;
		d[1][0]=4*x1-x2-5;
		d[1][1]=-x1;

		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);
	}


}
