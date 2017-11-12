package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroCeldasCuadradas.
 */
public class TableroCeldasCuadradas
extends Tablero2D
{

	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param dimensiones the dimensiones
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public TableroCeldasCuadradas(Coordenada2D dimensiones)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(dimensiones.getX(), dimensiones.getY());
	}

	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public TableroCeldasCuadradas(int x, int y)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(x, y);
	}

	/**
	 * Devuelve las celdas contiguas a la posicion especificada
	 *
	 * @param posicion la celda a estudiar
	 * @return ArrayList<Coordenada> con las celdas vecinas
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
				int x = ((Coordenada2D) posicion).getX(), y = ((Coordenada2D) posicion).getY();
				Coordenada2D aux = null;
				int anchura = anchuraColeccion(getPosiciones()), altura = alturaColeccion(getPosiciones());
				cds = new ArrayList<Coordenada>();

				if(x > 0  &&  y > 0)
				{
					aux = new Coordenada2D(x-1, y-1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x > 0)
				{
					aux = new Coordenada2D(x-1, y);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x > 0  &&  y < altura-1)
				{
					aux = new Coordenada2D(x-1, y+1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(y < altura-1)
				{
					aux = new Coordenada2D(x, y+1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x < anchura-1  &&  y < altura-1)
				{
					aux = new Coordenada2D(x+1, y+1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x < anchura-1)
				{
					aux = new Coordenada2D(x+1, y);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(x < anchura-1  &&  y > 0)
				{
					aux = new Coordenada2D(x+1, y-1);
					if(contiene(aux))
					{
						cds.add(aux);
					}
				}
				if(y > 0)
				{
					aux = new Coordenada2D(x, y-1);
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
			salida = "+";
			int anchura = anchuraColeccion(getPosiciones());
	
			for (int abc = 0; abc < anchura; abc++)
			{
				salida += "-";
			}
			salida += "+\n|";
	
			Collection<Coordenada> cds = getPosiciones();
			Iterator<Coordenada> iterator = cds.iterator();
			Coordenada2D cauxa = (Coordenada2D) iterator.next(), cauxn = null;
			if(getCelda(cauxa) == EstadoCelda.MUERTA)
			{
				salida += " ";
			}
			else salida += "*";
	
			while(iterator.hasNext())
			{
				cauxn = (Coordenada2D) iterator.next();
	
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
}
