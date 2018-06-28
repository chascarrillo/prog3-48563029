package mains;

import java.util.ArrayList;

import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Patron;
import modelo.Tablero;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Main2_P3.
 *
 * @author drizo
 */
public class Main2_P3 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// creamos un patrón
		Tablero tableroPatron = null;
		Tablero tableroPatron2 = null;
		Patron patron = null;
		Patron patron2 = null;
		Patron patron3 = null;
		try {
			tableroPatron = new TableroCeldasCuadradas(new Coordenada2D(3,3));
			tableroPatron.setCelda(new Coordenada2D(0,0), EstadoCelda.MUERTA);
			tableroPatron.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
			tableroPatron.setCelda(new Coordenada2D(2,0), EstadoCelda.MUERTA);
	
			tableroPatron.setCelda(new Coordenada2D(0,1), EstadoCelda.MUERTA);
			tableroPatron.setCelda(new Coordenada2D(1,1), EstadoCelda.MUERTA);
			tableroPatron.setCelda(new Coordenada2D(2,1), EstadoCelda.VIVA);
	
			tableroPatron.setCelda(new Coordenada2D(0,2), EstadoCelda.VIVA);
			tableroPatron.setCelda(new Coordenada2D(1,2), EstadoCelda.VIVA);
			tableroPatron.setCelda(new Coordenada2D(2,2), EstadoCelda.VIVA);
			patron = new Patron("Glider", tableroPatron);	
	
			// creamos otro patrón
			tableroPatron2 = new TableroCeldasCuadradas(new Coordenada2D(2,2));
			tableroPatron2.setCelda(new Coordenada2D(0,0), EstadoCelda.VIVA);
			tableroPatron2.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
	
			tableroPatron2.setCelda(new Coordenada2D(0,1), EstadoCelda.VIVA);
			tableroPatron2.setCelda(new Coordenada2D(1,1), EstadoCelda.VIVA);
			patron2 = new Patron("Bloque", tableroPatron2);		
			
			// otro más
			Tablero tableroPatron3 = new TableroCeldasCuadradas(new Coordenada2D(3,1));
			tableroPatron3.setCelda(new Coordenada2D(0,0), EstadoCelda.VIVA);
			tableroPatron3.setCelda(new Coordenada2D(1,0), EstadoCelda.VIVA);
			tableroPatron3.setCelda(new Coordenada2D(2,0), EstadoCelda.VIVA);

			patron3 = new Patron("Parpadeador", tableroPatron3);				
		} catch (ExcepcionCoordenadaIncorrecta e) {
			e.printStackTrace(); //ESTO NO DEBE SALIR NUNCA
		} catch (ExcepcionPosicionFueraTablero e) {
			e.printStackTrace(); //ESTO NO DEBE SALIR NUNCA
		}

		// lo cargamos en un tablero y jugamos
		try {
			Tablero t = new TableroCeldasCuadradas(new Coordenada2D(10,5));
			ReglaConway r = new ReglaConway();
			Juego juego = new Juego(t, r);
			juego.cargaPatron(patron, new Coordenada2D(0,0));
			try {
				juego.cargaPatron(patron2, new Coordenada2D(10,5)); // aquí no se debería cargar
			} catch (ExcepcionPosicionFueraTablero e) {
				System.err.println("Error cargando plantilla " + patron2.getNombre() + ":" + e.getMessage());
			}
			juego.cargaPatron(patron2, new Coordenada2D(8,3)); // aquí sí
			juego.cargaPatron(patron3, new Coordenada2D(7,0));
	
			System.out.println("Patrones usados:");
			ArrayList<Patron> patrones = juego.getPatrones();
			for (Patron p: patrones) {
				System.out.println(p.toString());
			}
			System.out.println("Juego:");
			for (int i=0; i<5; i++) {
				System.out.println(juego.getTablero().toString());
				juego.actualiza();
			}
			System.out.println(juego.getTablero().toString());
		} catch (Exception e) {
			e.printStackTrace(); // NO DEBE SALTAR NUNCA, EL UNICO ERROR YA SE HA CAPTURADO
		}
		
	}

}
