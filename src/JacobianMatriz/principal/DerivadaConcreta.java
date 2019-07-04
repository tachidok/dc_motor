package JacobianMatriz.principal;

import JacobianMatriz.Abstraccion.Derivada;
import JacobianMatriz.Abstraccion.Funcion;
/**
 * Esta clase sirve para calcular la derivada de una función de una variable
 */
public class DerivadaConcreta implements Derivada{

	private double incremento = 0.1;

	@Override
	public double derivar(Funcion F, double ...valores) {

		double f = F.calcularFuncion(valores);
		valores[0] += incremento;
		double fIncremento = F.calcularFuncion(valores);

		valores[0] -= incremento;

		double derivada = (fIncremento - f) / incremento;

		return derivada;
	}

	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}

	public double getIncremento() {
		return incremento;
	}

}
