/**
 * 
 */
package modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.d1.Coordenada1D;
import modelo.d1.ExcepcionCoordenada1DIncorrecta;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ExcepcionCoordenada2DIncorrecta;
import modelo.d2.ReglaConway;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import org.junit.Test;

/**
 * @author gonzalo
 *
 */
public class ExcepcionesSuiteTest<TipoCoordenada extends Coordenada> {


	//Excepciones en Coordenada, Coordenada1D y Coordenada2D
	@Test 
	public void testExcepcionArgumentosIncorrectosCoordenada1D()  {
		TipoCoordenada c=null;
		try {
			c = (TipoCoordenada) new Coordenada1D(null);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex) {
			if (ex instanceof ExcepcionArgumentosIncorrectos) {
				assertNull(c);
				 ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			 assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName());
			return;
		}
	}

	@Test 
	public void testExcepcionArgumentosIncorrectosCoordenada2D()  {
		TipoCoordenada c=null;
		try {
			c = (TipoCoordenada) new Coordenada2D(null);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex) {
			if (ex instanceof ExcepcionArgumentosIncorrectos) {
				assertNull(c);
				 ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			 assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName());
			return;
		}
	}
	
	@Test 
	public void testExcepcionArgumentosIncorrectosSuma1D()  {
		TipoCoordenada c=null;
		TipoCoordenada d=null;
		try {
			c = (TipoCoordenada) new Coordenada1D(10);
			d = (TipoCoordenada) c.suma(null);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex) {
			if (ex instanceof ExcepcionArgumentosIncorrectos){
				assertNull(d);
				 ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			 assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName());
		}
	}
	
	@Test 
	public void testExcepcionArgumentosIncorrectosSuma2D()  {
		TipoCoordenada c=null;
		TipoCoordenada d=null;
		try {
			c = (TipoCoordenada) new Coordenada2D(10,13);
			d = (TipoCoordenada) c.suma(null);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex) {
			if (ex instanceof ExcepcionArgumentosIncorrectos) {
				assertNull(d);
				ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName());
			return;
		}
	}
	
	/**
	 * Test method for {@link modelo.d2.ExcepcionCoordenada2DIncorrecta#ExcepcionCoordenada2DIncorrecta(int, int)}.
	 */
	@Test
	public void testExcepcionCoordenada2DIncorrecta() {
		TipoCoordenada c = null;
		 
		try {
			c = (TipoCoordenada) new Coordenada2D(-1,0);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (ExcepcionCoordenadaIncorrecta ex) {
			if (ex instanceof ExcepcionCoordenada2DIncorrecta) {
				ExcepcionCoordenada2DIncorrecta ex2d = (ExcepcionCoordenada2DIncorrecta)ex;
				assertNull(c);	
				assertTrue("Emisión de mensaje",ex2d.getMessage().length()>0);
				assertEquals("getX",-1,ex2d.getX());
				assertEquals("getY",0,ex2d.getY());
			}
			else fail("Se esperaba ExcepcionCoordenada2DIncorrecta, pero se capturo "+ex.getClass().getSimpleName());
		} catch (Exception ex) {
			fail("Se esperaba ExcepcionCoordenadaIncorrecta, pero se capturo "+ex.getClass().getSimpleName());
		}
		
		try {
				c = (TipoCoordenada) new Coordenada2D(0,-1);
				fail ("Error; no se produjo ninguna excepción.");
			} catch (ExcepcionCoordenadaIncorrecta ex1) {
				if (ex1 instanceof ExcepcionCoordenada2DIncorrecta) {
					ExcepcionCoordenada2DIncorrecta ex2d = (ExcepcionCoordenada2DIncorrecta)ex1;
					assertNull(c);
					assertTrue("Emisión de mensaje",ex2d.getMessage().length()>0);
					assertEquals("getX",0,ex2d.getX());
					assertEquals("getY",-1,ex2d.getY());
				}
				else fail("Se esperaba ExcepcionCoordenada2DIncorrecta, pero se capturo "+ex1.getClass().getSimpleName());
			} catch (Exception ex1) {
			fail ("Se esperaba ExcepcionCoordenadaIncorrecta, pero se capturo "+ex1.getClass().getSimpleName());			
			}
		
	}
	
	@Test
	public void testExcepcionCoordenada1DIncorrecta() {
		TipoCoordenada c = null;	 
	try {
		c = (TipoCoordenada) new Coordenada1D(-1);
		fail ("Error; no se produjo ninguna excepción.");
	} catch (ExcepcionCoordenadaIncorrecta ex) {
		if (ex instanceof ExcepcionCoordenada1DIncorrecta) {
			ExcepcionCoordenada1DIncorrecta ex1d = (ExcepcionCoordenada1DIncorrecta)ex;
			assertNull(c);
			assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
			assertEquals("getX",-1,ex1d.getX());
		}
		else fail("Se esperaba ExcepcionCoordenada1DIncorrecta, pero se capturo "+ex.getClass().getSimpleName());
	} catch (Exception ex1) {
		fail ("Se esperaba ExcepcionCoordenadaIncorrecta, pero se capturo "+ex1.getClass().getSimpleName());			
	}
}


	//Excepciones en Tablero, Tablero1D, Tablero2D, TableroCeldasCuadradas
	@Test
	public void testExcepcionCoordenadaIncorrectaEnTablero() {
		
		Tablero<TipoCoordenada> t1 = null;
		Tablero<TipoCoordenada> t2 = null;
	
		try {
			t1 = (Tablero<TipoCoordenada>) new Tablero1D(-1);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
			  if (e instanceof ExcepcionCoordenada1DIncorrecta){
				   ExcepcionCoordenada1DIncorrecta ex1d = (ExcepcionCoordenada1DIncorrecta) e;
				   assertNull(t1);
				   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
				   assertEquals("getX",-1,ex1d.getX());	   
			   }
			   else fail("Se esperaba ExcepcionCoordenada1DIncorrecta, pero se capturo "+e.getClass().getSimpleName());
		} catch (Exception e) {
			fail ("Se esperaba ExcepcionCoordenadaIncorrecta, pero se capturo "+e.getClass().getSimpleName());
		}
			   
		try {
 		    t2 = (Tablero<TipoCoordenada>) new TableroCeldasCuadradas(-1,2);
 		    fail ("Error; no se produjo ninguna excepción.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
				   if (e instanceof ExcepcionCoordenada2DIncorrecta){
					   ExcepcionCoordenada2DIncorrecta ex2d = (ExcepcionCoordenada2DIncorrecta) e;
					   assertNull(t2);
					   assertTrue("Emisión de mensaje",ex2d.getMessage().length()>0);
					   assertEquals("getX",-1,ex2d.getX());
					   assertEquals("getY",2,ex2d.getY());
				   }
				   else fail("Se esperaba ExcepcionCoordenada2DIncorrecta, pero se capturo "+e.getClass().getSimpleName());
		} catch (Exception e) {
			fail ("Se esperaba ExcepcionCoordenadaIncorrecta, pero se capturo "+e.getClass().getSimpleName());
		}
	}

	@Test
	public void testExcepcionArgumentosIncorrectosEnTablero() {
		
		Tablero<TipoCoordenada> t = null;
	
		try {
			t = new TableroPrueba(null);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex1) {
			  if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
				   assertNull(t);
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex1;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName());
		} 
	}
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnSetCeldaTablero() {
		
		Tablero<TipoCoordenada> t = null;
		try {
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
			t.setCelda(null, EstadoCelda.MUERTA);
			fail ("Error; no se produjo ninguna excepción.");
		} catch (Exception ex1) {
			  if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
				  ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex1;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnGetCeldaTablero() {
	   Tablero<TipoCoordenada> t = null;
	   
	   try {
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
		    t.getCelda(null);
		    fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex) {
			   if (ex instanceof ExcepcionArgumentosIncorrectos) {
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName()); 
	   }
	}
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnContieneTablero() {
	   Tablero<TipoCoordenada> t = null;
	   
	   try {
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
		    t.contiene(null);
		    fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex) {
			   if (ex instanceof ExcepcionArgumentosIncorrectos) {
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex.getClass().getSimpleName()); 
			   return;  
	   }
	}
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnGetPosicionesVecinasTablero() {
	   Tablero<TipoCoordenada> t = null;
	   
	   try {
			t = (Tablero<TipoCoordenada>) new Tablero1D(10);
		    t.getPosicionesVecinasCCW(null);
		    fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
	 			   assertTrue("Emisión de mensaje",ex1.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
	   }
	   
	   try {
			t = (Tablero<TipoCoordenada>) new TableroCeldasCuadradas(7,6);
			t.getPosicionesVecinasCCW(null);
			fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex2) {
				if (ex2 instanceof ExcepcionArgumentosIncorrectos) {
			 		   assertTrue("Emisión de mensaje",ex2.getMessage().length()>0);
				}
				else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex2.getClass().getSimpleName()); 
					   
	   } 		
	}
	
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnCargaPatronTablero() {
	   Tablero<TipoCoordenada> t = null;
	   Patron<TipoCoordenada> p = null;
	   try {
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
		    t.cargaPatron(null,(TipoCoordenada)new Coordenada1D(3));
		    fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex1) {
			if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
	 			   assertTrue("Emisión de mensaje",ex1.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
	   }
		
	   try {
		    p = new Patron("Prueba",new Tablero1D(10));
		    t.cargaPatron(p,null);
		    fail ("Error; no se produjo ninguna excepción.");
	   }catch (Exception ex2) {
		   	if (ex2 instanceof ExcepcionArgumentosIncorrectos) {
			 		assertTrue("Emisión de mensaje",ex2.getMessage().length()>0);
			}
			else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex2.getClass().getSimpleName()); 
		}
	}
	
	@Test
	public void testExcepcionPosicionFueraTableroGetCeldaTablero() {
	   Tablero<TipoCoordenada> t = null;
	   TipoCoordenada c = null;
	   try {
		    c = (TipoCoordenada) new Coordenada1D(5);
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
		    t.getCelda(c);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex1d = (ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",t.getDimensiones(),ex1d.getDimensiones());
	 			   assertEquals("getCoordenada",c,ex1d.getCoordenada()); 			   
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
			   return;  
	   }			
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	@Test
	public void testExcepcionPosicionFueraTableroSetCeldaTablero() {
	   Tablero<TipoCoordenada> t = null;
	   TipoCoordenada c = null;
	   try {
		    c = (TipoCoordenada) new Coordenada1D(5);
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
			t.setCelda(c,EstadoCelda.VIVA);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex1d = (ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",t.getDimensiones(),ex1d.getDimensiones());
	 			   assertEquals("getCoordenada",c,ex1d.getCoordenada());   
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
	 		   return;  
	   }
				
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	
	@Test
	public void testExcepcionPosicionFueraTableroEnCargaPatronTablero() {
	   Tablero<TipoCoordenada> t = null;
	   Patron<TipoCoordenada> p = null;
	   TipoCoordenada c=null;
	   TipoCoordenada s=null;
	   try {
		    s = (TipoCoordenada) new Coordenada1D(5);
			t = (Tablero<TipoCoordenada>) new Tablero1D(5);
			p = new Patron<TipoCoordenada>("Prueba",(Tablero<TipoCoordenada>)new Tablero1D(3));
			c = (TipoCoordenada) new Coordenada1D(3);
		    t.cargaPatron(p,c);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex1d = (ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",t.getDimensiones(),ex1d.getDimensiones());
	 			   assertEquals("getCoordenada",s,ex1d.getCoordenada()); 
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				    s = (TipoCoordenada) new Coordenada2D(5,5);
				    t = (Tablero<TipoCoordenada>) new TableroCeldasCuadradas(5,6);
				    p = new Patron<TipoCoordenada>("Prueba",(Tablero<TipoCoordenada>)new TableroCeldasCuadradas(3,3));
				    t.cargaPatron(p,(TipoCoordenada)new Coordenada2D(3,3));
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionPosicionFueraTablero) {
						   ExcepcionPosicionFueraTablero ex2d = (ExcepcionPosicionFueraTablero)ex2;
			 			   assertTrue("Emisión de mensaje",ex2d.getMessage().length()>0);
			 			   assertEquals("getDimensiones",t.getDimensiones(),ex2d.getDimensiones());
			 			  // assertEquals("getCoordenada",s,ex2d.getCoordenada()); 
					   }
					   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex2.getClass().getSimpleName()); 
					   return;  
			   }
	   }		
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	
	//Excepciones en Patron
	
	@Test
	public void testExcepcionArgumentosIncorrectosEnPatron() {
	
	   try {		
		   new Patron<TipoCoordenada>(null,(Tablero<TipoCoordenada>)new Tablero1D(3));
   
	   } catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex1;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				    
				    new Patron<TipoCoordenada>("Prueba",null);
			
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionArgumentosIncorrectos) {
						   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex2;
			 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
					   }
					   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex2.getClass().getSimpleName()); 
					   return;  
			   }
	   }		
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	
	@Test
	public void testExcepcionPosicionFueraTableroGetCeldaPatron() {
	   Patron<TipoCoordenada> p = null;
	   Tablero<TipoCoordenada> t= null;
	   TipoCoordenada c=null;
	   try {
		    t = (Tablero<TipoCoordenada>) new Tablero1D(10);
			p = new Patron<TipoCoordenada>("Prueba",t);
			c = (TipoCoordenada) new Coordenada1D(10);
		    p.getCelda(c);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex1d=(ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",t.getDimensiones(),ex1d.getDimensiones());
	 			   assertEquals("getCoordenada",c,ex1d.getCoordenada()); 
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
			   return; 			   
	   }
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	//Excepciones en Regla, ReglaConway y Regla30
	@Test
	public void testExcepcionArgumentosIncorrectosEnReglaConway() {
	   Regla<TipoCoordenada> regla = (Regla<TipoCoordenada>) new ReglaConway();
	   try {
			
		    regla.calculaSiguienteEstadoCelda(null,(TipoCoordenada) new Coordenada2D(4,7));
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex1;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				    regla = (Regla<TipoCoordenada>) new Regla30();
				    regla.calculaSiguienteEstadoCelda((Tablero<TipoCoordenada>) new Tablero1D(30),null);
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionArgumentosIncorrectos) {
						   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex2;
			 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
					   }
					   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
					   return; 			   
			   } 			   
	   }
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	@Test
	public void testExcepcionPosicionFueraTableroEnReglas() {
	   Regla<TipoCoordenada> regla = (Regla<TipoCoordenada>) new ReglaConway();
	   boolean bex1,bex2;
	   bex1=bex2=false;
	   Tablero<TipoCoordenada> t=null;
	   TipoCoordenada c=null;
	   try {
			t=(Tablero<TipoCoordenada>) new TableroCeldasCuadradas(4,7);
			c=(TipoCoordenada) new Coordenada2D(4,6);
		    regla.calculaSiguienteEstadoCelda(t,c);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex1d=(ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",t.getDimensiones(),ex1d.getDimensiones());
	 			 //  assertEquals("getCoordenada",c,ex1d.getCoordenada()); 
	 			   bex1=true;
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				    regla = (Regla<TipoCoordenada>) new Regla30();
				    t=(Tablero<TipoCoordenada>) new Tablero1D(30);
				    c=(TipoCoordenada) new Coordenada1D(30);
				    regla.calculaSiguienteEstadoCelda(t,c);
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionPosicionFueraTablero) {
						   ExcepcionPosicionFueraTablero ex1d=(ExcepcionPosicionFueraTablero)ex2;
			 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
			 			   assertEquals("getDimensiones",c,ex1d.getDimensiones());
			 			  // assertEquals("getCoordenada",c,ex1d.getCoordenada()); 
			 			   bex2=true;
					   }
					   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
					   return; 			   
			   } 			   
	   }
	   if (!bex1)  fail("No se ha lanzado ninguna excepcion en el primer try");
	   if (!bex2) fail("No se ha lanzado ninguna excepcion en el segundo try");
	}
	
	//Excepciones en Juego<TipoCoordenada>
	@Test
	public void testExcepcionArgumentosIncorrectosEnJuego() {
	
	  
	   try {
			new Juego<TipoCoordenada>(null,(Regla<TipoCoordenada>)new ReglaConway());   
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionArgumentosIncorrectos) {
				   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex1;
	 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
			   }
			   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				   new Juego<TipoCoordenada>((Tablero<TipoCoordenada>)new TableroCeldasCuadradas(5,4),null);
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionArgumentosIncorrectos) {
						   ExcepcionArgumentosIncorrectos exai=(ExcepcionArgumentosIncorrectos)ex2;
			 			   assertTrue("Emisión de mensaje",exai.getMessage().length()>0);
					   }
					   else fail("Se esperaba ExcepcionArgumentosIncorrectos, pero se capturo "+ex1.getClass().getSimpleName()); 
					   return; 			   
			   } 			   
	   }
	   fail("Alguna excepcion no se ha lanzado");
	}
	
	@Test
	public void testExcepcionPosicionFueraTableroEnCargaPatronDeJuego() {
	   Juego<TipoCoordenada> juego = null;
	   Tablero<TipoCoordenada> t = null;
	   TipoCoordenada c = null;
	   try {
		   t = (Tablero<TipoCoordenada>)new TableroCeldasCuadradas(1,1);
		   c = (TipoCoordenada)new Coordenada2D(5,4);
		   juego = new Juego<TipoCoordenada>((Tablero<TipoCoordenada>)new TableroCeldasCuadradas(5,4),(Regla<TipoCoordenada>)new ReglaConway());
		   juego.cargaPatron(new Patron<TipoCoordenada>("PatronTest",t),c);
	   }catch (Exception ex1) {
			   if (ex1 instanceof ExcepcionPosicionFueraTablero) {
				   ExcepcionPosicionFueraTablero ex2d=(ExcepcionPosicionFueraTablero)ex1;
	 			   assertTrue("Emisión de mensaje",ex2d.getMessage().length()>0);
	 			   assertEquals("getDimensiones",c,ex2d.getDimensiones());
	 			   assertEquals("getCoordenada",c,ex2d.getCoordenada()); 
			   }
			   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
			   try {
				   t = (Tablero<TipoCoordenada>)new Tablero1D(1);
				   c = (TipoCoordenada)new Coordenada1D(20);
				   juego = new Juego<TipoCoordenada>((Tablero<TipoCoordenada>)new Tablero1D(20),(Regla<TipoCoordenada>)new Regla30());
				   juego.cargaPatron(new Patron<TipoCoordenada>("PatronTest",t), c);
			   }catch (Exception ex2) {
					   if (ex2 instanceof ExcepcionPosicionFueraTablero) {
						   ExcepcionPosicionFueraTablero ex1d=(ExcepcionPosicionFueraTablero)ex2;
			 			   assertTrue("Emisión de mensaje",ex1d.getMessage().length()>0);
			 			   assertEquals("getDimensiones",c,ex1d.getDimensiones());
			 			   assertEquals("getCoordenada",c,ex1d.getCoordenada()); 
					   }
					   else fail("Se esperaba ExcepcionPosicionFueraTablero, pero se capturo "+ex1.getClass().getSimpleName()); 
					   return; 			   
			   } 			   
	   }
	   fail("Alguna excepcion no se ha lanzado");
	}
	
}
	


//*** AUXILIARES ****/
// Clase auxiliar para probar la clase Tablero.
final class TableroPrueba<TipoCoordenada extends Coordenada> extends Tablero<TipoCoordenada> {

	protected TableroPrueba(TipoCoordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		super(dimensiones);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TipoCoordenada> getPosicionesVecinasCCW(TipoCoordenada posicion) {
		// TODO Auto-generated method stub
		return null;
	}
	
}