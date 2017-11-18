/**
 * Este tipo enumerado es para ayudarme a ordenar las celdas segun sus coordenadas...
 * 
 * @author Alfonso Aracil Andres. 48563029R
 */

package modelo;

import java.util.Comparator;

/**
 * The Enum ComparadorCoordenada.
 */
public enum ComparadorCoordenada
implements Comparator<Coordenada>
{
	/** The x sort. */
	X_SORT
	{
		public int compare(Coordenada c1, Coordenada c2)
		{
			if (c1 instanceof Coordenada1D)
				return Integer.valueOf(((Coordenada1D) c1).getX()).compareTo(((Coordenada1D) c2).getX());
			else
				return Integer.valueOf(((Coordenada2D) c1).getX()).compareTo(((Coordenada2D) c2).getX());
		}
	},

	/** The y sort. */
	Y_SORT
	{
		public int compare(Coordenada c1, Coordenada c2)
		{
			return Integer.valueOf(((Coordenada2D) c1).getY()).compareTo(((Coordenada2D) c2).getY());
		}
	};

	/**
	 * Gets the comparator.
	 *
	 * @param multipleOptions the multiple options
	 * @return the comparator
	 */
	public static Comparator<Coordenada> getComparator(final ComparadorCoordenada... multipleOptions)
	{
		return new Comparator<Coordenada>()
		{
			public int compare(Coordenada o1, Coordenada o2)
			{
				for (ComparadorCoordenada option : multipleOptions)
				{
					int result = option.compare(o1, o2);
					if (result != 0)
						return result;
				}
				return 0;
			}
		};
	}
}