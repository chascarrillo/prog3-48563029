/**
 * Esta clase especifica una disposicion concreta en un tablero a medida...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Patron.
 */
public class Patron
{
	
	/** The nombre. */
	private String nombre;
	
	/** The tablero. */
	private Tablero tablero;

	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 */
	public Patron(String nombre, Tablero tablero)
	{
		if(nombre == null  ||  tablero == null) throw new ExcepcionArgumentosIncorrectos();
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
	 * @param c the c
	 * @return the celda
	 */
	public EstadoCelda getCelda(Coordenada c)
	{
		EstadoCelda estado = null;
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		try
		{
			estado = tablero.getCelda(c);
		}
		catch (ExcepcionPosicionFueraTablero e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			return estado;
		}
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection<Coordenada> getPosiciones()
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
		return (nombre+"\n"+tablero);
	}
}
