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

