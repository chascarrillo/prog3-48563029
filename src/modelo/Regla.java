package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Regla.
 */
public abstract class Regla
{
	
	/**
	 * Instantiates a new regla.
	 */
	public Regla() {}

	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tab the tab
	 * @param c the c
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada c) throws ExcepcionPosicionFueraTablero;
}
