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

package motor;
import org.apache.commons.math.ode.FirstOrderIntegrator;
import org.apache.commons.math.ode.nonstiff.ClassicalRungeKuttaIntegrator;



/**
 * En esta clase se asignan todos los par�metros y el integrador
 * usado para encontrar los param�tros �ptimos en  el modelo del motor DC
 * @author Administrator
 *
 */

public class BotonRojo {

	private FuncionCosto funcion;


	public void arracar()
	{

		double u[] = {10.0,10.0,10.0};


		//Modelo

		Modelo modelo= new Modelo();

		//par�metros del modelo

		modelo.setK(u);
		modelo.setB(2.0/3.0);
		modelo.setJ(2.0);
		modelo.setRf(10.0);
		modelo.setKt(10.0);
		modelo.setR(0.001);
		modelo.setLf(10.0);




		//selecciono el integrador
		FirstOrderIntegrator rungekutta4 = new ClassicalRungeKuttaIntegrator(0.01);

		Simulacion simulador = new Simulacion();


		simulador.setIntegrador(rungekutta4);
		simulador.setModelo(modelo);

		//par�metros de simulacion
		simulador.setTiempoActual(0.0);
		simulador.setTiempoFinal(3.3);
		double x0[] = {0.0,0.0,0.0,0.0};
		double xc[] = {0.0,0.0,0.0,0.0};
		simulador.setEstadoInicial(x0);
		simulador.setEstadoModelo(xc);



		//par�metros de la funcion costo
		funcion=new FuncionCosto();

		funcion.setW1(0.0);
		funcion.setW2(0.0);
		funcion.setW3(0.0);

		//env�o el simulador del motor
		funcion.setSimulador(simulador);



	}



	public void setFuncion(FuncionCosto funcion) {
		this.funcion = funcion;
	}


	public FuncionCosto getFuncion() {
		return funcion;
	}



}
