/**
 * Este tipo enumerado es para ayudarme a ordenar las celdas segun sus coordenadas...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.Comparator;

public enum ComparadorCoordenada
implements Comparator<Coordenada>
{
	X_SORT
	{
		public int compare(Coordenada c1, Coordenada c2)
		{
			return Integer.valueOf(c1.getX()).compareTo(c2.getX());
		}
	},
	Y_SORT
	{
		public int compare(Coordenada c1, Coordenada c2)
		{
			return Integer.valueOf(c1.getY()).compareTo(c2.getY());
		}
	};

	public static Comparator<Coordenada> descending(final Comparator<Coordenada> other)
	{
		return new Comparator<Coordenada>()
		{
			public int compare(Coordenada o1, Coordenada o2)
			{
				return -1 * other.compare(o1, o2);
			}
		};
	}

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
					{
						return result;
					}
				}
				return 0;
			}
		};
	}
}