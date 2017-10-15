/**
 * Esta clase especifica una coordenada...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

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
	 */
	public Coordenada(int x, int y)
	{
	  	 this.x = x;
		 this.y = y;
		 NUMERO_COORDENADAS++;
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
	 * Instantiates a new coordenada.
	 *
	 * @param otra the otra
	 */
	public Coordenada(Coordenada otra)
	{
		x = otra.x;
		y = otra.y;
		NUMERO_COORDENADAS++;
	}

	/**
	 * to String
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
	 * equals
	 *
	 * @param otro objeto con el que se compara el objeto implicito
	 * @return cierto, si los dos objetos son iguales
	 */
	@Override
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
	 */
	public Coordenada suma(Coordenada otra)
	{
		Coordenada nueva = new Coordenada(x+otra.x, y+otra.y);
		return nueva;
	}

	/**
	 * hashCode
	 *
	 * @return numero obtenido de aplicar la funcion al objeto implicito. 2 objetos que sean equals = true deben devolver el mismo hashcode
	 */
	@Override
	public int hashCode()
	{
		return new Integer(31*(31+x)+y);
	}
}
