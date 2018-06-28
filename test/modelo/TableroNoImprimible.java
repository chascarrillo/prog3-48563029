/**
 * 
 */
package modelo;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * @author gonzalo
 *
 */

final public class TableroNoImprimible<TipoCoordenada extends Coordenada> extends Tablero<TipoCoordenada> {
			
		public TableroNoImprimible(TipoCoordenada dimensiones)
				throws ExcepcionCoordenadaIncorrecta {
			super(dimensiones);
			// TODO Auto-generated constructor stub
		}

		@Override
		public ArrayList<TipoCoordenada> getPosicionesVecinasCCW(Coordenada posicion)
				throws ExcepcionPosicionFueraTablero {
			// TODO Auto-generated method stub
			return null;
		}
		
	
}
