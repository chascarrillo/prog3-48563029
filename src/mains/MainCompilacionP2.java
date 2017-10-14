package mains;

import java.util.ArrayList;
import java.util.Collection;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Patron;
import modelo.ReglaConway;
import modelo.Tablero;

/**
 * Programa que comprueba que todos los métodos de la 
 * interfaz pública de la práctica 2 tienen la signatura
 * que se especifica en el enunciado. Si no es así es muy probable
 * que este código no compile.
 * 
 * @author pierre
 *
 */
public class MainCompilacionP2 {
	/**
	 * Programa principal
	 * @param args No se usa
	 */
	public static void main(String[] args) {
	// Interfaz pública de Coordenada
		Coordenada c = new Coordenada(3, 4);
		Coordenada c2 = new Coordenada(c);

		boolean b = c.equals(c2);
		b = c.equals(new Integer(2));
		int x = c.getX();
		int y = c.getY();
		int h = c.hashCode();
		Coordenada c3 = c.suma(c2);
		String s = c.toString();
		h = Coordenada.getNumeroCoordenadas();
		
	// EstadoCelda es un enum
		EstadoCelda ec = EstadoCelda.MUERTA;
		ec = EstadoCelda.VIVA;
		h = ec.ordinal();
	
	// ReglaConway
		ReglaConway rc = new ReglaConway();
		ec = rc.calculaSiguienteEstadoCelda(new Tablero(c),c2);
		
	// Tablero
		Tablero t1 = new Tablero(c);
		b = t1.cargaPatron(new Patron("", null), c);
		b = t1.contiene(c);
		ec = t1.getCelda(c);
		c3 = t1.getDimensiones();
		Collection<Coordenada> cc = t1.getPosiciones();
		ArrayList<Coordenada> ac = t1.getPosicionesVecinasCCW(c);
		t1.setCelda(c, ec);
		s = t1.toString();
	
	// Patron
		Patron p1 = new Patron("P", t1);
		ec = p1.getCelda(c);
		s = p1.getNombre();
		cc = p1.getPosiciones();
		s = p1.toString();
	// Juego
		Juego j = new Juego(t1, rc);
		j.actualiza();
		j.cargaPatron(p1, c);
		ArrayList<Patron> ap = j.getPatrones();
		t1 = j.getTablero();
		
	}
}
