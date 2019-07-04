package EjemplosNewtons;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import lineasdebusqueda.LineaDeBusqueda;
import algebralineal.Matriz;
import arquitecturabase.ComponentesNewton;
import arquitecturabase.CriterioDeParo;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;
import arquitecturabase.LongitudDePaso;
import arquitecturabase.NewtonImp;
import criteriosdeparo.CriterioErrorRelativo;
import derivadas.DerivadaPrimerOrden;
import derivadas.DiferenciasGustavo;
import direcciones.DireccionSistemaNoLineal;
import direcciones.PseudoDireccionRangoDinamico;
import fabricaabstracta.Fabricas;
import funciones.Chandrasekhar;

public class ChandrasekharTest {

	private int numVariables = 100;

	public static void main(String j[]) {

		new ChandrasekharTest().correr();

	}

	public void correr() {
		Fabricas.crearFabrica();

		Funcion funcion = new Chandrasekhar(numVariables, numVariables);
		DerivadaPrimerOrden estrategiaGustavo = new DiferenciasGustavo(funcion);

		ProblemaNoLineal problema = new SistemasNoLineales();
		problema.setPrimeraDerivada(estrategiaGustavo);

		NewtonImp newton = new NewtonVacio(funcion, problema);
		ComponentesNewton componentes = newton.getComponentes();

		double x0[] = obtenerPuntoDeInicio();
		newton.setX0(x0);
		newton.setXn(x0);

		PseudoDireccionRangoDinamico direccionNewton = new PseudoDireccionRangoDinamico(funcion);
		direccionNewton.setCambiarRangoCada(10);
		direccionNewton.setRangoActual(80);
		direccionNewton.setRangoMaximo(100);
		componentes.setDireccionNewton(direccionNewton);

		LongitudDePaso longitudDePaso = new LineaDeBusqueda(funcion);
		componentes.setLongitudDePaso(longitudDePaso);

		CriterioErrorRelativo criterioParo = new CriterioErrorRelativo();
		criterioParo.setNumMaxIteraciones(1000);
		componentes.setCriterioDeParo(criterioParo);
	

		CorrerNewton(newton);

	}

	public void CorrerNewton(NewtonImp newton) {

		CriterioDeParo criterio = newton.getComponentes().getCriterioDeParo();
		boolean continuar = true;
		int iteracion = 0;

		continuar = true;

		imprimirNombresColumnas(numVariables);

		while (continuar) {
			long tiempoInicio = System.nanoTime();
			continuar = newton.iteraUsandoCriterio();
			long tiempoFinal = System.nanoTime() - tiempoInicio;
			iteracion++;
			imprimir(iteracion, tiempoFinal, newton.Fn(), newton.getXn(),
					criterio.errorActual());

		}

	}

	public void imprimir(int iteracion, long tiempo, Matriz fn, Matriz xn,
			double error) {
		
		//NumberFormat formato = new DecimalFormat("0.000000000000000000000E0");
		NumberFormat formato = new DecimalFormat("0.0000E0");


		String t = "";

		for (int i = 0; i < xn.numeroFilas(); i++)
			t += "\t" + formato.format(xn.getElemento(i, 0));

		System.out.println(iteracion + "\t" + formato.format(tiempo) + "\t"
				+ formato.format(fn.normaFlexible()) + "\t"
				+ formato.format(error) + t);
	}

	public void imprimirNombresColumnas(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += "\t\t" + "X" + i;

		System.out.println("iter" + "\ttiempo" + "\t\t||f||"
				+ "\t\tE. relativo");
	}

	public double[] obtenerPuntoDeInicio() {
		/*
		 * Declaro el punto de inicio y le asigno valores
		 */
		double x0[] = new double[numVariables];
		for (int i = 0; i < numVariables; i++)
			x0[i] = 1;

		return x0;
	}

}
