package bla;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class pilas {

	nodo head = null;
	public boolean isEmpty() 
		{
		 return head == null? true: false;
		}
	
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
	public String peek ()
	{
	
		nodo temp = head;
		String info = temp.toString();
		return info;
	}
	public void printpila ()
	{
	BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter (System.out));
	nodo temp = head;
	try
	{
		bw.write("grades : \n");
		while (!isEmpty())
		bw.write(pop());
			
		
		bw.flush();
	}
	catch(Exception ex) {ex.printStackTrace();}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pilas grades2 = new pilas();
		grades2.push(new nodo("task 1", 3.5));
		grades2.push(new nodo("task 2", 2.5));
		grades2.pop ();
	
	
	}
	
	
}
