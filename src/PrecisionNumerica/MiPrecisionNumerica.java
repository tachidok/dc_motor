/*					C�digo realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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

package PrecisionNumerica;

/**
 * Esta clase contiene un m�todo simple para encontrar el �psilon de la m�quina
 */
public final class MiPrecisionNumerica {



	@SuppressWarnings("unused")
	private static final MiPrecisionNumerica CARACTERISTICAS_MAQUINA=new MiPrecisionNumerica();
	public static double EPSILON;

	private MiPrecisionNumerica()
	{
		calcularEpsilon();
	}

	private void calcularEpsilon()
	{
		EPSILON=1;

		    while(1.0+EPSILON!=1.0){
		    	EPSILON=EPSILON/2.0;

		    }
	}


}
