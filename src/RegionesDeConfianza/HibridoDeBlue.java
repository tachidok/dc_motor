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

package RegionesDeConfianza;

import java.util.ArrayList;

import problemasnolineales.MiPortaPapeles;
import problemasnolineales.ProblemaNoLineal;
import problemasnolineales.SistemasNoLineales;
import algebralineal.Matriz;
import algebralineal.SVD;
import arquitecturabase.Funcion;
import fabricaabstracta.Fabricas;

/**
 * En esta clase se encuentra un algoritmo que hace el calculo de la
 * dirección newton como se especifica en el artículo
 *
 *
 * "Robust methods for systems of nonlinear equations"
 * @author Administrator
 *
 */


public class HibridoDeBlue extends RegionDeConfianza{



	private ArrayList<Matriz> direcciones;


	public HibridoDeBlue(Funcion F) {
		super(F);

		direcciones=new ArrayList<Matriz>();

		ActualizacionRegionNocedal a=new ActualizacionRegionNocedal();

		setActualizacionRegionConfianza(a);

		a.setcAlta(0.75);
		a.setCBaja(0.25);
		a.setcCrecimiento(2.0);
		a.setcDecrecimiento(0.5);
		a.setCotaDeConfianza(0.2);
		a.setCotaSuperior(2.0);
		a.setRadio(0.1);

		// TODO Auto-generated constructor stub
	}


	public Matriz getDireccionRegion(Matriz x, double region) {

		//calculando la direccion
		/* En este método la dirección es:
		 *
		 *     P = J^-1 f
		 *
		 *     y   J = USV,  J^-1 = - V S^-1 U^T
		 *
		 *     Se usa la pseudo inversa S^-1 = diag(1/v. singular 1, 1/v. singular j, 0, 0)
		 *
		 */
		ProblemaNoLineal t=getF().getProblemaActual();
		getF().setProblemaActual(new SistemasNoLineales(getF()));

		SVD descomposicionSVD=(SVD)Fabricas.fabricaAlgebraLineal.SVD(getF().primeraDerivada(x));




		//calculando posibles direcciones
		calcularDirecciones(descomposicionSVD);

		double alfa=0;
		Matriz Pj=direcciones.get(direcciones.size()-1);
		Matriz Pjsig;

		//si la direccion obtenida con todos los valores singulares
		//no sobrepasa la región, entonces es una dirección buena
		if(Pj.normaF()<=region)
			return Pj;

		//sino hay que buscar una dirección que esté dentro de la región


		for(int j=0;j<direcciones.size()-1;j++)
		{
			Pj=direcciones.get(j);
			Pjsig=direcciones.get(j+1);

			if(Pj.normaF()<=region && region<Pjsig.normaF())
			{
				//este intervalo pinta bien, entonces se calcula una direccion que vaya de
				//Pj a  Pj+1
				alfa=calcularTrayectoria(Pj,Pjsig,region);

				return Pj.mas(Pjsig.menos(Pj).por(alfa));
			}
		}

		//sino usa un gradiente descendente
		Pj=direcciones.get(0);

		getF().setProblemaActual(t);
		return Pj.por(Pj.normaF()).por(region);
	}



	public double calcularTrayectoria(Matriz Pj,Matriz Pjsig,double region)
	{
		double a,b,c;
		Matriz t;
		//a= ||Pj + Pjsig || ^2

		t=Pj.mas(Pjsig);
		t=t.transpuesta().por(t);

		a=t.getElemento(0, 0);

		//b= 2Pj (Pjsig + Pj)

		t=Pj.transpuesta().por(2.0).por(Pjsig.mas(Pj));
		b=t.getElemento(0, 0);

		//c = |Pj|| ^2

		t=Pj.transpuesta().por(Pj);


		c=t.getElemento(0, 0)-region*region;;
		return (-b+Math.sqrt(b*b-4*a*c))/2*a;

	}

	public void calcularDirecciones(SVD svd)
	{
		//calculo pseudo inversa de S

		Matriz V=svd.getV();
		Matriz U=svd.getU();
		double []valSingulares=svd.getValoresSingulares();
		Matriz pseudoInversa=Fabricas.fabricaAlgebraLineal.crearInstancia(getF().getNumVariables(),getF().getNumVariables());

		direcciones.clear();
		Matriz t;
		for(int j=0;j<valSingulares.length;j++)
		{
			pseudoInversa.set(j, j, 1.0/valSingulares[j]);

			t=V.por(pseudoInversa).por(U.transpuesta()).por(MiPortaPapeles.Fx);
			direcciones.add(t.por(-1.0));

		}

	}





	@Override
	public Matriz getDireccion(Matriz Xn) {
		// TODO Auto-generated method stub
		Matriz direccion;
		double concordancia;

		do{

		direccion=getDireccionRegion(Xn, getRadioConfianza());
		concordancia=concordanciaFuncionModelo(Xn,direccion);
		}
		while(!actualizarRadio(concordancia,direccion));

		return direccion;
	}

}
