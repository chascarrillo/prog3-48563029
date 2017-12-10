/**
 * Esta interfaz especifica los metodos a implementar por una clase que quiera considerarse IParserTablero...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

// TODO: Auto-generated Javadoc
/**
 * The Interface IParserTablero.
 */
public interface IParserTablero
{
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public Tablero leeTablero(String cadena)
	throws ExcepcionLectura;
}
