/**
 * 
 */
package modelo;

import static org.junit.Assert.*;


import java.util.HashSet;




import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class PatronP2Test.
 *
 * @author gonzalo
 */
public class PatronP2Test {

	/** The tablero. */
	Tablero tablero;
	
	/** The patron. */
	Patron patron;
	
	/** The snombre. */
	String snombre;
	

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		tablero = new Tablero(new Coordenada2D(3,3));
		tablero.setCelda(new Coordenada2D(0,0),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(1,1),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(2,2),EstadoCelda.VIVA);
		snombre = new String ("Diagonal");
		patron = new Patron(snombre,tablero);
	}

	/**
	 * Test method for {@link modelo.Patron#getNombre()}.
	 */
	@Test
	public void testGetNombre() {
		
		assertEquals("Nombre ","Diagonal",patron.getNombre());
		
	}

	/**
	 * Test method for {@link modelo.Patron#getCelda(modelo.Coordenada2D)}.
	 */
	@Test
	public void testGetCelda() {
		Coordenada2D c;
		for (int x=0; x<tablero.getDimensiones().getX(); x++)
			for (int y=0; y<tablero.getDimensiones().getY(); y++) {
				c = new Coordenada2D(x,y);
				if (x==y) assertEquals("Estado Celda VIVA ", EstadoCelda.VIVA, patron.getCelda(c));
				else assertEquals("Estado Celda MUERTA ", EstadoCelda.MUERTA,patron.getCelda(c));
			}
	}

	/**
	 * Test method for {@link modelo.Patron#getPosiciones()}.
	 */
	@Test
	public void testGetPosiciones() {
		HashSet<Coordenada2D> sctab =new HashSet<Coordenada2D>();
		
		for (int x=0; x<tablero.getDimensiones().getX(); x++)
			for (int y=0; y<tablero.getDimensiones().getY(); y++) {
				sctab.add(new Coordenada2D(x,y));
			}
		assertEquals("Estan todas posiciones en Patron", sctab, patron.getPosiciones());
		}

	/**
	 * Test method for {@link modelo.Patron#toString()}.
	 */
	@Test
	public void testToString() {
		StringBuilder salida=new StringBuilder();
		salida.append("Diagonal\n");
		salida.append("+---+\n");
		salida.append("|*  |\n");
		salida.append("| * |\n");
		salida.append("|  *|\n");
		salida.append("+---+\n");
		String sal = salida.toString();
		assertEquals("Impresión de Patron ", sal,patron.toString());
	}
	

}
