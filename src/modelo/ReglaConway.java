/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ReglaConway
{
	public ReglaConway()
	{}

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
