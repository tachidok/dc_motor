/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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

package algebralineal;
import java.util.ArrayList;

import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 * Esta clase es una fábrica para instancar las diferentes normas usadas en la arquitectura
 *
 */


public class FbNormas extends FabricaAbstracta{

	private final int ID_EUCLIDIANA=1;
	private final int ID_INFINITO=2;

	public FbNormas(ArrayList<Observador> observadores)
	{
		super(observadores);
		add(ID_EUCLIDIANA,"Euclidiana");
		add(ID_INFINITO,"Infinito");
		setInstancia(ID_EUCLIDIANA);
	}

	public FbNormas()
	{
		setInstancia(ID_EUCLIDIANA);
	}


	@Override
	public NormaFlexible crearInstancia() {

		switch (instancia)
		{
			case ID_EUCLIDIANA: return new NormaEuclidiana();
			case ID_INFINITO: return new NormaInfinito();
			default: return null;
		}
	}

	@Override
	public void add(int idInstancia, String descripcion) {
		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

}
