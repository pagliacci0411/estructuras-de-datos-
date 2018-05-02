package asfddsafdsf;

public class nodo 
{
	nodo der = null;
	nodo izq= null;
	int value;
	public nodo (int dato) 
	{
		this.value = dato;
	}
	
	public String  tostring ( ) 
	{
		return "value:" + this.value + "\n";
	}
	
	public nodo clone()
	{
		return new nodo (this.value);
	}
}
