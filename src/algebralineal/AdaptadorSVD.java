/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package algebralineal;
import fabricaabstracta.Fabricas;
import Jama.Matrix;
import Jama.SingularValueDecomposition;

/**
 *
 *Esta clase es un adaptador de la clase  QRDecomposition ubicada en la paqueteria Jama-1.0.2
 *
 * Éste es un adaptador para la clase SingularValueDecomposition del paquete JaMa: java matrix package
 * @author Administrator
 *
 */

public class AdaptadorSVD implements SVD{

	private SingularValueDecomposition svd;

	/**
	 * Crea un objeto SVD a partir de la matriz A
	 * @param A es la matriz a descomponer
	 */
	public AdaptadorSVD(Matriz A)
	{
		svd=new SingularValueDecomposition(new Matrix(A.getArreglo()));
	}

	@Override
	public Matriz getS() {
		// TODO Auto-generated method stub

		Matrix A=svd.getS();
		return Fabricas.fabricaAlgebraLineal.crearInstancia(A.getArray());
	}

	@Override
	public Matriz getU() {
		// TODO Auto-generated method stub
		Matrix A=svd.getU();
		return Fabricas.fabricaAlgebraLineal.crearInstancia(A.getArray());
	}

	@Override
	public Matriz getV() {
		// TODO Auto-generated method stub
		Matrix A=svd.getV();
		return Fabricas.fabricaAlgebraLineal.crearInstancia(A.getArray());
	}

	@Override
	public double[] getValoresSingulares() {
		// TODO Auto-generated method stub
		return svd.getSingularValues();
	}

}
