package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Regla30.
 */
public class Regla30
extends Regla
{

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
		EstadoCelda estado = null;
		try
		{
			ArrayList<Coordenada> aux = tablero.getPosicionesVecinasCCW(posicion);
			if (aux.size() == 1)
			{
				estado = EstadoCelda.MUERTA;
			}
			else if(tablero.getCelda(aux.get(0)) == EstadoCelda.VIVA  &&  tablero.getCelda(aux.get(1)) == EstadoCelda.VIVA)
			{
				estado = EstadoCelda.MUERTA;
			}
			else if(tablero.getCelda(posicion) == EstadoCelda.VIVA  &&  tablero.getCelda(aux.get(0)) == EstadoCelda.VIVA)
			{
				estado = EstadoCelda.MUERTA;
			}
			else if(tablero.getCelda(posicion) == EstadoCelda.MUERTA  &&  tablero.getCelda(aux.get(0)) == EstadoCelda.MUERTA
					&&  tablero.getCelda(aux.get(1)) == EstadoCelda.MUERTA)
			{
				estado = EstadoCelda.MUERTA;
			}
			else estado = EstadoCelda.VIVA;
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
