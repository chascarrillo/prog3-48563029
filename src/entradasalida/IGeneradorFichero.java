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
	 * @param file the file
	 * @param juego the juego
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public void generaFichero(File file, Juego juego, int iteraciones)
	throws ExcepcionGeneracion;
}
