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
 * Ésta es una implentación simple para calcular una segunda derivada con diferencias finitas
 * @author Administrator
 *
 */

public class HessianaDiferencias extends DerivadaSegundoOrden{
	private DerivadaPrimerOrden derivadaPrimerOrden;
	private double incremento;

/**
 * Constructor
 *
 * @param F
 */

	public HessianaDiferencias(Funcion F) {
		super(F);
		// TODO Auto-generated constructor stub

	}




	@Override
	public Matriz evaluar(double []x) {
		// TODO Auto-generated method stub

		setDerivadaPrimerOrden(Fabricas.fabricaDerivadasPrimerOrden.crearInstancia(getF()));
		setIncremento(Math.sqrt(PrecisionNumerica.MiPrecisionNumerica.EPSILON)*10);


		int n=x.length;

		Matriz gradiente=getDerivadaPrimerOrden().evaluar(x);
		double []xn=x.clone();
		double hessiana[][]=new double[n][n];

		double temp,h;

		for(int i=0;i<n;i++)
		{

			temp=x[i];
			h=getIncremento()*Math.abs(temp);

			if(h==0)
				h=getIncremento();

			xn[i]= temp+h;
			h=xn[i]-temp;


			Matriz gradiente2=getDerivadaPrimerOrden().evaluar(xn);
			xn[i] =temp;


			for(int j=0;j<n;j++)
				hessiana[i][j]=(gradiente2.getElemento(0, j)-gradiente.getElemento(0, j))/h;

		}


		return Fabricas.fabricaAlgebraLineal.crearInstancia(hessiana);
	}

	/**
	 * Este método sirve para asignar el criterio para aproximar derivadas de primer orden
	 * @param derivadaPrimerOrden
	 */

	public void setDerivadaPrimerOrden(DerivadaPrimerOrden derivadaPrimerOrden) {
		this.derivadaPrimerOrden = derivadaPrimerOrden;
	}

	/**
	 * Este método devuelve un objeto que representa el criterio para aproximar derivadas de primer orden
	 * @return
	 */
	public DerivadaPrimerOrden getDerivadaPrimerOrden() {
		return derivadaPrimerOrden;
	}


	/**
	 * Asigna el incremento usado para aproximar la matriz hessiana
	 * @param incremento
	 */
	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}

	/**
	 * Devuelve el incremento usado para aproximar la matriz hessiana
	 * @return
	 */

	public double getIncremento() {
		return incremento;
	}



}
