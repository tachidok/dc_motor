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

package problemasnolineales;
import java.util.ArrayList;

import arquitecturabase.Funcion;


import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 * Esta clase se encarga de instanciar el tipo de problema no lineal en la
 * arquitectura para Newtons
 *
 * @author Ricardo
 *
 */

public class FbProblemaNoLineal extends FabricaAbstracta{

	/**
	 * Identificador para instanciar la clase MinimosCuadrados
	 */
    private final int ID_MinimosCuadrados=1;
    /**
     * Identificador para instanciar la clase OptimizacionSinRestricciones
     */
    private  final int ID_OptimizacionSinRestricciones=2;
    /**
     * Identificador para instanciar la clase SistemasNoLineales
     */
    private final int ID_SistemasNoLineales=3;


	public FbProblemaNoLineal()
	{

	}

    public FbProblemaNoLineal(ArrayList<Observador> observadores) {
		super(observadores);


		add(ID_MinimosCuadrados,"Mínimos cuadrados");
		add(ID_OptimizacionSinRestricciones,"Optimización sin restricciones");
		add(ID_SistemasNoLineales,"Sistemas no lineales" );
	}




	@Override
	public void add(int idInstancia, String descripcion) {
		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}
	}

	@Override
	public ProblemaNoLineal crearInstancia() {


                switch (instancia)
                {
                case ID_MinimosCuadrados: return new MinimosCuadrados(null);
                case ID_OptimizacionSinRestricciones: return new OptimizacionSinRestricciones(null);
                case ID_SistemasNoLineales: return new SistemasNoLineales(null);

                    default: return null;
                }


	}


	public ProblemaNoLineal crearInstancia(Funcion F) {


        switch (instancia)
        {
        case ID_MinimosCuadrados: return new MinimosCuadrados(F);
        case ID_OptimizacionSinRestricciones: return new OptimizacionSinRestricciones(F);
        case ID_SistemasNoLineales: return new SistemasNoLineales(F);

         default: return null;
        }


}




}
