/**
 * Esta clase define un algoritmo para un juego de la vida de tablero unidimensional...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo.d1;

import java.util.ArrayList;

import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla30.
 */
public class Regla30
extends Regla<Coordenada1D>
{
	/**
	 * Decide si una celda debe vivir... o morir...
	 *
	 * @param tablero las celdas
	 * @param posicion la celda a estudiar
	 * @return EstadoCelda.VIVA si toca, de lo contrario EstadoCelda.MUERTA
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada1D> tablero, Coordenada1D posicion)
	throws ExcepcionPosicionFueraTablero
	{
		if (tablero == null || posicion == null)
			throw new ExcepcionArgumentosIncorrectos();
		EstadoCelda estado = null;

		ArrayList<Coordenada1D> aux = tablero.getPosicionesVecinasCCW(posicion);
		if (aux.size() == 1)
			estado = EstadoCelda.MUERTA;
		else if (tablero.getCelda(aux.get(0)) == EstadoCelda.VIVA && tablero.getCelda(aux.get(1)) == EstadoCelda.VIVA)
			estado = EstadoCelda.MUERTA;
		else if (tablero.getCelda(posicion) == EstadoCelda.VIVA && tablero.getCelda(aux.get(0)) == EstadoCelda.VIVA)
			estado = EstadoCelda.MUERTA;
		else if (tablero.getCelda(posicion) == EstadoCelda.MUERTA
				&& tablero.getCelda(aux.get(0)) == EstadoCelda.MUERTA
				&& tablero.getCelda(aux.get(1)) == EstadoCelda.MUERTA)
			estado = EstadoCelda.MUERTA;
		else
			estado = EstadoCelda.VIVA;

		return estado;
	}
}
