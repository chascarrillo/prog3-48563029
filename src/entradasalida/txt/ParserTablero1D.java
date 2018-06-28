/**
 * Esta clase instancia el tablero correcto dependiendo del contenido de la cadena que se le proporciona...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida.txt;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class ParserTablero1D.
 */
public class ParserTablero1D
implements IParserTablero
{
	/**
	 * Instantiates a new parser tablero 1 D.
	 */
	public ParserTablero1D()
	{}

	/** {@inheritDoc}*/
	public Tablero leeTablero(String cadena)
	throws ExcepcionLectura
	{
		if(cadena == null) throw new ExcepcionArgumentosIncorrectos();
		if(cadena.isEmpty()) throw new ExcepcionLectura("Se paso como argumento una cadena vacia");

		Tablero tablero = null;
		try
		{
			tablero = new Tablero1D(cadena.length());

			for(int i = 0; i < cadena.length(); i++)
			{
				if(cadena.charAt(i) != ' '  &&  cadena.charAt(i) != '*')
					throw new ExcepcionLectura("La cadena argumento contiene caracteres invalidos");

				if(cadena.charAt(i) == ' ')
						tablero.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
				else
					tablero.setCelda(new Coordenada1D(i), EstadoCelda.VIVA);
			}
		}
		catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e)
		{
			throw new ExcepcionEjecucion(e);
		}

		return tablero;
	}
}
