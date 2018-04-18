package bla;

public class cola {
	nodo head = null;

	public boolean isEmpty() 
	{
		return head == null? true: false;
	}
	public void insertAtBegin (nodo newnodo) 
	{
		newnodo.next = head;
		head = newnodo ;

	}
	public void insertarAtEnd (nodo newnodo) 
	{
		if (isEmpty())
			head = newnodo;
		else 
		{
			nodo temp = head;
			while (temp.next != null)
				temp = temp.next;
	
			temp.next = newnodo;
			
		}
	}
	public void eliminarAlFinal () 
	{
			nodo temp = head;
		while (temp.next.next != null)
		{
			temp = temp.next;
		}
		temp.next = null;
		System.gc();
			
		
	}
}
