package JacobianMatriz.principal;

/**
 * Esta clase contiene un ejemplo para utilizar la clase MiMatrizJacobiana
 * @author Administrator
 *
 */

public class Prueba2 {

	public static void main(String ar[])
	{
		double X[] ={1,1};

		MiFuncionVectorial F = new MiFuncionVectorial(2,2);
		MiMatrizJacobiana J = new MiMatrizJacobiana();

		double matriz [][]= J.calcularMatriz(F, X);

		imprimirMatriz(matriz);

	}

	public static void imprimirMatriz(double m[][])
	{

		for(int i = 0; i < m.length ; i++)
		{
			System.out.println();
			for(int j = 0; j< m[0].length; j++)
			{
				System.out.print(m[i][j]+",");
			}
		}
	}

}
