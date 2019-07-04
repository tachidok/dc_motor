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

package vistas;
import criteriosdeparo.FbCriteriosParo;
import problemasnolineales.FbProblemaNoLineal;
import lineasdebusqueda.FbLineasBusqueda;
import algebralineal.FbAlgebraLineal;
import algebralineal.FbNormas;
import arquitecturabase.Funcion;
import derivadas.FbDerivadasPrimerOrden;
import derivadas.FbDerivadasSegundoOrden;

import fabricaabstracta.Fabricas;
import fabricaabstracta.FabricaAbstracta;
import fabricaabstracta.Modelo;
import fabricaabstracta.Observador;
import funciones.FbFunciones;
import newtonsconcretos.FbTiposNewton;



/**
 * Esta clase controla la interacción entre la clase ModeloNewton, las fábricas usadas en la arquitectura y
 * la clase Vista usada para presentar los datos. Controlador es parte del patrón modelo vista controlador
 *
 *
 * @author Ricardo
 * @see Modelo, ModeloNewton, Vista, InstanciadorNewton, Observador, Controlador
 */

public class Controlador implements Observador {


	int funcion=1;
	/**
	 * Es el método newton utilizado
	 */
	private ModeloNewton modelo;

	/**
	 * Es la vista utilizada para presentar los datos
	 */

	private Vista vista;

	/**
	 * Constructor del controlador
	 * @param m
	 * @param v
	 */

	public Controlador(ModeloNewton m, Vista v)
	{

          vista=v;
          modelo=m;
	}


	/**
	 * Le indica a la fábrica el objeto que debe de crear en la arquitectura Newton
	 * @param instanciador
	 * @param idinstancia
	 */


    public void setInstancia(FabricaAbstracta fabrica, int idinstancia)
     {
            fabrica.setInstancia(idinstancia);
     }

    /**
     * Asigna el modelo o método Newton que se debe coordinar junto con la vista
     *
     * @param modelo
     */

	public void setModelo(ModeloNewton modelo) {
		this.modelo = modelo;
	}


	/**
	 * Devuelve el modelo utilizado por el controlador
	 * @return
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * Asigna la vista que tiene que ser coordinada junto con el modelo
	 * @param vista
	 */


	public void setVista(Vista vista) {
		this.vista = vista;
	}

	/**
	 * Devuelve la vista usada por el controlador
	 * @return
	 */

	public Vista getVista() {
		return vista;
	}


	@Override
	public void instanciaAgregada(FbDerivadasPrimerOrden i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbDerivadasSegundoOrden i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbProblemaNoLineal i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbAlgebraLineal i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbTiposNewton i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbFunciones i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}

	/**
	 * Se crea un nuevo modelo de acuerdo a los parametros asignados a las fábricas
	 */

    public void instanciar()
    {
    	/*
    	 * cuidado en esta parte (está claramente acoplado, revisalo después)
    	 */

      Funcion f=Fabricas.fabricaFunciones.crearInstancia();
      new PuntoInicio(vista,true,f.getNumVariables(),this).setVisible(true);


      modelo.instanciarNuevoNewton();
      funcion++;

      vista.getgraficaIteraciones().agregarFuncion(""+funcion);
      vista.getGraficaNumEval().agregarFuncion(""+funcion);
      vista.getGraficaTiempoEjecucion().agregarFuncion(""+funcion);
    }

    /**
     * Le indica al modelo o método Newton, que debe realizar una iteraciï¿½n
     */

    public void itera()
     {
       modelo.itera();
     }

    public void resolver()
    {
    	modelo.resolver();
    }

    /**
     * Le indica a la vista que tiene que desplegar una cadena de caracteres
     * @param datos
     */


	@Override
	public void notificar() {
		// TODO Auto-generated method stub

	}


	@Override
	public void puntoAgregado(double puntoActual[][],double punto, int iteracion, int numEvaluaciones, long tiempoEjecuacion, double normaDxF) {
		// TODO Auto-generated method stub

	}


	@Override
	public void instanciaAgregada(FbLineasBusqueda i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}

	public int getNumFuncion(){
		return funcion;
	}

        public void setPuntoInicio(double a[][])
        {
         modelo.setPuntoInicio(a);
        }


		@Override
		public void instanciaAgregada(FbNormas i, int idInstancia,
				String descripcion) {
			// TODO Auto-generated method stub

		}


		@Override
		public void instanciaAgregada(FbCriteriosParo fbCriteriosParo,
				int idInstancia, String descripcion) {
			// TODO Auto-generated method stub

		}

}
