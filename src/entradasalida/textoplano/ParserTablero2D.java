/**
 * Esta clase instancia el tablero correcto dependiendo del contenido de la cadena que se le proporciona...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class ParserTablero2D.
 */
public class ParserTablero2D
implements IParserTablero
{
	/**
	 * Instantiates a new parser tablero 2 D.
	 */
	public ParserTablero2D()
	{}

	/** {@inheritDoc}*/
	public Tablero leeTablero(String cadena)
	throws ExcepcionLectura
	{
		if(cadena == null) throw new ExcepcionArgumentosIncorrectos();
		if(cadena.isEmpty()) throw new ExcepcionLectura("Se paso como argumento una cadena vacia");

		int x = -1, y = -1, bucle;
		for(bucle = 0; bucle < cadena.length(); bucle++)
		{
			if(cadena.charAt(bucle) == '\n')
			{
				break;
			}
			x = bucle;
		}
		for(bucle = x; bucle < cadena.length(); bucle++)
		{
			
		}

		Tablero tablero = null;
		try
		{
			tablero = new TableroCeldasCuadradas(cadena.length());

			for(int i = 0; i < cadena.length(); i++)
			{
				if(cadena.charAt(i) != ' '  ||  cadena.charAt(i) != '*')
					throw new ExcepcionLectura("La cadena argumento contiene caracteres invalidos");

				if(cadena.charAt(i) == ' ')
					tablero.setCelda(new Coordenada2D(i), EstadoCelda.MUERTA);
				else
					tablero.setCelda(new Coordenada2D(i), EstadoCelda.VIVA);
			}
		}
		catch (ExcepcionCoordenadaIncorrecta e)
		{
			e.printStackTrace();
		}
		catch (ExcepcionPosicionFueraTablero e)
		{
			e.printStackTrace();
		}

		return tablero;
	}
}
