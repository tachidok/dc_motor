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

import problemasnolineales.ProblemaNoLineal;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import direcciones.DireccionSistemaNoLineal;
import fabricaabstracta.Fabricas;


/**
 * Esta clase es la implementaci�n de un Newton cl�sico que utiliza una direcci�n para sistemas no
 * lineales y una l�nea de b�squeda especificada por la clase FbLineasBusqueda.Usa descomposici�n LU para resolver el sistema lineal en la
 * direccion Newton.
 *
 * @author Ricardo
 *
 */

public class NewtonClasico extends NewtonImp {



	public  NewtonClasico(Funcion F)
	{
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new DireccionSistemaNoLineal(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}


	public  NewtonClasico(Funcion F, ProblemaNoLineal problema)
	{
		super(F,problema);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new DireccionSistemaNoLineal(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));

	}

	public NewtonClasico() {
		super();
	}


}


