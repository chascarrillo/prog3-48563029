/**
 * Esta clase no parece tener ninguna utilidad por el momento...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
		int cuenta = 0;
		ArrayList<Coordenada> aux = tablero.getPosicionesVecinasCCW(posicion);
		Iterator<Coordenada> iterator = aux.iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
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
		else if (cuenta == 2)
			return EstadoCelda.VIVA;
		else return EstadoCelda.MUERTA;
	}
}
