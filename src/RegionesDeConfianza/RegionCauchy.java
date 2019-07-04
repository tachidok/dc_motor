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


import direcciones.PuntoCauchy;
import direcciones.DireccionRegion;
import algebralineal.Matriz;
import arquitecturabase.Funcion;
/**
 * Esta clase contiene un algoritmo de región de confianza que utiliza una dirección cauchy o punto cauchy
 * @author Administrator
 *
 */
public class RegionCauchy extends RegionDeConfianza{
	private DireccionRegion puntoCauchy;

	public RegionCauchy(Funcion F) {
		super(F);

		ActualizacionRegionNocedal a=new ActualizacionRegionNocedal();

		setActualizacionRegionConfianza(a);

		a.setcAlta(0.75);
		a.setCBaja(0.25);
		a.setcCrecimiento(2.0);
		a.setcDecrecimiento(0.5);
		a.setCotaDeConfianza(0.2);
		a.setCotaSuperior(2.0);
		a.setRadio(0.1);

		puntoCauchy=new PuntoCauchy(F);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matriz getDireccion(Matriz Xn) {
		// TODO Auto-generated method stub

		Matriz direccion;
		double concordancia;

		do{

		direccion=puntoCauchy.getDireccion(Xn, getRadioConfianza());
		concordancia=concordanciaFuncionModelo(Xn,direccion);
		}
		while(!actualizarRadio(concordancia,direccion));

		return direccion;
	}



}
