package JacobianMatriz.principal;
import JacobianMatriz.Abstraccion.*;

/**
 * Esta clase contiene una función para hacer pruebas
 * @author Administrator
 *
 */
public class MiFuncionVectorial extends FuncionVectorial{

	public MiFuncionVectorial(int numVariables, int numFunciones) {
		super(numVariables, numFunciones);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] calcularFuncion(double... X) {

		double F[] = new double[dimension()];

		F[0] = X[0]*X[0];
		F[1] = X[0]*X[1];

		return F;
	}

	@Override
	public int dimension() {
		return 2;
	}

	@Override
	public double[] evaluar(double[] x) {
		// TODO Auto-generated method stub
		return calcularFuncion(x);
	}

}
