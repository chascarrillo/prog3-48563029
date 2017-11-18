/**
 * Esta clase especifica el caso de crear una coordenada bidimensional negativa...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada2DIncorrecta.
 */
public class ExcepcionCoordenada2DIncorrecta
extends ExcepcionCoordenadaIncorrecta
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The x. */
	private float x;

	/** The y. */
	private float y;

	/**
	 * Instantiates a new excepcion coordenada incorrecta.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public ExcepcionCoordenada2DIncorrecta(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX()
	{
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public float getY()
	{
		return y;
	}

	/**
	 * Devuelve un mensaje con informacion sobre la excepcion ocurrida.
	 *
	 * @return info
	 */
	public String getMessage()
	{
		return "Coordenada negativa";
	}
}
