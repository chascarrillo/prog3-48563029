/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Collection;

public class Patron
{
	private String nombre;
	private Tablero tablero;

	public Patron(String nombre, Tablero tablero)
	{
		this.nombre = nombre;
		this.tablero = tablero;
	}

	public String getNombre()
	{
		return nombre;
	}

	public EstadoCelda getCelda(Coordenada c)
	{
		return tablero.getCelda(c);
	}

	public Collection<Coordenada> getPosiciones()
	{
		return tablero.getPosiciones();
	}

	public String toString()
	{
		return (nombre+"\n"+tablero);
	}
}
