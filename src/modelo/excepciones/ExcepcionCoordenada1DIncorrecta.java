package modelo.excepciones;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcepcionCoordenada1DIncorrecta.
 */
public class ExcepcionCoordenada1DIncorrecta
extends ExcepcionCoordenadaIncorrecta
{
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
}
