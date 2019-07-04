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

package derivadas;

import algebralineal.Matriz;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;

/**
 * Ésta es una matriz identidad que utiliza la interfaz de DerivadaSegundoOrden. El
 * propósito de esta clase es permitir la transición entre un método Newton y un gradiente
 * descendiente.
 *
 * la dirección x de un Newton tiene la siguiente forma
 *
 * B x = - g, donde B es una aproximación de la matriz hessiana. Note que si B = I entonces
 * 			  el método es un gradiente descendiente
 * @author Ricardo
 *
 */
public class HessianaIdentidad extends DerivadaSegundoOrden {

	public HessianaIdentidad(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz evaluar(double[] x) {
		// TODO Auto-generated method stub

		double h[][]=new double[x.length][x.length];

		for(int i=0;i<x.length;i++)
		h[i][i]=1.0;

		return Fabricas.fabricaAlgebraLineal.crearInstancia(h);
	}

}
