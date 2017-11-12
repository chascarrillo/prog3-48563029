/**
 * Esta clase especifica una partida...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import modelo.Tablero;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Juego.
 */
public class Juego
{
	
	/** The tablero. */
	private Tablero tablero;

	/** The regla conway. */
	private Regla regla;

	/** The patrones usados. */
	private ArrayList<Patron> patronesUsados = new ArrayList<Patron>();

	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 */
	public Juego (Tablero tablero, Regla regla)
	{
		if(tablero == null  ||  regla == null) throw new ExcepcionArgumentosIncorrectos();
		this.tablero = tablero;
		this.regla = regla;
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
			Coordenada2D caux = (Coordenada2D) iterator.next();
			try
			{
				tablero.setCelda(caux, regla.calculaSiguienteEstadoCelda(tablero, caux));
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
