package problemas_datos;

public  class nodo 
{
	int Dato;
	int [] array ;
	float dato;
	String cadena;
	nodo next = null;
	
	
	public nodo(int a)
	{
		this.Dato = a;
	}
	public nodo(String a, float  b)
	{
		this.cadena = a;
		this.dato = b;
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
