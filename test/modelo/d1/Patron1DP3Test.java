package modelo.d1;


import static org.junit.Assert.*;

import java.util.HashSet;

import modelo.EstadoCelda;
import modelo.Patron;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

import org.junit.Before;
import org.junit.Test;

public class Patron1DP3Test {

	Tablero<Coordenada1D> tablero;
	Patron<Coordenada1D> patron;
	String snombre;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tablero = new Tablero1D(5);
		tablero.setCelda(new Coordenada1D(1),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(2),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(3),EstadoCelda.VIVA);
		snombre = new String ("Trio");
		patron = new Patron<Coordenada1D>(snombre,tablero);
	}

	
	@Test
	public void testGetNombre() {
		
		assertEquals("Nombre ","Trio",patron.getNombre());
		
	}

	
	@Test
	public void testGetCelda() {
		Coordenada1D c;
		for (int x=0; x<5; x++)		
				try {
					c = new Coordenada1D(x);
					if ((x>0)&&(x<4)) assertEquals("Estado Celda VIVA ", EstadoCelda.VIVA, patron.getCelda(c));
					else assertEquals("Estado Celda MUERTA ", EstadoCelda.MUERTA,patron.getCelda(c));
				} catch (Exception ex) {
					fail("No debía producirse ninguna excepción pero se capturo "+ex.getClass().getSimpleName());
				}
	}

	/**
	 * Test method for {@link modelo.Patron#getPosiciones()}.
	 */
	@Test
	public void testGetPosiciones() {
		HashSet<Coordenada1D> sctab =new HashSet<Coordenada1D>();
		
		for (int x=0; x<5; x++)
				try {
					sctab.add(new Coordenada1D(x));
				} catch (ExcepcionCoordenadaIncorrecta ex) {
					fail("No debía producirse ninguna excepción pero se capturo "+ex.getClass().getSimpleName());
				}
		assertEquals("Estan todas posiciones en Patron", sctab, patron.getPosiciones());
		}

	/**
	 * Test method for {@link modelo.Patron#toString()}.
	 */
	@Test
	public void testToString() {
		StringBuilder salida=new StringBuilder();
		salida.append("Trio\n");
		salida.append("| *** |\n");
		String sal = salida.toString();
		assertEquals("Impresión de Patron ", sal,patron.toString());
	}
	

}
