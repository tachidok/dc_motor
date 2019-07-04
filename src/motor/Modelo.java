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

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;

import ModelMVC.ModelRK.equation_system.Model;

/**
 * En esta clase se evalúan las derivadas que conforman el modelo del motor DC
 *
 *
 * variables de estado:
 *
 * x1 = es el costo para poner el eje en la posición angular deseada
 * x2 = es la posición del eje
 * x3 = es el cambio de la posicición del eje con respecto del tiempo
 * x4 = es la corriente que controla el torque del motor
 *
 * @author Administrator
 *
 */
public class Modelo extends Model implements FirstOrderDifferentialEquations{


	/**
	 * vector K=[k1, k2, k3]
	 *
	 * usado para la ley de control del motor: u = - K' x  + k1 * r , r es la posición del eje deseada
	 * x es el estado del modelo
	 */
	private double K[];


	/**
	 * Es el amortiguamiento rotacional
	 */
	private double B;


	/**
	 * Es el momento de inercia en el eje
	 */
	private double J;


	/**
	 * Resistencia del circuito estator
	 */
	private double Rf;

	/**
	 * Es una constante del motor
	 */
	private double Kt;

	/**
	 * Es una constante para limitar la energia aplicada
	 */
	private double R;


	/**
	 * Inductancia en la bobina
	 */
	private double Lf;


	public double[] evaluateModel(double t, double... x) {
		// TODO Auto-generated method stub


		double dxdt[]=new double[4];

		double ef=K[0]*(10 - x[1]) - K[1]*x[2] - K[2]*x[3];
		dxdt[0] = Math.pow(10 - x[1], 2.0) + R *Math.pow(ef, 2);
		dxdt[1] = x[2];
		dxdt[2] = -(B /J )*x[2] + (Kt / J)*x[3];
		//dxdt[3] = -(Rf / Lf)*x[3] + ef/Lf;
		dxdt[3] = (-Rf*x[3] + ef) / Lf;


		return dxdt;
	}



	@Override
	public void computeDerivatives(double t, double[] x, double[] dxdt)
			throws DerivativeException {
		// TODO Auto-generated method stub

		double ef=K[0]*(10 - x[1]) - K[1]*x[2] - K[2]*x[3];
		dxdt[0]=Math.pow(10 - x[1], 2.0) + R *Math.pow(ef, 2);
		dxdt[1]=x[2];
		dxdt[2]=-(B /J )*x[2] + (Kt / J)*x[3];
		//dxdt[3]=-(Rf / Lf)*x[3] + ef/Lf;
		dxdt[3] = (-Rf*x[3] + ef) / Lf;
	}

	@Override
	public int getDimension() {
		// TODO Auto-generated method stub
		return 4;
	}	@Override
	public int getEcuationsCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public void setK(double k[]) {
		K = k;
	}

	public double[] getK() {
		return K;
	}

	public void setB(double b) {
		B = b;
	}

	public double getB() {
		return B;
	}

	public void setJ(double j) {
		J = j;
	}

	public double getJ() {
		return J;
	}

	public void setRf(double rf) {
		Rf = rf;
	}

	public double getRf() {
		return Rf;
	}

	public void setKt(double kt) {
		Kt = kt;
	}

	public double getKt() {
		return Kt;
	}

	public void setR(double r) {
		R = r;
	}

	public double getR() {
		return R;
	}

	public void setLf(double lf) {
		Lf = lf;
	}

	public double getLf() {
		return Lf;
	}

}
