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


import problemasnolineales.MiPortaPapeles;
import PrecisionNumerica.MiPrecisionNumerica;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * Esta clase es parte de un algoritmo de línea de búsqueda que utiliza backtracking
 */
public class Backtracking extends EstrgsLineasBusqueda{

	private int MaxNumIteraciones;

	public Backtracking(Funcion F) {
		super(F);
		MaxNumIteraciones=15;
		CondicionDecremento c=getCondicionDecrecimiento();
		c.setEstrategia(new CondicionSimple(F));
		// TODO Auto-generated constructor stub
	}

	public void setMaxNumIteraciones(int maxNumIteraciones) {
		MaxNumIteraciones = maxNumIteraciones;
	}

	public int getMaxNumIteraciones() {
		return MaxNumIteraciones;
	}



	public double getLongitudDePaso(Matriz direccion, Matriz x) {

		double alfa=1.0;
		double Fx=MiPortaPapeles.FxDeAcuerdoAlProblema;
		boolean condDecremento=getCondicionDecrecimiento().evaluar(alfa, direccion,Fx,x);
		int i=1;

		while(!condDecremento && alfa>MiPrecisionNumerica.EPSILON && MaxNumIteraciones>i )
		{
			alfa=alfa/2.0;
			condDecremento=getCondicionDecrecimiento().evaluar(alfa, direccion,Fx,x);
			i++;
		}

		return alfa;
	}

}
