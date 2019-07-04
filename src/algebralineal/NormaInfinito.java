/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

/**
 *Esta clase es parte de un patrón Visitante encargado de dar flexibilidad para
 *instanciar diversas normas en la arquitectura.
 *
 *
 */


public class NormaInfinito extends NormaFlexible{

	@Override
	public double evaluarNorma(Matriz matriz) {
		// TODO Auto-generated method stub

		if(matriz.numeroFilas()==1) // se trata de un vector de 1 x n o 1x 1
			return matriz.norma1(); // máximo de la suma de las columnas

		if(matriz.numeroColumnas()==1)// se trata de un vector de n x 1
			return matriz.normaInfinito();


		return matriz.normaInfinito(); // se trata d euna matriz de n x m
	}

}
