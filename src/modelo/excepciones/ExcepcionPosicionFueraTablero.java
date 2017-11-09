package modelo.excepciones;

import modelo.Coordenada;

public class ExcepcionPosicionFueraTablero
extends Exception
{
	private Coordenada dimensiones;
	private Coordenada coordenada;

	public ExcepcionPosicionFueraTablero(Coordenada coordenada, Coordenada dimensiones)
	{
		if(coordenada != null  &&  dimensiones != null)
		{
			this.dimensiones = dimensiones;
			this.coordenada = coordenada;
		}
		else throw new ExcepcionArgumentosIncorrectos();
	}

	public String getMessage()
	{
		return coordenada.toString() + "no entra en el tablero de dimensiones " + dimensiones.toString();
	}

	public Coordenada getDimensiones()
	{
		return dimensiones;
	}

	public Coordenada getCoordenada()
	{
		return coordenada;
	}
}
