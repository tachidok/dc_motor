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
import RegionesDeConfianza.PataDePerroPowell;

/**
 * Este es una implementaci�n del  m�todo newton que se describe en los art�culos
 * "a hybrid method for non linear equations" y
 * "a Fortran subroutine for solving systems of non linear algebraic equations"
 *
 *  ambos art�culos vienen en el libro
 *
 *  "numerical methods for non linear algebraic equations"
 * @author Administrator
 *
 */

public class PataPowell extends NewtonImp{


	public  PataPowell(Funcion F)
	{
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new PataDePerroPowell(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}

}
