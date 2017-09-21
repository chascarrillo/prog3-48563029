/**
 * Esta clase especifica una coordenada...
 * 
 * @author Alfonso Aracil Andrés. 48563029
 */

package modelo;

public class Coordenada
{
	private static int NUMERO_COORDENADAS = 0;
	private int x;
	private int y;
	
	public Coordenada(int x, int y)
	{
	  	 this.x = x;
		 this.y = y;
		 NUMERO_COORDENADAS++;
	}
	
	public Coordenada(Coordenada otra)
	{
		x = otra.x;
		y = otra.y;
		NUMERO_COORDENADAS++;
	}
	
	/**
	 * Este método devuelve el num de corodenadas creado
	 * @return el número de coordenadas creado
	 */
	public static int getNumeroCoordenadas()
	{
		return NUMERO_COORDENADAS;
	}


	@Override
	public String toString()
	{
		return new String("("+this.x+","+this.y+")");
	}


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

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Coordenada suma(Coordenada otra)
	{
		Coordenada nueva = new Coordenada(x+otra.x, y+otra.y);
		return nueva;
	}
}
