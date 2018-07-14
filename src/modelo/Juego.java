/**
 * Esta clase especifica una partida...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Juego.
 */
public class Juego<TipoCoordenada extends Coordenada>
{

	/** The tablero. */
	private Tablero<TipoCoordenada> tablero;

	/** The regla conway. */
	private Regla<TipoCoordenada> regla;

	/** The patrones usados. */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados = new ArrayList<Patron<TipoCoordenada>>();

	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 */
	public Juego(Tablero<TipoCoordenada> tablero, Regla<TipoCoordenada> regla)
	{
		if (tablero == null || regla == null)
			throw new ExcepcionArgumentosIncorrectos();
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
	public void cargaPatron(Patron<TipoCoordenada> p, TipoCoordenada posicionInicial)
	throws ExcepcionPosicionFueraTablero
	{
		if (tablero.cargaPatron(p, posicionInicial))
			patronesUsados.add(p);
		else
			System.err.println("Error cargando plantilla " + p.getNombre() + " en " + posicionInicial);
	}

	/**
	 * Actualiza.
	 */
	@SuppressWarnings("unchecked")
	public void actualiza()
	{
		try
		{
			Tablero<TipoCoordenada> copiaTablero = null;
			if(tablero instanceof Tablero1D)
			{
				copiaTablero = (Tablero<TipoCoordenada>) new Tablero1D(((Coordenada1D) tablero.getDimensiones()).getX());
			}
			else if(tablero instanceof TableroCeldasCuadradas)
			{
				copiaTablero = (Tablero<TipoCoordenada>) new TableroCeldasCuadradas(((Coordenada2D) tablero.getDimensiones()).getX(), ((Coordenada2D) tablero.getDimensiones()).getY());
			}
			else
			{
				throw new ExcepcionEjecucion("se intento actualizar un tablero de tipo no valido");
			}


			Iterator<TipoCoordenada> iterator = tablero.getPosiciones().iterator();
			while(iterator.hasNext())
			{
				TipoCoordenada caux = iterator.next();
				copiaTablero.setCelda(caux, tablero.getCelda(caux));
			}


			iterator = copiaTablero.getPosiciones().iterator();
			while (iterator.hasNext())
			{
				TipoCoordenada caux = iterator.next();
				tablero.setCelda(caux, regla.calculaSiguienteEstadoCelda(copiaTablero, caux));
			}
		}
		catch (ExcepcionPosicionFueraTablero e)
		{
			throw new ExcepcionEjecucion(e);
		}
		catch (ExcepcionCoordenadaIncorrecta e)
		{
			throw new ExcepcionEjecucion(e);
		}
	}

	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero<TipoCoordenada> getTablero()
	{
		return tablero;
	}

	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones()
	{
		return patronesUsados;
	}
}
