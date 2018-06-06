package SpecialData;
import processing.core.PApplet;

public class list {
nodo head = null;
PApplet parent;
	public boolean isEmpty() 
	{
	 return head == null? true: false;
	}
	 void display() {
		    parent.println(head.Dato);
		    
		  }
	public  void llenar_lista(nodo nuevo_nodo)
	{
		{
			if (isEmpty())
				head = nuevo_nodo;
			else 
			{
				nodo temp = head;
				while (temp.next != null)
				temp = temp.next;
				
				temp.next = nuevo_nodo;					
			}
			}		
	}
	public int tamaño () 
	{
		int contador = 0;
		nodo temp =  head;
		while(temp.next == null)
		{
			temp = temp.next;
			contador++;
		}
		System.out.println(contador);
		return contador;
	}
	
	
	
	
	
	
	public void printlist ()
	{
		nodo temp = head;
		while (temp != null)
		{
		System.out.println(temp.Dato);
		temp = temp.next;
		}
		}
	
}
