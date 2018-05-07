package problemas_datos;


public class cola {

	nodo head = null;

	public boolean isEmpty() 
	{
		return head == null? true: false;
	}
	
	public void llenar_cola (nodo nuevo_nodo) 
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
	
	public nodo buscar_string(String a)
	{
		nodo temp = head;
		while(!a.equals(temp.cadena)) 
		{
			temp = temp.next;
		}
		return temp;
	}
	
	public void vaciar_cola () 
	{
		nodo temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	
	public void printcola ()
	{
		nodo temp = head;
		while (temp != null)
		{
		System.out.println(temp.Dato);
		temp = temp.next;
		}
	}
	
	
	
}
