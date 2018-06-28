/**
 * Esta clase especifica un tipo de tablero bidimensional...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.d2;

import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

/**
 * The Class Tablero2D.
 */
public abstract class Tablero2D
extends Tablero<Coordenada2D>
{
	/**
	 * Instantiates a new tablero 2 D.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @throws ExcepcionCoordenadaIncorrecta
	 *             the excepcion coordenada incorrecta
	 */
	public Tablero2D(int x, int y)
	throws ExcepcionCoordenadaIncorrecta
	{
		super(new Coordenada2D(x, y));

		for (int j = 0; j < y; j++)
		{
			for (int i = 0; i < x; i++)
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
