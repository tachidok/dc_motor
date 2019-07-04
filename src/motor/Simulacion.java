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

package motor;

import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.FirstOrderIntegrator;

import motor.Modelo;


/**
 * Esta clase se encarga de integrar el modelo con el método de integración
 * indicado
 *
 * @author Administrator
 *
 */


public class Simulacion {

	//private  Integrator integrador;
	private Modelo modelo;
	private FirstOrderIntegrator integrador;
	private double tiempoActual;
	private double tiempoFinal;
	private double estadoModelo[];
	private double estadoInicial[];


	public void integrar() {
		// TODO Auto-generated method stub

		double salida[]=new double[4];


		// integrar de tc a tiempo final
		try
		{
		integrador.integrate((FirstOrderDifferentialEquations) modelo,//modelo
								tiempoActual, //tiempo actual
								estadoModelo, //estado actual
								tiempoFinal , //tiempo final
								salida); // estado en el tiempo final

		//actualizo el estado del modelo
		 setEstadoModelo(salida);


		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}




		//int iteraciones=Math.ceil()


	}




	public void setIntegrador(FirstOrderIntegrator integrador) {
		this.integrador = integrador;
	}


	public FirstOrderIntegrator getIntegrador() {
		return integrador;
	}

	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public void setTiempoActual(double tiempoActual) {
		this.tiempoActual = tiempoActual;
	}


	public double getTiempoActual() {
		return tiempoActual;
	}


	public void setTiempoFinal(double tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}


	public double getTiempoFinal() {
		return tiempoFinal;
	}



	public void setEstadoModelo(double estadoModelo[]) {
		this.estadoModelo = estadoModelo;
	}


	public double[] getEstadoModelo() {
		return estadoModelo;
	}




	public void setEstadoInicial(double estadoInicial[]) {
		this.estadoInicial = estadoInicial;
	}




	public double[] getEstadoInicial() {
		return estadoInicial;
	}




}
