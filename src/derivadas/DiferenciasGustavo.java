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

import JacobianMatriz.principal.MiMatrizJacobiana;
import PrecisionNumerica.MiPrecisionNumerica;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;

/**
 * Ésta es una implementación para derivar por diferencias finitas.
 * Hace uso de una estrategia para encontrar el incremento h adecuado para hacer las diferencias
 * finitas (Es de Gustavo Rodríguez Gómez)
 *
 * @author Ricardo
 *
 */
public class DiferenciasGustavo extends DerivadaPrimerOrden{

	private MiMatrizJacobiana jacobianaGustavo;

	public DiferenciasGustavo(Funcion F) {
		super(F);

		jacobianaGustavo = new MiMatrizJacobiana();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz evaluar(double[] x) {
		// TODO Auto-generated method stub

		jacobianaGustavo.setEpsilon(MiPrecisionNumerica.EPSILON);

		double d[][]= jacobianaGustavo.calcularMatriz(getF(), x );
		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);

	}

}
