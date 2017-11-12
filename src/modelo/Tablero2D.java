package modelo;

import java.util.HashMap;

import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero2D.
 */
public abstract class Tablero2D
extends Tablero
{
	
	/**
	 * Instantiates a new tablero 2 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero2D(int x, int y)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(new Coordenada2D(x, y));

		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int j = 0; j < y; j++)
		{
			for(int i = 0; i < x; i++)
			{
				try
				{
					Coordenada2D aux = new Coordenada2D(i, j);
					celdas.put(aux, EstadoCelda.MUERTA);
				}
				catch (ExcepcionCoordenadaIncorrecta e) 
				{
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}

}
