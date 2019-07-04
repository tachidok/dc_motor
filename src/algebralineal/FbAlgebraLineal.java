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
import java.util.ArrayList;

import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 *
 *
 *
 * Esta clase está encargada de instanciar el paquete de algebra lineal usado en
 * la arquitectura para Newtons
 *
 * @author Ricardo
 * @version 1.0
 */

public class FbAlgebraLineal extends FabricaAbstracta {

	/**
	 * Identificador para el paquete JaMA: Java Matrix Package
	 */
	private final int ID_JaMaMatrix=1;

	public FbAlgebraLineal()
	{
		setInstancia(ID_JaMaMatrix);
	}

	public FbAlgebraLineal(ArrayList<Observador> observadores)
	{
		super(observadores);
		add(ID_JaMaMatrix,"JaMaMatrix");
		setInstancia(ID_JaMaMatrix);
	}

	@Override
	public void add(int idInstancia, String descripcion) {

		for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

	/**
	 * Crea un objeto Matriz a partir de una matriz del tipo double
	 * @param d
	 * @return Matriz
	 */


	public Matriz crearInstancia(double[][] d) {

		switch (instancia)
		{
			case ID_JaMaMatrix: return new AdaptadorJaMaMatrix(d);

			default: return null;
		}

	}


	/**
	 * Crea un objeto Matriz a partir de un arreglo del tipo double
	 * @param d
	 * @return Matriz de n x 1 elementos
	 */


	public Matriz crearInstancia(double[] d) {

		switch (instancia)
		{
			case ID_JaMaMatrix: return new AdaptadorJaMaMatrix(d);

			default: return null;
		}

	}


	/**
	 * Crea un objeto Matriz de m filas y n columnas
	 * @param n
	 * @param m
	 * @return
	 */

	public Matriz crearInstancia(int m, int n) {

		switch (instancia)
		{
			case ID_JaMaMatrix: return new AdaptadorJaMaMatrix(m,n);

			default: return null;
		}

	}

	@Override
	public Object crearInstancia() {
		switch (instancia)
		{
			case ID_JaMaMatrix: return new AdaptadorJaMaMatrix();

			default: return null;
		}

	}

	public Object LU(Matriz A)
	{
		return new AdaptadorJaMaLU(A);
	}

	public Object SVD(Matriz A)
	{
		return new AdaptadorSVDCommons(A);
	}

	public Ortonormalizacion Ortonormalizacion()
	{
		return new AdaptadorOrtonormalizacionJaMaMatrix();
	}




}
