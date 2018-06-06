package SpecialData;

import Data.Vector;

public class Node {
	private double Size;
	private Vector vector;
	public boolean stat;
	public Node(double Size, Vector v)
	{
		this.Size = Size;
		this.vector = v;
		this.stat = false;
	}
	

	
	public double getSize()
	{
		return this.Size;
	}
	public Vector getVector()
	{
		return this.vector;
	}
	public void setSize(double newSize)
	{
		this.Size = newSize;
	}
	
	public void setVector( Vector newVector)
	{
		this.vector = newVector; 
	}
	
	public Node Clone()
	{
		return new Node(this.Size, this.vector);
	}
}
