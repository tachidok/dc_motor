package JacobianMatriz.principal;

import JacobianMatriz.Abstraccion.Funcion;
/**
 * Esta clase contiene una función para hacer pruebas
 * @author Administrator
 *
 */
public class MiFuncion extends Funcion{



	@Override
	public double calcularFuncion(double ...valores) {

		return Math.exp(valores[0]);
	}


}
