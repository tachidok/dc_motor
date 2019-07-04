/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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

package algebralineal;
import fabricaabstracta.Fabricas;
import Jama.Matrix;
import Jama.QRDecomposition;
/**
 *Esta clase es un adaptador de la clase  QRDecomposition ubicada en la paqueteria Jama-1.0.2
 */


public class AdaptadorOrtonormalizacionJaMaMatrix implements Ortonormalizacion {

	@Override
	public Matriz evaluar(Matriz A) {

		double [][]d=A.getArreglo();

		Matrix B=new Matrix(d);

		QRDecomposition qr= new QRDecomposition(B);

		Matrix C=qr.getQ();

		return Fabricas.fabricaAlgebraLineal.crearInstancia(C.getArray());

	}

}
