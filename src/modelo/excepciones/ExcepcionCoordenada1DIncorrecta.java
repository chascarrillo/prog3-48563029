package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada1DIncorrecta.
 */
public class ExcepcionCoordenada1DIncorrecta
extends ExcepcionCoordenadaIncorrecta
{
	private static final long serialVersionUID = 1L;
	/** The x. */
	private float x;
	
	/**
	 * Instantiates a new excepcion coordenada incorrecta.
	 *
	 * @param x the x
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
	public float getX()
	{
		return x;
	}

	public String getMessage()
	{
		return "Coordenada negativa";
	}
}
