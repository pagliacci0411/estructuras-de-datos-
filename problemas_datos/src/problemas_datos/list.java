package problemas_datos;


public class list 
{
	nodo head = null;
	
	public boolean isEmpty() 
	{
	 return head == null? true: false;
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
	public void eliminaralinicio () 
	{
	nodo temp = head;
	head = head.next;
	temp = null;
	System.gc();
	}
	
	public void buscar_en_lista_marbles (int [] a )
	{    	
		for(int i = 0; i< a.length ; i++)
		{
			int contador = 0;
			int posicion = 1;
			nodo temp = head;
		  while (temp != null) 
		  {
			  if (a[i] == temp.Dato) 
			  {
				  contador = contador + 1;
				  System.out.println(a[i] + " encontrado en  la posicion : " + posicion);
			  }
			  
			  temp = temp.next;
			  posicion = posicion + 1 ;
		 }
		  System.out.println("se encontraron " + contador +" - "+ a[i] );
		  
		}
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
	
	public void eliminarEnElmedio ( int a)
	{
		nodo temp = head;
		nodo todelete;
		for (int i = 0 ; i < a -1; i++)
			temp = temp.next;
		
		todelete = temp.next;
		temp.next = temp.next.next;
		todelete = null;
		System.gc();
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

