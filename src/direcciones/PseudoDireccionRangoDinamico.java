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
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;

/**
 * Esta clase tiene una variante de la dirección Newton propuesta en * el artículo
 * "Robust Methods for Non linear Equations" de J L Blue.
 *
 * Reemplaza la matriz jacobiana J de nxn por una matriz aproximada de k x n,  k<n
 *
 * k cambia gradualmente durante cada iteración hasta que sea igual a n
 */




public class PseudoDireccionRangoDinamico extends DireccionNewton {

	private int iteraciones=0;
	private int cambiarRangoCada=5;
	private int rangoActual=6;		
	private int rangoMaximo=9;
	
	
	public int getIteraciones() {
		return iteraciones;
	}


	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}


	public int getCambiarRangoCada() {
		return cambiarRangoCada;
	}


	public void setCambiarRangoCada(int cambiarRangoCada) {
		this.cambiarRangoCada = cambiarRangoCada;
	}


	public int getRangoActual() {
		return rangoActual;
	}


	public void setRangoActual(int rangoActual) {
		this.rangoActual = rangoActual;
	}


	public int getRangoMaximo() {
		return rangoMaximo;
	}


	public void setRangoMaximo(int rangoMaximo) {
		this.rangoMaximo = rangoMaximo;
	}




	public PseudoDireccionRangoDinamico(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Matriz getDireccion(Matriz Xn) {
		// TODO Auto-generated method stub
		PseudoDireccionSVD pseudodireccion=new PseudoDireccionSVD(getF());
		iteraciones++;

		if(iteraciones==cambiarRangoCada)
		{
			if(rangoActual<rangoMaximo)
			rangoActual++;
			iteraciones=0;
		}

		pseudodireccion.setRangoAproximado(rangoActual);

		return pseudodireccion.getDireccion(Xn);
	}

}
