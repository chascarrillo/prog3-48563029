package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

// TODO: Auto-generated Javadoc
/**
 * The Class Coordenada1D.
 */
public class Coordenada1D
extends Coordenada
{
	
	/** The x. */
	private int x;
	
	/**
	 * Instantiates a new coordenada.
	 *
	 * @param x the x
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada1D(int x)
	throws ExcepcionCoordenadaIncorrecta
	{	
		if(x < 0) throw new ExcepcionCoordenada1DIncorrecta(x);
	  	this.x = x;
	}
	
	/**
	 * Instantiates a new coordenada.
	 *
	 * @param otra the otra
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada1D(Coordenada1D otra)
	throws ExcepcionCoordenadaIncorrecta
	{
		if(otra == null) throw new ExcepcionArgumentosIncorrectos();
		x = otra.x;
	}

	/**
	 * to String.
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		return new String("("+this.x+")");
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}


	/**
	 * equals.
	 *
	 * @param otro objeto con el que se compara el objeto implicito
	 * @return cierto, si los dos objetos son iguales
	 */
	public boolean equals(Object otro)
	{
		if (this == otro)
	        return true;
	    if (otro == null)
	        return false;
	    if (getClass() != otro.getClass())
	        return false;
	    Coordenada1D caux = (Coordenada1D)otro;
	    if (Integer.valueOf(x) != Integer.valueOf(caux.x))
	        return false;
	    return true;
	}

	/**
	 * Suma.
	 *
	 * @param otra the otra
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada1D suma(Coordenada1D otra)
	throws ExcepcionCoordenadaIncorrecta
	{
		if(otra == null) throw new ExcepcionArgumentosIncorrectos();
		Coordenada1D nueva = new Coordenada1D(x+otra.x);
		return nueva;
	}

	/**
	 * hashCode.
	 *
	 * @return numero obtenido de aplicar la funcion al objeto implicito. 2 objetos que sean equals = true deben devolver el mismo hashcode
	 */
	@Override
	public int hashCode()
	{
		return new Integer(31+x);
	}

	/* (non-Javadoc)
	 * @see modelo.Coordenada#suma(modelo.Coordenada)
	 */
	@Override
	public Coordenada1D suma(Coordenada c)
	throws ExcepcionCoordenadaIncorrecta
	{
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		Coordenada1D aux = new Coordenada1D ((Coordenada1D) c);
		return new Coordenada1D(x + aux.x);
	}

	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada1D()
	throws ExcepcionCoordenadaIncorrecta
	{
		super();
	}
}
