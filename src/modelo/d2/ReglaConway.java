/**
 * Esta clase define un algoritmo para un juego de la vida de tablero de celdas cuadradas...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.d2;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class ReglaConway.
 */
public class ReglaConway
extends Regla<Coordenada2D>
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
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada2D> tablero, Coordenada2D posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if (tablero == null || posicion == null) throw new ExcepcionArgumentosIncorrectos();

		int cuenta = 0;
		EstadoCelda estado = null;

		ArrayList<Coordenada2D> aux = tablero.getPosicionesVecinasCCW(posicion);
		Iterator<Coordenada2D> iterator = aux.iterator();
		while (iterator.hasNext())
		{
			Coordenada2D caux = iterator.next();
			if (tablero.getCelda(caux) == EstadoCelda.VIVA)
				cuenta++;
		}
		if (tablero.getCelda(posicion) == EstadoCelda.VIVA)
		{
			if (cuenta == 2 || cuenta == 3)
				estado = EstadoCelda.VIVA;
			else
				estado = EstadoCelda.MUERTA;
		}
		else if (cuenta == 3)
			estado = EstadoCelda.VIVA;
		else
			estado = EstadoCelda.MUERTA;

		return estado;
	}
}
