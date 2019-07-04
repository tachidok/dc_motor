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

package arquitecturabase;
import fabricaabstracta.Fabricas;
import problemasnolineales.MiPortaPapeles;
import problemasnolineales.ProblemaNoLineal;
import algebralineal.Matriz;

/**
 * Esta clase es la implementación dentro del patrón Bridge en la arquitectura Newton.
 * NewtonImp es usado por la clase Newton para definir su comportamiento.
 *
 * @author Ricardo
 * @see Newton
 */

public abstract class NewtonImp {

	/**
	 * Punto en la iteración n
	 */
	private Matriz Xn;

	/**
	 * Fachada hacia los componentes del método Newton
	 */
	ComponentesNewton componentes;


	public NewtonImp()
	{

	}


	/**
	 * Con este constructor se crea un método Newton para resolver la funcion F, el problema no lineal
	 * a tratar es especificado con una fábrica
	 * @param F
	 */
    public NewtonImp(Funcion F, ProblemaNoLineal problema)
     {

        	componentes = new ComponentesNewton();
            setFuncion(F);
            F.setProblemaActual(problema);
     }

    /**
	 * Con este constructor se crea un método Newton para resolver la funcion F, el problema no lineal
	 * a tratar es especificado con una fábrica
	 * @param F
	 */

    public NewtonImp(Funcion F)
    {

       	componentes = new ComponentesNewton();
           setFuncion(F);
           F.instanciarProblema();
    }



    /**
     * Resuelve el problema por medio del método Newton
     */
	public void resolver(){

		CriterioDeParo criterio=componentes.getCriterioDeParo();

		while(!criterio.evaluar())
			itera();
	}

	/**
	 * Realiza una iteración con el método Newton
	 */

	public void itera(){

		MiPortaPapeles.actualizarValores(getFuncion(), Xn);

		Matriz d=calcularDireccion();
		double l=calcularLongitudPaso(d);
		actualizarXn(d,l);



	}

	/**
	 * Realiza una iteración si el criterio de paro no se ha cumplido
	 *
	 * @return devuelve verdadero si se realizo la iteración. Si el criterio de paro se cumplió y la iteración no se
	 * llevó acabo, devuelve falso
	 *
	 */
	public boolean iteraUsandoCriterio()
	{
		CriterioDeParo criterioDeParo=componentes.getCriterioDeParo();

		if(criterioDeParo.evaluar())
		return false;

		itera();
		return true;
	}

	/**
	 * Asigna la función a tratar por el método Newton
	 * @param f
	 */

	public void setFuncion(Funcion f)
	{
		componentes.setFuncion(f);
	}

	/**
	 * Devuelve la función utilizada por el método Newton
	 * @return
	 */
	public Funcion getFuncion()
	{
		return componentes.getFuncion();
	}

	/**
	 * Calcula la dirección Newton
	 * @return
	 */
	public Matriz calcularDireccion()
	{
		return componentes.getDireccionNewton().getDireccion(getXn());
	}

	/**
	 * Devuelve los componentes del método
	 * @return
	 */
	public ComponentesNewton getComponentes() {
		return componentes;
	}

	/**
	 * Asigna los componentes del método
	 * @param componentes
	 */

	public void setComponentes(ComponentesNewton componentes) {
		this.componentes = componentes;
	}

	/**
	 * Calcula la longitud de paso
	 * @return
	 */

	public  double calcularLongitudPaso(Matriz direccion)
	{
		return componentes.getLongitudDePaso().getLongitudDePaso(direccion, getXn());
	}

	/**
	 * Actualiza el valor del punto en la iteración n por el siguiente punto, utilizando la
	 * dirección Newton y la longitud de paso
	 * @param direcciones
	 * @param longitudPaso
	 */

	public  void actualizarXn(Matriz direcciones, double longitudPaso)
	{
		Matriz incremento=direcciones.por(longitudPaso);
		Xn=Xn.mas(incremento);
		MiPortaPapeles.actualizarPunto(Xn);
	}

	/**
	 * Asigna el punto en donde el método debe evaluar la función
	 * @param xn
	 */

	public void setXn(Matriz xn) {
		Xn = xn;
	}

	public void setXn(double xn[]) {
		Xn = Fabricas.fabricaAlgebraLineal.crearInstancia(xn);
	}


	/**Devuelve el punto en donde se encuentra el método
	 *
	 * @return
	 */
	public Matriz getXn() {
		return Xn;
	}

	public double[] getPuntoActual()
	{
		double x[]=new double[Xn.numeroFilas()];

		for(int i=0;i<Xn.numeroFilas();i++)
			x[i]=Xn.getElemento(i, 0);

		return x;
	}


	public Matriz Fn()
	{
		return MiPortaPapeles.Fx;
	}


	public void setX0(double x0[])
	{
		MiPortaPapeles.puntoInicio=Fabricas.fabricaAlgebraLineal.crearInstancia(x0);
	}



}
