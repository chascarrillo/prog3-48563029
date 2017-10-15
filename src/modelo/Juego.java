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
		this.tablero = tablero;
		reglaConway = reglaconway;
	}

	/**
	 * Carga patron.
	 *
	 * @param p the p
	 * @param posicionInicial the posicion inicial
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial)
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
		Collection<Coordenada> cds = sortColeccion(tablero.getPosiciones());
		Iterator<Coordenada> iterator = cds.iterator();

		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			tablero.setCelda(caux, reglaConway.calculaSiguienteEstadoCelda(tablero, caux));
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

	/**
	 * Sort coleccion.
	 *
	 * @param poss the poss
	 * @return the collection
	 */
	private Collection<Coordenada> sortColeccion(Collection<Coordenada> poss)
	{// las primeras 5 lineas son una tonteria mia para poder inicializar una coleccion vacia...
		List<Coordenada> NOSEINICIALIZARCOLECCIONES = new ArrayList<Coordenada>(Arrays.asList(new Coordenada(0, 0)));
		Iterator<Coordenada> SIGOSINSABERINICIALIZARCOLECCIONES = NOSEINICIALIZARCOLECCIONES.iterator();
		while (SIGOSINSABERINICIALIZARCOLECCIONES.hasNext())
		{
			SIGOSINSABERINICIALIZARCOLECCIONES.remove();
		}

		Collection<Coordenada> collreturn = (Collection<Coordenada>) NOSEINICIALIZARCOLECCIONES;
		Collection<Coordenada> arg = (Collection<Coordenada>) NOSEINICIALIZARCOLECCIONES;
		arg.addAll(poss);

		Coordenada caux = null, cauxxm = null, cauxym = null;
		Iterator<Coordenada> iterator = null;
		int xmin = Integer.MAX_VALUE, ymin = Integer.MAX_VALUE;

		while(!arg.isEmpty())
		{
			iterator = arg.iterator();
			while(iterator.hasNext())
			{
				caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
				if (xmin > caux.getX())
				{
					xmin = caux.getX();
					cauxxm = caux;
				}
				if (ymin > caux.getY())
				{
					ymin = caux.getY();
					cauxym = caux;
				}
				else if(cauxym.getY() == caux.getY()  &&  cauxym.getX()>caux.getX())
				{
					cauxym = caux;
				}
			}
			if(cauxxm.getY() == ymin)
			{
				collreturn.add(cauxxm);
				arg.remove(cauxxm);
			}
			else
			{
				collreturn.add(cauxym);
				arg.remove(cauxym);
			}
		}

		return collreturn;
	}
}
