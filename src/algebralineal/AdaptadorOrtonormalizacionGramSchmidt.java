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
import edu.cudenver.bios.matrix.GramSchmidtOrthonormalization;
import fabricaabstracta.Fabricas;
/**

 * Esta clase es un adaptador de la clase GramSchmidtOrthonormalization que se encuentra en el
 * la paqueteria commons-math-2.2
 */
public class AdaptadorOrtonormalizacionGramSchmidt implements Ortonormalizacion {

	@Override
	public Matriz evaluar(Matriz A) {
		// TODO Auto-generated method stub

		double d[][]=A.getArreglo();

		RealMatrix m = new Array2DRowRealMatrix(d);
		GramSchmidtOrthonormalization ort=new GramSchmidtOrthonormalization(m);
		m=ort.getQ();


		Matriz Q=Fabricas.fabricaAlgebraLineal.crearInstancia(m.getData());

		return Q;
	}

}
