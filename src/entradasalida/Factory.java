/**
 * Esta clase se encargara de instanciar objetos...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada1D;
import entradasalida.gif.GeneradorTableroCoordenada2D;
import entradasalida.txt.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.Tablero2D;
import modelo.d2.TableroCeldasCuadradas;
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
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension)
	throws ExcepcionGeneracion
	{
		if(tablero == null  ||  extension == null) throw new ExcepcionArgumentosIncorrectos();
		if(extension.isEmpty()  ||  (!extension.contentEquals("txt")  &&  !extension.contentEquals("gif")))
			throw new ExcepcionGeneracion("El argumento extension no contenia un valor dentro del rango de valores validos (txt/gif)");
		if(!(tablero instanceof Tablero1D)  &&  !(tablero instanceof Tablero2D))
			throw new ExcepcionEjecucion("Tablero de tipo incorrecto");

		IGeneradorFichero generador = null;

		try
		{
			generador = (IGeneradorFichero) Class.forName("entradasalida."+ extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName()).newInstance();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			throw new ExcepcionGeneracion(e);
		}
		catch (ClassNotFoundException e)
		{
			throw new ExcepcionGeneracion("entradasalida."+ extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName());
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
		else if(tablero instanceof Tablero2D)
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
