/*					Código realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package pruebasnewtonbluealeatorio;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import edu.cudenver.bios.matrix.GramSchmidtOrthonormalization;

public class temp {


	public static void main(String f[])
	{
		double matrix[][]={{1,1,1},{0,1,1},{0,0,1}};


		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				if(j+1!=matrix.length)
					System.out.print(matrix[i][j]+",");
				else
					System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		RealMatrix m = new Array2DRowRealMatrix(matrix);
		GramSchmidtOrthonormalization ort=new GramSchmidtOrthonormalization(m.transpose());

		m=ort.getQ();


		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				if(j+1!=matrix.length)
					System.out.print(m.getEntry(i, j)+",");
				else
					System.out.print(m.getEntry(i, j));
			}
			System.out.println();
		}

		System.out.println(m.getNorm());
	}

}
