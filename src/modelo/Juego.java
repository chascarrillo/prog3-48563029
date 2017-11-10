/**
 * Esta clase especifica una partida...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import modelo.ReglaConway;

/**
 * The Class Juego.
 */
public class Juego
{
	
	/** The tablero. */
	private Tablero tablero;

	/** The regla conway. */
	private ReglaConway reglaConway;

	/** The patrones usados. */
	private ArrayList<Patron> patronesUsados;

	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param reglaconway the reglaconway
	 */
	public Juego (Tablero tablero, ReglaConway reglaconway)
	{
		if(tablero == null  ||  reglaconway == null) throw new ExcepcionArgumentosIncorrectos();
		this.tablero = tablero;
		reglaConway = reglaconway;
	}

	/**
	 * Carga patron.
	 *
	 * @param p the p
	 * @param posicionInicial the posicion inicial
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial)
	throws ExcepcionPosicionFueraTablero
	{
		if(tablero.cargaPatron(p, posicionInicial))
		{
			patronesUsados.add(p);
		}
		else
		{
			System.err.println("Error cargando plantilla " + p.getNombre() + " en " + posicionInicial);
		}
	}

	/**
	 * Actualiza.
	 */
	public void actualiza()
	{
		Collection<Coordenada> cds = tablero.getPosiciones();
		Iterator<Coordenada> iterator = cds.iterator();

		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			try
			{
				tablero.setCelda(caux, reglaConway.calculaSiguienteEstadoCelda(tablero, caux));
			}
			catch (ExcepcionPosicionFueraTablero e)
			{
				throw new ExcepcionEjecucion(e);
			}
		}
	}

	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero()
	{
		return tablero;
	}

	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron> getPatrones()
	{
		return patronesUsados;
	}
}
