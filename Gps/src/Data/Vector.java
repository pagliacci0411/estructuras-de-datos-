 package Data;

import java.util.ArrayList;




public class Vector {
	
	private double X;
	private double Y;
	private int id;
	private int prevID;
	public boolean stat ; 
	private ArrayList<Vector> ramas;
	
	public Vector(double x, double y)
	{
		this.X = x;
		this.Y = y;
		this.ramas = new ArrayList<>();
		this.prevID = -1;
		this.id = -1;
		this.stat = false;
	}
	
	public Vector()
	{
		this.X = 0;
		this.Y = 0;
		this.id = 0;
		this.ramas = new ArrayList<>();
		this.prevID = -1;
	}

	public ArrayList<Vector> getRamas()
	{
		return this.ramas;
	}
	
	public int getPrevId()
	{
		return this.prevID;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public double getX()
	{
		return this.X;
	}
	
	public double getY()
	{
		return this.Y;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setX(double x)
	{
		this.X = x;
	}
	
	public void setY(double y)
	{
		this.Y = y;
	}
	
	public double Size()
	{
		return (Math.sqrt(Math.pow(this.X,2) + Math.pow(this.Y, 2)));	
	}
	
	public void setPrevId(int pid)
	{
		this.prevID = pid;
	}
	
	public double SizeVectorFlotante(Vector cabeza)
	{
		Vector temp = new Vector(cabeza.getX() - this.X , cabeza.getY() - this.Y);
		return temp.Size();
	}
	
	public String toString()
	{
		return "Id : " + this.getId() + " [ " + this.getX() + ", " + this.getY() + " ]";
	}
}
