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

package newtonsconcretos;
import java.util.ArrayList;

import problemasnolineales.MiPortaPapeles;
import arquitecturabase.NewtonImp;
import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 * Esta clase se encarga de instanciar el tipo de Newton a utilizar en la
 * arquitectura para Newtons
 *
 * @author Ricardo
 *
 */

public class FbTiposNewton extends FabricaAbstracta{

	/**
	 * Identificador para instanciar la clase NewtonClasico
	 */
	private final int ID_NewtonClasico=1;
	private final int ID_EmpinadaDescendiente=2;
	private final int ID_NewtonCauchy=3;

	private final int ID_NewtonDirSegundoOrden=5;
	private final int ID_NewtonPataNocedal=6;
	private final int ID_NewtonHibridoBlue=7;
	private final int ID_NewtonPataPowell=8;


	public FbTiposNewton()
	{

	}

	public FbTiposNewton(ArrayList<Observador> observadores)
	{
		super(observadores);
		add(ID_NewtonClasico,"Newton Clásico");
		add(ID_EmpinadaDescendiente,"Gradiente descendiente");
		add(ID_NewtonCauchy,"Newton cauchy");
		add(ID_NewtonDirSegundoOrden,"Newton dirección segundo orden");
		add(ID_NewtonPataNocedal,"Pata de perro de Nocedal");
		add(ID_NewtonHibridoBlue,"Newton Híbrido Blue");
		add(ID_NewtonPataPowell,"Newton pata Powell");
	}

	@Override
	public void add(int idInstancia, String descripcion) {

		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

	/**
	 * Devuelve un objeto NewtonImp
	 */
	public NewtonImp crearInstancia() {

		switch (instancia)
		{
			case ID_NewtonClasico: return new NewtonClasico(MiPortaPapeles.funcion);
			case ID_EmpinadaDescendiente: return new GradienteDescendiente(MiPortaPapeles.funcion);
			case ID_NewtonCauchy: return new NewtonCauchy(MiPortaPapeles.funcion);
			case ID_NewtonDirSegundoOrden: return new NewtonOptimizacion(MiPortaPapeles.funcion);
			case ID_NewtonPataNocedal:return new NewtonPataNocedal(MiPortaPapeles.funcion);
			case ID_NewtonHibridoBlue:return new NewtonHibridoBlue(MiPortaPapeles.funcion);
			case ID_NewtonPataPowell:return new PataPowell(MiPortaPapeles.funcion);
			default: return null;
		}


	}





}
