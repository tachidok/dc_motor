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

package PrecisionNumerica;

/**
 * Esta clase contiene un método simple para encontrar el épsilon de la máquina
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
