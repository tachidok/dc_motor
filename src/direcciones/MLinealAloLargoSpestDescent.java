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


package direcciones;

import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * Esta clase encuentra el minimizador del modelo lineal M(x+ p) = Fx + Jp,   p= x - xn
 * a lo largo de la dirección del gradiente descendiente.
 *
 * Es decir, encuentra el escalar alfa que minimice
 *
 *  || Fx + J (alfa * g)||^2, g es el gradiente
 *
 *
 */
public class MLinealAloLargoSpestDescent extends DireccionRegion{

	private EmpinadaDescendiente gradienteDescendiente;
	private Funcion F;
	private Matriz dirGradienteDescendiente;
	private double correccion;

	public MLinealAloLargoSpestDescent(Funcion F)
	{
		this.setF(F);
		gradienteDescendiente=new EmpinadaDescendiente(F);

	}

	public void setGradienteDescendiente(EmpinadaDescendiente gradienteDescendiente) {
		this.gradienteDescendiente = gradienteDescendiente;
	}


	public EmpinadaDescendiente getGradienteDescendiente() {
		return gradienteDescendiente;
	}


	public void setF(Funcion f) {
		F = f;
	}


	public Funcion getF() {
		return F;
	}





	@Override
	public Matriz getDireccion(Matriz Xn, double regionConfianza) {
		// TODO Auto-generated method stub

		dirGradienteDescendiente =gradienteDescendiente.getDireccion(Xn);
		calcularCorreccion(Xn,dirGradienteDescendiente);
		double correccion=getCorreccion();

		return dirGradienteDescendiente.por(correccion);
	}

	/**
	 * Devuelve un escalar que minimiza el modelo lineal a lo largo de
	 * la direccion del gradiente descendiente
	 */

	public void calcularCorreccion(Matriz Xn)
	{
		Matriz primeraDerivada=F.primeraDerivada(Xn);
		Matriz stpsdescent=gradienteDescendiente.getDireccion(Xn);

		Matriz t1=primeraDerivada.por(stpsdescent);
		t1=t1.transpuesta().por(t1);

		Matriz t2= stpsdescent.transpuesta().por(stpsdescent);

		correccion=t2.getElemento(0, 0)/t1.getElemento(0, 0);
	}


	public void calcularCorreccion(Matriz Xn, Matriz dirstpsdescent)
	{

		Matriz primeraDerivada=F.primeraDerivada(Xn);
		Matriz t1=primeraDerivada.por(dirstpsdescent);
		t1=t1.transpuesta().por(t1);

		Matriz t2= dirstpsdescent.transpuesta().por(dirstpsdescent);

		correccion=t2.getElemento(0, 0)/t1.getElemento(0, 0);

	}

	public void setCorreccion(double correccion) {
		this.correccion = correccion;
	}

	public double getCorreccion() {
		return correccion;
	}

	public void setDirGradienteDescendiente(Matriz dirGradienteDescendiente) {
		this.dirGradienteDescendiente = dirGradienteDescendiente;
	}

	public Matriz getDirGradienteDescendiente() {
		return dirGradienteDescendiente;
	}




}
