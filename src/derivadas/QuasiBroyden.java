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

import fabricaabstracta.Fabricas;

import algebralineal.Matriz;
import arquitecturabase.Funcion;

/**
 * Ésta es una implementación simple de una fórmula Quasi Newton para
 * aproximar una matriz Jacobiana. Sigue la fórmula clásica de Broyden
 *
 * Bn+1 = Bn +  { (y - Bn * s)* s / s*s   }
 *
 *	       s= Xn+1 - Xn
 *        y= F(Xn+1) - F(Xn)
 *
 * Más información en "Numerical Methods for unconstrained optimization and non linear equations"
 * de J. E. Dennis, Robert B. Schnabel
 * @author Ricardo
 *
 */

public class QuasiBroyden extends DerivadaPrimerOrden{

	/**
	 * Valor del punto anterior
	 */
	private Matriz Xanterior;

	/**
	 * Valor de la "jacobiana" anterior
	 */
	private Matriz Banterior;


	public QuasiBroyden(Funcion F, Matriz puntoInicio) {
		super(F);
		// TODO Auto-generated constructor stub

		Xanterior=puntoInicio;
		Banterior=new Diferencias(getF()).evaluar(Xanterior);
	}

	@Override
	public Matriz evaluar(double x[]) {

		Matriz temp=Fabricas.fabricaAlgebraLineal.crearInstancia(Banterior.getArreglo().clone());

		actualizarMatriz(x);
		return temp;
	}


	public void actualizarMatriz(double a[])
	{
		/* fórmula para calcular matriz broyden

	       Bn+1 = Bn +  { (y - Bn * s)* s / s*s   }

	       s= Xn+1 - Xn
	       y= F(Xn+1) - F(Xn)

	       */


		//calculando s

		double temp[][]=new double[a.length][1];
		for(int i=0;i<a.length;i++)
			temp[i][0]=a[i];



		Matriz x=Fabricas.fabricaAlgebraLineal.crearInstancia(temp);

		Matriz s=x.menos(Xanterior);


		//si el incremento no es significativo, no tiene caso hacer todo
		if(s.normaF()<=PrecisionNumerica.MiPrecisionNumerica.EPSILON)
			return;


		//calculando y = F(Xn+1) - F(X)


		Matriz y=(getF().evaluar(x)).menos(getF().evaluar(Xanterior));


		//Bn * s
		Matriz t=Banterior.por(s);

		//y - Bn*s
		t=y.menos(t);

		//(y-Bn *s)*s
		t=t.por(s.transpuesta());

		//ahora t es un escalar

		double numerador=t.getElemento(0, 0);
		double denominador= s.por(s.transpuesta()).getElemento(0, 0);
		double incremento=numerador/denominador;
		double te;
		//actualizando Banterior

		for(int i=0;i<Banterior.numeroFilas();i++)
			for(int j=0;j<Banterior.numeroColumnas();j++)
			{
				te=Banterior.getElemento(i, j)*incremento;
				Banterior.set(i, j, te);

			}

		Xanterior=Fabricas.fabricaAlgebraLineal.crearInstancia(x.getArreglo());


	}

}
