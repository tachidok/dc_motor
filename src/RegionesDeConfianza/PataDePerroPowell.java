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
import direcciones.MLinealAloLargoSpestDescent;
import algebralineal.Matriz;
import arquitecturabase.Funcion;


/**
 * En esta clase se encuentra un algoritmo tipo "pata de perro"
 * que hace una transición entre el gradiente descendiente y un método Newton para
 * sistemas no lineales
 * @author Administrator
 *
 */

public class PataDePerroPowell extends RegionDeConfianza{

	private DireccionNewtonRegion direccionNewton;
	private MLinealAloLargoSpestDescent direccionMLinAloLargoSD;


	public PataDePerroPowell(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub


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
		setDireccionMLinAloLargoSD(new MLinealAloLargoSpestDescent(F));
	}

	@Override
	public Matriz getDireccion(Matriz Xn) {
		// TODO Auto-generated method stub

		Matriz direccion;
		double concordancia;

		do{

		direccion=getDireccionRegion(Xn, getRadioConfianza());
		concordancia=concordanciaFuncionModelo(Xn,direccion);
		}
		while(!actualizarRadio(concordancia,direccion));

		return direccion;

	}



	public Matriz getDireccionRegion(Matriz x, double region)
	{
		Matriz dirMlinSD=direccionMLinAloLargoSD.getDireccion(x, getRadioConfianza());
		Matriz stpsdescent=direccionMLinAloLargoSD.getDirGradienteDescendiente();
		Matriz newton=direccionNewton.getDireccion(x, getRadioConfianza());


		if(newton.normaF()<=region)
			return newton;
		else
			if(dirMlinSD.normaF()>=region)
			{
				double t=region*(1.0/stpsdescent.normaF());
				return stpsdescent.por(t);
			}
			else
			{
				double teta=interseccionConRegion(dirMlinSD,newton,region);
				return dirMlinSD.por(1.0-teta).mas(newton.por(teta));
			}



	}

	public double interseccionConRegion(Matriz dirMlinSD, Matriz newton, double region)
	{

		// ver numerical methods for nonlinear algebraic equations - Rabinowitz - página 128

		//region = delta
		//dirMLinSD = ug

		//newton = v

		//parte del numerador  delta^2  -  || ug ||^2
		Matriz t;
		double d1,d2,d3,d4,d5;
		double regioncdrdo=region*region;

		//region^2 || ug ||^2
		t=dirMlinSD.transpuesta().por(dirMlinSD);
		d1=regioncdrdo-t.getElemento(0, 0);


		//parte del denominador;


		// (v-ug , ug)

		t=newton.menos(dirMlinSD);
		t=t.transpuesta().por(dirMlinSD);
		d2=t.getElemento(0, 0);


		// (v ,ug) -region^2
		t=newton.transpuesta().por(dirMlinSD);
		d3=t.getElemento(0, 0)-regioncdrdo;


		// ||v||^2 - region^2

		t=newton.transpuesta().por(newton);
		d4=t.getElemento(0, 0)-regioncdrdo;


		// region^2 - ||ug||^2

		t=dirMlinSD.transpuesta().por(dirMlinSD);
		d5=regioncdrdo-t.getElemento(0, 0);

		return d1/(d2+Math.sqrt( d3*d3  +  d4*d5));
	}


	public MLinealAloLargoSpestDescent getDireccionMLinAloLargoSD() {
		return direccionMLinAloLargoSD;
	}

	public void setDireccionMLinAloLargoSD(
			MLinealAloLargoSpestDescent direccionMLinAloLargoSD) {
		this.direccionMLinAloLargoSD = direccionMLinAloLargoSD;
	}


	public void setDireccionNewton(DireccionNewtonRegion direccionNewton) {
		this.direccionNewton = direccionNewton;
	}

	public DireccionNewtonRegion getDireccionNewton() {
		return direccionNewton;
	}



}
