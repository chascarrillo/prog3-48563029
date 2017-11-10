/**
 * Esta clase especifica el caso de buscar una coordenada negativa...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo.excepciones;

/**
 * The Class ExcepcionCoordenadaIncorrecta.
 */
public class ExcepcionCoordenadaIncorrecta
extends Exception
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
	public ExcepcionCoordenadaIncorrecta(float x, float y)
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
}
