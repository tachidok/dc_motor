package JacobianMatriz.Abstraccion;

/**
 * Ésta es la clase raíz para definir funciones de la forma F: R^n -> R^m
 * @author Administrator
 *
 */
public abstract class FuncionVectorial extends arquitecturabase.Funcion{
	public FuncionVectorial(int numVariables, int numFunciones) {
		super(numVariables, numFunciones);
		// TODO Auto-generated constructor stub
	}
	public abstract double[] calcularFuncion(double ...X);
	public abstract int dimension();
}
