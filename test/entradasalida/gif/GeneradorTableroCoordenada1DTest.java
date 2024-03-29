/**
 * 
 */
package entradasalida.gif;

import static org.junit.Assert.*;

import java.io.File;

import modelo.Juego;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entradasalida.IGeneradorFichero;
import modelo.MetodosAuxiliares;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada1D;

/**
 * @author gonzalo
 *
 */
public class GeneradorTableroCoordenada1DTest extends MetodosAuxiliares<Coordenada1D> {

	  static Tablero1D t;
		/**
		 * @throws java.lang.Exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			t = new Tablero1D(20);
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
			IGeneradorFichero generador = new GeneradorTableroCoordenada1D();		
			generador.generaFichero(null,new Juego<Coordenada1D>(t,new Regla30()),1);
		}
		
		//El juego es null
		@Test(expected=ExcepcionArgumentosIncorrectos.class)
		public void testGeneraFicheroExcepcion2() throws Exception {
			IGeneradorFichero generador = new GeneradorTableroCoordenada1D();
			generador.generaFichero(new File("fff.gif"),null,1);
		}

		//El número de iteraciones es 0
		@Test(expected=ExcepcionGeneracion.class)
		public void testGeneraFicheroExcepcion3() throws Exception {
			IGeneradorFichero generador = new GeneradorTableroCoordenada1D();
			generador.generaFichero(new File("fff.gif"), new Juego<Coordenada1D>(t,new Regla30()),0);
		}
		
		//El número de iteraciones es negativo
		@Test(expected=ExcepcionGeneracion.class)
		public void testGeneraFicheroExcepcion4() throws Exception {
			IGeneradorFichero generador = new GeneradorTableroCoordenada1D();
			generador.generaFichero(new File("fff.gif"), new Juego<Coordenada1D>(t,new Regla30()),-3);
		}
		
		@Test
		public void testGeneraFicheroDelMain() {
		
			try {
				run(new Coordenada1D(80), new Coordenada1D(40), "*", "test/ficheros/p4-1d_alu.gif", 30);
				assertTrue(ComparaFicheros("test/ficheros/p4-1d.gif","test/ficheros/p4-1d_alu.gif"));
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
		}
		
		@Test
		public void testGeneraFicheroGif1() {
		
			try {
				run(new Coordenada1D(80), new Coordenada1D(20), "***   ***  * * *", "test/ficheros/p4-1d_test1_alu.gif", 30);
				assertTrue("Los ficheros p4-1d_test.gif y p4-1d_test_alu.gif no son iguales ",ComparaFicheros("test/ficheros/p4-1d_test1.gif","test/ficheros/p4-1d_test1_alu.gif"));
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
			
		}
		
		@Test
		public void testGeneraFicheroGif2() {
		
			try {
				run(new Coordenada1D(40), new Coordenada1D(10), "********************", "test/ficheros/p4-1d_test2_alu.gif", 40);
				assertTrue("Los ficheros p4-1d_test2.gif y p4-1d_test2_alu.gif no son iguales ",ComparaFicheros("test/ficheros/p4-1d_test2.gif","test/ficheros/p4-1d_test2_alu.gif"));
				
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
		}
		
		@Test
		public void testGeneraFicheroGif3() {
			
				try {
					run(new Coordenada1D(35), new Coordenada1D(0), "* * * * * * * * * * * * * * * * * *", "test/ficheros/p4-1d_test3_alu.gif", 1);
					assertTrue("Los ficheros p4-1d_test3.gif y p4-1d_test3_alu.gif no son iguales ",ComparaFicheros("test/ficheros/p4-1d_test3.gif","test/ficheros/p4-1d_test3_alu.gif"));
					
				} catch (Exception e) {
					fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
				}
		}
		
		
		
}
