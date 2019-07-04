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


package newtonsconcretos;

import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import direcciones.DireccionOptimizacion;
import fabricaabstracta.Fabricas;

/**
 * Este es un método newton que utiliza una dirección x,  H x = g, donde h es la hessiana
 * g es el gradiente, puede utilizar la línea de búsqueda especificada por la clase FbLineasBusqueda
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
