/**
 * Esta clase especifica una disposicion concreta en un tablero a medida...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
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
	 * @param caux the c
	 * @return the celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada caux)
	throws ExcepcionPosicionFueraTablero
	{
		EstadoCelda estado = null;
		if(caux == null) throw new ExcepcionArgumentosIncorrectos();
		estado = tablero.getCelda(caux);

		return estado;
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
