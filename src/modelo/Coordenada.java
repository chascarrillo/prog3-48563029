/**
 * Esta clase abstracta especifica una coordenada...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class Coordenada.
 */
public abstract class Coordenada
{
	/**
	 * Instantiates a new coordenada.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada()
	throws ExcepcionCoordenadaIncorrecta
	{ };

	/**
	 * Suma.
	 *
	 * @param c the c
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	abstract public Coordenada suma(Coordenada c)
	throws ExcepcionCoordenadaIncorrecta;
}
