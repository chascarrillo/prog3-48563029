/**
 * 
 */
package modeloExcepciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaConwayP2Test.
 *
 * @author gonzalo
 */
public class ReglaConwayP2Test {
	
	/** The tablero. */
	private Tablero tablero;
	
	/** The regla. */
	private static ReglaConway regla;
	
	/** The xtab. */
	private int xtab;
	
	/** The ytab. */
	private int ytab;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		regla = new ReglaConway();
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * MMM
		 * MMM
		 * MMM
		 */
		xtab=ytab=3;
		tablero = new TableroCeldasCuadradas(xtab,ytab);
		
		
	}

	/**
	 * Test method for {@link modelo.ReglaConway#calculaSiguienteEstadoCelda(modelo.Tablero, modelo.Coordenada2D)}.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaTodasMuertas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos;
		for (int x=0; x<xtab;x++)
			for(int y=0; y<ytab;y++) {
				pos=new Coordenada2D(x,y);
				assertEquals ("Todas muertas", EstadoCelda.MUERTA, regla.calculaSiguienteEstadoCelda(tablero, pos));
			}
	}
	
	/**
	 * Test calcula siguiente estado celda muerta 1 viva.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaMuerta1Viva() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(0,0);
		Coordenada2D pos2 =new Coordenada2D(0,1);
		Coordenada2D pos3 =new Coordenada2D(1,1);
		Coordenada2D pos4 =new Coordenada2D(2,0);
		Coordenada2D pos5 =new Coordenada2D(2,1);
		Coordenada2D pos6 =new Coordenada2D(0,2);
		Coordenada2D pos7 =new Coordenada2D(1,2);
		/*
		 * MVM
		 * MMM
		 * MMM
		 */
		tablero.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		assertEquals ("Muerta(0,0)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		assertEquals ("Muerta(0,1)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos2));
		assertEquals ("Muerta(1,1)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos3));		
		assertEquals ("Muerta(2,0)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos4));
		assertEquals ("Muerta(2,1)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos5));	
		
		/*
		 * MVM
		 * VMM
		 * MMM
		 */
		tablero.setCelda(pos2, EstadoCelda.VIVA);
		assertEquals ("Muerta(0,2)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos6));
		assertEquals ("Muerta(1,2)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos7));
		
	}
	
	/**
	 * Test calcula siguiente estado celda muerta 2 vivas.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaMuerta2Vivas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(0,0);
		Coordenada2D pos2 =new Coordenada2D(1,1);
		
		/*
		 * MVM
		 * VMM
		 * MMM
		 */
		tablero.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		assertEquals ("Muerta(0,0)con 2 Vivas = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		assertEquals ("Muerta(1,1)con 2 Vivas = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos2));		
	}
		
	/**
	 * Test calcula siguiente estado celda muerta 3 vivas.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaMuerta3Vivas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(1,0);
		Coordenada2D pos2 =new Coordenada2D(1,2);
		/*
		 * MMM
		 * VVV
		 * MMM
		 */
		tablero.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(1,1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(2,1),EstadoCelda.VIVA);
		assertEquals ("Muerta(1,0)con 3 Viva = Viva ",EstadoCelda.VIVA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		assertEquals ("Muerta(1,2)con 3 Viva = Viva ",EstadoCelda.VIVA,regla.calculaSiguienteEstadoCelda(tablero,pos2));		
	}	
	
	/**
	 * Test calcula siguiente estado celda muerta 4 vivas.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaMuerta4Vivas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(1,0);
		
		/*
		 * MMV
		 * VVV
		 * MMM
		 */
		tablero.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(1,1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(2,1),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada2D(2,0), EstadoCelda.VIVA);
		
		assertEquals ("Muerta(1,0)con 4 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		
	}	
	
	/**
	 * Test calcula siguiente estado celda viva 0145 vivas.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaViva0145Vivas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(0,1);
		Coordenada2D pos2 =new Coordenada2D(1,1);	
		Coordenada2D pos3 =new Coordenada2D(2,1);
		Coordenada2D pos4 =new Coordenada2D(1,0);
		Coordenada2D pos5 =new Coordenada2D(0,0);
		Coordenada2D pos6 =new Coordenada2D(2,0);
		/*
		 * MMM
		 * VMM
		 * MMM
		 */
		tablero.setCelda(pos1, EstadoCelda.VIVA);
		assertEquals ("Viva(0,1)con 0 Vivas = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		
		/*
		 * MMM
		 * VVM
		 * MMM
		 */
		tablero.setCelda(pos2, EstadoCelda.VIVA);
		assertEquals ("Viva(0,1)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos1));
		assertEquals ("Viva(1,1)con 1 Viva = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos2));
		
		/*
		 * VVM
		 * VVV
		 * MMM
		 */
		tablero.setCelda(pos3, EstadoCelda.VIVA);
		tablero.setCelda(pos4, EstadoCelda.VIVA);
		tablero.setCelda(pos5,EstadoCelda.VIVA);
		assertEquals ("Viva(1,0)con 4 Vivas = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos4));
		
		/*
		 * VVV
		 * VVV
		 * MMM
		 */
		tablero.setCelda(pos6,EstadoCelda.VIVA);
		assertEquals ("Viva(1,0)con 5 Vivas = Muerta ",EstadoCelda.MUERTA,regla.calculaSiguienteEstadoCelda(tablero,pos4));
	}	
	
	/**
	 * Test calcula siguiente estado celda viva 23 vivas.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testCalculaSiguienteEstadoCeldaViva23Vivas() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Coordenada2D pos1 =new Coordenada2D(0,1);
		Coordenada2D pos2 =new Coordenada2D(1,1);	
		Coordenada2D pos3 =new Coordenada2D(2,1);
		Coordenada2D pos4 =new Coordenada2D(1,2);
		/*
		 * MMM
		 * VVV
		 * MMM
		 */
				
		tablero.setCelda(pos1, EstadoCelda.VIVA);
		tablero.setCelda(pos2, EstadoCelda.VIVA);
		tablero.setCelda(pos3, EstadoCelda.VIVA);
		assertEquals ("Viva(1,1)con 2 Vivas = Viva ",EstadoCelda.VIVA,regla.calculaSiguienteEstadoCelda(tablero,pos2));
		
		/*
		 * MMM
		 * VVV
		 * MVM
		 */
		tablero.setCelda(pos4, EstadoCelda.VIVA);
		assertEquals ("Viva(1,2)con 3 Vivas = Viva ",EstadoCelda.VIVA,regla.calculaSiguienteEstadoCelda(tablero,pos4));
		
	}	
}
