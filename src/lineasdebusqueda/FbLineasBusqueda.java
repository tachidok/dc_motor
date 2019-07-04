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


package lineasdebusqueda;

import java.util.ArrayList;

import arquitecturabase.Funcion;


import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;

/**
 * Esta clase está encargada de crear los distintos algoritmos de líneas de búsqueda
 * @author Administrator
 *
 */

public class FbLineasBusqueda extends FabricaAbstracta {

	private final int ID_LineaBacktracking=1;
	private final int ID_LineaBurda=2;
	private final int LBArmijo=3;

	public FbLineasBusqueda()
	{
		setInstancia(LBArmijo);
	}

	public FbLineasBusqueda(ArrayList<Observador> observadores) {
		super(observadores);
		add(ID_LineaBurda,"Línea burda");
		add(ID_LineaBacktracking,"Línea backtracking");
		add(LBArmijo,"Línea Armijo");
	}


	@Override
	public void add(int idInstancia, String descripcion) {

		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}


	public EstrgsLineasBusqueda crearInstancia(Funcion F) {

		switch (instancia)
		{
			case ID_LineaBacktracking: return new Backtracking(F);
			case ID_LineaBurda: return new LineaBurda(F);
			case LBArmijo: return new LBReglaArmijo(F);

			default: return null;
		}


	}

	@Override
	public Object crearInstancia() {
		// TODO Auto-generated method stub
		return null;
	}

}
