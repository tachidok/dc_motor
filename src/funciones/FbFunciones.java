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

package funciones;
import java.util.ArrayList;

import arquitecturabase.Funcion;



import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Observador;


/**
 * Esta clase se encarga de instanciar la función a utilizar en la arquitectura
 * para Newtons
 * @author Ricardo
 *
 */

public class FbFunciones extends FabricaAbstracta{

	/**
	 * Identificador para instanciar la clase MiFuncion
	 */
	private final int ID_MiFuncion=1;
	private final int ID_FuncionConteBoor=2;
	private final int ID_MiFuncion3=3;
	private final int ID_FuncionZhanlav=4;
	private final int ID_Chebyquad=5;
	private final int ID_FuncionPowell=6;
	private final int MotorDC=7;
	private final int ParaboloideEliptico=8;
	private final int ParaboloideEliptico2=9;



	public FbFunciones ()
	{

	}

	public FbFunciones(ArrayList<Observador> observadores) {
		super(observadores);

                add(ID_MiFuncion,"Mi función");
                add(ID_FuncionConteBoor,"Funcion Conte-Boor");
                add(ID_MiFuncion3,"Mi función3");
                add(ID_FuncionZhanlav,"Función Zhanlav");
                add(ID_Chebyquad,"Chebyquad");
                add(ID_FuncionPowell,"Funcion Powell");
                add(MotorDC, "Motor DC");
                add(ParaboloideEliptico,"Paraboloide Eliptico");
                add(ParaboloideEliptico2,"Paraboloide Eliptico2");


	}

	@Override
	public void add(int idInstancia, String descripcion) {
            for(Observador o:observadores)
		{
			o.instanciaAgregada(this, idInstancia, descripcion);
		}

	}

	@Override
	public Funcion crearInstancia() {


		switch(instancia){
		case ID_MiFuncion: return new MiFuncion();
		case ID_FuncionConteBoor: return new FuncionConteBoor();
		case ID_MiFuncion3: return new MiFuncion3();
		case ID_FuncionZhanlav: return new FuncionZhanlav();
		case ID_Chebyquad: return new ChebyquadN9();
		case ID_FuncionPowell: return new FuncionPowell();
		case MotorDC: return new MotorDC();
		case ParaboloideEliptico: return new ParaboloideEliptico();
		case ParaboloideEliptico2: return new ParaboloideEliptico2();

		default: return null;


		}
	}

}
