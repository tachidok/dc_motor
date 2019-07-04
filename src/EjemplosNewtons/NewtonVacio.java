package EjemplosNewtons;

import problemasnolineales.ProblemaNoLineal;
import arquitecturabase.Funcion;
import arquitecturabase.NewtonImp;


/**
 * 
 * @author Ricardo
 *
 *
 *Esta clase la voy a utilizar como base para instanciar diferentes Newtons.
 *
 *La clase NewtonImp tiene los métodos para cambiar los componentes del newton (criterio de paro, dirección, longitud de paso, etc.
 *
 *Lo que se pretende es instanciar esta clase y cambiar los componentes dependiendo de las necesidades requeridas.
 *
 */
public class NewtonVacio  extends NewtonImp {
	
	public NewtonVacio(Funcion f, ProblemaNoLineal p){
		super(f, p);
	}


}
