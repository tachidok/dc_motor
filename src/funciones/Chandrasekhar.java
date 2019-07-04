package funciones;

import arquitecturabase.Funcion;
import algebralineal.Matriz;
import algebralineal.AdaptadorJaMaMatrix;

/**
 * @author Iván
 *
 */

public class Chandrasekhar extends Funcion {
	
	private int n;
	private double c=0.9;
	private Matriz A;
	private double[][] dataA;
	
	
	public Chandrasekhar(int numVariables, int numFunciones){
		super(numVariables, numFunciones);
		this.n = numFunciones;
		dataA = new double[n][n];
		
		A = new AdaptadorJaMaMatrix(dataA, n, n);
        construyeA();
	}
	
	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	public Matriz getA() {
		return A;
	}

	public void setA(Matriz a) {
		A = a;
	}

	private double mu(double i) {
		double mu = 0.0;
		
		mu = i - 0.5;
		mu = mu * Math.pow(n, -1.0);
		
		return mu;
	}
	
	private void construyeA() {
		double mui = 0.0;
		double muj = 0.0;
		double numerador   = 0.0;
		double denominador = 0.0;
		double aij = 0.0;
		
		for(int i = 0; i < n; i++) {
			
			mui = mu((double)(i + 1));
			
			for(int j = 0; j < n; j++) {
				muj = mu((double)(j + 1));
				numerador = c * mui;
				denominador = 2 * n * (mui + muj);
				aij = numerador * Math.pow(denominador, -1.0);
				
				A.set(i, j, aij);
			}
		}
	}
	
	protected double[] evaluar(double[] x) {
		double[] evaluacion = new double[x.length];
		double temp;
		
		Matriz valX = new AdaptadorJaMaMatrix(x);
		Matriz Ax = A.por(valX);
		
		for(int i = 0; i < x.length; i++) {
			temp = 1 - Ax.getElemento(i, 0);
			temp = Math.pow(temp, -1.0);
			evaluacion[i] = x[i] - temp;
		}
		
		return evaluacion;
	}
}
