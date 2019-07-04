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

import problemasnolineales.MiPortaPapeles;
import fabricaabstracta.Fabricas;
import algebralineal.EsquemaGeneralMatrizAleatoria;
import algebralineal.Matriz;
import algebralineal.SVD;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
/**
 * Esta clase tiene la pseudo dirección Newton propuesta en * el artículo
 * "Robust Methods for Non linear Equations" de J L Blue.
 *
 * @author Ricardo Serrato
 *
 */


public class PseudoDireccionSVD extends  DireccionNewton{

	private int rangoAproximado;
	private double alfa=1;
	public PseudoDireccionSVD(Funcion F) {
		super(F);
		setRangoAproximado((int)(alfa*F.getNumFunciones()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz Xn)  {
		// TODO Auto-generated method stub

		Matriz Fx=MiPortaPapeles.Fx;
		Matriz DFx=MiPortaPapeles.DFx;
		Matriz aproximada;

		EsquemaGeneralMatrizAleatoria esqAproxMatriz= new EsquemaGeneralMatrizAleatoria();
		esqAproxMatriz.setMatrizOriginal(DFx);
		esqAproxMatriz.setReduccion(rangoAproximado);


		try{
		//Obtengo la matriz reducida
	   aproximada=esqAproxMatriz.reducirMatriz();
	   Matriz Q=esqAproxMatriz.getBaseOrtonormal();

	   SVD descomposicionSVD=(SVD)Fabricas.fabricaAlgebraLineal.SVD(aproximada);

	   Matriz U,S,V;

	   U=descomposicionSVD.getU();//U kxk
	   S=descomposicionSVD.getS();//S kxn
	   V=descomposicionSVD.getV();//V nxn


	   int k=Math.min(S.numeroColumnas(), S.numeroFilas());
	   Matriz pseudoInversaS=Fabricas.fabricaAlgebraLineal.crearInstancia(k,k);

	   for(int i=0;i<k;i++)
		 pseudoInversaS.set(i, i, 1.0/S.getElemento(i, i));

	   Matriz direccion = U.transpuesta().por(Q.transpuesta()).por(Fx);
	   direccion=V.por(pseudoInversaS).por(direccion);
	   direccion=direccion.por(-1.0);

	   return direccion;
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
			System.out.print(e.toString());
		}

		return null;
	}




	public void setRangoAproximado(int rangoAproximado) {
		this.rangoAproximado = rangoAproximado;
	}

	public int getRangoAproximado() {
		return rangoAproximado;
	}

}
