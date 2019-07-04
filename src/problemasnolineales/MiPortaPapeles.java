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

import fabricaabstracta.Fabricas;
import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 *  Esta clase es un patrón singleton en donde se almacenan los datos
 *  más utilizados en el método, por ejemplo el valor de la función en el
 *  punto xn, la primera derivada de la función, el punto de inicio, etc
 *
 */
public final class MiPortaPapeles extends PortaPapeles{


	public static Matriz puntoInicio;
	public static Matriz puntoActual;
	public static Funcion funcion;
	public static boolean vacio;
	public static Matriz Fx;
	public static double FxDeAcuerdoAlProblema;
	public static Matriz DFx;
	public static Matriz DDFx;
	public static int contador;

	public static Matriz EdoFx;
	public static Matriz EdoFxDeAcuerdoAlProblema;
	public static Matriz EdoDFx;
	public static Matriz EdoDDFx;


	public final static  MiPortaPapeles instancia=new MiPortaPapeles();

	private MiPortaPapeles()
	{

		vacio=true;
	}

	public static void actualizarValores(Funcion F, Matriz Xn)
	{


			if(!(MiPortaPapeles.EdoFx!=null && MiPortaPapeles.EdoFx.equals(Xn)))
			Fx=F.evaluar(Xn);

			EdoFx=Fabricas.fabricaAlgebraLineal.crearInstancia((Xn.getArreglo()));

			FxDeAcuerdoAlProblema=F.evaluarDeAcuerdoAlProblema(Xn);
			EdoFxDeAcuerdoAlProblema=Fabricas.fabricaAlgebraLineal.crearInstancia((Xn.getArreglo()));

			DFx=F.primeraDerivada(Xn);
			EdoDFx=Fabricas.fabricaAlgebraLineal.crearInstancia((Xn.getArreglo()));;

			DDFx=F.segundaDerivada(Xn);
			EdoDDFx=Fabricas.fabricaAlgebraLineal.crearInstancia((Xn.getArreglo()));;

			contador=F.getContadorDeEvaluaciones();

			puntoActual=Xn;
			vacio=false;
	}

	public static void  actualizarPunto(Matriz m)
	{
		MiPortaPapeles.puntoActual=Fabricas.fabricaAlgebraLineal.crearInstancia(m.getArreglo());
	}
/*
	public static Matriz getPuntoInicio()
	{
// f1 y f2
		double d[][]=new double[2][1];

		d[0][0]=1;
		d[1][0]=1;
/*

		double d[][]=new double[6][1];
		d[0][0]=0.0;
		d[1][0]=0.0;
		d[2][0]=0.0;
		d[3][0]=1.0;
		d[4][0]=1.0;
		d[5][0]=0.0;


*/
		//f3

	/*	double d[][]=new double[3][1];

		d[0][0]=0.5;
		d[1][0]=0.5;
		d[2][0]=0.5;
*/
//		return Fabrica.fabricaAlgebraLineal.crearInstancia(d);
//	}

}
