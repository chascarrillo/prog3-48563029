/**
 * Esta clase se encargara de instanciar objetos...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;

public class Factory
{
	public Factory()
	{}

	public IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension)
	throws ExcepcionGeneracion
	{
		if(tablero == null) throw new ExcepcionArgumentosIncorrectos();
		if(extension.isEmpty()  ||  (!extension.contentEquals("txt")  &&  !extension.contentEquals("gif")))
			throw new ExcepcionGeneracion("El argumento extension no contenia un valor dentro del rango de valores validos (txt/gif)");
		if(!(tablero instanceof Tablero1D)  &&  !(tablero instanceof TableroCeldasCuadradas)) throw new ExcepcionEjecucion("Tablero de tipo incorrecto");

		IGeneradorFichero generador = null;

		if(extension.contentEquals("txt"))
		{
			GeneradorFicheroPlano gfp = new GeneradorFicheroPlano();
		}
		else // extension == "gif"
		{
			if(tablero instanceof Tablero1D)
			{
				
			}
			else // tablero instanceof TableroCeldasCuadradas
			{
				
			}
		}

		return generador;
	}
}
