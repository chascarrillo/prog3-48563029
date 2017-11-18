/**
 * Esta clase especifica una coordenada bidimensional...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class Coordenada2D.
 */
public class Coordenada2D
extends Coordenada
{
	/** The x. */
	private int x;

	/** The y. */
	private int y;

	/**
	 * Instantiates a new coordenada.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada2D(int x, int y)
	throws ExcepcionCoordenadaIncorrecta
	{
		if (x < 0 || y < 0)
			throw new ExcepcionCoordenada2DIncorrecta(x, y);
		this.x = x;
		this.y = y;
	}

	/**
	 * Instantiates a new coordenada.
	 *
	 * @param otra the otra
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada2D(Coordenada2D otra)
	throws ExcepcionCoordenadaIncorrecta
	{
		if (otra == null)
			throw new ExcepcionArgumentosIncorrectos();
		x = otra.x;
		y = otra.y;
	}

	/**
	 * to String.
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		return new String("(" + this.x + "," + this.y + ")");
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
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY()
	{
		return y;
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
		Coordenada2D caux = (Coordenada2D) otro;
		if (Integer.valueOf(this.getX()) != Integer.valueOf(caux.getX()))
			return false;
		if (Integer.valueOf(this.getY()) != Integer.valueOf(caux.getY()))
			return false;
		return true;
	}

	/**
	 * hashCode.
	 *
	 * @return numero obtenido de aplicar la funcion al objeto implicito. 2 objetos
	 *         que sean equals = true deben devolver el mismo hashcode
	 */
	@Override
	public int hashCode()
	{
		return new Integer(31 * (31 + x) + y);
	}

	/**
	 * Suma.
	 *
	 * @param c the c
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	@Override
	public Coordenada2D suma(Coordenada c)
	throws ExcepcionCoordenadaIncorrecta
	{
		if (c == null)
			throw new ExcepcionArgumentosIncorrectos();
		return new Coordenada2D(x + ((Coordenada2D) c).x, y + ((Coordenada2D) c).y);
	}

	/**
	 * Instantiates a new coordenada 2 D.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada2D()
	throws ExcepcionCoordenadaIncorrecta
	{
		super();
	}
}
