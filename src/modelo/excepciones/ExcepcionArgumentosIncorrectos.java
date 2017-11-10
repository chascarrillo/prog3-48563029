/**
 * Esta clase especifica el caso de buscar un argumento y encontar null...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo.excepciones;

/**
 * The Class ExcepcionArgumentosIncorrectos.
 */
public class ExcepcionArgumentosIncorrectos
extends ExcepcionEjecucion
{
	
	/**
	 * Instantiates a new excepcion argumentos incorrectos.
	 */
	public ExcepcionArgumentosIncorrectos()
	{
		super("Parametro incorrecto, no deberia ser null");
	}
}
