/*					C�digo realizado durante el trabajo de tesis
 *	Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
 *
 *										por 
 *			   				   Ricardo Serrato Barrera
 *
 *								     Asesores:
 *			  			     Dr. Gustavo Rodr�guez G�mez
 *			 		         Dr. Sa�l Pomares Hern�ndez
 *			
 *			     				 1ro de diciembre 2011
 *
 *						Programador: Ricardo Serrato Barrera
 * 	
 */

package funciones;

import arquitecturabase.Funcion;
/**
 * �sta es una traducci�n del c�digo de la funci�n chebyquad que aparece en minpack
 *
 * http://www.netlib.org/minpack/ex/file09
 *
 * ver los art�culos
 *
 * Testing unconstrained optimization Optimization software de Jorge Mor�
 * Function minimization without evaluation derivatives- a review de Fletcher
 * Robust Methods for non linear equations de James Blue
 *
 *
 * @author Administrator
 *
 */

public class Chebyquad extends Funcion{


    public Chebyquad(int numVariables, int numFunciones) {
        super(numVariables, numFunciones);
        this.n=numFunciones;
        // TODO Auto-generated constructor stub
    }

    private int n;



    @Override
    protected double[] evaluar(double[] x) {
        // TODO Auto-generated method stub


        double[] fvec=new double[n];
        double temp1, temp2, temp,ti, dx;
        int iev;

         for (int j = 0; j < n; j++) //el �ndice j es para moverse en Xj
         {

            temp1 = 1.0;
            temp2 = 2.0*x[j] - 1.0;
            temp = 2.0*temp2;

            for (int i = 0; i < n; i++) // el �ndice i es para moverse en Fi
            {

               fvec[i] += temp2; //se almacena la sumatoria  Ti(X1) + ... +  Ti(Xn)
               ti = temp*temp2 - temp1;
               temp1 = temp2;
               temp2 = ti;

            }

         }

         //al salir de este ciclo
         // fi= Ti(X1) + ... +  Ti(Xn)

         dx = 1.0/n;
         iev = -1;

         for (int i = 0; i < n; i++) {

            fvec[i] *= dx; // fi= 1/n (Ti(X1) + ... +  Ti(Xn))

          //si es par
            if (iev > 0)
            	fvec[i] += 1.0/(Math.pow((i+1), 2) - 1.0);
            iev = -iev;

         }

         return fvec;

    }


}


