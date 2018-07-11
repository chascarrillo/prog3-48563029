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
public class ExcepcionGeneracion
extends Exception
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	String mensaje = "";

	/**
	 * Instantiates a new excepcion generacion.
	 */
	public ExcepcionGeneracion()
	{}

	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionGeneracion(String mensaje)
	{
		this.mensaje = mensaje;
		System.err.println(mensaje);
	}

	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param causa the causa
	 */
	public ExcepcionGeneracion(Throwable causa)
	{
		causa.printStackTrace();
	}

	@Override
	public String getMessage()
	{
		return mensaje;
	}
}
