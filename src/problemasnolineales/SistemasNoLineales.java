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
 *problema de resolución de sistemas no lineales
 *
 * @author Ricardo
 * @version 1.0
 * @see Funcion, MinimosCuadrados, OptimizacionSinRestricciones, SistemasNoLineales
 */
public class SistemasNoLineales extends ProblemaNoLineal{

	public SistemasNoLineales() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SistemasNoLineales(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluarDeAcuerdoAlProblema(Funcion F, Matriz x) {
		// TODO Auto-generated method stub
		if( MiPortaPapeles.EdoFx!=null && MiPortaPapeles.EdoFx.equals(x))
			return MiPortaPapeles.Fx.normaF();

		return F.evaluar(x).normaF();
	}

	@Override
	public Matriz primerDerivada(Funcion F, Matriz x) {
		// TODO Auto-generated method stub


		if( MiPortaPapeles.EdoDFx!=null && MiPortaPapeles.EdoDFx.equals(x))
			return MiPortaPapeles.DFx;

		return getPrimeraDerivada().evaluar(x);
	}

	@Override
	public Matriz segundaDerivada(Funcion F, Matriz x) {
		// TODO Auto-generated method stub
		Matriz jacobiana=primerDerivada(F,x);
		Matriz jacobianaTranspuesta=jacobiana.transpuesta();

		return jacobianaTranspuesta.por(jacobiana);
	}

	@Override
	public Matriz modeloLineal(Funcion F, Matriz x, Matriz direccion) {

		Matriz Fn=F.evaluar(x);
		Matriz Jn=primerDerivada(F,x);
		Matriz t=Jn.por(direccion);

		t=t.mas(Fn);

		return t;
	}

	@Override
	public Matriz modeloCuadratico(Funcion F, Matriz x, Matriz direccion) {

		ProblemaNoLineal temp=F.getProblemaActual();

		F.setProblemaActual(new MinimosCuadrados(F));

		Matriz modelo=F.modeloCuadratico(x, direccion);

		F.setProblemaActual(temp);

		return modelo;
	}




}
