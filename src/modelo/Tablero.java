/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.ComparadorCoordenada;
import modelo.Patron;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Tablero.
 */
public class Tablero
{
	
	/** The celdas. */
	private HashMap<Coordenada,EstadoCelda> celdas;

	/**
	 * Instantiates a new tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public Tablero(Coordenada dimensiones)
	{
		if(dimensiones == null) throw new ExcepcionArgumentosIncorrectos();
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int y = 0; y < dimensiones.getY(); y++)
		{
			for(int x = 0; x < dimensiones.getX(); x++)
			{
				try
				{
					Coordenada aux = new Coordenada(x, y);
					celdas.put(aux, EstadoCelda.MUERTA);
				}
				catch (ExcepcionCoordenadaIncorrecta e) 
				{
					throw new ExcepcionEjecucion(e);
				}
			}
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
			dimensiones = new Coordenada(anchuraColeccion(getPosiciones()), alturaColeccion(getPosiciones()));
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
	{
		Set<Coordenada> ts = new TreeSet <Coordenada>(
				ComparadorCoordenada.getComparator(ComparadorCoordenada.Y_SORT, ComparadorCoordenada.X_SORT)
				);
		ts.addAll(celdas.keySet());
		return (Collection<Coordenada>) ts;
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
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		ArrayList<Coordenada> cds = null;
		if(!contiene(posicion)) throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
		else
		{
			try
			{
				cds = new ArrayList<Coordenada>();
				Coordenada aux = new Coordenada(posicion.getX()-1, posicion.getY()-1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX()-1, posicion.getY());
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX()-1, posicion.getY()+1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX(), posicion.getY()+1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX()+1, posicion.getY()+1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX()+1, posicion.getY());
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX()+1, posicion.getY()-1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
				aux = new Coordenada(posicion.getX(), posicion.getY()-1);
				if(contiene(aux))
				{
					cds.add(aux);
				}
			}
			catch (ExcepcionCoordenadaIncorrecta e)
			{
				throw new ExcepcionEjecucion(e);
			}
		}
		return cds;
	}

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
		Coordenada caux = null;
		Iterator<Coordenada> iterator = null;
		boolean control;
		Collection<Coordenada> posPatron = patron.getPosiciones();
		Collection<Coordenada> posTablero = recortarColeccion(getPosiciones(), coordenadaInicial);

		if(anchuraColeccion(posPatron) <= anchuraColeccion(posTablero)  &&  alturaColeccion(posPatron) <= alturaColeccion(posTablero))
		{
			iterator = posPatron.iterator();
			while(iterator.hasNext())
			{
				caux = (Coordenada) iterator.next();
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
		else
		{
			control = false;
			posPatron.removeAll(posTablero);
			iterator = posPatron.iterator();
			caux = (Coordenada) iterator.next();
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
		if(posicion != null)
		{
			if (getPosiciones().contains(posicion))
			{
				return true;
			}
			else return false;
		}
		else throw new ExcepcionArgumentosIncorrectos();
	}

	/**
	 * to String.
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		String salida = "";
		try
		{
			salida = "+";
			int anchura = anchuraColeccion(getPosiciones());
	
			for (int abc = 0; abc < anchura; abc++)
			{
				salida += "-";
			}
			salida += "+\n|";
	
			Collection<Coordenada> cds = getPosiciones();
			Iterator<Coordenada> iterator = cds.iterator();
			Coordenada cauxa = (Coordenada) iterator.next(), cauxn = null;
			if(getCelda(cauxa) == EstadoCelda.MUERTA)
			{
				salida += " ";
			}
			else salida += "*";
	
			while(iterator.hasNext())
			{
				cauxn = (Coordenada) iterator.next();
	
				if(cauxa.getY() == cauxn.getY())
				{
					if(getCelda(cauxn) == EstadoCelda.MUERTA)
						salida += " ";
					else salida += "*";
					cauxa = cauxn;
					cauxn = null;
				}
				else if (iterator.hasNext())
				{
					if(getCelda(cauxn) == EstadoCelda.MUERTA)
						salida += "|\n| ";
					else salida += "|\n|*";
					cauxa = cauxn;
					cauxn = null;
				}
			}
	
			salida += "|\n+";
			for (int abc = 0; abc < anchura; abc++)
			{
				salida += "-";
			}
			salida += "+\n";
		}
		catch (Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			return salida;
		}
	}

	/**
	 * Altura coleccion.
	 *
	 * @param c la coleccion
	 * @return la altura de la coleccion
	 */
	private int alturaColeccion(Collection<Coordenada> c)
	{
		if (c.isEmpty())
			return 0;
		int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
		int devuelto = 1;
		Iterator<Coordenada> iterator = c.iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada) iterator.next();
			if (ymin > caux.getY())
			{
				ymin = caux.getY();
			}
			if (ymax < caux.getY())
			{
				ymax = caux.getY();
			}
		}
		// hago esto y no ymax - ymin + 1 para poder trabajar con ymax positivo e ymin negativo sin problemas
		while(ymin < ymax)
		{
			ymin++;
			devuelto++;
		}

		return devuelto;
	}

	/**
	 * Anchura coleccion.
	 *
	 * @param c la coleccion
	 * @return la anchura de la coleccion
	 */
	private int anchuraColeccion(Collection<Coordenada> c)
	{
		if (c.isEmpty())
			return 0;
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, devuelto = 1;
		Iterator<Coordenada> iterator = c.iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada) iterator.next();
			if (xmin > caux.getX())
			{
				xmin = caux.getX();
			}
			if (xmax < caux.getX())
			{
				xmax = caux.getX();
			}
		}
		// hago esto y no xmax - xmin + 1 para poder trabajar con xmax positivo y xmin negativo sin problemas
		while(xmin < xmax)
		{
			xmin++;
			devuelto++;
		}

		return devuelto;
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
				caux = (Coordenada) iterator.next();
				if (caux.equals(c))
				{
					break;
				}
				else iterator.remove();
			}

			Coordenada caux2 = null;
			while (iterator.hasNext())
			{
				caux2 = (Coordenada) iterator.next();
				if (caux2.getY() < caux.getY())
				{
					iterator.remove();
				}
			}
		}
		return devuelto;
	}
}
