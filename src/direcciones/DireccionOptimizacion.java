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

package direcciones;


import problemasnolineales.MinimosCuadrados;
import problemasnolineales.ProblemaNoLineal;
import algebralineal.AdaptadorJaMaLU;
import algebralineal.Matriz;
import algebralineal.ResSistemaLineal;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * Ésta es una implementación de la dirección Newton :
 *
 *    H x = - g , donde H es la hessiana de la función y g es el gradiente
 *
 *
 * Esta dirección es usada en los métodos Newton para problemas de mínimos cuadrados
 * y optimización sin restricciones
 *
 */

public class DireccionOptimizacion extends DireccionNewton {

	public DireccionOptimizacion(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz Xn) {
		// TODO Auto-generated method stub

		Funcion F=getF();
		ProblemaNoLineal problema=F.getProblemaActual();

		//trato el problema como un problema de mínimos cuadrados
		if(F.getNumFunciones()>1)
		F.setProblemaActual(new MinimosCuadrados(F));

		Matriz gradiente=F.primeraDerivada(Xn);
		Matriz Hessiana=F.segundaDerivada(Xn);

		gradiente=gradiente.por(-1.0);

		ResSistemaLineal r= new AdaptadorJaMaLU(Hessiana);
		Matriz x=r.resolver(gradiente);

		F.setProblemaActual(problema);

		return x;
	}

}
