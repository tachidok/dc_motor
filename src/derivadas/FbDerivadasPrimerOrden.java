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
import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;

import java.util.ArrayList;

import arquitecturabase.Funcion;

import problemasnolineales.MiPortaPapeles;


/**
 * Esta clase se encarga de instanciar las clases en las que se definen
 * los algoritmos usados para calcular derivadas de primer orden
 *
 * @author Ricardo
 * @version 1.0
 */

public class FbDerivadasPrimerOrden extends FabricaAbstracta {

	/**
	 * Identificador para la clase DMiFuncion
	 */
	private final int ID_DMiFuncion=1;
	private final int ID_Diferencias=2;
	private final int ID_QuasiBroyden=3;
	private final int ID_DFuncion2=4;
	private final int ID_DiferenciasGustavo=5;

	public FbDerivadasPrimerOrden ()
	{
		setInstancia(ID_DiferenciasGustavo);
	}


	public FbDerivadasPrimerOrden(ArrayList<Observador> observadores) {
		super(observadores);

		add(ID_DMiFuncion,"DMiFuncion");
		add(ID_Diferencias,"Diferencias");
		add(ID_QuasiBroyden,"QuasiBroyden");
		add(ID_DFuncion2,"DFuncion2");
		add(ID_DiferenciasGustavo,"Diferencias gustavo");

		setInstancia(ID_DiferenciasGustavo);
	}

	@Override
	public void add(int idInstancia, String descripcion) {

		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

	/**
	 * Devuelve un objeto DerivadaPrimerOrden
	 * @param F
	 * @return DerivadaPrimerOrden
	 */
	public DerivadaPrimerOrden crearInstancia(Funcion F) {

		switch (instancia)
		{
			case ID_DMiFuncion: return new DMiFuncion(F);
			case ID_Diferencias: return new Diferencias(F);
			case ID_QuasiBroyden: return new QuasiBroyden(F, MiPortaPapeles.puntoInicio);
			case ID_DFuncion2: return new DFuncionConteBoor(F);
			case ID_DiferenciasGustavo: return new DiferenciasGustavo(F);
			default: return null;
		}


	}

	@Override
	public DerivadaPrimerOrden crearInstancia() {

		switch (instancia)
		{
			case ID_DMiFuncion: return new DMiFuncion(null);
			case ID_Diferencias: return new Diferencias(null);
			case ID_QuasiBroyden: return new QuasiBroyden(null,null);
			default: return null;
		}


	}





}
