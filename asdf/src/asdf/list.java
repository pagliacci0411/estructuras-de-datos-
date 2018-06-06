package asdf;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;

public class list 
{

	public secuence head ;
	
	public void List()
	{
		this.head = null;
	}
	public boolean isEmpty() 
		{
		 return head == null? true: false;
		}
	
		public void insertAtBegin (secuence newsecuence) 
		{
		newsecuence.next = head;
		head = newsecuence ;
		
		}
	public void insertarAtEnd (secuence newsecuence) 
		{
		if (isEmpty())
			head = newsecuence;
		else 
		{
			secuence temp = head;
			while (temp.next != null)
			temp = temp.next;
			
			temp.next = newsecuence;
					
		}
		}
	
	public void eliminaralinicio () 
		{
		secuence temp = head;
		head = head.next;
		temp = null;
		System.gc();
		}
	public void agregarEnElmedio(secuence newsecuence, int a) 
	{ int posicion = a;
		secuence temp = head;
		 for(int i = 0 ; i < posicion -1 ; i++ )
		 {
			 temp = temp.next;
		 }
		 newsecuence.next = temp.next;
		 temp.next = newsecuence;
	}
	 public void eliminarAlFinal () 
	 {
		  secuence temp = head;
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
		secuence temp = head;
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
		secuence temp = head;
		secuence todelete;
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
		secuence temp = head;
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
	public char[] Size() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
