package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero1D.
 */
public class Tablero1D
extends Tablero
{
	
	/**
	 * Instantiates a new tablero 1 D.
	 *
	 * @param dimensiones the dimensiones
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero1D(Coordenada1D dimensiones)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(new Coordenada1D(dimensiones.getX()));
		if(dimensiones == null) throw new ExcepcionArgumentosIncorrectos();
		celdas = new HashMap<Coordenada,EstadoCelda>();

		for(int x = 0; x < dimensiones.getX(); x++)
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

	/* (non-Javadoc)
	 * @see modelo.Tablero#getPosicionesVecinasCCW(modelo.Coordenada)
	 */
	@Override
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
				int x = ((Coordenada1D) posicion).getX();
				Coordenada1D aux = null;
				int anchura = anchuraColeccion(getPosiciones());
				cds = new ArrayList<Coordenada>();

				if(x > 0)
				{
					aux = new Coordenada1D(x-1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x < anchura-1)
				{
					aux = new Coordenada1D(x+1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
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
			int anchura = anchuraColeccion(getPosiciones());
	
			Collection<Coordenada> cds = getPosiciones();
			Iterator<Coordenada> iterator = cds.iterator();
			Coordenada1D caux = null;
			while(iterator.hasNext())
			{
				caux = (Coordenada1D) iterator.next();
				if(getCelda(caux) == EstadoCelda.MUERTA)
				{
					salida += " ";
				}
				else salida += "*";
			}
	
			salida += "|\n";
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
}
