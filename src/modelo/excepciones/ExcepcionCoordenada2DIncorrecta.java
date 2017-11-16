/**
 * Esta clase especifica el caso de buscar una coordenada negativa...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo.excepciones;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcepcionCoordenada2DIncorrecta.
 */
public class ExcepcionCoordenada2DIncorrecta
extends ExcepcionCoordenadaIncorrecta
{
	
	/** The x. */
	private float x;
	
	/** The y. */
	private float y;
	
	/**
	 * Instantiates a new excepcion coordenada incorrecta.
	 *
	 * @param x the x
	 * @param y the y
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

	public String getMessage()
	{
		return "Coordenada negativa";
	}
}
