/**
 * Esta clase genera un gif que representa graficamente la evolucion de un tablero de juego bidimensional...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class GeneradorGifAnimadoTablero2D.
 */
public class GeneradorGifAnimadoTablero2D
implements IGeneradorFichero
{
	
	/**
	 * Instantiates a new generador gif animado tablero 2 D.
	 */
	public GeneradorGifAnimadoTablero2D()
	{}

	/** {@inheritDoc}*/
	public void generaFichero(File file, Juego juego, int iteraciones)
	throws ExcepcionGeneracion
	{
		if(file == null  ||  juego == null) throw new ExcepcionArgumentosIncorrectos();
		if(iteraciones <= 0) throw new ExcepcionGeneracion("Se paso como argumentos un numero incorrecto de iteraciones");
		if(  !(juego.getTablero() instanceof TableroCeldasCuadradas)  ) throw new ExcepcionGeneracion("El tablero de juego no es cuadrado");

		int ancho = ((Coordenada2D) juego.getTablero().getDimensiones()).getX();
		int alto = ((Coordenada2D) juego.getTablero().getDimensiones()).getY();
		ImagenGIFAnimado gif = new ImagenGIFAnimado(100);

		for(int i = 0; i < iteraciones; i++)
		{
			ImagenGIF fotograma = new ImagenGIF(ancho, alto);
			for(int y = 0; y < alto; y++)
			{
				for(int x = 0; x < ancho; x++)
				{
					try
					{
						if(juego.getTablero().getCelda(new Coordenada2D(x, y)) == EstadoCelda.VIVA)
							fotograma.pintaCuadrado(x, y);
					}
					catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e)
					{
						throw new ExcepcionEjecucion(e);
					}
				}
			}
			gif.addFotograma(fotograma);
			juego.actualiza();
		}
		gif.guardaFichero(file);
	}
}
