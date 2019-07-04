/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
 *
 *										por 
 *			   				   Ricardo Serrato Barrera
 *
 *								     Asesores:
 *			  			     Dr. Gustavo Rodr�guez G�mez
 *			 		         Dr. Sa�l Pomares Hern�ndez
 *			
 *			     				 1ro de diciembre 2011
 *
 *						Programador: Ricardo Serrato Barrera
 * 	
 */


package algebralineal;


/**
 * Esta clase es una interfaz para resolver sistemas lineales usando descomposici�n
 * LU
 *
 * @author Ricardo
 * @version 1.0
 */

public interface ResSistemaLineal {

	/**
	 * resuelve el sistema Ax=b
	 * @param B Es el vector b del sistema Ax = b. B es una matriz (vector) de
	 * n x 1 elementos
	 *
	 * @return Devuelve una matriz de n x 1 elementos con la soluci�n del
	 * sistema
	 */
	public Matriz resolver(Matriz B);
}
