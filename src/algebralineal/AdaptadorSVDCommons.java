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
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.SingularValueDecomposition;
import org.apache.commons.math.linear.SingularValueDecompositionImpl;

import fabricaabstracta.Fabricas;
/**
 *
 * Esta clase es un adaptador para la clase  SingularValueDecomposition  de la paqueteria
 * commons-math-2.2
 *
*/
public class AdaptadorSVDCommons implements SVD{

	private SingularValueDecomposition svd;
	private RealMatrix A;

	public AdaptadorSVDCommons(Matriz A)
	{
		double datos[][]=A.getArreglo();
		this.A=new Array2DRowRealMatrix(datos);
		this.svd=new SingularValueDecompositionImpl(this.A) ;
	}

	@Override
	public Matriz getV() {
		// TODO Auto-generated method stub

		double d[][]=svd.getV().getData();

		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);
	}

	@Override
	public Matriz getS() {
		// TODO Auto-generated method stub

		double d[][]=svd.getS().getData();

		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);

	}

	@Override
	public Matriz getU() {

		double d[][]=svd.getU().getData();

		return Fabricas.fabricaAlgebraLineal.crearInstancia(d);
	}

	@Override
	public double[] getValoresSingulares() {
		// TODO Auto-generated method stub

		double d[]=svd.getSingularValues();
		return d;
	}

}
