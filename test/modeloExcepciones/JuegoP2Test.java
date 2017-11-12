/**
 * 
 */
package modeloExcepciones;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Patron;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class JuegoP2Test.
 *
 * @author gonzalo
 */
public class JuegoP2Test {
     
     /** The regla. */
     ReglaConway regla;
     
     /** The patrones. */
     ArrayList<Patron> patrones;
     
     /** The tablero. */
     Tablero tablero;
     
     /** The juego. */
     Juego juego;
     
     /** The patronsapo. */
     static Patron patronglider, patronbloque, patronparpadeador, patronbarco, patronsapo;
     
     /** The tablero 4. */
     static String tablero1, tablero2, tablero3, tablero4;
     
     /** The tableroconmaspatrones. */
     static Tablero tablerodelmain, tableroparpadeadores, tableroconmaspatrones;
     
     /** The errstd. */
     static PrintStream salstd, errstd; //salida y error standard
     
     /** The Constant FICHERRORES. */
     static final String FICHERRORES = "test/ficheros/salidaerrorespatron.txt";
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		salstd = new PrintStream(System.out);
		errstd = new PrintStream(System.err);
	    tablerodelmain = IniciaTablerosResultado(new Coordenada2D(10,5),"test/ficheros/tablerodelmain.ent");
	    tableroparpadeadores = IniciaTablerosResultado(new Coordenada2D(10,1),"test/ficheros/tablerodelmain.ent");
	    tableroconmaspatrones = IniciaTablerosResultado(new Coordenada2D(10,15),"test/ficheros/tableroconmaspatrones.ent");
	    CreaPatrones();
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		tablero = new TableroCeldasCuadradas(new Coordenada2D(10,15));
		regla = new ReglaConway();
		juego = new Juego(tablero,regla);
		patrones = juego.getPatrones();	
	}

	
	/**
	 * Test method for {@link modelo.Juego#Juego(modelo.Tablero, modelo.ReglaConway)}.
	 */
	@Test
	public void testJuego() {

		assertNotNull ("Patrones usados iniciado", juego.getPatrones());
	}

	/**
	 * Test method for {@link modelo.Juego#cargaPatron(modelo.Patron, modelo.Coordenada2D)}.
	 *
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Test(expected = ExcepcionPosicionFueraTablero.class)
	public void testNoCargaPatron() throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {				
		juego.cargaPatron(patronglider, new Coordenada2D(8,10));
	}

	/**
	 * Test method for {@link modelo.Juego#cargaPatron(modelo.Patron, modelo.Coordenada2D)}.
	 *
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Test(expected = ExcepcionPosicionFueraTablero.class)
	public void testNoCargaPatron2() throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {				
		juego.cargaPatron(patronparpadeador, new Coordenada2D(0,15));
	}

	/**
	 * Test method for {@link modelo.Juego#cargaPatron(modelo.Patron, modelo.Coordenada2D)}.
	 *
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Test
	public void testCargaPatron() throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {
		
				
		juego.cargaPatron(patronglider, new Coordenada2D(7,11));
		assertEquals("Sí carga el patrón",1, patrones.size());
		assertSame("Agregación", patronglider,patrones.get(0));
		
		juego.cargaPatron(patronbloque, new Coordenada2D(0,2));
		assertEquals("Sí carga el patrón",2,patrones.size());
		assertSame("Agregación", patronbloque,patrones.get(1));
		
		juego.cargaPatron(patronparpadeador, new Coordenada2D(0,14));
		assertEquals("Sí carga el patrón",3,patrones.size());
		assertSame("Agregación", patronparpadeador,patrones.get(2));
		
	}

	/**
	 * Test method for {@link modelo.Juego#actualiza()}.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testActualizaTableroDelMain() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		
		Juego juego1 = new Juego(new TableroCeldasCuadradas(new Coordenada2D(10,5)),regla);
		juego1.cargaPatron(patronglider, new Coordenada2D(0,0));
		juego1.cargaPatron(patronbloque, new Coordenada2D(8,3)); 
		juego1.cargaPatron(patronparpadeador, new Coordenada2D(7,0));
	
		
		/*Fichero con los tableros que el alumno genera.Para que pueda
		analizar sus actualizaciones sucesivas en caso de error */
		PrintStream s = abrirFichero("test/ficheros/tablerosdelmaindelalumno.sal"); 
		for (int i=0; i<5; i++) {

			s.print(juego1.getTablero().toString()); //Guarda tablero del alumno
			juego1.actualiza();
		}
		s.close();
		
		//Comprobación del tablero final del alumno.
		Coordenada2D c;
		for (int i=0; i<10; i++)
			for (int j=0; j<5; j++) {
				c = new Coordenada2D(i,j);
				assertEquals("Estado ("+i+","+j+")",tablerodelmain.getCelda(c),juego1.getTablero().getCelda(c));
			}
	}
	
	/**
	 * Test actualiza parpadeadores solapados.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Test
	public void testActualizaParpadeadoresSolapados() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		
		Juego juego1 = new Juego(new TableroCeldasCuadradas(new Coordenada2D(10,1)),regla);
		juego1.cargaPatron(patronparpadeador, new Coordenada2D(1,0));
		juego1.cargaPatron(patronparpadeador, new Coordenada2D(3,0)); 
		juego1.cargaPatron(patronparpadeador, new Coordenada2D(4,0));
	
		
		/*Fichero con los tableros que el alumno genera.Para que en caso de error pueda
		hacer un seguimiento de sus actualizaciones */
		PrintStream s = abrirFichero("test/ficheros/tablerosparpadeadores.sal"); 
		for (int i=0; i<4; i++) {

			s.print(juego1.getTablero().toString()); //Guarda tablero del alumno 
			juego1.actualiza();
		}
		s.close();
		
		//Comprobamos el contenido del tablero del alumno
		Coordenada2D c;
		for (int i=0; i<10; i++)
			for (int j=0; j<1; j++) {
				c = new Coordenada2D(i,j);
				assertEquals("Estado ("+i+","+j+") = MUERTA",EstadoCelda.MUERTA,juego1.getTablero().getCelda(c));
			}
	}
	
	/**
	 * Test actualiza con mas patrones.
	 *
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Test
	public void testActualizaConMasPatrones() throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {
		
		juego.cargaPatron(patronglider, new Coordenada2D(0,0));
		juego.cargaPatron(patronbloque, new Coordenada2D(8,3)); 
		juego.cargaPatron(patronparpadeador, new Coordenada2D(7,0));
		juego.cargaPatron(patronglider, new Coordenada2D(7,12));
		juego.cargaPatron(patronbloque, new Coordenada2D(3,8)); 
		juego.cargaPatron(patronparpadeador, new Coordenada2D(0,14));
		juego.cargaPatron(patronbarco, new Coordenada2D(0,4)); 
		juego.cargaPatron(patronsapo, new Coordenada2D(3,12));
		juego.cargaPatron(patronbarco, new Coordenada2D(6,8)); 
		juego.cargaPatron(patronsapo, new Coordenada2D(3,3));
	
		/*Fichero con los tableros que el alumno genera en cada actualización para que
		pueda hacer un seguimiento en caso de error. */
		PrintStream s = abrirFichero("test/ficheros/tablerosconmaspatrones.sal"); 
		for (int i=0; i<9; i++) {
			s.print(juego.getTablero().toString()); //Guarda tablero del alumno 
			juego.actualiza();
		}
		s.close();
		
		//Comprobación del contenido del tablero del alumno
		Coordenada2D c;
		for (int i=0; i<10; i++)
			for (int j=0; j<15; j++) {
				c = new Coordenada2D(i,j);
				assertEquals("Estado ("+i+","+j+")",tableroconmaspatrones.getCelda(c),juego.getTablero().getCelda(c));
			}
	}

	/**
	 * Test actualiza todo vivo.
	 *
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Test
	public void testActualizaTodoVivo() throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {
	
		Juego juego1 = new Juego(new TableroCeldasCuadradas(new Coordenada2D(4,4)),regla);
		juego1.cargaPatron(patronbloque, new Coordenada2D(0,0));
		juego1.cargaPatron(patronbloque, new Coordenada2D(2,0)); 
		juego1.cargaPatron(patronbloque, new Coordenada2D(0,2));
		juego1.cargaPatron(patronbloque, new Coordenada2D(2,2));
	
	
		/*Fichero con los tableros que el alumno genera para que pueda hacer un seguimiento
		de sus actualizaciones en caso de error. */
		PrintStream s = abrirFichero("test/ficheros/tablerostodovivo.sal"); 
		for (int i=0; i<3; i++) {
			s.print(juego1.getTablero().toString()); //Guarda tablero del alumno 
			juego1.actualiza();
		}
		s.close();
		
		//Comprobación del contenido del tablero del alumno
		Coordenada2D c;
		for (int i=0; i<4; i++)
			for (int j=0; j<4; j++) {
				c = new Coordenada2D(i,j);
				assertEquals("Estado ("+i+","+j+")=MUERTA",EstadoCelda.MUERTA,juego1.getTablero().getCelda(c));
			}
	}
	
	/**
	 * Test method for {@link modelo.Juego#getTablero()}.
	 */
	@Test
	public void testGetTablero() {
		
		assertSame("GetTablero",tablero,juego.getTablero());
	}

	/**
	 * Test method for {@link modelo.Juego#getPatrones()}.
	 */
	@Test
	public void testGetPatrones() {
		assertSame("GetPatrones",patrones.size(),juego.getPatrones().size());
	}
	
	/*------------------------- FIN TESTS ----------------------*/
	
	/* FUNCIONES AUXILIARES */
	
	/**
	 * Crea patrones.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	private static void CreaPatrones() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Tablero tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(3,3));
		tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,0), EstadoCelda.MUERTA);

		tableroPatron.setCelda(new Coordenada2D(0,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(1,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(2,1), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada2D(0,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,2), EstadoCelda.VIVA);
		patronglider = new Patron("Glider", tableroPatron);	

		// creamos otro patrón
		tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(2,2));
		tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,1), EstadoCelda.VIVA);

		patronbloque = new Patron("Bloque", tableroPatron);		
		
		// otro más
		tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(3,1));
		tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,0), EstadoCelda.VIVA);

		patronparpadeador = new Patron("Parpadeador", tableroPatron);	
		
		tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(3,3));
		tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,0), EstadoCelda.MUERTA);

		tableroPatron.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(2,1), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada2D(0,2), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(1,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,2), EstadoCelda.MUERTA);
		patronbarco = new Patron("Barco", tableroPatron);
		
		tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(4,2));
		tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(3,0), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(1,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(2,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada2D(3,1), EstadoCelda.MUERTA);
		patronsapo = new Patron("Sapo", tableroPatron);

	}
	
	
	/**
	 * Abrir fichero.
	 *
	 * @param fichero the fichero
	 * @return the prints the stream
	 */
	//Abre un fichero para escribir las tablas que genera el alumno.
	private PrintStream abrirFichero (String fichero) {
		PrintStream s=null;
		try {
			s = new PrintStream(fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
   /**
    * Inicia tableros resultado.
    *
    * @param dim the dim
    * @param fichero the fichero
    * @return the tablero
    * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
    * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
    */
   //Inicia un tablero con dimensiones dim a partir del contenido de un fichero
   private static Tablero IniciaTablerosResultado(Coordenada2D dim,String fichero) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
	   Scanner s;
	   Tablero tablero=null;
	try {
		s = new Scanner(new File(fichero));
		int x =((Coordenada2D)dim).getX();
		int y =((Coordenada2D)dim).getY();
	   tablero = new TableroCeldasCuadradas(new Coordenada2D(x,y));
	   s.nextLine();
	   String linea;
	   for (int j=0; j<y; j++) {
		   linea = s.nextLine();
		   for (int i=0; i<x+1; i++)
		   {
			 
			  if (linea.charAt(i+1)==' ') tablero.setCelda(new Coordenada2D(i,j),EstadoCelda.MUERTA);
			  else if (linea.charAt(i+1)=='*') tablero.setCelda(new Coordenada2D(i,j), EstadoCelda.VIVA);
		   }
		 }
	    s.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    return tablero;
   }
   
   /**
    * Comprueba mensaje de error.
    *
    * @param sc the sc
    * @param spatron the spatron
    * @param scoord the scoord
    */
   //Comprueba los errores de cargaPatron generados por el alumno y contenidos en un fichero.
   private void CompruebaMensajeDeError (Scanner sc, String spatron,String scoord){
		String error;
		String errorpatron="Error cargando plantilla "+spatron+" en "+scoord;
		if (sc.hasNext()) {
	    	error=sc.nextLine();
	    	assertTrue("Error Celda",error.contains("Error: La celda"));
	    	error=sc.nextLine();
	    	assertEquals("Error carga patron", error,errorpatron);
	    }
	}
   
/**
 * Redireccionar salidas standard A fichero.
 *
 * @param fic the fic
 * @return the prints the stream
 */
//Redireccionamiento de las salidas standard a un fichero
   private PrintStream redireccionarSalidasStandardAFichero(String fic) {
	   PrintStream ps=null;
	   try {
		   ps = new PrintStream(fic);
		   System.setOut(ps);
		   System.setErr(ps);
	   } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	  			
	   return (ps);
}

/**
 * Restaurar salidas standard.
 */
//Restaura las salidas standard
   private void restaurarSalidasStandard() {
	   System.setOut(salstd);
	   System.setErr(errstd);
   }
}