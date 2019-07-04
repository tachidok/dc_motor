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

package vistas;
import problemasnolineales.MiPortaPapeles;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import arquitecturabase.Newton;
import arquitecturabase.NewtonGenerico;
import fabricaabstracta.Fabricas;
import fabricaabstracta.Modelo;
import fabricaabstracta.Observador;


/**
 * Esta clase es el modelo dentro del patrón modelo vista controlador. Se encarga de
 * realizar las operaciones básicas de un método iterativo (iterar y resolver). Es una
 * caja negra de la arquitectura para métodos Newton.
 *
 *
 * @author Ricardo
 *
 */
public class ModeloNewton extends Modelo{

    private  double[][] puntoInicio;
	private  int iteracion=1;
	private long tiempoEjecucion=(long) 0.0;

	/**
	 * Método Newton
	 */
	private Newton newton;

	public ModeloNewton()
	{
		iteracion=0;
	}

	/**
	 * Asigna el método Newton
	 * @param newton
	 */

	public void setNewton(Newton newton) {
		this.newton = newton;
	}

       public void setPuntoInicio(double[][] puntoInicio) {
        this.puntoInicio = puntoInicio;

        }

     public double[][] getPuntoInicio() {
        return puntoInicio;
     }

	/**
	 * Devuelve el método Newton del modelo
	 * @return
	 */

	public Newton getNewton() {
		return newton;
	}

	/**
	 * Realiza una iteración con el método Newton
	 */

	public void itera()
	{



		long tiempoInicio=System.nanoTime();
		Matriz Xn=Fabricas.fabricaAlgebraLineal.crearInstancia(MiPortaPapeles.puntoActual.getArreglo());

		newton.itera();

		long tiempoFinal=System.nanoTime()-tiempoInicio;

		notificarNuevoPunto(Xn,MiPortaPapeles.Fx.normaF(),iteracion,MiPortaPapeles.contador, tiempoEjecucion, MiPortaPapeles.DFx.normaF());

		tiempoEjecucion+=tiempoFinal;
		iteracion++;
	}

	/**
	 *  Resuelve un problema dado con el método Newton
	 */

	public void resolver()
	{

	boolean continuar=true;
		do
		{



			long tiempoInicio=System.nanoTime();
			Matriz Xn=Fabricas.fabricaAlgebraLineal.crearInstancia(MiPortaPapeles.puntoActual.getArreglo());
			continuar=newton.iteraUsandoCriterio();
			long tiempoFinal=System.nanoTime()-tiempoInicio;

			notificarNuevoPunto(Xn,MiPortaPapeles.Fx.normaF(),iteracion,MiPortaPapeles.contador, tiempoEjecucion, MiPortaPapeles.DFx.normaF());

			tiempoEjecucion+=tiempoFinal;
			iteracion++;
		}
        while(continuar);
	}

/**
 * Este método prepara la arquitectura para que pueda ser utilizada
 */
	public void instanciarNuevoNewton()
	{
 		Matriz puntoinicial=Fabricas.fabricaAlgebraLineal.crearInstancia(puntoInicio);
		Funcion funcion=Fabricas.fabricaFunciones.crearInstancia();;


		MiPortaPapeles.puntoInicio=puntoinicial;
		MiPortaPapeles.funcion=funcion;



		newton=new NewtonGenerico();
		newton.getImplementacion().setXn(Fabricas.fabricaAlgebraLineal.crearInstancia(puntoInicio));

		MiPortaPapeles.actualizarValores(funcion, puntoinicial);
		reiniciarIteracion();



	}


	public void notificarNuevoPunto(Matriz puntoActual,double punto, int iteracion, int numEvaluaciones,long tiempoEjecucion, double normaDfx)
	{
		for(Observador o:getObservadores())
		{
			o.puntoAgregado(puntoActual.getArreglo(),punto,iteracion,numEvaluaciones, tiempoEjecucion, normaDfx);
		}
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}

	public int getIteracion() {
		return iteracion;
	}


	public void reiniciarIteracion()
	{
		iteracion=0;
		tiempoEjecucion=0;
	}
}
