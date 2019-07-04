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

import problemasnolineales.MiPortaPapeles;
import algebralineal.Matriz;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.Funcion;


/**
 * Esta es una condición de paro de la forma fx < = ta* f0 + te
 * @author Administrator
 *
 */
public class CriterioKelley extends CriterioDeParo{
	private Matriz Finicial;
	private Funcion funcion;
	private int numMaxIteraciones;
	private double tolRelativa=1e-5;
	private double tolAbsoluta=1e-2;
	private int contadorEvaluaciones;

	public CriterioKelley()
	{
		setFuncion(MiPortaPapeles.funcion);
		setFinicial(MiPortaPapeles.Fx);
		setNumMaxIteraciones(200);
		setContadorEvaluaciones(0);
	}

	@Override
	public boolean evaluar() {

		if(contadorEvaluaciones>numMaxIteraciones)
			return true;

		double Factual = MiPortaPapeles.Fx.normaFlexible();
		double Finicio= Finicial.normaFlexible();

		contadorEvaluaciones++;
		if(Factual<=tolRelativa*Finicio+tolAbsoluta)
			return true;

		return false;
	}

	public void setFinicial(Matriz finicial) {
		Finicial = finicial;
	}

	public Matriz getFinicial() {
		return Finicial;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setTolRelativa(double tolRelativa) {
		this.tolRelativa = tolRelativa;
	}

	public double getTolRelativa() {
		return tolRelativa;
	}

	public void setTolAbsoluta(double tolAbsoluta) {
		this.tolAbsoluta = tolAbsoluta;
	}

	public double getTolAbsoluta() {
		return tolAbsoluta;
	}



	public void setNumMaxIteraciones(int numMaxIteraciones) {
		this.numMaxIteraciones = numMaxIteraciones;
	}

	public int getNumMaxIteraciones() {
		return numMaxIteraciones;
	}

	public void setContadorEvaluaciones(int contadorEvaluaciones) {
		this.contadorEvaluaciones = contadorEvaluaciones;
	}

	public int getContadorEvaluaciones() {
		return contadorEvaluaciones;
	}

	@Override
	public double errorActual() {
		// TODO Auto-generated method stub
		return 0;
	}


}
