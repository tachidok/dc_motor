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

package derivadas;

import algebralineal.Matriz;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;

/**
 * �sta es una matriz identidad que utiliza la interfaz de DerivadaSegundoOrden. El
 * prop�sito de esta clase es permitir la transici�n entre un m�todo Newton y un gradiente
 * descendiente.
 *
 * la direcci�n x de un Newton tiene la siguiente forma
 *
 * B x = - g, donde B es una aproximaci�n de la matriz hessiana. Note que si B = I entonces
 * 			  el m�todo es un gradiente descendiente
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
