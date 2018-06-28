/**
 * Esta clase especifica una disposicion concreta de estados de celdas en un tablero a medida...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Patron.
 */
public class Patron<TipoCoordenada extends Coordenada>
{
	/** The nombre. */
	private String nombre;

	/** The tablero. */
	private Tablero<TipoCoordenada> tablero;

	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 */
	public Patron(String nombre, Tablero tablero)
	{
		if (nombre == null || tablero == null)
			throw new ExcepcionArgumentosIncorrectos();
		this.nombre = nombre;
		this.tablero = tablero;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Gets the celda.
	 *
	 * @param posicion the c
	 * @return the celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(TipoCoordenada posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if (posicion == null)
			throw new ExcepcionArgumentosIncorrectos();

		if (tablero.contiene(posicion))
			return tablero.celdas.get(posicion);
		else
			throw new ExcepcionPosicionFueraTablero(posicion, tablero.getDimensiones());
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection<TipoCoordenada> getPosiciones()
	{
		return tablero.getPosiciones();
	}

	/**
	 * to String.
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		return (nombre + "\n" + tablero);
	}
}
