/**
 * Esta clase especifica el caso de buscar una coordenada en un tablero que no la contiene...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.excepciones;

import modelo.Coordenada;

/**
 * The Class ExcepcionPosicionFueraTablero.
 */
public class ExcepcionPosicionFueraTablero
extends Exception
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dimensiones. */
	private Coordenada dimensiones;

	/** The coordenada. */
	private Coordenada coordenada;

	/**
	 * Instantiates a new excepcion posicion fuera tablero.
	 *
	 * @param posicion
	 *            the coordenada
	 * @param coordenada2
	 *            the dimensiones
	 */
	public ExcepcionPosicionFueraTablero(Coordenada posicion, Coordenada dimensiones)
	{
		if (posicion == null || dimensiones == null)
			throw new ExcepcionArgumentosIncorrectos();
		this.dimensiones = dimensiones;
		this.coordenada = posicion;
	}

	/**
	 * Devuelve un mensaje con informacion sobre la excepcion ocurrida.
	 *
	 * @return info
	 */
	public String getMessage()
	{
		return coordenada.toString() + " no entra en el tablero de dimensiones " + dimensiones.toString();
	}

	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones()
	{
		return dimensiones;
	}

	/**
	 * Gets the coordenada.
	 *
	 * @return the coordenada
	 */
	public Coordenada getCoordenada()
	{
		return coordenada;
	}
}
