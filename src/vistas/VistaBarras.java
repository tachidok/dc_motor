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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * Esta es una gráfica de barras simple
 *
 * @author Administrator
 *
 */

public class VistaBarras {

	private String dominio;
	private String rango;
	private CategoryDataset datos;
	private JFreeChart jfreechart;
	private JFrame ventana;
	private ChartPanel chartPanel;
	private int tamanoHorizontal=500;
    private int tamanoVertical=300;



	public VistaBarras(String titulo,String dominio, String rango)
	{


		datos=new DefaultCategoryDataset();
		jfreechart=ChartFactory.createBarChart(
	            titulo,         // chart title
	            dominio,               // domain axis label
	            rango,                  // range axis label
	            datos,                  // data
	            PlotOrientation.VERTICAL,
	            true,                     // include legend
	            true,                     // tooltips?
	            false                     // URLs?
	        );

		chartPanel = new ChartPanel(jfreechart);
        chartPanel.setPreferredSize(new Dimension(360, 500));
        ventana=new JFrame();
        ventana.setSize(tamanoVertical,tamanoHorizontal);
        ventana.getContentPane().add(chartPanel,BorderLayout.CENTER);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void agregarDatos(double valor, String serie, String categoria)
	{
		((DefaultCategoryDataset) datos).addValue(1.0, serie, categoria);
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getDominio() {
		return dominio;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getRango() {
		return rango;
	}

	public void setJfreechart(JFreeChart jfreechart) {
		this.jfreechart = jfreechart;
	}

	public JFreeChart getJfreechart() {
		return jfreechart;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

	public JFrame getVentana() {
		return ventana;
	}



	public static void main(String y[])
	{
		new VistaBarras("Tiempo ejecución", "dominio", "rango");
	}
}
