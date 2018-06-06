package SpecialData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import Data.Vector;



public class Stack {
	
	public nodo head;
	
	public Stack() 
	{
		this.head = null;
	}
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public void push(nodo newNode)
	{
		if(!this.isEmpty())
		{
			newNode.next = this.head;
			this.head = newNode;
		}
		else
		{
			this.head = newNode;
		}
	}
	
	public String pop()
	{
		nodo toPop = this.head;
		this.head = this.head.next;
		String data = toPop.toString();
		toPop = null;
		System.gc();
		return data;
	}
	public Vector popV()
	{
		nodo toPop = this.head;
		this.head = this.head.next;
		return toPop.vector;

	}
	public String peek()
	{
		return this.head.toString();
	}
	
	public void printStack() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Grades:\n");
		while(!isEmpty())
			bw.write(pop());
		bw.flush();
	}
	

	
}