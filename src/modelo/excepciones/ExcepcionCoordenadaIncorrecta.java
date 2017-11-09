package modelo.excepciones;

public class ExcepcionCoordenadaIncorrecta
extends Exception
{
	private float x;
	private float y;
	public ExcepcionCoordenadaIncorrecta(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
}
