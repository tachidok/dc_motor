package JacobianMatriz.principal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import JacobianMatriz.Abstraccion.Funcion;

/**
 * Esta clase contiene un ejemplo sencillo para utilizar
 * la clase DerivadaConcreta
 * @author Administrator
 *
 */
public class Prueba {
	public static void main(String ar[])
	{
		NumberFormat formato = new DecimalFormat("#0.0000");
		NumberFormat formato2 = new DecimalFormat("#0.000000000000");
		double[] X ={5};// valores iniciales
		Funcion F = new MiFuncion();
		DerivadaConcreta d = new DerivadaConcreta();

		double Freal = F.calcularFuncion(X);
		double Faproximada = 0;
		double error = 0;

		double incremento = 1;
		int iteraciones = 20;

		System.out.println("Incremento             | Valor real    | Valor   aproximado   | Error");

		for(int i = 0; i<iteraciones; i++)
		{
			d.setIncremento(incremento);
			Faproximada = d.derivar(F, X);
			incremento /= 10;

			error = Math.abs((Freal - Faproximada)/ Freal);

			String real = formato.format(Freal);
			String aprox = formato.format(Faproximada);
			String incre = formato2.format(incremento);
			String er = formato.format(error);

			System.out.println( incre+"         "+ real +"         "+aprox+ "              "+ er);
		}

	}

}
