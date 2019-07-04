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
package criteriosdeparo;

import fabricaabstracta.Fabricas;
import problemasnolineales.MiPortaPapeles;
import algebralineal.Matriz;
import arquitecturabase.CriterioDeParo;
/**
 * Esta clase prueba  el criterio de paro ||Xn-1   -  Xn||
 * @author Ricardo
 *
 */
public class CriterioErrorAbsoluto extends CriterioDeParo{

	private double error;
	private int contadorIteraciones;
	private int numMaxIteraciones;
	private Matriz Xanterior;



	public CriterioErrorAbsoluto()
	{
	 setError(1.0e-5);
	 setContadorIteraciones(0);
	 setNumMaxIteraciones(200);
	}

	@Override
	public boolean evaluar() {
		// TODO Auto-generated method stub

		if(contadorIteraciones>=numMaxIteraciones) //numero máximo de iteraciones
			return true;

		if(contadorIteraciones==0) //primera iteración
		{
			Xanterior=Fabricas.
							fabricaAlgebraLineal.
							crearInstancia(MiPortaPapeles.puntoInicio.getArreglo());

			contadorIteraciones++;
			return false;
		}

		Matriz Xn=MiPortaPapeles.puntoActual;
		double errorabsoluto=Xn.menos(Xanterior).normaFlexible();

		if(errorabsoluto<error)
		{
		 contadorIteraciones++;
			return true;
		}

	    Xanterior=Fabricas.fabricaAlgebraLineal.crearInstancia(Xn.getArreglo());
	    contadorIteraciones++;
		return false;
	}



	public void setError(double error) {
		this.error = error;
	}

	public double getError() {
		return error;
	}

	public void setContadorIteraciones(int contadorIteraciones) {
		this.contadorIteraciones = contadorIteraciones;
	}

	public int getContadorIteraciones() {
		return contadorIteraciones;
	}

	public void setNumMaxIteraciones(int numMaxIteraciones) {
		this.numMaxIteraciones = numMaxIteraciones;
	}

	public int getNumMaxIteraciones() {
		return numMaxIteraciones;
	}

	public Matriz getXanterior() {
		return Xanterior;
	}

	public void setXanterior(Matriz xanterior) {
		Xanterior = xanterior;
	}

	@Override
	public double errorActual() {
		// TODO Auto-generated method stub
		return 0;
	}


}
