/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelo.Tablero;
import modelo.ReglaConway;

public class Juego
{
	private Tablero tablero;

	private ReglaConway reglaConway;

	private ArrayList<Patron> patronesUsados;

	public Juego (Tablero tablero, ReglaConway reglaconway)
	{
		this.tablero = tablero;
		reglaConway = reglaconway;
	}

	public void cargaPatron(Patron p, Coordenada posicionInicial)
	{
		if(tablero.cargaPatron(p, posicionInicial))
		{
			patronesUsados.add(p);
		}
		else
		{
			System.err.println("Error cargando plantilla " + p.getNombre() + " en " + posicionInicial);
		}
	}

	public void actualiza()
	{
		Collection<Coordenada> cds = sortColeccion(tablero.getPosiciones());
		Iterator<Coordenada> iterator = cds.iterator();

		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			tablero.setCelda(caux, reglaConway.calculaSiguienteEstadoCelda(tablero, caux));
		}
	}

	public Tablero getTablero()
	{
		return tablero;
	}

	public ArrayList<Patron> getPatrones()
	{
		return patronesUsados;
	}

	private Collection<Coordenada> sortColeccion(Collection<Coordenada> poss)
	{// las primeras 5 lineas son una tonteria mia para poder inicializar una coleccion vacia...
		List<Coordenada> NOSEINICIALIZARCOLECCIONES = new ArrayList<Coordenada>(Arrays.asList(new Coordenada(0, 0)));
		Iterator<Coordenada> SIGOSINSABERINICIALIZARCOLECCIONES = NOSEINICIALIZARCOLECCIONES.iterator();
		while (SIGOSINSABERINICIALIZARCOLECCIONES.hasNext())
		{
			SIGOSINSABERINICIALIZARCOLECCIONES.remove();
		}

		Collection<Coordenada> collreturn = (Collection<Coordenada>) NOSEINICIALIZARCOLECCIONES;
		Collection<Coordenada> arg = (Collection<Coordenada>) NOSEINICIALIZARCOLECCIONES;
		arg.addAll(poss);

		Coordenada caux = null, cauxxm = null, cauxym = null;
		Iterator<Coordenada> iterator = null;
		int xmin = Integer.MAX_VALUE, ymin = Integer.MAX_VALUE;

		while(!arg.isEmpty())
		{
			iterator = arg.iterator();
			while(iterator.hasNext())
			{
				caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
				if (xmin > caux.getX())
				{
					xmin = caux.getX();
					cauxxm = caux;
				}
				if (ymin > caux.getY())
				{
					ymin = caux.getY();
					cauxym = caux;
				}
				else if(cauxym.getY() == caux.getY()  &&  cauxym.getX()>caux.getX())
				{
					cauxym = caux;
				}
			}
			if(cauxxm.getY() == ymin)
			{
				collreturn.add(cauxxm);
				arg.remove(cauxxm);
			}
			else
			{
				collreturn.add(cauxym);
				arg.remove(cauxym);
			}
		}

		return collreturn;
	}
}
