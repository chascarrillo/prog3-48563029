/**
 * Esta clase especifica una coordenada...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class Coordenada.
 */
public class Coordenada
{
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The numero coordenadas. */
	private static int NUMERO_COORDENADAS = 0;
	
	/**
	 * Instantiates a new coordenada.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada(int x, int y)
	throws ExcepcionCoordenadaIncorrecta
	{	
		if(x >= 0  &&  y >= 0)
		{
		  	 this.x = x;
			 this.y = y;
		}
		else throw new ExcepcionCoordenadaIncorrecta(x, y);
	}
	
	/**
	 * Instantiates a new coordenada.
	 *
	 * @param otra the otra
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada(Coordenada otra)
	throws ExcepcionArgumentosIncorrectos
	{
		if(otra != null)
		{
			x = otra.x;
			y = otra.y;
		}
		else throw new ExcepcionArgumentosIncorrectos();
	}
	
	/**
	 * Este metodo devuelve el num de corodenadas creado.
	 *
	 * @return el nemero de coordenadas creado
	 */
	public static int getNumeroCoordenadas()
	{
		return NUMERO_COORDENADAS;
	}

	/**
	 * to String.
	 *
	 * @return string con un cierto formato
	 */
	@Override
	public String toString()
	{
		return new String("("+this.x+","+this.y+")");
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY()
	{
		return y;
	}


	/**
	 * equals.
	 *
	 * @param otro objeto con el que se compara el objeto implicito
	 * @return cierto, si los dos objetos son iguales
	 */
	public boolean equals(Object otro)
	{
		if (this == otro)
	        return true;
	    if (otro == null)
	        return false;
	    if (getClass() != otro.getClass())
	        return false;
	    Coordenada caux = (Coordenada)otro;
	    if (Integer.valueOf(x) != Integer.valueOf(caux.x))
	        return false;
	    if (Integer.valueOf(y) != Integer.valueOf(caux.y))
	        return false;
	    return true;
	}

	/**
	 * Suma.
	 *
	 * @param otra the otra
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada suma(Coordenada otra)
	throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos
	{
		if(otra != null)
		{
			Coordenada nueva = new Coordenada(x+otra.x, y+otra.y);
			return nueva;
		}
		else throw new ExcepcionArgumentosIncorrectos();
	}

	/**
	 * hashCode.
	 *
	 * @return numero obtenido de aplicar la funcion al objeto implicito. 2 objetos que sean equals = true deben devolver el mismo hashcode
	 */
	@Override
	public int hashCode()
	{
		return new Integer(31*(31+x)+y);
	}/*

	private boolean menorQue(Coordenada c2)
	{
		if(this.y > c2.y)
		{
			return false;
		}
		else if(this.y == c2.y)
		{
			if(this.x < c2.x)
			{
				return true;
			}
			else return false;
		}
		else return true;
	}*/
}
