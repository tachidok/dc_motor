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
import java.awt.Dimension;

import lineasdebusqueda.FbLineasBusqueda;

import newtonsconcretos.FbTiposNewton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import criteriosdeparo.FbCriteriosParo;


import problemasnolineales.FbProblemaNoLineal;

import derivadas.FbDerivadasPrimerOrden;
import derivadas.FbDerivadasSegundoOrden;

import algebralineal.FbAlgebraLineal;
import algebralineal.FbNormas;


import fabricaabstracta.Observador;
import funciones.FbFunciones;

/**
 * Esta clase es la base para implementar gráficas en la arquitectura
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public abstract class Grafica  implements Observador{


	private Controlador controlador;
	private XYSeries funcion;
	private XYSeriesCollection coleccionDeFunciones;

	private String ejeX;
	private String ejeY;
    private ChartPanel chartPanel;



	public Grafica(String title, Controlador controlador, String ejeY, String ejeX ) {
		//super(title);

		this.ejeX=ejeX;
		this.ejeY=ejeY;
		this.controlador=controlador;

		funcion = new XYSeries("");
		coleccionDeFunciones = new XYSeriesCollection();
		coleccionDeFunciones.addSeries(funcion);

        JFreeChart jfreechart = crearPlot(coleccionDeFunciones);
        chartPanel = new ChartPanel(jfreechart);
        chartPanel.setPreferredSize(new Dimension(360, 500));

	}

	public void setFuncion(XYSeries funcion) {
		this.funcion = funcion;
	}

	public XYSeries getFuncion() {
		return funcion;
	}

	public void setColeccionDeFunciones(XYSeriesCollection coleccionDeFunciones) {
		this.coleccionDeFunciones = coleccionDeFunciones;
	}

	public XYSeriesCollection getColeccionDeFunciones() {
		return coleccionDeFunciones;
	}


	private JFreeChart crearPlot(XYSeriesCollection coleccionDeFunciones )
	{
		 JFreeChart jfreechart = ChartFactory.createXYLineChart(null, ejeY, ejeX,   coleccionDeFunciones, PlotOrientation.VERTICAL, true, true, false);


		 return jfreechart;
	}


	public void agregarFuncion(String nombre)
	{
		this.funcion = new XYSeries(nombre,true,false);
		coleccionDeFunciones.addSeries(funcion);
	}

	public void agregarPunto(double x, double y)
	{
	 funcion.add(x, y);
	 actualizar();
	}

	public void actualizar()
	{
		controlador.getVista().repaint();
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

	@Override
	public void notificar() {
		// TODO Auto-generated method stub

	}

	@Override
	public abstract void puntoAgregado(double puntoActual[][],double punto, int iteracion,  int numEvaluaciones, long tiempoEjecucion, double normaDFx);

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public Controlador getControlador() {
		return controlador;
	}

	@Override
	public void instanciaAgregada(FbLineasBusqueda i, int idInstancia,
			String descripcion) {
		// TODO Auto-generated method stub

	}


        public void setChartPanel(ChartPanel chartPanel) {
             this.chartPanel = chartPanel;
        }

        public ChartPanel getChartPanel() {
                 return chartPanel;
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
