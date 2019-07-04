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


package direcciones;

import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * �sta es una implementaci�n del punto Cauchy usado en los algoritmos de regi�n de confianza
 *
 *  p = - a  (r/ ||g||) g
 *
 *
 *  a es un escalar que minimiza al modelo cuadr�tico a lo largo del gradiente descendiente
 *  r es el radio de confianza
 *  g es el gradiente
 */
public class PuntoCauchy extends DireccionRegion {

	/**
	 * Direcci�n de un gradiente descendiente
	 */
	private EmpinadaDescendiente gradienteDescendiente;
	private Funcion F;


	public PuntoCauchy(Funcion F) {
		gradienteDescendiente=new EmpinadaDescendiente(F);
		this.F=F;
	}


	public Matriz getDireccion(Matriz Xn) {

		return gradienteDescendiente.getDireccion(Xn);
	}

	public Matriz getDireccion(Matriz Xn,double regionConfianza)
	{
		Matriz direccion=getDireccion(Xn);
		Matriz gradiente=direccion.por(-1.0);


		//convierto direccion en un vector unitario
		direccion=direccion.por(1.0/direccion.normaF());

		double longitud;
		Matriz B=getF().segundaDerivada(Xn);

		Matriz t=gradiente.transpuesta().por(B).por(gradiente);
		double gradienteNorma=gradiente.normaF();

		if(t.getElemento(0, 0)<=0)
		{
			longitud=1;
		}
		else
		{
			longitud=Math.min((gradienteNorma*gradienteNorma*gradienteNorma)/(regionConfianza*t.getElemento(0, 0)), 1);
		}

		return direccion.por(regionConfianza).por(longitud);
	}

	/**
	 * Devuelve la funci�n usada para calcular el punto Cauchy
	 * @return
	 */
	public Funcion getF() {
		return F;
	}

	/**
	 * Asigna a f como la funci�n usada para calcular el punto Cauchy
	 * @param f
	 */

	public void setF(Funcion f) {
		F = f;
	}

}
