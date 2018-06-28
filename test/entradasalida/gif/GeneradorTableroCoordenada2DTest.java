/**
 * 
 */
package entradasalida.gif;

import static org.junit.Assert.*;

import java.io.File;

import modelo.Juego;
import modelo.Tablero;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entradasalida.IGeneradorFichero;
import modelo.MetodosAuxiliares;
import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada2D;

/**
 * @author gonzalo
 *
 */
public class GeneradorTableroCoordenada2DTest extends MetodosAuxiliares<Coordenada2D>{

	

	/**
	 * Test method for {@link entradasalida.gif.GeneradorTableroCoordenada2D#generaFichero(java.io.File, modelo.Juego, int)}.
	 */

	  static Tablero<Coordenada2D> t;
	  static IGeneradorFichero generador;
	  Juego<Coordenada2D> juego;
	  Tablero<Coordenada2D> tablero;
		/**
		 * @throws java.lang.Exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			t = new TableroCeldasCuadradas(20,30);
			generador = new GeneradorTableroCoordenada2D();
		}

		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
		}

		/**
		 * Test method for {@link entradasalida.txt.GeneradorFicheroPlano#generaFichero(java.io.File, modelo.Juego, int)}.
		 * @throws Exception 
		 */
		//El fichero es null
		@Test(expected=ExcepcionArgumentosIncorrectos.class)
		public void testGeneraFicheroExcepcion1() throws Exception {		
			generador.generaFichero(null,new Juego<Coordenada2D>(t,new ReglaConway()),1);
		}
		
		//El juego es null
		@Test(expected=ExcepcionArgumentosIncorrectos.class)
		public void testGeneraFicheroExcepcion2() throws Exception {
			generador.generaFichero(new File("fff.gif"),null,1);
		}

		//El número de iteraciones es 0
		@Test(expected=ExcepcionGeneracion.class)
		public void testGeneraFicheroExcepcion3() throws Exception {
			IGeneradorFichero generador = new GeneradorTableroCoordenada2D();
			generador.generaFichero(new File("fff.gif"), new Juego<Coordenada2D>(t,new ReglaConway()),0);
		}
		
		//El número de iteraciones es negativo
		@Test(expected=ExcepcionGeneracion.class)
		public void testGeneraFicheroExcepcion4() throws Exception {

			generador.generaFichero(new File("fff.gif"), new Juego<Coordenada2D>(t,new ReglaConway()),-3);
		}
		
		@Test
		public void testGeneraFicheroGifAnimadoDelMain() {
		
			try {
				run(new Coordenada2D(10, 5), new Coordenada2D(0, 0), " * \n  *\n***", "test/ficheros/p4-2d_alu.gif", 5);
				boolean comp = ComparaFicheros("test/ficheros/p4-2d.gif","test/ficheros/p4-2d_alu.gif");
				assertTrue("Los ficheros p4-2d.gif y p4-2d_alu.gif no son iguales ",comp);
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void testGeneraFicheroGifAnimado1() {
			
			try {
				tablero = ParserTableros.leeTablero(cargaTablero("test/ficheros/tablero2Dtest1.ent"));
			
				juego = new Juego<Coordenada2D>(tablero,new ReglaConway());

				generador.generaFichero(new File("test/ficheros/p4-2d_test1_alu.gif"),juego,10);
				boolean comp = ComparaFicheros("test/ficheros/p4-2d_test1.gif","test/ficheros/p4-2d_test1_alu.gif");
				assertTrue("Los ficheros p4-2d_test1.gif y p4-2d_test1_alu.gif no son iguales ",comp);
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
			
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void testGeneraFicheroGifAnimado2() {
			
			try {
				tablero = ParserTableros.leeTablero(cargaTablero("test/ficheros/tablero2Dtest2.ent"));
			
			    juego = new Juego<Coordenada2D>(tablero,new ReglaConway());
				generador.generaFichero(new File("test/ficheros/p4-2d_test2_alu.gif"),juego,10);
				boolean comp = ComparaFicheros("test/ficheros/p4-2d_test2.gif","test/ficheros/p4-2d_test2_alu.gif");
				assertTrue("Los ficheros p4-2d_test2.gif y p4-2d_test2_alu.gif no son iguales ",comp);
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
			
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void testGeneraFicheroGifAnimado3() {
		
			try {
				tablero = ParserTableros.leeTablero(cargaTablero("test/ficheros/tablero2Dtest3.ent"));
			
				juego = new Juego<Coordenada2D>(tablero,new ReglaConway());
				generador.generaFichero(new File("test/ficheros/p4-2d_test3_alu.gif"),juego,10);
				boolean comp = ComparaFicheros("test/ficheros/p4-2d_test3.gif","test/ficheros/p4-2d_test3_alu.gif");
				assertTrue("Los ficheros p4-2d_test3.gif y p4-2d_test3_alu.gif no son iguales ",comp);
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
			
		}
		
		

}
