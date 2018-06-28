package modelo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mains.FileUtils;
import modelo.Coordenada;
import modelo.Juego;
import modelo.Patron;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import entradasalida.Factory;
import entradasalida.IGeneradorFichero;
import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;

public class MetodosAuxiliares<TipoCoordenada extends Coordenada> {
	
	 @SuppressWarnings("unchecked")
	protected void run(TipoCoordenada dimensiones, TipoCoordenada posicionCargaPatron, String cadena, String fichero, int iteraciones) throws ExcepcionPosicionFueraTablero, ExcepcionGeneracion, ExcepcionCoordenadaIncorrecta, ExcepcionLectura {
		Tablero<TipoCoordenada> tablero = Factory.creaTablero(dimensiones);
		Regla<TipoCoordenada> regla = Factory.creaRegla(tablero);		
		Tablero<TipoCoordenada> tableroPatron = ParserTableros.leeTablero(cadena);
		Patron<TipoCoordenada> p = new Patron<TipoCoordenada>("Entrada", tableroPatron);
		
		Juego<TipoCoordenada> juego = new Juego<TipoCoordenada>(tablero, regla);
		juego.cargaPatron(p, posicionCargaPatron);
		IGeneradorFichero generador = Factory.creaGeneradorFichero(tablero, FileUtils.getFileExtension(fichero));
		generador.generaFichero(new File(fichero), juego, iteraciones);		
	}


	protected boolean ComparaFicheros(String f1, String f2) {
		String comando[] = {"diff",f1,f2};
		if (!new File(f1).exists())  {
			System.out.println("El fichero "+f1+ "no existe.");
			return false;
		}
		if (!new File(f1).exists())  {
			System.out.println("El fichero "+f1+ "no existe.");
			return false;
		}
		try {
		 
			// Ejecutamos el comando definido
			Process p = Runtime.getRuntime().exec(comando);
      
			// Instanciamos un lector del buffer para mostrar resultado
			BufferedReader resultado = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// System.out.println("Resultado del comando:");
			String diferencias = resultado.readLine();
			if (diferencias!=null && diferencias.length()!=0) {
				while (diferencias!= null){
					System.out.println(diferencias);
					diferencias=resultado.readLine();
				}
				return false;
			}
			else return true;
		} catch (IOException ex) {
        return false;
		}
	}
	
	protected String cargaTablero(String fichero) throws IOException {
		 File f= new File(fichero);
		 FileReader fr1=null;
		 String cad = null;
		
			fr1 = new FileReader(f);
		// Create char array of file length
			char[] c1=new char[(int)f.length()];
			cad = new String();
		// Dump from 0 to end into c1
		
			fr1.read(c1,0,c1.length);

			for(int i=0;i<c1.length;i++)
				cad=cad+c1[i];

			// Close FileReader
			fr1.close(); 
		
		return cad;
	  }
	
}
