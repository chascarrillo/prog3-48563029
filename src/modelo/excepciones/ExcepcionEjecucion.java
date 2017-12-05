/**
 * Esta clase especifica el caso de un fallo imprevisto en tiempo de ejecucion...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.excepciones;

/**
 * The Class ExcepcionEjecucion.
 */
public class ExcepcionEjecucion
extends RuntimeException
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionEjecucion(String mensaje)
	{
		System.err.println(mensaje);
	}

	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param causa the causa
	 */
	public ExcepcionEjecucion(Throwable causa)
	{
		causa.printStackTrace();
	}
}
