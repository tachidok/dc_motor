/*					 C�digo realizado durante el trabajo de tesis
 *	   Arquitectura de Software Flexible y Gen�rica para M�todos del Tipo Newton
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

package arquitecturabase;
import fabricaabstracta.Fabricas;
import problemasnolineales.MiPortaPapeles;
import problemasnolineales.ProblemaNoLineal;
import algebralineal.Matriz;

/**
 * Esta clase es la implementaci�n dentro del patr�n Bridge en la arquitectura Newton.
 * NewtonImp es usado por la clase Newton para definir su comportamiento.
 *
 * @author Ricardo
 * @see Newton
 */

public abstract class NewtonImp {

	/**
	 * Punto en la iteraci�n n
	 */
	private Matriz Xn;

	/**
	 * Fachada hacia los componentes del m�todo Newton
	 */
	ComponentesNewton componentes;


	public NewtonImp()
	{

	}


	/**
	 * Con este constructor se crea un m�todo Newton para resolver la funcion F, el problema no lineal
	 * a tratar es especificado con una f�brica
	 * @param F
	 */
    public NewtonImp(Funcion F, ProblemaNoLineal problema)
     {

        	componentes = new ComponentesNewton();
            setFuncion(F);
            F.setProblemaActual(problema);
     }

    /**
	 * Con este constructor se crea un m�todo Newton para resolver la funcion F, el problema no lineal
	 * a tratar es especificado con una f�brica
	 * @param F
	 */

    public NewtonImp(Funcion F)
    {

       	componentes = new ComponentesNewton();
           setFuncion(F);
           F.instanciarProblema();
    }



    /**
     * Resuelve el problema por medio del m�todo Newton
     */
	public void resolver(){

		CriterioDeParo criterio=componentes.getCriterioDeParo();

		while(!criterio.evaluar())
			itera();
	}

	/**
	 * Realiza una iteraci�n con el m�todo Newton
	 */

	public void itera(){

		MiPortaPapeles.actualizarValores(getFuncion(), Xn);

		Matriz d=calcularDireccion();
		double l=calcularLongitudPaso(d);
		actualizarXn(d,l);



	}

	/**
	 * Realiza una iteraci�n si el criterio de paro no se ha cumplido
	 *
	 * @return devuelve verdadero si se realizo la iteraci�n. Si el criterio de paro se cumpli� y la iteraci�n no se
	 * llev� acabo, devuelve falso
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
	 * Asigna la funci�n a tratar por el m�todo Newton
	 * @param f
	 */

	public void setFuncion(Funcion f)
	{
		componentes.setFuncion(f);
	}

	/**
	 * Devuelve la funci�n utilizada por el m�todo Newton
	 * @return
	 */
	public Funcion getFuncion()
	{
		return componentes.getFuncion();
	}

	/**
	 * Calcula la direcci�n Newton
	 * @return
	 */
	public Matriz calcularDireccion()
	{
		return componentes.getDireccionNewton().getDireccion(getXn());
	}

	/**
	 * Devuelve los componentes del m�todo
	 * @return
	 */
	public ComponentesNewton getComponentes() {
		return componentes;
	}

	/**
	 * Asigna los componentes del m�todo
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
	 * Actualiza el valor del punto en la iteraci�n n por el siguiente punto, utilizando la
	 * direcci�n Newton y la longitud de paso
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
	 * Asigna el punto en donde el m�todo debe evaluar la funci�n
	 * @param xn
	 */

	public void setXn(Matriz xn) {
		Xn = xn;
	}

	public void setXn(double xn[]) {
		Xn = Fabricas.fabricaAlgebraLineal.crearInstancia(xn);
	}


	/**Devuelve el punto en donde se encuentra el m�todo
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
