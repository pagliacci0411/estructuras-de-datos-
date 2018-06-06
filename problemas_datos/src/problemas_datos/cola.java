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
	public int encontrar_posicion(int a)
	{ 	nodo temp = head;
		int posicion = 1;
		while(temp.Dato != a)
		{
			temp =  temp.next;
		posicion = posicion +1;
		}
		return posicion;
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
	
}
