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
 * Esta clase forma parte del patrón Modelo Vista Controlador. Observador notifica
 * a Vista y Controlador de los cambios en el Modelo.
 * @author Ricardo
 * @see Modelo, ModeloNewton, Vista, InstanciadorNewton, Observador, Controlador
 */

public interface Observador {

	public abstract void notificar();
	public abstract void instanciaAgregada(FbDerivadasPrimerOrden i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbDerivadasSegundoOrden i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbProblemaNoLineal i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbAlgebraLineal i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbTiposNewton i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbFunciones i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbLineasBusqueda i,int idInstancia, String descripcion);
	public abstract void puntoAgregado(double [][] puntoActual,double punto, int iteracion, int numEvaluaciones, long tiempo, double normaDFx);
	public abstract void instanciaAgregada(FbNormas i,int idInstancia, String descripcion);
	public abstract void instanciaAgregada(FbCriteriosParo fbCriteriosParo,
			int idInstancia, String descripcion);

}