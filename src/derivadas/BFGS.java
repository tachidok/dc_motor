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

package derivadas;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;

/**
 * Esta clase es una implementación de la actualización de la matriz Hessiana en los métodos
 * BFGS. Ésta es su fórmula
 *
 * s= Xk+1 - Xk
 * y = Gk+1 - Gk
 *
 *  Bk+1 = Bk  - (Bk s s' Bk  /  s'B s)   +   yy'/y's
 *
 *  Más información en "Numerical optimization" de Jroge Nocedal y Stephen Wright
 *
 * @author Ricardo
 *
 */
public class BFGS extends DerivadaSegundoOrden{

	/**
	 * Valor del punto anterior
	 */
	private Matriz Xanterior;
	/**
	 * Valor del gradiente en el punto anterior
	 */
	private Matriz Ganterior;
	/**
	 * Valor de la "hessiana" en el punto anterior
	 */
	private Matriz Banterior;

	/**
	 * Criterio para aproximar la primera derivada
	 */
	private DerivadaPrimerOrden derivadaPrimerOrden;

	public BFGS(Funcion F,Matriz puntoInicio) {
		super(F);
		// TODO Auto-generated constructor stub


		derivadaPrimerOrden=new DiferenciasGustavo(getF());

		Xanterior=puntoInicio;
		Ganterior=derivadaPrimerOrden.evaluar(Xanterior).transpuesta();
		Banterior=new HessianaDiferencias(getF()).evaluar(Xanterior);

	}


	@Override
	public Matriz evaluar(double x[]) {

		Matriz temp=Fabricas.fabricaAlgebraLineal.crearInstancia(Banterior.getArreglo().clone());
		actualizarMatriz(x);
		return temp;
	}
/**
 * actualiza las variables Xanterior, Banterior, Ganterior usando el punto a
 *
 * @param a es el punto actual
 */

	public void actualizarMatriz(double a[])
	{


		/*
		 * Fórmula
		 *
		 * s= Xk+1 - Xk
		 * y = Gk+1 - Gk
		 *
		 *  Bk+1 = Bk  - (Bk s s' Bk  /  s'B s)   +   yy'/y's
		 */

		double temp[][]=new double[a.length][1];
		for(int i=0;i<a.length;i++)
			temp[i][0]=a[i];

		Matriz x=Fabricas.fabricaAlgebraLineal.crearInstancia(temp);

		// calculando s
		Matriz s=x.menos(Xanterior);

		//si el incremento no es significativo, no tiene caso hacer todo
		if(s.normaF()<=PrecisionNumerica.MiPrecisionNumerica.EPSILON)
			return;

		Matriz g=derivadaPrimerOrden.evaluar(x).transpuesta();
		Matriz y=g.menos(Ganterior);

      //calculando Bk s s' Bk

		Matriz t1=(Banterior.por(s)).por(s.transpuesta().por(Banterior));


		//s'B s

		Matriz t2=s.transpuesta().por(Banterior).por(s);

		//yy'/y's

		Matriz t3=y.por(y.transpuesta());


	   Matriz t4=y.transpuesta().por(s);


	   // (Bk s s' Bk  /  s'B s)   +   yy'/y's
	   Matriz t=t1.  por(1.0/t2.getElemento(0, 0)).por(-1.0)   .mas(   t3.por  (1.0/t4.getElemento(0, 0)));


		Banterior=Banterior.mas(t);

		Xanterior=Fabricas.fabricaAlgebraLineal.crearInstancia(x.getArreglo());
		Ganterior=Fabricas.fabricaAlgebraLineal.crearInstancia(g.getArreglo());

	}
}
