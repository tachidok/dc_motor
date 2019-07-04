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

import algebralineal.Matriz;
/**
 * En esta clase se encuentra un algoritmo de actualización de región de confianza
 * programado como se especifica en el libro "numerical optimization" de Jorge Nocedal
 * @author Administrator
 *
 */
public class ActualizacionRegionNocedal extends StrActRadioConfianza {

	private double radio;
	private double cBaja;
	private double cDecrecimiento;
	private double cAlta;
	private double cCrecimiento;
	private double cotaSuperior;
	private double cotaDeConfianza;




	@Override
	public boolean actualizarRadioConfianza(double concordancia,
			Matriz direccion) {
		// TODO Auto-generated method stub

		if(concordancia<cBaja)
		{
			radio=direccion.normaF()*cDecrecimiento;
		}
		else
		{
			if(concordancia>cAlta && direccion.normaF()-radio<=PrecisionNumerica.MiPrecisionNumerica.EPSILON)
				radio=Math.min(cCrecimiento*radio, cotaSuperior);

		}


		if(concordancia>cotaDeConfianza )
			return true;
		else
			return false;

	}

	public double getCBaja() {
		return cBaja;
	}

	public void setCBaja(double c1) {
		cBaja = c1;
	}

	public double getCDecrecimiento() {
		return cDecrecimiento;
	}

	public void setcDecrecimiento(double c2) {
		cDecrecimiento = c2;
	}


	public double getCotaSuperior() {
		return cotaSuperior;
	}

	public void setCotaSuperior(double cotaSuperior) {
		this.cotaSuperior = cotaSuperior;
	}

	public double getCotaDeConfianza() {
		return cotaDeConfianza;
	}

	public void setCotaDeConfianza(double cotaDeConfianza) {
		this.cotaDeConfianza = cotaDeConfianza;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double getRadioConfianza() {
		// TODO Auto-generated method stub
		return getRadio();
	}

	public void setcAlta(double cAlta) {
		this.cAlta = cAlta;
	}

	public double getcAlta() {
		return cAlta;
	}

	public void setcCrecimiento(double cCrecimiento) {
		this.cCrecimiento = cCrecimiento;
	}

	public double getcCrecimiento() {
		return cCrecimiento;
	}

}
