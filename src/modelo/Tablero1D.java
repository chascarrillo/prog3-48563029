/**
 * Esta clase especifica un tipo de tablero unidimensional...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Tablero1D.
 */
public class Tablero1D
extends Tablero
implements Imprimible
{
	/**
	 * Instantiates a new tablero 1 D.
	 *
	 * @param dimension the dimensiones
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero1D(int dimension)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(new Coordenada1D(dimension));

		for (int x = 0; x < dimension; x++)
		{
			try
			{
				Coordenada1D aux = new Coordenada1D(x);
				celdas.put(aux, EstadoCelda.MUERTA);
			}
			catch (ExcepcionCoordenadaIncorrecta e)
			{
				throw new ExcepcionEjecucion(e);
			}
		}
	}

	/**
	 * Devuelve las celdas contiguas a la posicion especificada.
	 *
	 * @param posicion            la celda a estudiar
	 * @return ArrayList<Coordenada> con las celdas vecinas
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if (posicion == null) throw new ExcepcionArgumentosIncorrectos();

		ArrayList<Coordenada> cds = null;
		if (!contiene(posicion))
			throw new ExcepcionPosicionFueraTablero(posicion, getDimensiones());
		else
		{
			try
			{
				int x = ((Coordenada1D) posicion).getX();
				Coordenada1D aux = null;
				int anchura = anchuraColeccion(getPosiciones());
				cds = new ArrayList<Coordenada>();

				if (x > 0)
				{
					aux = new Coordenada1D(x - 1);
					if (contiene(aux))
						cds.add(aux);
				}
				if (x < anchura - 1)
				{
					aux = new Coordenada1D(x + 1);
					if (contiene(aux))
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
			salida = "|";
			Collection<Coordenada> cds = getPosiciones();
			Iterator<Coordenada> iterator = cds.iterator();
			Coordenada1D caux = null;
			while (iterator.hasNext())
			{
				caux = (Coordenada1D) iterator.next();
				if (getCelda(caux) == EstadoCelda.MUERTA)
					salida += " ";
				else
					salida += "*";
			}

			salida += "|\n";
			return salida;
		}
		catch (Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		return salida;
	}

	/** {@inheritDoc}*/
	public String generaCadena()
	{
		return toString();
	}
}
