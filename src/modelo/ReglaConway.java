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

/**
 * The Class ReglaConway.
 */
public class ReglaConway
{
	
	/**
	 * Instantiates a new regla conway.
	 */
	public ReglaConway()
	{}

	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 */
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
				Coordenada caux = iterator.next();
				if (tablero.getCelda(caux) == EstadoCelda.VIVA)
				{
					cuenta++;
				}
			}
			if(tablero.getCelda(posicion) == EstadoCelda.VIVA)
			{
				if(cuenta == 2  || cuenta == 3)
				{
					estado = EstadoCelda.VIVA;
				}
				else estado = EstadoCelda.MUERTA;
			}
			else if (cuenta == 2)
				estado = EstadoCelda.VIVA;
			else estado = EstadoCelda.MUERTA;
		}
		catch (ExcepcionPosicionFueraTablero e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			return estado;
		}
	}
}
