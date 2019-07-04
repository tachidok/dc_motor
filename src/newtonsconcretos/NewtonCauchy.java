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
import RegionesDeConfianza.RegionCauchy;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;

/**
 * Esta clase es un m�todo Newton que utiliza un punto Cauchy y un algoritmo de
 * regiones de confianza
 * @author Administrator
 *
 */

public class NewtonCauchy extends NewtonImp {


	public  NewtonCauchy(Funcion F)
	{
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new RegionCauchy(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}

}
