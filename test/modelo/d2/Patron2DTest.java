package modelo.d2;


import static org.junit.Assert.*;

import java.util.HashSet;

import modelo.EstadoCelda;
import modelo.Patron;
import modelo.Tablero;
import modelo.d2.Coordenada2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

import org.junit.Before;
import org.junit.Test;

public class Patron2DTest {

	Tablero<Coordenada2D> tablero;
	Patron<Coordenada2D> patron;
	String snombre;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tablero = new TableroCeldasCuadradas(3,3);
		tablero.setCelda(new Coordenada2D(0,0),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(1,1),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(2,2),EstadoCelda.VIVA);
		snombre = new String ("Diagonal");
		patron = new Patron<Coordenada2D>(snombre,tablero);
	}

	
	@Test
	public void testGetNombre() {
		
		assertEquals("Nombre ","Diagonal",patron.getNombre());
		
	}

	/**
	 * Test method for {@link modelo.Patron#getCelda(modelo.d2.Coordenada2D)}.
	 */
	@Test
	public void testGetCelda() {
		Coordenada2D c;
		for (int x=0; x<3; x++)
			for (int y=0; y<3; y++) {
				try {
					c = new Coordenada2D(x,y);
					if (x==y) assertEquals("Estado Celda VIVA ", EstadoCelda.VIVA, patron.getCelda(c));
					else assertEquals("Estado Celda MUERTA ", EstadoCelda.MUERTA,patron.getCelda(c));
				} catch (Exception ex) {
					fail("No debía producirse ninguna excepción pero se capturo "+ex.getClass().getSimpleName());
				}
			}
	}

	/**
	 * Test method for {@link modelo.Patron#getPosiciones()}.
	 */
	@Test
	public void testGetPosiciones() {
		HashSet<Coordenada2D> sctab =new HashSet<Coordenada2D>();
		
		for (int x=0; x<3; x++)
			for (int y=0; y<3; y++) {
				try {
					sctab.add(new Coordenada2D(x,y));
				} catch (ExcepcionCoordenadaIncorrecta ex) {
					fail("No debía producirse ninguna excepción pero se capturo "+ex.getClass().getSimpleName());
				}
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
