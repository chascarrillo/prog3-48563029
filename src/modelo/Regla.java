/**
 * Esta clase define un esquema para algoritmos de juegos de la vida...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla.
 */
public abstract class Regla
{
	/**
	 * Instantiates a new regla.
	 */
	public Regla()
	{}

	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tab the tab
	 * @param c the c
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada c)
	throws ExcepcionPosicionFueraTablero;
}
