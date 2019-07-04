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

package fabricaabstracta;
import java.util.ArrayList;

import criteriosdeparo.FbCriteriosParo;

import newtonsconcretos.FbTiposNewton;
import problemasnolineales.FbProblemaNoLineal;
import lineasdebusqueda.FbLineasBusqueda;
import derivadas.FbDerivadasPrimerOrden;
import derivadas.FbDerivadasSegundoOrden;
import funciones.FbFunciones;
import algebralineal.FbAlgebraLineal;
import algebralineal.FbNormas;


/**
 *	Esta clase es una fachada para las distintas f�bricas encargadas de instanciar
 *  la arquitectura para m�todos Newton. La clase Fabrica hace uso del patr�n singleton
 *  para tener s�lo una instancia de las diversas f�bricas usadas en la arquitectura.
 *
 * @author Ricardo Serrato
 * @version 1.0
 *
 */
public final class Fabricas {


	/**
	 * F�brica para la familia encargada de calcular derivadas de primer orden
	 */
	public static FbDerivadasPrimerOrden fabricaDerivadasPrimerOrden;

	/**
	 * F�brica para la familia encargada de calcular derivadas de segundo orden
	 */
	public static FbDerivadasSegundoOrden fabricaDerivadasSegundoOrden;

	/**
	 *F�brica para la familia de problemas no lineales
	 */
	public static FbProblemaNoLineal fabricaProblemaNoLineal;

	/**
	 * F�brica para los adaptadores de algebra lineal y operaciones con matrices
	 */
	public static FbAlgebraLineal fabricaAlgebraLineal;

	/**
	 * F�brica para la familia de m�todos del tipo Newton
	 */
	public static FbTiposNewton fabricaTiposNewton;

	/**
	 * F�brica para la familia de funciones
	 */
    public static FbFunciones fabricaFunciones;

    /**
     * Variable que sirve para accesar las distintas f�bricas usadas en la arquitectura
     */

    public static FbLineasBusqueda fabricaLineasBusqueda;

    public static FbNormas fabricaDeNormas;

    public static FbCriteriosParo fabricacriterios;

	private static Fabricas fabrica=null;

	/**
	 * Constructor de las f�bricas
	 * @param observadores
	 */

	private Fabricas(ArrayList <Observador> observadores)
	{
		fabricaDerivadasPrimerOrden=new FbDerivadasPrimerOrden(observadores);
		fabricaDerivadasSegundoOrden=new FbDerivadasSegundoOrden(observadores);
		fabricaProblemaNoLineal=new FbProblemaNoLineal(observadores);
		fabricaAlgebraLineal=new FbAlgebraLineal(observadores);
		fabricaTiposNewton=new FbTiposNewton(observadores);
        fabricaFunciones= new FbFunciones(observadores);
        fabricaLineasBusqueda=new FbLineasBusqueda(observadores);
        fabricacriterios=new FbCriteriosParo(observadores);
        fabricaDeNormas=new FbNormas(observadores);
	}

	/**
	 * M�todo para asegurar una s�la instancia de cada f�brica (Singleton)
	 * @param observadores
	 */
	public static void crearFabrica(ArrayList<Observador> observadores)
	{
		if(fabrica!=null)
			return;

		fabrica=new Fabricas(observadores);

	}

	public static void crearFabrica()
	{
		if(fabrica!=null)
			return;

		fabrica=new Fabricas();

	}

	private Fabricas()
	{
		fabricaDerivadasPrimerOrden=new FbDerivadasPrimerOrden();
		fabricaDerivadasSegundoOrden=new FbDerivadasSegundoOrden();
		fabricaProblemaNoLineal=new FbProblemaNoLineal();
		fabricaAlgebraLineal=new FbAlgebraLineal();
		fabricaTiposNewton=new FbTiposNewton();
        fabricaFunciones= new FbFunciones();
        fabricaLineasBusqueda=new FbLineasBusqueda();
        fabricaDeNormas=new FbNormas();
        fabricacriterios=new FbCriteriosParo();
	}

}
