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

		int anchura, altura;

		String[] lineas = cadena.split("\n");
		altura = lineas.length;
		anchura = lineas[0].length();

		for(int aux = 0; aux < altura; aux++)
			if(lineas[aux].length() != anchura)
				throw new ExcepcionLectura("La cadena argumento contiene lineas de distintas anchuras");

		Tablero tablero = null;
		try
		{
			tablero = new TableroCeldasCuadradas(anchura, altura);

			for(int j = 0; j < altura; j++)
			{
				for(int i = 0; i < anchura; i++)
				{
					if(lineas[j].charAt(i) != ' '  &&  lineas[j].charAt(i) != '*')
						throw new ExcepcionLectura("La cadena argumento contiene caracteres invalidos");
					if(lineas[j].charAt(i) == ' ')
						tablero.setCelda(new Coordenada2D(i, j), EstadoCelda.MUERTA);
					if(lineas[j].charAt(i) == '*')
						tablero.setCelda(new Coordenada2D(i, j), EstadoCelda.VIVA);
				}
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
