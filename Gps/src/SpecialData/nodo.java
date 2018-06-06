package SpecialData;

import Data.Vector;

public class nodo {
	int Dato;
	int [] array ;
	float dato;
	String cadena;
	public nodo next ;
	public Vector vector;
	
	public nodo(int a)
	{
		this.Dato = a;
		this.next = null;
	}
	public nodo(String a, float  b)
	{
		this.cadena = a;
		this.dato = b;
		this.next = null;
	}

	public nodo()
	{
		this.vector = null;
		this.next = null;
	}
	public String toString()
	{
		return this.vector.toString() + "\n";
	}
	public nodo (int [] a) 
	{
		this.array = a ;
	}
	
	public void enlazar (nodo otronodo)
	{
		next = otronodo;
	}
}
