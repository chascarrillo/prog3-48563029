package modelo.excepciones;

public class ExcepcionArgumentosIncorrectos
extends ExcepcionEjecucion
{
	public ExcepcionArgumentosIncorrectos()
	{
		super("Parametro incorrecto, no deberia ser null");
	}
}
