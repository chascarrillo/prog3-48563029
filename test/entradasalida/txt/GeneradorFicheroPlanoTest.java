/**
 * 
 */
package entradasalida.txt;

import static org.junit.Assert.*;

import java.io.File;

import modelo.Juego;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.TableroNoImprimible;
import modelo.Coordenada;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entradasalida.Factory;
import entradasalida.IGeneradorFichero;
import modelo.MetodosAuxiliares;
import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.txt.GeneradorFicheroPlano;

/**
 * @author gonzalo
 *
 */
public class GeneradorFicheroPlanoTest<TipoCoordenada extends Coordenada> extends MetodosAuxiliares<TipoCoordenada>{
     Tablero<TipoCoordenada> t;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = (Tablero<TipoCoordenada>) new Tablero1D(20);
	}

	/**
	 * Test method for {@link entradasalida.txt.GeneradorFicheroPlano#generaFichero(java.io.File, modelo.Juego, int)}.
	 * @throws Exception 
	 */
	//El fichero es null
	@Test(expected=ExcepcionArgumentosIncorrectos.class)
	public void testGeneraFicheroExcepcion1() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();		
		generador.generaFichero(null,new Juego<TipoCoordenada>(t,(Regla<TipoCoordenada>)new Regla30()),1);
	}
	
	//El juego es null
	@Test(expected=ExcepcionArgumentosIncorrectos.class)
	public void testGeneraFicheroExcepcion2() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();
		generador.generaFichero(new File("fff.txt"),null,1);
	}

	//El número de iteraciones es 0
	@Test(expected=ExcepcionGeneracion.class)
	public void testGeneraFicheroExcepcion3() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();
		generador.generaFichero(new File("fff.txt"), new Juego<TipoCoordenada>(t,(Regla<TipoCoordenada>)new Regla30()),0);
	}
	
	//El número de iteraciones es negativo
	@Test(expected=ExcepcionGeneracion.class)
	public void testGeneraFicheroExcepcion4() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();
		generador.generaFichero(new File("fff.txt"), new Juego<TipoCoordenada>(t,(Regla<TipoCoordenada>)new Regla30()),-3);
	}
	
	//El tablero del juego no es imprimible
	@Test(expected=ExcepcionGeneracion.class)
	public void testGeneraFicheroExcepcion5() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();
		Tablero<TipoCoordenada> t=new TableroNoImprimible(new Coordenada2D(2,2));
		generador.generaFichero(new File("fff.txt"), new Juego<TipoCoordenada>(t,(Regla<TipoCoordenada>)new ReglaConway()),3);
	}
	
	//No existe el directorio donde crear el fichero
	@Test(expected=ExcepcionGeneracion.class)
	public void testGeneraFicheroExcepcion6() throws Exception {
		IGeneradorFichero generador = new GeneradorFicheroPlano();
		generador.generaFichero(new File("nohaydirectorio/nosepuedecrear.txt"), new Juego<TipoCoordenada>(t,(Regla<TipoCoordenada>)new Regla30()),3);
	}
	
	@Test
	public void testGeneraFicheroDelMain4() {
	
		try {
			run((TipoCoordenada)new Coordenada1D(80),(TipoCoordenada) new Coordenada1D(40), "*", "test/ficheros/p4-1d_alu.txt", 30);
			boolean comp = ComparaFicheros("test/ficheros/p4-1d.txt","test/ficheros/p4-1d_alu.txt");
			assertTrue("Los ficheros p4-1d.txt y p4-1d_alu.txt son distintos",comp);
			
		} catch (Exception e) {
			fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
		}
		
	}
	
	@Test
	public void testGeneraFicheroDelMain5() {
	
		try {
			run((TipoCoordenada)new Coordenada2D(10, 5),(TipoCoordenada) new Coordenada2D(0, 0), " * \n  *\n***", "test/ficheros/p4-2d_alu.txt", 5);
			assertTrue(ComparaFicheros("test/ficheros/p4-2d.txt","test/ficheros/p4-2d_alu.txt"));
			
		} catch (Exception e) {
			fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
		}
		
	}
	
	@Test
	public void testGeneraFichero6() {
		
		try {
			Tablero<TipoCoordenada> tablero = ParserTableros.leeTablero(cargaTablero("test/ficheros/tablero2Dtest2.ent"));
			Regla<TipoCoordenada> regla = Factory.creaRegla(tablero);
			Juego<TipoCoordenada> juego = new Juego<TipoCoordenada>(tablero, regla);
			IGeneradorFichero generador = Factory.creaGeneradorFichero(tablero, "txt");
			generador.generaFichero(new File("test/ficheros/p4-2d_test2_alu.txt"), juego, 5);	
			boolean comp = ComparaFicheros("test/ficheros/p4-2d_test2.txt","test/ficheros/p4-2d_test2_alu.txt");
			assertTrue("Los ficheros p4-2d_test2.txt y p4-2d_test2_alu.txt no son iguales",comp);
		} catch (ExcepcionLectura e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
		}
	}
		@Test
		public void testGeneraFichero7() {
			
			try {
				Tablero<TipoCoordenada> tablero = ParserTableros.leeTablero(cargaTablero("test/ficheros/tablero2Dtest3.ent"));
				Regla<TipoCoordenada> regla = Factory.creaRegla(tablero);
				Juego<TipoCoordenada> juego = new Juego<TipoCoordenada>(tablero, regla);
				IGeneradorFichero generador = Factory.creaGeneradorFichero(tablero, "txt");
				generador.generaFichero(new File("test/ficheros/p4-2d_test3_alu.txt"), juego, 7);
				boolean comp = ComparaFicheros("test/ficheros/p4-2d_test3.txt","test/ficheros/p4-2d_test3_alu.txt");
				assertTrue("Los ficheros p4-2d_test3.txt y p4-2d_test3_alu.txt no son iguales",comp);
			} catch (Exception e) {
				fail("No se esperaba excepcion, pero se capturo "+e.getClass().getSimpleName());
			}
	}
}
