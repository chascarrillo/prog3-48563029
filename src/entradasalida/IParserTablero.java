/**
 * Esta interfaz especifica los metodos a implementar por una clase que quiera considerarse IParserTablero...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

/**
 * The Interface IParserTablero.
 */
public interface IParserTablero
{
	
	/**
	 * Lee tablero.
	 *
	 * @param tablero the tablero
	 * @return the tablero
	 * @throws ExcepcionLectura 
	 */
	public Tablero leeTablero(String cadena)
	throws ExcepcionLectura;
}
