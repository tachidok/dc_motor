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

import problemasnolineales.ProblemaNoLineal;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;
import lineasdebusqueda.LineaDeBusqueda;
import direcciones.DireccionSistemaNoLineal;
import fabricaabstracta.Fabricas;


/**
 * Esta clase es la implementación de un Newton clásico que utiliza una dirección para sistemas no
 * lineales y una línea de búsqueda especificada por la clase FbLineasBusqueda.Usa descomposición LU para resolver el sistema lineal en la
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


