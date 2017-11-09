package modelo.excepciones;

public class ExcepcionEjecucion
extends RuntimeException
{
	public ExcepcionEjecucion(String mensaje)
	{
		System.err.println(mensaje);
	}

	public ExcepcionEjecucion(Throwable causa)
	{
		causa.printStackTrace();
	}
}
