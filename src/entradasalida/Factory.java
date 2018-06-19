/**
 * Esta clase se encargara de instanciar objetos...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

/**
 * The Class Factory.
 */
public class Factory
{
	
	/**
	 * Instantiates a new factory.
	 */
	public Factory()
	{}

	/**
	 * Crea generador fichero.
	 *
	 * @param tablero the tablero
	 * @param extension the extension
	 * @return the i generador fichero
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	static public IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension)
	throws ExcepcionGeneracion
	{
		if(tablero == null) throw new ExcepcionArgumentosIncorrectos();
		if(extension.isEmpty()  ||  (!extension.contentEquals("txt")  &&  !extension.contentEquals("gif")))
			throw new ExcepcionGeneracion("El argumento extension era incorrecto. Rango de valores validos = [ txt , gif ]");
		if(!(tablero instanceof Tablero1D)  &&  !(tablero instanceof TableroCeldasCuadradas)) throw new ExcepcionEjecucion("Tablero de tipo incorrecto");

		IGeneradorFichero generador = null;

		if(extension.contentEquals("txt"))
		{
			generador = new GeneradorFicheroPlano();
		}
		else // extension == "gif"
		{
			if(tablero instanceof Tablero1D)
			{
				generador = new GeneradorGIFTablero1D();
			}
			else // tablero instanceof Tablero2D
			{
				generador = new GeneradorGifAnimadoTablero2D();
			}
		}

		return generador;
	}

	/**
	 * Crea regla.
	 *
	 * @param tablero the tablero
	 * @return the regla
	 */
	static public Regla creaRegla(Tablero tablero)
	{
		if(tablero == null) throw new ExcepcionArgumentosIncorrectos();

		if(tablero instanceof Tablero1D)
			return new Regla30();
		else if(tablero instanceof TableroCeldasCuadradas)
			return new ReglaConway();
		else
			throw new ExcepcionEjecucion("Tablero de tipo incorrecto");
	}

	/**
	 * Crea tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @return the tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	static public Tablero creaTablero(Coordenada dimensiones)
	throws ExcepcionCoordenadaIncorrecta
	{
		if(dimensiones == null) throw new ExcepcionArgumentosIncorrectos();

		if(dimensiones instanceof Coordenada1D)
		{
			return new Tablero1D(((Coordenada1D) dimensiones).getX());
		}
		else if(dimensiones instanceof Coordenada2D)
		{
			return new TableroCeldasCuadradas(((Coordenada2D) dimensiones).getX(), ((Coordenada2D) dimensiones).getY());
		}
		else
			throw new ExcepcionEjecucion("Argumento Coordenada dimensiones era de tipo incorrecto");
	}
}
