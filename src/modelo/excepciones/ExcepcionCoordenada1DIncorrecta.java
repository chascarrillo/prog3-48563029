/**
 * Esta clase especifica el caso de crear una coordenada unidimensional negativa...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada1DIncorrecta.
 */
public class ExcepcionCoordenada1DIncorrecta
extends ExcepcionCoordenadaIncorrecta
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The x. */
	private float x;

	/**
	 * Instantiates a new excepcion coordenada incorrecta.
	 *
	 * @param x
	 *            the x
	 */
	public ExcepcionCoordenada1DIncorrecta(float x)
	{
		this.x = x;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX() {
		return x;
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
