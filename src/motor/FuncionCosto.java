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

/**
 * Esta clase es la función costo del mortor DC
 * @author Administrator
 *
 */
public class FuncionCosto{


	private Simulacion simulador;

	private int numVariables;
	private int numFunciones;

	private double w1;
	private double w2;
	private double w3;


	public FuncionCosto()
	{
		setNumVariables(3);
		setNumFunciones(1);
	}


	public double[] evaluarFuncion(double[] u) {
		// TODO Auto-generated method stub

		double salida[]=new double[1];
		Modelo modelo=simulador.getModelo();

		modelo.setK(u);// el modelo depende de este vector

		simulador.integrar();//con esto obtengo el estado del modelo hasta el tiempo final
							// el valor se queda en simulador.estadoActual


		//obtengo el estado del modelo
		double xc[]=simulador.getEstadoModelo();


		//funcionCosto
		salida[0]= xc[0] +  w1*Math.pow(xc[1]-10, 2.0) + w2*Math.pow(xc[2],2.0) + w3*Math.pow(xc[3],2.0);

		//regreso el modelo al estado inicial
		simulador.setEstadoModelo(simulador.getEstadoInicial());

		return salida;
	}




	public void setNumVariables(int numVariables) {
		this.numVariables = numVariables;
	}

	public int getNumVariables() {
		return numVariables;
	}

	public void setNumFunciones(int numFunciones) {
		this.numFunciones = numFunciones;
	}

	public int getNumFunciones() {
		return numFunciones;
	}


	public void setSimulador(Simulacion simulador) {
		this.simulador = simulador;
	}


	public Simulacion getSimulador() {
		return simulador;
	}


	public void setW1(double w1) {
		this.w1 = w1;
	}


	public double getW1() {
		return w1;
	}


	public void setW2(double w2) {
		this.w2 = w2;
	}


	public double getW2() {
		return w2;
	}


	public void setW3(double w3) {
		this.w3 = w3;
	}


	public double getW3() {
		return w3;
	}

}
