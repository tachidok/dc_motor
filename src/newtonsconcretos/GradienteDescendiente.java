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
import direcciones.EmpinadaDescendiente;
import fabricaabstracta.Fabricas;
/**
 * Ésta es la implemtación de un gradiente descendiente que usa una línea de búsqueda especificada por
 * la fábrica FbLineasBusqueda
 * @author Administrator
 * @see FbLineaBusqueda
 */
public class GradienteDescendiente  extends NewtonImp{

	public GradienteDescendiente(Funcion F) {
		super(F);
		getComponentes().setCriterioDeParo(Fabricas.fabricacriterios.crearInstancia());
		getComponentes().setDireccionNewton(new EmpinadaDescendiente(getFuncion()));
		getComponentes().setLongitudDePaso(new LineaDeBusqueda(getFuncion()));
	}





}
