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

import fabricaabstracta.Fabricas;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import RegionesDeConfianza.HibridoDeBlue;

/**
 * Esta es una implementaci�n del m�todo descrito en el paper "Robust Newton for solving
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
