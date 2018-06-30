/**
 * Esta clase representa en un fichero de texto la evolucion de un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package entradasalida.txt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.nio.charset.StandardCharsets;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.d1.Tablero1D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class GeneradorFicheroPlano.
 */
public class GeneradorFicheroPlano
implements IGeneradorFichero
{
	
	/**
	 * Instantiates a new generador fichero plano.
	 */
	public GeneradorFicheroPlano()
	{}

	/** {@inheritDoc}*/
	public void generaFichero(File file, Juego juego, int iteraciones)
	throws ExcepcionGeneracion
	{
		if(file == null  ||  juego == null) throw new ExcepcionArgumentosIncorrectos();
		if(iteraciones <= 0) throw new ExcepcionGeneracion("el parametro iteraciones debe ser mayor que 0");
		if((juego.getTablero() instanceof Imprimible) == false) throw new ExcepcionGeneracion("tablero no imprimible");

		OutputStreamWriter osw = null;
		try
		{
			osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
			PrintWriter pw = new PrintWriter(osw, true);
			pw.flush();
			boolean es1D = false;

			if(juego.getTablero() instanceof Tablero1D)
				es1D = true;

			for(int i = 0; i < iteraciones; i++)
			{
				juego.actualiza();
				if(es1D)
					pw.println(((Tablero1D) juego.getTablero()).generaCadena());
				else
					pw.println(((TableroCeldasCuadradas) juego.getTablero()).generaCadena());
			}
			pw.close();
		}
		catch (FileNotFoundException e)
		{
			throw new ExcepcionGeneracion("El fichero no fue encontrado");
		}
	}
}
