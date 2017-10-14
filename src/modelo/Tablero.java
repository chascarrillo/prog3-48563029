/**
 * Esta clase especifica un tablero de juego...
 * 
 * @author Alfonso Aracil Andres. 48563029
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Patron;

public class Tablero
{
	private HashMap<Coordenada,EstadoCelda> celdas;

	public Tablero(Coordenada dimensiones)
	{
		if(dimensiones.getX() >= 0)
		{
			if(dimensiones.getY() >= 0)
			{
				for(int x = 0; x <= dimensiones.getX(); x++)
				{
					for(int y = 0; y <= dimensiones.getY(); y++)
					{
						celdas.put(new Coordenada(x, y), EstadoCelda.MUERTA);
					}
				}
			}
			else
			{
				for(int x = 0; x <= dimensiones.getX(); x++)
				{
					for(int y = 0; y > dimensiones.getY(); y--)
					{
						celdas.put(new Coordenada(x, y), EstadoCelda.MUERTA);
					}
				}
			}
		}
		else
		{
			if(dimensiones.getY() >= 0)
			{
				for(int x = 0; x > dimensiones.getX(); x--)
				{
					for(int y = 0; y <= dimensiones.getY(); y++)
					{
						celdas.put(new Coordenada(x, y), EstadoCelda.MUERTA);
					}
				}
			}
			else
			{
				for(int x = 0; x > dimensiones.getX(); x--)
				{
					for(int y = 0; y > dimensiones.getY(); y--)
					{
						celdas.put(new Coordenada(x, y), EstadoCelda.MUERTA);
					}
				}
			}
		}
	}

	public Collection<Coordenada> getPosiciones()
	{
		return (Collection<Coordenada>)celdas.keySet();
	}

	public EstadoCelda getCelda(Coordenada posicion)
	{
		muestraErrorPosicionInvalida(posicion);
		return celdas.get(posicion);
	}

	public void setCelda(Coordenada posicion, EstadoCelda e)
	{
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
		Iterator<Coordenada> iterator = getPosiciones().iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			if (xmin > caux.getX())
			{
				xmin = caux.getX();
			}
			if (xmax < caux.getX())
			{
				xmax = caux.getX();
			}
			if (ymin > caux.getY())
			{
				ymin = caux.getY();
			}
			if (ymax < caux.getY())
			{
				ymax = caux.getY();
			}
		}
		if (posicion.getX() > xmax  ||  posicion.getY() > ymax  ||  posicion.getX() < xmin  ||  posicion.getY() < ymin)
		{
			muestraErrorPosicionInvalida(posicion);
		}
		else
		{
			celdas.put(posicion, e);
		}
	}

	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)
	{
		ArrayList<Coordenada> cds = null;
		if(celdas.containsKey(posicion))
		{
			cds = new ArrayList<Coordenada>();
			Coordenada aux = new Coordenada(posicion.getX()-1, posicion.getY()-1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX()-1, posicion.getY());
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX()-1, posicion.getY()+1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX(), posicion.getY()+1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX()+1, posicion.getY()+1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX()+1, posicion.getY());
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX()+1, posicion.getY()-1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
			aux = new Coordenada(posicion.getX(), posicion.getY()-1);
			if(celdas.containsKey(aux))
			{
				cds.add(aux);
			}
		}
		return cds;
	}

	private void muestraErrorPosicionInvalida(Coordenada c)
	{
		if(!celdas.containsKey(c))
		{
			System.err.println("Error: La celda " + c + " no existe");
		}
	}

	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial)
	{
		Coordenada caux = null;
		Iterator<Coordenada> iterator = null;
		boolean control;
		Collection<Coordenada> posPatron = sortColeccion(patron.getPosiciones());
		Collection<Coordenada> posTablero = recortarColeccion(sortColeccion(getPosiciones()), coordenadaInicial);

		if(anchuraColeccion(posPatron) <= anchuraColeccion(posTablero)  &&  alturaColeccion(posPatron) <= alturaColeccion(posTablero))
		{
			iterator = posPatron.iterator();
			while(iterator.hasNext())
			{
				caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
				setCelda(caux.suma(coordenadaInicial), patron.getCelda(caux));
			}
			control = true;
		}
		else
		{
			control = false;
			posPatron.removeAll(posTablero);
			iterator = posPatron.iterator();
			caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			muestraErrorPosicionInvalida(caux);
		}

		return control;
	}

	private int anchuraColeccion(Collection<Coordenada> c)
	{
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
		int devuelto = 1;
		Iterator<Coordenada> iterator = c.iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			if (xmin > caux.getX())
			{
				xmin = caux.getX();
			}
			if (xmax < caux.getX())
			{
				xmax = caux.getX();
			}
		}
		// hago esto y no xmax - xmin + 1 para poder trabajar con xmax positivo y xmin negativo sin problemas
		while(xmin < xmax)
		{
			xmin++;
			devuelto++;
		}

		return devuelto;
	}

	private int alturaColeccion(Collection<Coordenada> c)
	{
		int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE, devuelto = 1;
		Iterator<Coordenada> iterator = c.iterator();
		while(iterator.hasNext())
		{
			Coordenada caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
			if (ymin > caux.getY())
			{
				ymin = caux.getY();
			}
			if (ymax < caux.getY())
			{
				ymax = caux.getY();
			}
		}
		while(ymin < ymax)
		{
			ymin++;
			devuelto++;
		}

		return devuelto;
	}

	private Collection<Coordenada> recortarColeccion(Collection<Coordenada> col, Coordenada c)
	{
		Collection<Coordenada> devuelto = null;
		if(col.contains(c))
		{
			Coordenada caux = null;
	
			devuelto.addAll(sortColeccion(col));
			Iterator<Coordenada> iterator = devuelto.iterator();
			while(iterator.hasNext())
			{
				caux = (Coordenada)((Map.Entry) iterator.next()).getKey();
				if (caux.equals(c))
				{
					break;
				}
				else iterator.remove();
			}
		}
		return devuelto;
	}

	private Collection<Coordenada> sortColeccion(Collection<Coordenada> poss)
	{
		Collection<Coordenada> collreturn = null, arg = null;
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
