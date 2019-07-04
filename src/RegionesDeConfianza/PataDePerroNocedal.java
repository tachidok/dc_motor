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

package RegionesDeConfianza;

import direcciones.DireccionNewtonRegion;
/**
 * En esta clase se encuentra un algoritmo que usa una "pata de perro". Es una transicón entre
 * un gradiente descendiente y un método newton por medio de una región de confianza.
 */
import direcciones.PuntoCauchy;
import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Esta clase contiene un algoritmo "dogleg" como se especifica en 
 * el libro "Numerical Optimization"  de Jorge Nocedal
 * @author Administrator
 *
 */
public class PataDePerroNocedal extends  RegionDeConfianza{

	private DireccionNewtonRegion direccionNewton;
	private PuntoCauchy direccionCauchy;


	public PataDePerroNocedal(Funcion F) {
		super(F);


		ActualizacionRegionNocedal a=new ActualizacionRegionNocedal();
		setActualizacionRegionConfianza(a);

		a.setcAlta(0.75);
		a.setCBaja(0.25);
		a.setcCrecimiento(2.0);
		a.setcDecrecimiento(0.5);
		a.setCotaDeConfianza(0.2);
		a.setCotaSuperior(2.0);
		a.setRadio(0.1);


		setDireccionNewton(new DireccionNewtonRegion(F));
		setDireccionCauchy(new PuntoCauchy(F));

	}




	public double interseccionConRegion(Matriz gradienteCauchy, Matriz newton,double region)
	{
		double a;
		double b;
		double c;
		double solucion;


		//Pb es la direccion del newton
		//Pu es la direccion cauchy

		// a = || Pu - Pb || ^2
		Matriz temp=gradienteCauchy.menos(newton);
		temp=temp.transpuesta().por(temp);

		a=temp.getElemento(0, 0);

		// b= -(2Pb - 2Pu) * (Pb - 2Pu)

		temp=newton.por(2.0);
		temp=temp.menos(gradienteCauchy.por(2.0));

		Matriz temp2;
		temp2=newton.menos(gradienteCauchy.por(2.0));
		temp=temp.transpuesta().por(temp2);

		b=temp.getElemento(0, 0)*-1.0;

		// c= ||Pb - 2Pu||^2 - region^2

		temp=newton.menos(gradienteCauchy.por(2.0));
		temp=temp.transpuesta().por(temp);
		c=temp.getElemento(0, 0)-region*region;

		solucion=(-b+Math.sqrt(b*b-4*a*c))/(2*a);


		return solucion;
	}

	public Matriz trayectoriaDePataDePerro(Matriz x,Matriz gradienteCauchy, Matriz newton,double region)
	{

		double t=interseccionConRegion(gradienteCauchy, newton,region);

		if(0<t && t<=1)
			return gradienteCauchy;
		else if(1<t && t<=2)
		{
			return gradienteCauchy.mas(newton.menos(gradienteCauchy).por(t-1));
		}

		return null;
	}



	public Matriz getDireccionRegion(Matriz x, double region) {

		Matriz gradienteCauchy=direccionCauchy.getDireccion(x, getRadioConfianza());
		Matriz newton=direccionNewton.getDireccion(x, getRadioConfianza());


		if(newton.normaF()<=region)
			return newton;


		return trayectoriaDePataDePerro(x,gradienteCauchy, newton, region);
	}




	@Override
	public Matriz getDireccion(Matriz Xn) {

		Matriz direccion;
		double concordancia;

		do{

		direccion=getDireccionRegion(Xn, getRadioConfianza());
		concordancia=concordanciaFuncionModelo(Xn,direccion);
		}
		while(!actualizarRadio(concordancia,direccion));

		return direccion;
	}



	public void setDireccionNewton(DireccionNewtonRegion direccionNewton) {
		this.direccionNewton = direccionNewton;
	}

	public DireccionNewtonRegion getDireccionNewton() {
		return direccionNewton;
	}

	public void setDireccionCauchy(PuntoCauchy direccionCauchy) {
		this.direccionCauchy = direccionCauchy;
	}

	public PuntoCauchy getDireccionCauchy() {
		return direccionCauchy;
	}


}
