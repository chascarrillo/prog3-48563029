/**
 * Esta clase no parece tener ninguna utilidad por el momento...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaConway.
 */
public class ReglaConway
extends Regla
{
	
	/**
	 * Instantiates a new regla conway.
	 */
	public ReglaConway()
	{}

	/**
	 * Decide si una celda debe vivir... o morir...
	 *
	 * @param tablero las celdas
	 * @param posicion la celda a estudiar
	 * @return EstadoCelda.VIVA si toca, de lo contrario EstadoCelda.MUERTA
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion)
	{
		if(tablero == null  ||  posicion == null) throw new ExcepcionArgumentosIncorrectos();
		int cuenta = 0;
		EstadoCelda estado = null;
		try
		{
			ArrayList<Coordenada> aux = tablero.getPosicionesVecinasCCW(posicion);
			Iterator<Coordenada> iterator = aux.iterator();
			while(iterator.hasNext())
			{
				Coordenada2D caux = (Coordenada2D) iterator.next();
				if (tablero.getCelda(caux) == EstadoCelda.VIVA)
				{
					cuenta++;
				}
			}
			if(tablero.getCelda(posicion) == EstadoCelda.VIVA)
			{
				if(cuenta == 2  || cuenta == 3)
				{
					return EstadoCelda.VIVA;
				}
				else return EstadoCelda.MUERTA;
			}
			else if (cuenta == 3)
				return EstadoCelda.VIVA;
			else return EstadoCelda.MUERTA;
		}
		catch (ExcepcionPosicionFueraTablero e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		return estado;
	}
}
