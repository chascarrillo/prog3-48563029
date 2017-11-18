/**
 * Esta clase especifica el caso de buscar un argumento y encontar null...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.excepciones;

/**
 * The Class ExcepcionArgumentosIncorrectos.
 */
public class ExcepcionArgumentosIncorrectos
extends ExcepcionEjecucion
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new excepcion argumentos incorrectos.
	 */
	public ExcepcionArgumentosIncorrectos() {
		super("Parametro incorrecto, no deberia ser null");
	}

	/**
	 * Devuelve un mensaje con informacion sobre la excepcion ocurrida.
	 *
	 * @return info
	 */
	public String getMessage() {
		return "Parametro incorrecto, no deberia ser null";
	}
}
