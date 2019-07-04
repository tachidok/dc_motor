package JacobianMatriz.principal;

/**
 * Esta clase define un las operaciones básicas de un vector
 * @author Administrator
 *
 */

public class Vector {
	private double datos[];
	private int dimension = 2;

	public Vector(double ...datos)
	{
		this.datos = new double[datos.length];
		System.arraycopy(datos,0,this.datos,0,datos.length);
		dimension = datos.length;
	}

	public Vector(int dimension)
	{
		this.dimension = dimension;
		datos = new double[dimension];
	}

	public int getDimension()
	{
		return dimension;
	}

	public void sumar(Vector v)
	{
		for(int i = 0; i < dimension ; i++)
			datos[i]+=v.get(i);
	}

	public void restar(Vector v)
	{
		for(int i = 0; i < dimension ; i++)
			datos[i]-=v.get(i);
	}

	public void multiplicarEscalar(double escalar)
	{
		for(int i = 0; i < dimension ; i++)
			datos[i]*=escalar;
	}

	public double norma()
	{
		double normaSinRaiz = normaSinRaiz();
		return Math.sqrt(normaSinRaiz);
	}

	public double normaSinRaiz()
	{
		double norma = 0;

		for(int i = 0; i< dimension;i++)
			norma =norma + (datos[i]*datos[i]);

		return norma;
	}

	public double distancia(Vector v)
	{
		double res = distanciaSinRaiz(v);
		return Math.sqrt(res);
	}

	public double distanciaSinRaiz(Vector v)
	{
		double temp = 0;
		double res = 0;

		for(int i = 0; i< dimension;i++)
		{
			temp = datos[i]- v.get(i);
			res += temp*temp;
		}

		return res;
	}

	public double productoPunto(Vector v)
	{
		double res = 0;

		for(int i = 0; i< dimension;i++)
		{
			res = res + (datos[i]* v.get(i));
		}

		return res;
	}

	public Vector clonar()
	{
		return new Vector(datos);
	}

	public boolean equals(Vector v)
	{
		if(v.getDimension() != dimension)
			return false;

		for(int i = 0; i < dimension; i++)
		{
			if(datos[i] != v.get(i))
				return false;
		}

		return true;
	}

	public void acotarMagnitud(double cota)
	{
		Double norma = norma();

		if(!norma.isNaN())
		{
			this.multiplicarEscalar(cota/norma);
		}
	}

	public double get(int indice)
	{
		return datos[indice];
	}


	public void set(Vector v)
	{
		datos = new double[v.getDimension()];
		dimension = v.getDimension();
		System.arraycopy(v.getDatos(),0,datos,0,dimension);
	}

	public void set(double ...datos)
	{
		System.arraycopy(datos,0,this.datos,0,dimension);
	}

	public String toString()
	{
		StringBuffer s = new StringBuffer();
		s.append("[");

		for(int i = 0; i<dimension;i++)
		{
			s.append(datos[i]+ ", ");
		}

		s.append("]");
		return s.toString();
	}

	public double [] getDatos()
	{
		return datos;
	}

	public static void main(String ar[])
	{
		Vector v = new Vector(5);



		System.out.println(v);
	}
}
