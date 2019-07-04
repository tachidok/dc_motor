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

import fabricaabstracta.Fabricas;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import RegionesDeConfianza.HibridoDeBlue;

/**
 * Esta es una implementación del método descrito en el paper "Robust Newton for solving
 * systems of nonlinear equations" de James Blue
 */

public class NewtonHibridoBlue extends NewtonImp{


	public  NewtonHibridoBlue(Funcion F)
	{
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new HibridoDeBlue(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}
}
