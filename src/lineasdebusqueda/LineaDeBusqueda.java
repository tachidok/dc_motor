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

import algebralineal.Matriz;
import arquitecturabase.Funcion;
import arquitecturabase.LongitudDePaso;
import fabricaabstracta.Fabricas;


/**
 * Esta clase es parte del patrón estrategia, sirve para poder intercambiar de manera sencilla
 * entre distintas líneas de búsqueda
 * @author Administrator
 *
 */

public class LineaDeBusqueda extends LongitudDePaso{

	private EstrgsLineasBusqueda estrategia;


	public LineaDeBusqueda(Funcion F)
	{
		estrategia=Fabricas.fabricaLineasBusqueda.crearInstancia(F);
	}

	@Override
	public double getLongitudDePaso(Matriz direccion, Matriz x) {
		return estrategia.getLongitudDePaso(direccion, x);

	}

	public void setEstrategia(EstrgsLineasBusqueda estrategia) {
		this.estrategia = estrategia;
	}

	public EstrgsLineasBusqueda getEstrategia() {
		return estrategia;
	}

}
