package JacobianMatriz.Abstraccion;

/**
 * �sta es la clase ra�z para definir distintas estrategias para calcular una Matriz Jacobiana
 * @author Administrator
 *
 */
public abstract class MatrizJacobiana {

	public abstract double[][] calcularMatriz(arquitecturabase.Funcion F, double ...X);

}
