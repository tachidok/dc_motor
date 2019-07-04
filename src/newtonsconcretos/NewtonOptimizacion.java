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


package newtonsconcretos;

import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import direcciones.DireccionOptimizacion;
import fabricaabstracta.Fabricas;

/**
 * Este es un m�todo newton que utiliza una direcci�n x,  H x = g, donde h es la hessiana
 * g es el gradiente, puede utilizar la l�nea de b�squeda especificada por la clase FbLineasBusqueda
 * @author Administrator
 *
 */
public class NewtonOptimizacion extends NewtonImp {


	public NewtonOptimizacion (Funcion F)
	{
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new DireccionOptimizacion(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}
}
