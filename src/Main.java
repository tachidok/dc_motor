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
import java.util.ArrayList;
import vistas.ModeloNewton;
import vistas.Vista;
import fabricaabstracta.Fabricas;
import fabricaabstracta.Observador;
/**
 * Clase principal del programa
 */

public class Main {

    public static void main(String args[]) {

/*
    	double d[][]={{1}};
    	Matriz a=new AdaptadorJaMaMatrix(d);

    	System.out.print(a.getElemento(0, 0));

    	double x[][]=new double[1][3];

    	Matrix d=new Matrix(x);

    	System.out.println("columnas "+d.getColumnDimension());
    	System.out.println("filas "+d.getRowDimension());

*/
/*
    	double d[][]={{1,5,2},{1,2,4},{9,9,9}};
    	Matrix A=new Matrix(d);




    	SingularValueDecomposition svd=new SingularValueDecomposition(A);

    	double t[]=svd.getSingularValues();

    	for(int i=0;i<d.length;i++)
    	{
    		System.out.println(t[i]);
    	}
*//*
    	Fabrica.crearFabrica();
    	Fabrica.fabricaAlgebraLineal.setInstancia(1);
    	Funcion F= new MiFuncion(null);
    	Diferencias Df=new Diferencias(F);
    	double d[][]={{0.5},{0.5}};

    	Matriz Dfx=Df.evaluar(new AdaptadorJaMaMatrix(d));


    	for(int i=0;i<Dfx.numeroFilas();i++)
    	{
    		System.out.println();
    		for(int j=0;j<Dfx.numeroFilas();j++)
    		{
    			System.out.print(" " +Dfx.getElemento(i, j))	;
    		}
    	}

*/




    	ModeloNewton mn= new ModeloNewton();
		Vista v = new Vista(mn);

		ArrayList<Observador> observadores=new ArrayList<Observador>();

		observadores.add(v);
		observadores.add(v.getgraficaIteraciones());
		observadores.add(v.getGraficaNumEval());
		observadores.add(v.getGraficaTiempoEjecucion());
		observadores.add(v.getControlador());
		mn.setObservadores(observadores);

		Fabricas.crearFabrica(observadores);

        v.setVisible(true);


/*        Funcion funcion= new MotorDC();

        double x[]={31.559324209153651,22.296716383654225,38.235319171015995};

        double resultado[]=funcion.evaluarFuncion(x);

        System.out.println(resultado[0]);

		//Newton n= new NewtonGenerico(fnewtons.crearInstancia());
*/}

}
