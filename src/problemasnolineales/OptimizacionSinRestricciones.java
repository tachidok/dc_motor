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

import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 *Esta clase define el comportamiento de la clase Funcion, de acuerdo al
 *problema de optimizaciónn sin restricciones
 *
 * @author Ricardo
 * @version 1.0
 * @see Funcion, MinimosCuadrados, OptimizacionSinRestricciones, SistemasNoLineales
 */

public class OptimizacionSinRestricciones extends  ProblemaNoLineal
{

	public OptimizacionSinRestricciones(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluarDeAcuerdoAlProblema(Funcion F, Matriz x) {
		// TODO Auto-generated method stub

		if( MiPortaPapeles.EdoFx!=null && MiPortaPapeles.EdoFx.equals(x))
			return MiPortaPapeles.Fx.getElemento(0, 0);

		return F.evaluar(x).getElemento(0, 0);
	}

	@Override
	public Matriz primerDerivada(Funcion F, Matriz x) {


		if( MiPortaPapeles.EdoDFx!=null && MiPortaPapeles.EdoDFx.equals(x))
			return MiPortaPapeles.DFx;
		else
			return getPrimeraDerivada().evaluar(x).transpuesta();


	}

	@Override
	public Matriz segundaDerivada(Funcion F, Matriz x) {
		// TODO Auto-generated method stub

		if( MiPortaPapeles.EdoDDFx!=null && MiPortaPapeles.EdoDDFx.equals(x))
			return MiPortaPapeles.DDFx;
		else
			return getSegundaDerivada().evaluar(x);
	}

	@Override
	public Matriz modeloLineal(Funcion F, Matriz x, Matriz direccion) {
		// TODO Auto-generated method stub

		Matriz Fn=F.evaluar(x);
		Matriz gradiente=primerDerivada(F,x);

		Matriz t=gradiente.por(direccion);

		t=t.mas(Fn);

		return t;
	}


	public Matriz modeloCuadratico(Funcion F, Matriz x, Matriz direccion) {
		// TODO Auto-generated method stub
		return null;
	}




}
