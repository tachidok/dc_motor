/*					 Código realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Genérica para Métodos del Tipo Newton
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


package algebralineal;
import fabricaabstracta.Fabricas;

/**
 *
 *
 * Esta clase reduce la dimensión de una matriz n x m
 * @author Administrator
 *
 */
public class EsquemaGeneralMatrizAleatoria extends MatrizAproximada {

	public EsquemaGeneralMatrizAleatoria()
	{
		super();
	}
	public EsquemaGeneralMatrizAleatoria(Matriz A) {
		super(A);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("serial")
	@Override
	public Matriz reducirMatriz() throws Exception {
		// TODO Auto-generated method stub

		Matriz A=getMatrizOriginal();
		int n=A.numeroColumnas();
		int m=A.numeroFilas();
		int k=Math.min(m,n);
		int reduccion=getReduccion();



	/**
	 * la variable reduccion  = r + p
	 * verifico que las dimensiones esperadas de la matriz sean correctas
	 */
		if(k<reduccion || reduccion<2){
			throw new Exception()
				{
					public String getMessage()
					{
						return "Las dimensiones esperadas de la matriz aproximada son incorrectas o pueden no ser las mejores.";
					}
				};
		}

			/**
			 * genero los r + p vectores aleatorios
			 *  y los almaceno en una matriz de n x (r+p)
			 */
			Matriz omega=Fabricas.fabricaAlgebraLineal.crearInstancia(n,reduccion);
			llenarMatrizConAleatorios(omega);

			/**
			 * Hago una aproximación de la imagen de A. Es decir F(x)= Ax con las x almacenadas en omega
			 * A x1 = b1
			 * .
			 * .
			 * A xn =  bn
			 */

			Matriz Y;
			Y=A.por(omega);

			/**
			 * Ortonormalizacion de Y
			 */

			Ortonormalizacion ort=Fabricas.fabricaAlgebraLineal.Ortonormalizacion();
			Matriz Q=ort.evaluar(Y);
			setBaseOrtonormal(Q);


		return Q.transpuesta().por(A);
	}

	private void llenarMatrizConAleatorios(Matriz A)
	{
		for(int i=0;i<A.numeroFilas();i++)
			for(int j=0;j<A.numeroColumnas();j++)
				A.set(i, j, Math.random());
	}

}
