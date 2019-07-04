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


package derivadas;

import java.util.ArrayList;

import arquitecturabase.Funcion;

import problemasnolineales.MiPortaPapeles;


import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 * Esta clase se encarga de instanciar las clases en las que se definen
 * los algoritmos usados para calcular derivadas de segundo  orden
 *
 * @author Ricardo
 * @version 1.0
 */

public class FbDerivadasSegundoOrden extends FabricaAbstracta {

	private final int ID_HessianaIdentidad=1;
	private final int ID_HessianaDiferencias=2;
	private final int ID_BFGS=3;

	public FbDerivadasSegundoOrden(ArrayList<Observador> observadores) {
		super(observadores);
		// TODO Auto-generated constructor stub

		add(ID_HessianaIdentidad,"Identidad");
		add(ID_HessianaDiferencias,"Hessiana por diferencias");
		add(ID_BFGS,"BFGS");

		setInstancia(ID_HessianaDiferencias);
	}


	public FbDerivadasSegundoOrden ()
	{
		setInstancia(ID_HessianaDiferencias);

	}


	@Override
	public void add(int idInstancia, String descripcion) {
		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

	@Override
	public Object crearInstancia() {
		// TODO Auto-generated method stub

		switch(instancia){
		case ID_HessianaIdentidad: return new HessianaIdentidad(null);
		default:
		return null;
		}

	}

	public DerivadaSegundoOrden crearInstancia(Funcion F) {

		switch(instancia){
		case ID_HessianaIdentidad: return new HessianaIdentidad(F);
		case ID_HessianaDiferencias:return new HessianaDiferencias(F);
		case ID_BFGS:return new BFGS(F,MiPortaPapeles.puntoInicio);
		default:
		return null;
		}

	}






}
