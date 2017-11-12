/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.ComparadorCoordenada1D;
import modelo.ComparadorCoordenada2D;
import modelo.Patron;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero.
 */
public abstract class Tablero
{
	
	/** The celdas. */
	protected HashMap<Coordenada,EstadoCelda> celdas;

	/** The dimensiones. */
	protected Coordenada dimensiones;

	/**
	 * Instantiates a new tablero.
	 *
	 * @param dimensiones the dimensiones
	 */
	protected Tablero(Coordenada dimensiones)
	{
		if(dimensiones == null) throw new ExcepcionArgumentosIncorrectos();
		this.dimensiones = dimensiones;
		celdas = new HashMap<Coordenada,EstadoCelda>();
	}

	/**
	 * Checks if is tablero 1 D.
	 *
	 * @return true, if is tablero 1 D
	 */
	private boolean isTablero1D()
	{
		boolean control = false;
		try
		{
			Tablero1D t1d = new Tablero1D (new Coordenada1D(0));
			if (getClass() == t1d.getClass())
				control = true;
		}
		catch (ExcepcionCoordenadaIncorrecta e)
		{
			e.printStackTrace();
		}
		finally
		{
			return control;
		}
	}

	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones()
	{
		Coordenada dimensiones = null;
		try
		{
			if (!isTablero1D())
				dimensiones = new Coordenada2D(anchuraColeccion(getPosiciones()), alturaColeccion(getPosiciones()));
			else
				dimensiones = new Coordenada1D(anchuraColeccion(getPosiciones()));
		}
		catch (ExcepcionCoordenadaIncorrecta e)
		{
			e.printStackTrace();
		}
		finally
		{
			return dimensiones;
		}
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return coleccion de coordenadas
	 */
	public Collection<Coordenada> getPosiciones()
	{/*
		Set<Coordenada2D> ts = new TreeSet <Coordenada2D>(
				ComparadorCoordenada.getComparator(ComparadorCoordenada.Y_SORT, ComparadorCoordenada.X_SORT)
				);
		ts.addAll(celdas.keySet());
		return (Collection<Coordenada2D>) ts;*/
		Collection<Coordenada> devuelta = null;
		if (!isTablero1D())
		{
			Set<Coordenada2D> ts = new TreeSet <Coordenada2D>(
					ComparadorCoordenada2D.getComparator(ComparadorCoordenada2D.Y_SORT, ComparadorCoordenada2D.X_SORT)
					);

			Iterator<Coordenada> it = celdas.keySet().iterator();
			while(it.hasNext())
			{
				ts.add((Coordenada2D) it.next());
			}
			Iterator<Coordenada2D> it2 = ts.iterator();
			devuelta = new ArrayList<Coordenada>();
			while(it2.hasNext())
			{
				Coordenada caux = it2.next();
				devuelta.add(caux);
			}
		}
		else
		{
			Set<Coordenada1D> ts = new TreeSet <Coordenada1D>(
					ComparadorCoordenada1D.getComparator(ComparadorCoordenada1D.X_SORT)
					);

			Iterator<Coordenada> it = celdas.keySet().iterator();
			while(it.hasNext())
			{
				ts.add((Coordenada1D) it.next());
			}
			Iterator<Coordenada1D> it2 = ts.iterator();
			devuelta = new TreeSet<Coordenada>();
			while(it2.hasNext())
			{
				devuelta.add((Coordenada) it2.next());
			}
		}

		return devuelta;
	}

	/**
	 * Obtiene el estado de la celda.
	 *
	 * @param posicion the posicion
	 * @return celda viva/muerta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		
		if(contiene(posicion))
		{
			return celdas.get(posicion);
		}
		else throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
	}

	/**
	 * Sets the celda.
	 *
	 * @param posicion the posicion
	 * @param e el estado
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e)
	throws ExcepcionPosicionFueraTablero
	{
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		if(!contiene(posicion)) throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
		else
		{
			celdas.put(posicion, e);
		}
	}

	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return las coordenadas circundantes
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)
	throws ExcepcionPosicionFueraTablero;

	/**
	 * Carga patron.
	 *
	 * @param patron the patron
	 * @param coordenadaInicial the coordenada inicial
	 * @return true, if successful
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial)
	throws ExcepcionPosicionFueraTablero
	{
		if(patron == null  ||  coordenadaInicial == null) throw new ExcepcionArgumentosIncorrectos();
		boolean d1 = isTablero1D();
		Iterator<Coordenada> iterator = null;
		Coordenada caux = null;
		boolean control = false;
		Collection<Coordenada> posPatron = patron.getPosiciones();
		Collection<Coordenada> posTablero = recortarColeccion(getPosiciones(), coordenadaInicial);

		if(anchuraColeccion(posPatron) <= anchuraColeccion(posTablero))
		{
			if(d1)
			{
				iterator = posPatron.iterator();
				while(iterator.hasNext())
				{
					caux = (Coordenada1D) iterator.next();
					try
					{
						setCelda(caux.suma(coordenadaInicial), patron.getCelda(caux));
					}
					catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero e)
					{
						e.printStackTrace();
					}
					catch (ExcepcionCoordenadaIncorrecta e)
					{
						throw new ExcepcionEjecucion(e);
					}
				}
				control = true;
			}
			else if(alturaColeccion(posPatron) <= alturaColeccion(posTablero))
			{
				iterator = posPatron.iterator();
				while(iterator.hasNext())
				{
					caux = (Coordenada2D) iterator.next();
					try
					{
						setCelda(caux.suma(coordenadaInicial), patron.getCelda(caux));
					}
					catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero e)
					{
						e.printStackTrace();
					}
					catch (ExcepcionCoordenadaIncorrecta e)
					{
						throw new ExcepcionEjecucion(e);
					}
				}
				control = true;
				
			}
		}
		else
		{
			control = false;
			posPatron.removeAll(posTablero);
			iterator = posPatron.iterator();
			caux = (Coordenada2D) iterator.next();
			throw new ExcepcionPosicionFueraTablero(caux, getDimensiones());
		}

		return control;
	}

	/**
	 * Contiene.
	 *
	 * @param posicion la posicion
	 * @return true, if successful
	 */
	public boolean contiene(Coordenada posicion)
	{
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		if (getPosiciones().contains(posicion))
		{
			return true;
		}
		else return false;
	}

	/**
	 * Altura coleccion.
	 *
	 * @param collection la coleccion
	 * @return la altura de la coleccion
	 */
	protected int alturaColeccion(Collection<Coordenada> collection)
	{
		if (collection.isEmpty())
			return 0;
		int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
		Iterator<Coordenada> iterator = collection.iterator();
		while(iterator.hasNext())
		{
			Coordenada2D caux = (Coordenada2D) iterator.next();
			if (ymin > caux.getY())
			{
				ymin = caux.getY();
			}
			if (ymax < caux.getY())
			{
				ymax = caux.getY();
			}
		}

		return ymax - ymin + 1;
	}

	/**
	 * Anchura coleccion.
	 *
	 * @param collection la coleccion
	 * @return la anchura de la coleccion
	 */
	protected int anchuraColeccion(Collection<Coordenada> collection)
	{
		if (collection.isEmpty())
			return 0;
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE;
		Iterator<Coordenada> iterator = collection.iterator();
		while(iterator.hasNext())
		{
			Coordenada2D caux = (Coordenada2D) iterator.next();
			if (xmin > caux.getX())
			{
				xmin = caux.getX();
			}
			if (xmax < caux.getX())
			{
				xmax = caux.getX();
			}
		}

		return xmax - xmin + 1;
	}

	/**
	 * Recortar coleccion hasta que la coordenada sea la nueva esquina superior izquierda.
	 *
	 * @param col la coleccion
	 * @param c la coordenada
	 * @return la coleccion recortada
	 */
	private Collection<Coordenada> recortarColeccion(Collection<Coordenada> col, Coordenada c)
	{
		HashSet<Coordenada> devuelto = new HashSet<Coordenada>();
		if(col.contains(c))
		{
			Coordenada caux = null;

			devuelto.addAll(col);
			Iterator<Coordenada> iterator = devuelto.iterator();
			while(iterator.hasNext())
			{
				caux = iterator.next();
				if (caux.equals(c))
				{
					break;
				}
				else iterator.remove();
			}
			if(!isTablero1D())
			{
				Coordenada2D caux2 = null;
				while (iterator.hasNext())
				{
					caux2 = (Coordenada2D) iterator.next();
					if (caux2.getY() < ((Coordenada2D) caux).getY())
					{
						iterator.remove();
					}
				}
			}
		}
		return devuelto;
	}
}
