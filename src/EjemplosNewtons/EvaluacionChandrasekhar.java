package EjemplosNewtons;



import fabricaabstracta.Fabricas;
import funciones.Chandrasekhar;


public class EvaluacionChandrasekhar {
	
	private int numVariables=100; 
	
	public static void main(String []args){
		new EvaluacionChandrasekhar().correr();
	}
	
	public void correr(){
		Fabricas.crearFabrica();
		double x0[]=obtenerPuntoDeInicio(1);
		
		Chandrasekhar f =new Chandrasekhar(numVariables, numVariables);
		
	
		double f0[]=f.evaluarFuncion(x0);
		
		for (double d : f0) {
			System.out.println(d);
		}
	}
	
	public double[] obtenerPuntoDeInicio(double numero) {
		/*
		 * Declaro el punto de inicio y le asigno valores
		 */
		double x0[] = new double[numVariables];
		for (int i = 0; i < numVariables; i++)
			x0[i] = numero;

		return x0;
	}

}
