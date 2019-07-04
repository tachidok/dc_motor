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
import problemasnolineales.MiPortaPapeles;
import algebralineal.Matriz;
import arquitecturabase.DireccionNewton;
import arquitecturabase.Funcion;


/**
 * Esta es la raiz de la familia de métodos que utilizan regiones de confianza
 * @author Administrator
 *
 */
public abstract class RegionDeConfianza extends DireccionNewton{

	public RegionDeConfianza(Funcion F) {
		super(F);

		// TODO Auto-generated constructor stub
	}


	private StrActRadioConfianza actualizacionRegionConfianza;

	public double concordanciaFuncionModelo(Matriz x, Matriz direccion)
	{

	    Matriz Xsiguiente= x.mas(direccion);
		double difFuncion=MiPortaPapeles.Fx.normaF()-getF().evaluarDeAcuerdoAlProblema(Xsiguiente);
		double difModelo=getF().modeloCuadratico(x, direccion).normaF()-getF().modeloCuadratico(Xsiguiente, direccion).normaF();

		return difFuncion/difModelo;
	}


	public double getRadioConfianza()
	{
		return actualizacionRegionConfianza.getRadioConfianza();
	}

	public boolean actualizarRadio(double concoordancia, Matriz direccion)
	{
		return actualizacionRegionConfianza.actualizarRadioConfianza(concoordancia, direccion);
	}

	public void setActualizacionRegionConfianza(
			StrActRadioConfianza actualizacionRegionConfianza) {
		this.actualizacionRegionConfianza = actualizacionRegionConfianza;
	}


	public StrActRadioConfianza getActualizacionRegionConfianza() {
		return actualizacionRegionConfianza;
	}

}
