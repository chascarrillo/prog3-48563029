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
public enum ComparadorCoordenada1D
implements Comparator<Coordenada1D>
{
	
	/** The x sort. */
	X_SORT
	{
		public int compare(Coordenada1D c1, Coordenada1D c2)
		{
			return Integer.valueOf(c1.getX()).compareTo(c2.getX());
		}
	};


	/**
	 * Gets the comparator.
	 *
	 * @param multipleOptions the multiple options
	 * @return the comparator
	 */
	public static Comparator<Coordenada1D> getComparator(final ComparadorCoordenada1D... multipleOptions)
	{
		return new Comparator<Coordenada1D>()
		{
			public int compare(Coordenada1D o1, Coordenada1D o2)
			{
				for (ComparadorCoordenada1D option : multipleOptions)
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