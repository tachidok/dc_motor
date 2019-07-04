
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
package criteriosdeparo;


import java.util.ArrayList;

import arquitecturabase.CriterioDeParo;

import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;

/**
 * Esta clase es una f�brica para instanciar los distintos criterios de paro en un m�todo iterativo.
 * @author Administrator
 *
 */
public class FbCriteriosParo extends FabricaAbstracta{

private final int  ID_criterioKelley=1;
private final int  ID_ErrorAbsoluto=2;
private final int  ID_ErrorRelativo=3;

	public FbCriteriosParo(ArrayList<Observador> observadores) {
	super(observadores);

	add(ID_criterioKelley,"Criterio Kelley");
	add(ID_ErrorAbsoluto,"ErrorAbsoluto");
	add(ID_ErrorRelativo,"ErrorRelativo");
	setInstancia(ID_ErrorRelativo);
}

	public FbCriteriosParo() {
		setInstancia(ID_ErrorRelativo);
	}

	@Override
	public CriterioDeParo crearInstancia() {
        switch (instancia)
        {
        case ID_criterioKelley: return new CriterioKelley();
        case ID_ErrorAbsoluto: return new CriterioErrorAbsoluto();
        case ID_ErrorRelativo: return new CriterioErrorRelativo();
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
