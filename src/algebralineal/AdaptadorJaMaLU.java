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

package algebralineal;
import Jama.*;

/**

 * Esta clase es un Adaptador para resolver sistemas lineales por descomposición LU y usando
 * el paquete  de algebra lineal JaMa: Java Matrix Package
 *
 * @author Ricardo Serrato Barrera
 *
 */

public class AdaptadorJaMaLU implements ResSistemaLineal{

	private LUDecomposition descomposicionLU;

	/**
	 * Constructor para resolver el sistema Ax=b
	 * @param A es la matriz A, del sistema Ax = b
	 */
	public AdaptadorJaMaLU(Matriz A)
	{
		Matrix m=new Matrix(A.getArreglo());

		descomposicionLU = new LUDecomposition(m);
	}


	@Override
	public Matriz resolver(Matriz B) {
		Matriz m=new AdaptadorJaMaMatrix(descomposicionLU.solve(new Matrix(B.getArreglo())));
		return m;
	}






}
