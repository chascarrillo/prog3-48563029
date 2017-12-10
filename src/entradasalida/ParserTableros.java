/**
 * Esta clase coordina la instanciacion de tableros a partir de un String...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

// TODO: Auto-generated Javadoc
/**
 * The Class ParserTableros.
 */
public class ParserTableros
{
	
	/**
	 * Instantiates a new parser tableros.
	 */
	public ParserTableros()
	{}

	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	static public Tablero leeTablero(String cadena)
	throws ExcepcionLectura
	{
		if(cadena == null) throw new ExcepcionArgumentosIncorrectos();
		if(cadena.isEmpty()) throw new ExcepcionLectura("Se paso como argumento una cadena vacia");
		Tablero tablero = null;

		if(cadena.contains("\n"))
		{
			ParserTablero2D pt2d= new ParserTablero2D();
			tablero = pt2d.leeTablero(cadena);
		}
		else
		{
			ParserTablero1D pt1d = new ParserTablero1D();
			tablero = pt1d.leeTablero(cadena);
		}

		return tablero;
	}
}
