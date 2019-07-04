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

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * Esta es una ventana con una gráfica simple en un plano xy
 *
 * @author Ricardo Serrato
 *
 */
public class VistaSobria {

	private XYSeries funcion;
	private XYSeriesCollection coleccionDeFunciones;
	private JFrame ventana;

	private String ejeX;
	private String ejeY;
    private ChartPanel chartPanel;
    private int tamanoHorizontal=500;
    private int tamanoVertical=300;


	public VistaSobria(String title, String ejeY, String ejeX ) {
		//super(title);

		this.ejeX=ejeX;
		this.ejeY=ejeY;

		funcion = new XYSeries("");
		coleccionDeFunciones = new XYSeriesCollection();
		coleccionDeFunciones.addSeries(funcion);

        JFreeChart jfreechart = crearPlot(coleccionDeFunciones);
        chartPanel = new ChartPanel(jfreechart);
        chartPanel.setPreferredSize(new Dimension(360, 500));
        ventana=new JFrame();
        ventana.setSize(tamanoVertical,tamanoHorizontal);
        ventana.getContentPane().add(chartPanel,BorderLayout.CENTER);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


	/**
	 * Agrega una función a la gráfica
	 * @param nombre
	 */
	public void agregarFuncion(String nombre)
	{
		this.funcion = new XYSeries(nombre,true,false);
		coleccionDeFunciones.addSeries(funcion);
	}
	/**
	 * Agrega un punto a la gráfica
	 * @param x
	 * @param y
	 */
	public void agregarPunto(double x, double y)
	{
	 funcion.add(x, y);
	 actualizar();
	}

	public void actualizar()
	{
		ventana.repaint();
	}


        public void setChartPanel(ChartPanel chartPanel) {
             this.chartPanel = chartPanel;
        }

        public ChartPanel getChartPanel() {
                 return chartPanel;
         }

}
