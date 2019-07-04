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
 * Esta clase define el comportamiento de la clase Funcion de acuerdo al problema de
 * mínimos cuadrados. MinimosCuadrados forma parte del patrón Estado.
 *
 * @author Ricardo
 *
 */
public class MinimosCuadrados extends ProblemaNoLineal{

	public MinimosCuadrados(Funcion F) {
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

		Matriz jacobiana;
		Matriz Fx;


		if( MiPortaPapeles.EdoDFx!=null && MiPortaPapeles.EdoDFx.equals(x))
			jacobiana=MiPortaPapeles.DFx;
		else
			jacobiana=getPrimeraDerivada().evaluar(x);

		if( MiPortaPapeles.EdoFx!=null && MiPortaPapeles.EdoFx.equals(x))
			Fx=MiPortaPapeles.Fx;
		else
			Fx=F.evaluar(x);


		jacobiana=jacobiana.transpuesta();

		return jacobiana.por(Fx);
	}

	@Override
	public Matriz segundaDerivada(Funcion F, Matriz x) {
		// TODO Auto-generated method stub

		Matriz jacobiana;

		if( MiPortaPapeles.EdoDFx!=null && MiPortaPapeles.EdoDFx.equals(x))
			jacobiana=MiPortaPapeles.DFx;
		else

		jacobiana=getPrimeraDerivada().evaluar(x);

		Matriz jacobianaTranspuesta=jacobiana.transpuesta();

		return jacobianaTranspuesta.por(jacobiana);
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

		Matriz gradiente=primerDerivada(F,x);
		Matriz AprxHessiano=segundaDerivada(F,x);
		Matriz Fn=F.evaluar(x);

		//f= 1/2 * F * F
		Matriz fn=Fn.transpuesta();
		fn=fn.por(Fn);
		fn=fn.por(0.5);

		Matriz t1;

		//1/2 * d * Hessiana * d

		t1=AprxHessiano.por(direccion);
		t1=t1.transpuesta();
		t1=t1.por(direccion);
		t1=t1.por(0.5);


		Matriz t2;
		t2=gradiente.transpuesta().por(direccion);

		return fn.mas(t1).mas(t2);
	}





}
