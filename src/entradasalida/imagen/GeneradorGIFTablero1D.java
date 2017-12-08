package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class GeneradorGIFTablero1D
implements IGeneradorFichero
{
	/** {@inheritDoc}*/
	public void generaFichero(File file, Juego juego, int iteraciones)
	throws ExcepcionGeneracion
	{
		if(file == null  ||  juego == null) throw new ExcepcionArgumentosIncorrectos();
		if(iteraciones <= 0) throw new ExcepcionGeneracion("Se paso como argumentos un numero incorrecto de iteraciones");

		int ancho = ((Coordenada1D) juego.getTablero().getDimensiones()).getX();

		ImagenGIF imagen = new ImagenGIF(ancho, iteraciones);
		for(int y = 0; y < iteraciones; y++)
		{
			for(int x = 0; x < ancho; x++)
			{
				try
				{
					if(juego.getTablero().getCelda(new Coordenada1D(x)) == EstadoCelda.VIVA)
						imagen.pintaCuadrado(x, y);
				}
				catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e)
				{
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}
}
