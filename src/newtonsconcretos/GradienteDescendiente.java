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
import direcciones.EmpinadaDescendiente;
import fabricaabstracta.Fabricas;
/**
 * �sta es la implemtaci�n de un gradiente descendiente que usa una l�nea de b�squeda especificada por
 * la f�brica FbLineasBusqueda
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
