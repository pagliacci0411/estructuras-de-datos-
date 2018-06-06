package Data;

public class Lugar 
{
	private double X;
	private double Y;
	
	private String Nombre;
	private String info;
	private String tipo;
	public Lugar(double x, double y, String nombre, String info,String tipo)
	{
		this.X = x;
		this.Y = y;
		this.Nombre = nombre;
		this.info = info;
		this.tipo = tipo;
	}
	
	public Lugar()
	{
		this.X = 0;
		this.Y = 0;
		this.Nombre = "";
	}
	
	public double getX()
	{
		return this.X;
	}
	
	public double getY()
	{
		return this.Y;
	}
	
	public String getNombre()
	{
		return this.Nombre;
	}
	
	public String getInfo()
	{
		return this.info;
	}
	
	public String getTipo()
	{
		return this.tipo;
	}
	
	public void setX(double x)
	{
		this.X = x;
	}
	
	public void setY(double y)
	{
		this.Y = y;
	}
	
	public void setNombre(String nombre)
	{
		this.Nombre = nombre;
	}
	
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
}
