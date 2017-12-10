/**
 * Esta clase especifica el caso de buscar una coordenada en un tablero que no la contiene...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida.excepciones;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcepcionGeneracion.
 */
public class ExcepcionLectura
extends Exception
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new excepcion lectura.
	 */
	public ExcepcionLectura()
	{}

	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionLectura(String mensaje)
	{
		System.err.println(mensaje);
	}

	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param causa the causa
	 */
	public ExcepcionLectura(Throwable causa)
	{
		causa.printStackTrace();
	}
}
