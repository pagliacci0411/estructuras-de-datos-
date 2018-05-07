package problemas_datos;


public class pila {
	nodo head = null;

	public void push (nodo newnodo)
	{
		newnodo.next = head;
		head = newnodo;		
	}
	
	public String pop ()
	{
		nodo temp = head;
		head = head.next;
		String info = temp.toString();
		temp = null;
		System.gc();
		return info;
	}
	
	public void printpila ()
	{
		nodo temp = head;
		while (temp != null)
		{
		System.out.println(temp.Dato);
		temp = temp.next;
		}
	}
	public void printpila_array(int a) 
	{
		nodo temp = head;
		while (temp != null)
		{
			for (int i= 0; i < a ; i++ ) 
			{
				System.out.print(temp.array[i] + "," );
			}
			System.out.print("\n");
		temp = temp.next;
		}
	}
	public int numero_de_datos () 
	{  int contador = 0;
		nodo temp = head;
		while (temp != null)
		{
			temp = temp.next;
			contador = contador +1;
		}
		
		return contador ;
	}
	
	
}
