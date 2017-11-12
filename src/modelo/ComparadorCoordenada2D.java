/**
 * Este tipo enumerado es para ayudarme a ordenar las celdas segun sus coordenadas...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Enum ComparadorCoordenada.
 */
public enum ComparadorCoordenada2D
implements Comparator<Coordenada2D>
{
	
	/** The x sort. */
	X_SORT
	{
		public int compare(Coordenada2D c1, Coordenada2D c2)
		{
			return Integer.valueOf(c1.getX()).compareTo(c2.getX());
		}
	},
	
	/** The y sort. */
	Y_SORT
	{
		public int compare(Coordenada2D c1, Coordenada2D c2)
		{
			return Integer.valueOf(c1.getY()).compareTo(c2.getY());
		}
	};

	/**
	 * Descending.
	 *
	 * @param other the comparator
	 * @return the comparator en orden inverso
	 */
	public static Comparator<Coordenada2D> descending(final Comparator<Coordenada2D> other)
	{
		return new Comparator<Coordenada2D>()
		{
			public int compare(Coordenada2D o1, Coordenada2D o2)
			{
				return -1 * other.compare(o1, o2);
			}
		};
	}

	/**
	 * Gets the comparator.
	 *
	 * @param multipleOptions the multiple options
	 * @return the comparator
	 */
	public static Comparator<Coordenada2D> getComparator(final ComparadorCoordenada2D... multipleOptions)
	{
		return new Comparator<Coordenada2D>()
		{
			public int compare(Coordenada2D o1, Coordenada2D o2)
			{
				for (ComparadorCoordenada2D option : multipleOptions)
				{
					int result = option.compare(o1, o2);
					if (result != 0)
					{
						return result;
					}
				}
				return 0;
			}
		};
	}
}