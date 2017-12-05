/**
 * Esta interfaz especifica los metodos a implementar por una clase que quiera considerarse IGeneradorFichero...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

/**
 * The Interface IGeneradorFichero.
 */
public interface IGeneradorFichero
{
	
	/**
	 * Genera fichero.
	 *
	 * @param archivo the archivo
	 * @param juego the juego
	 * @param entero the entero
	 * @throws ExcepcionGeneracion
	 */
	public void generaFichero(File file, Juego juego, int iteraciones)
	throws ExcepcionGeneracion;
}
