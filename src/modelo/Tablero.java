/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Coordenada;
import modelo.EstadoCelda;

public class Tablero
{
	private HashMap<Coordenada,EstadoCelda> celdas;

	public Tablero(Coordenada dimensiones)
	{
		for(int x = 0; x <= Math.abs(dimensiones.getX()); x++)
		{
			for(int y = 0; y <= Math.abs(dimensiones.getY()); y++)
			{
				celdas.put(new Coordenada(x, y), EstadoCelda.MUERTA);
			}
		}
	}

	public Collection<Coordenada> getPosiciones()
	{
		return (Collection<Coordenada>)celdas.keySet();
	}

	public EstadoCelda getCelda(Coordenada posicion)
	{
		muestraErrorPosicionInvalida(posicion);
		return celdas.get(posicion);
	}

	private void muestraErrorPosicionInvalida(Coordenada c)
	{
		if(celdas.get(c) == null)
		{
			System.err.println("Error: La celda " + c + " no existe");
		}
	}

	public void setCelda(Coordenada posicion, EstadoCelda e)
	{
		int x = 0, y = 0;
		Iterator<Coordenada> iterator = getPosiciones().iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			if (x < Math.abs(caux.getX()))
			{
				x = Math.abs(caux.getX());
			}
			if (y < Math.abs(caux.getY()))
			{
				y = Math.abs(caux.getX());
			}
		}
		if (Math.abs(posicion.getX()) > x  ||  Math.abs(posicion.getY()) > y)
		{
			muestraErrorPosicionInvalida(posicion);
		}
		else
		{
			celdas.put(posicion, e);
		}
	}
}
