
/*					C�digo realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
 *
 *										por 
 *			   				   Ricardo Serrato Barrera
 *
 *								     Asesores:
 *			  			     Dr. Gustavo Rodr�guez G�mez
 *			 		         Dr. Sa�l Pomares Hern�ndez
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
 * �sta es una implementaci�n sencilla para aproximar por diferencias finitas. Se puede utilizar
 * para aproximar Jacobianos o Gradiente
 * @author Administrator
 *
 */

public class Diferencias extends DerivadaPrimerOrden{



	public Diferencias(Funcion F)
	{
		super(F);
		setIncremento(2.9919484923847943E-8);

	}

	@Override
	public Matriz evaluar(double x[]) {


		int columnas=getF().getNumVariables();
		int filas=getF().getNumFunciones();

		double jacobiana[][]=new double[filas][columnas];
		double temp;
		double h;

		double[] xn=x.clone();
		double[] fvec=getF().evaluarFuncion(x);
		double[] f;

		for(int j=0;j<columnas;j++)
		{
			temp=x[j];
			h=getIncremento()*Math.abs(temp);

			if(h==0)
				h=getIncremento();

			xn[j]=temp+h;
			h=xn[j]-temp;


			f=getF().evaluarFuncion(xn);
			xn[j]=temp;

			for(int i=0;i<filas;i++)
				jacobiana[i][j]=(f[i]-fvec[i])/h;

		}

		return Fabricas.fabricaAlgebraLineal.crearInstancia(jacobiana);
	}



}
