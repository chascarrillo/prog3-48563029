/**
 * Esta clase abstracta especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map;

import modelo.EstadoCelda;
import modelo.Patron;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Tablero.
 */
public abstract class Tablero<TipoCoordenada extends Coordenada>
{
	/** The celdas. */
	protected Map<TipoCoordenada, EstadoCelda> celdas;

	/** The dimensiones. */
	protected TipoCoordenada dimensiones;

	/**
	 * Instantiates a new tablero.
	 *
	 * @param dimensiones the dimensiones
	 */
	protected Tablero(TipoCoordenada dimensiones)
	{
		if (dimensiones == null)
			throw new ExcepcionArgumentosIncorrectos();
		this.dimensiones = dimensiones;
		celdas = new HashMap<TipoCoordenada, EstadoCelda>();
	}

	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public TipoCoordenada getDimensiones()
	{
		return dimensiones;
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return coleccion de coordenadas
	 */
	public Collection<TipoCoordenada> getPosiciones()
	{/*
		if (this instanceof Tablero1D)
		{
			Set<TipoCoordenada> ts = new TreeSet<TipoCoordenada>(
					ComparadorCoordenada.getComparator(ComparadorCoordenada.X_SORT));
			ts.addAll(celdas.keySet());
			return (Collection<TipoCoordenada>) ts;
		}
		else
		{
			Set<TipoCoordenada> ts = new TreeSet<TipoCoordenada>(
					ComparadorCoordenada.getComparator(ComparadorCoordenada.Y_SORT, ComparadorCoordenada.X_SORT));
			ts.addAll(celdas.keySet());
			return (Collection<TipoCoordenada>) ts;
		}*/
		Map<TipoCoordenada, EstadoCelda> treeMap = new TreeMap<TipoCoordenada, EstadoCelda>(
			new Comparator<TipoCoordenada>()
			{
				@Override
				public int compare(TipoCoordenada c1, TipoCoordenada c2)
				{
					if (c1 instanceof Coordenada1D)
					{
						Integer aux1 = ((Coordenada1D) c1).getX();
						Integer aux2 = ((Coordenada1D) c2).getX();
						return aux1.compareTo(aux2);
					}
					else //c1 instanceof Coordenada2D
					{
						Integer aux1x = ((Coordenada2D) c1).getX();
						Integer aux1y = ((Coordenada2D) c1).getY();
						Integer aux2x = ((Coordenada2D) c2).getX();
						Integer aux2y = ((Coordenada2D) c2).getY();
						if(aux1y.compareTo(aux2y) != 0)
						{ // c1 y c2 tienen distinta y
							return aux1y.compareTo(aux2y);
						}
						else
						{ // c1 y c2 tienen igual y
							return aux1x.compareTo(aux2x);
						}
					}
				}
			}
		);
		treeMap.putAll(celdas);
		return (Collection<TipoCoordenada>) treeMap.keySet();
	}

	/**
	 * Obtiene el estado de la celda.
	 *
	 * @param posicion the posicion
	 * @return celda viva/muerta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(TipoCoordenada posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if (posicion == null) throw new ExcepcionArgumentosIncorrectos();

		if (contiene(posicion))
			return celdas.get(posicion);
		else
			throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
	}

	/**
	 * Sets the celda.
	 *
	 * @param posicion the posicion
	 * @param e el estado
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void setCelda(TipoCoordenada posicion, EstadoCelda e)
	throws ExcepcionPosicionFueraTablero
	{
		if (posicion == null) throw new ExcepcionArgumentosIncorrectos();
		if (contiene(posicion))
			celdas.put(posicion, e);
		else
			throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
	}

	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return las coordenadas circundantes
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract ArrayList<TipoCoordenada> getPosicionesVecinasCCW(TipoCoordenada posicion)
	throws ExcepcionPosicionFueraTablero;

	/**
	 * Carga patron.
	 *
	 * @param patron the patron
	 * @param coordenadaInicial the TipoCoordenada inicial
	 * @return true, if successful
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public boolean cargaPatron(Patron<TipoCoordenada> patron, TipoCoordenada coordenadaInicial)
	throws ExcepcionPosicionFueraTablero
	{
		if (patron == null || coordenadaInicial == null) throw new ExcepcionArgumentosIncorrectos();

		Iterator<TipoCoordenada> iterator = null;
		TipoCoordenada caux = null;
		boolean control = false;
		Collection<TipoCoordenada>	posPatron = patron.getPosiciones(),
								posTablero = recortarColeccion(getPosiciones(), coordenadaInicial);

		if (posTablero.isEmpty()  ||  anchuraColeccion(posPatron) > anchuraColeccion(posTablero)
				||  alturaColeccion(posPatron) > alturaColeccion(posTablero))
		{
			iterator = posPatron.iterator();
			while (iterator.hasNext())
			{
				try
				{
					caux = (TipoCoordenada) coordenadaInicial.suma(iterator.next());
				}
				catch (ExcepcionCoordenadaIncorrecta e)
				{
					e.printStackTrace();
				}

				if (!contiene(caux))
					break;
			}
			throw new ExcepcionPosicionFueraTablero(caux, getDimensiones());
		}
		else // anchuraColeccion(posPatron) <= anchuraColeccion(posTablero)
		{
			if (this instanceof Tablero1D)
			{
				iterator = posPatron.iterator();
				while (iterator.hasNext())
				{
					caux = (TipoCoordenada) iterator.next();
					try
					{
						setCelda((TipoCoordenada) coordenadaInicial.suma(caux), patron.getCelda(caux));
					}
					catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e)
					{
						e.printStackTrace();
					}
				}
				control = true;
			}
			else if (alturaColeccion(posPatron) <= alturaColeccion(posTablero))
			{
				iterator = posPatron.iterator();
				while (iterator.hasNext())
				{
					caux = (TipoCoordenada) iterator.next();
					try
					{
						setCelda((TipoCoordenada) coordenadaInicial.suma(caux), patron.getCelda(caux));
					}
					catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e)
					{
						e.printStackTrace();
					}
				}
				control = true;
			}
		}

		return control;
	}

	/**
	 * Contiene.
	 *
	 * @param posicion la posicion
	 * @return true, if successful
	 */
	public boolean contiene(TipoCoordenada posicion)
	{
		if (posicion == null)
			throw new ExcepcionArgumentosIncorrectos();
		if (getPosiciones().contains(posicion))
			return true;
		else
			return false;
	}

	/**
	 * Altura coleccion.
	 *
	 * @param collection la coleccion
	 * @return la altura de la coleccion
	 */
	protected int alturaColeccion(Collection<TipoCoordenada> collection)
	{
		if (collection.isEmpty())
			return 0;
		if(this instanceof Tablero1D)
			return 1;
		int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;

		Iterator<TipoCoordenada> iterator = collection.iterator();
		while (iterator.hasNext())
		{
			Coordenada2D caux = (Coordenada2D) iterator.next();
			if (ymin > caux.getY())
				ymin = caux.getY();
			if (ymax < caux.getY())
				ymax = caux.getY();
		}

		return ymax - ymin + 1;
	}

	/**
	 * Anchura coleccion.
	 *
	 * @param collection la coleccion
	 * @return la anchura de la coleccion
	 */
	protected int anchuraColeccion(Collection<TipoCoordenada> collection)
	{
		if (collection.isEmpty())
			return 0;
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE;

		Iterator<TipoCoordenada> iterator = collection.iterator();
		while (iterator.hasNext())
		{
			if (this instanceof Tablero1D)
			{
				Coordenada1D caux = (Coordenada1D) iterator.next();
				if (xmin > caux.getX())
					xmin = caux.getX();
				if (xmax < caux.getX())
					xmax = caux.getX();
			}
			else
			{
				Coordenada2D caux = (Coordenada2D) iterator.next();
				if (xmin > caux.getX())
					xmin = caux.getX();
				if (xmax < caux.getX())
					xmax = caux.getX();
			}
		}

		return xmax - xmin + 1;
	}

	/**
	 * Recortar coleccion hasta que la TipoCoordenada sea la nueva esquina superior
	 * izquierda.
	 *
	 * @param col la coleccion
	 * @param c la TipoCoordenada
	 * @return la coleccion recortada
	 */
	private Collection<TipoCoordenada> recortarColeccion(Collection<TipoCoordenada> col, TipoCoordenada c)
	{
		ArrayList<TipoCoordenada> devuelto = new ArrayList<TipoCoordenada>();
		if (col.contains(c))
		{
			TipoCoordenada caux = null;

			devuelto.addAll(col);
			Iterator<TipoCoordenada> iterator = devuelto.iterator();
			while (iterator.hasNext())
			{
				caux = iterator.next();
				if (caux.equals(c))
					break;
				else
					iterator.remove();
			}
			if (this instanceof TableroCeldasCuadradas)
			{
				Coordenada2D caux2 = null;
				while (iterator.hasNext())
				{
					caux2 = (Coordenada2D) iterator.next();
					if (caux2.getX() < ((Coordenada2D) caux).getX())
						iterator.remove();
				}
			}
		}
		return devuelto;
	}
}
