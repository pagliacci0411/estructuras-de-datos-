package bla;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import org.w3c.dom.Node;

public class list 
{

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
	
	public void eliminaralinicio () 
		{
		nodo temp = head;
		head = head.next;
		temp = null;
		System.gc();
		}
	public void agregarEnElmedio(nodo newnodo, int a) 
	{ int posicion = a;
		/**int posicion = a;
		 *  nodo temp = head;
		 for(int i = 1 ; i < posicion -1 ; i++ )
		 {
			 temp = temp.next;
		 }
		 newnodo.next = temp.next;
		 temp.next = newnodo;
		 *  	
		 */
		nodo temp = head;
		 for(int i = 0 ; i < posicion -1 ; i++ )
		 {
			 temp = temp.next;
		 }
		 newnodo.next = temp.next;
		 temp.next = newnodo;
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
	public void eliminarEnElmedio ( int a)
	{
		/**int posicion = a;
		nodo temp = head;
		 for(int i = 1 ; i < posicion -1 ; i++ )
		 {
			if (i != posicion) 
				temp = temp.next;
		 }
		 temp = temp.next;
		 temp = null;
		System.gc();
		 * 
		 */
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
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter (System.out));
		nodo temp = head;
		try
		{
			bw.write("grades : \n");
			while (temp != null)
			{
				bw.write(temp.toString());
				temp = temp.next;
			}
			bw.flush();
		}
		catch(Exception ex) {ex.printStackTrace();}
		}
	/**
	 * 
	 * @param args
	 */
		public  void inversa ()
		{
		pilas temppila = new pilas();
		nodo temp = head;
		while (temp != null)
			{
			temppila.push(temp.clon());
			
			temp = temp.next;
			
			}
			head = temppila.head;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list grades = new list();
		
		grades.printlist();
		grades.insertAtBegin(new nodo("task 1", 3.5));
		grades.printlist();
		grades.insertAtBegin(new nodo ("quiz 1", 1.5));
		grades.printlist();
		grades.eliminaralinicio();
		grades.printlist();
		grades.insertAtBegin(new nodo ("quiz 2", 2.5));
		grades.insertAtBegin(new nodo ("quiz 3", 4.5));
		grades.printlist();
		/**
		 * grades.eliminarEnElmedio(1);
		 * grades.printlist();
		 */
		grades.agregarEnElmedio(new nodo ("quiz 4", 3.5), 2);
		grades.printlist();
		grades.eliminarAlFinal();
		grades.printlist();
		grades.agregarEnElmedio(new nodo ("quiz 5", 0.5), 2);
		grades.printlist();
		grades.eliminarEnElmedio(2);
		grades.printlist();
		grades.inversa();
		grades.printlist();
	}

}
