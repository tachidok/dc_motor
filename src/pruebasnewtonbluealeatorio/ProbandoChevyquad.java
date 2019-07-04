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

package pruebasnewtonbluealeatorio;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;
import funciones.*;
import derivadas.*;
import problemasnolineales.*;
/**
 * Esta es una prueba sencilla para obtener el valor de las derivadas de la función chevyquad
 * @author Ricardo Serrato
 * @see Chebyquad en el paquete funciones
 */

public class ProbandoChevyquad {

	public static void main(String h[])
	{
		int n=9;

		Fabricas.crearFabrica();
		Funcion chebyquad;
		DerivadaPrimerOrden estrategiaDF;
		ProblemaNoLineal problema;


		chebyquad=new Chebyquad(n,n);
		estrategiaDF=new DiferenciasGustavo(chebyquad);
		problema=new SistemasNoLineales();


		//selecciono como quiero que se trate la funcion
		chebyquad.setProblemaActual(problema);

		//asigno la estrategia para diferencias finitas
		problema.setPrimeraDerivada(estrategiaDF);




		/**
		 * Punto inicial estándar
		 */
		double xbueno[]=new double[n];
		for(int i=0;i<n;i++)
			xbueno[i]=((double)(i+1))/(n+1);

		/**
		 * Punto inicial malo
		 */
		//double xmalo[]={0.8340,0.8340,0.9510,0.9534,0.9645,0.9659,0.9877,0.9982,1.0053};

		double xmalo[]={0.8340,0.8416,0.9510,0.9534,0.9645,0.9659,0.9877,0.9982,1.0053};
		double y[]=chebyquad.evaluarFuncion(xmalo);


		for(int i=0;i<n;i++)
			System.out.println(xbueno[i]+"\t"+y[i]);


		//derivo la función chebyquad en el punto bueno
		Matriz Dcheb1=chebyquad.primeraDerivada(xbueno);

		//se imprimen resultados
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j+1!=n)
					System.out.print(Dcheb1.getElemento(i, j)+",");
				else
					System.out.print(Dcheb1.getElemento(i, j));
			}
			System.out.println();
		}

	/*	DerivadaPrimerOrden diferencias=new Diferencias(chebyquad);


		double pmalo=new AdaptadorJaMaMatrix(xmalo).normaF();
		double epsilon=PrecisionNumerica.MiPrecisionNumerica.EPSILON;

		diferencias.setIncremento(Math.sqrt(epsilon)*pmalo);

		problema.setPrimeraDerivada(diferencias);
		Matriz Dcheb2=chebyquad.primeraDerivada(xmalo);

		System.out.println();
		System.out.println(Math.sqrt(epsilon)*pmalo);*/

		//se imprimen resultados

		//derivo la funcion chebyquad en el punto malo
		Matriz Dcheb2=chebyquad.primeraDerivada(xmalo);

		System.out.println();
		System.out.println();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j+1!=n)
					System.out.print(Dcheb2.getElemento(i, j)+",");
				else
					System.out.print(Dcheb2.getElemento(i, j));
			}
			System.out.println();
		}


		System.out.println("condicional "+ Dcheb1.getRango()+","+Dcheb2.getRango());

	}

}