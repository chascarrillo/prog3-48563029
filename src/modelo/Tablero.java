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
	 */
	public Tablero(Coordenada dimensiones)
	{
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int y = 0; y < dimensiones.getY(); y++)
		{
			for(int x = 0; x < dimensiones.getX(); x++)
			{
				Coordenada aux = new Coordenada(x, y);
				celdas.put(aux, EstadoCelda.MUERTA);
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
		return new Coordenada(anchuraColeccion(getPosiciones()), alturaColeccion(getPosiciones()));
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return coleccion de coordenadas
	 */
	public Collection<Coordenada> getPosiciones()
	{
		Set<Coordenada> ts = new TreeSet <Coordenada>(ComparadorCoordenada.getComparator(ComparadorCoordenada.Y_SORT, ComparadorCoordenada.X_SORT));
		ts.addAll(celdas.keySet());
		return (Collection<Coordenada>) ts;
		/*ArrayList<Coordenada> al = new ArrayList<Coordenada>();
		al.addAll(celdas.keySet());
		Collections.sort(al, ComparadorCoordenada.getComparator(ComparadorCoordenada.Y_SORT, ComparadorCoordenada.X_SORT));
		
		TreeSet<Coordenada> devuelta = new TreeSet<Coordenada>()*/
	}

	/**
	 * Obtiene el estado de la celda
	 *
	 * @param posicion the posicion
	 * @return celda viva/muerta
	 */
	public EstadoCelda getCelda(Coordenada posicion)
	{
		muestraErrorPosicionInvalida(posicion);
		return celdas.get(posicion);
	}

	/**
	 * Sets the celda.
	 *
	 * @param posicion the posicion
	 * @param e el estado
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e)
	{
		if(contiene(posicion))
		{
			celdas.put(posicion, e);
		}
		else
		{
			muestraErrorPosicionInvalida(posicion);
		}
	}

	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return las coordenadas circundantes
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)
	{
		ArrayList<Coordenada> cds = null;
		if(contiene(posicion))
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
		return cds;
	}

	/**
	 * Muestra error posicion invalida.
	 *
	 * @param c la coordenada
	 */
	private void muestraErrorPosicionInvalida(Coordenada c)
	{
		if(!contiene(c))
		{
			System.err.println("Error: La celda " + c + " no existe");
		}
	}

	/**
	 * Carga patron.
	 *
	 * @param patron the patron
	 * @param coordenadaInicial the coordenada inicial
	 * @return true, if successful
	 */
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial)
	{
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
				setCelda(caux.suma(coordenadaInicial), patron.getCelda(caux));
			}
			control = true;
		}
		else
		{
			control = false;
			posPatron.removeAll(posTablero);
			iterator = posPatron.iterator();
			caux = (Coordenada) iterator.next();
			muestraErrorPosicionInvalida(caux);
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
		if (getPosiciones().contains(posicion))
		{
			return true;
		}
		else return false;
	}

	/**
	 * to String
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		String salida = "+";
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
		return salida;
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
	 * Recortar coleccion hasta que la coordenada sea la nueva esquina superior izquierda
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
