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
 *	Esta clase es una fachada para las distintas fábricas encargadas de instanciar
 *  la arquitectura para métodos Newton. La clase Fabrica hace uso del patrón singleton
 *  para tener sólo una instancia de las diversas fábricas usadas en la arquitectura.
 *
 * @author Ricardo Serrato
 * @version 1.0
 *
 */
public final class Fabricas {


	/**
	 * Fábrica para la familia encargada de calcular derivadas de primer orden
	 */
	public static FbDerivadasPrimerOrden fabricaDerivadasPrimerOrden;

	/**
	 * Fábrica para la familia encargada de calcular derivadas de segundo orden
	 */
	public static FbDerivadasSegundoOrden fabricaDerivadasSegundoOrden;

	/**
	 *Fábrica para la familia de problemas no lineales
	 */
	public static FbProblemaNoLineal fabricaProblemaNoLineal;

	/**
	 * Fábrica para los adaptadores de algebra lineal y operaciones con matrices
	 */
	public static FbAlgebraLineal fabricaAlgebraLineal;

	/**
	 * Fábrica para la familia de métodos del tipo Newton
	 */
	public static FbTiposNewton fabricaTiposNewton;

	/**
	 * Fábrica para la familia de funciones
	 */
    public static FbFunciones fabricaFunciones;

    /**
     * Variable que sirve para accesar las distintas fábricas usadas en la arquitectura
     */

    public static FbLineasBusqueda fabricaLineasBusqueda;

    public static FbNormas fabricaDeNormas;

    public static FbCriteriosParo fabricacriterios;

	private static Fabricas fabrica=null;

	/**
	 * Constructor de las fábricas
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
	 * Método para asegurar una sóla instancia de cada fábrica (Singleton)
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
