package JacobianMatriz.principal;
import JacobianMatriz.Abstraccion.MatrizJacobiana;

/**
 * Esta clase contiene un algoritmo de diferencias finitas para
 * calcular una matriz Jacobiana
 * @author Administrator
 *
 */

public class MiMatrizJacobiana extends MatrizJacobiana{

	private double incremento;
	private double epsilon;
	private double cons;
	private final double HMIN = 1.0E-010;
	private final double HMAX = 0.1;



	public MiMatrizJacobiana()
	{
		epsilon = obtenerEpsilon();
		cons = Math.sqrt(epsilon/5.0);
	}

	@Override
	public double[][] calcularMatriz(arquitecturabase.Funcion F, double... X) {

		int numFilas = F.getNumFunciones();
		int numCol = X.length;
		double temp,absx, xi, hmaxEscalada;
		double matriz[][] = new double[numFilas][numCol];
		double valorDeltaF[];


		double valorF[] = F.evaluarFuncion(X);

		for(int i =0; i < numCol; i++)
		{
			xi = X[i];
			//cálculo abs(x)
			absx = Math.abs(X[i]);
			// Escalamos el valor de HMAX
			hmaxEscalada = HMAX*Math.max(1.0, absx);
			// calculamos incremento
			if ( absx <= 1.0e-10 )
				incremento = HMIN;
			else
				incremento = cons*Math.sqrt(absx);

			if ( incremento < HMIN )
				incremento = HMIN;

			//Escalar el incremento
			incremento = Math.max(1.0, absx)*incremento;

			if ( incremento > hmaxEscalada )
				incremento = hmaxEscalada;

			// Mejoramos la representacion de incremento en
			// punto flotante (consultar Shampine)
			temp = X[i] + incremento;
			incremento = temp - X[i];

			// Agregamos el incremento X[i]
			X[i] = X[i] + incremento;

			//calculo la funcion con el vector X modificado
			valorDeltaF = F.evaluarFuncion(X);

			//retorno el vector a su estado original
			X[i] = xi;

			//calculo la columna i-ésima de la matriz jacobiana
			for(int j = 0; j < numFilas; j++)
			{
				matriz[j][i] = (valorDeltaF[j] - valorF[j])/ incremento;
			}
		}
		return matriz;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public double getEpsilon() {
		return epsilon;
	}

	private double obtenerEpsilon()
	{
		//Por implementar está función. Debería de calcular el epsilon de la computadora.
		return 1.110E-16;
	}

	public static void main(String ar[])
	{
		MiMatrizJacobiana m = new MiMatrizJacobiana();

		System.out.println(m.getEpsilon());
	}
}
