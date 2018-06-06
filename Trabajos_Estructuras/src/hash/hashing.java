package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class hashing 
{
	int tamaño;
	ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	hashing(int a)
	{
		this.tamaño = a;
		for(int i = 0; i < tamaño; i++)
		{
			array.add(new ArrayList<Integer>());
			
		}
				
	}
	public void insetar(int [] a) 
	{
		
		
		for(int i = 0; i < a.length; i++)
		{
			array.get(a[i]% tamaño).add(a[i]);
			
		}
	}
	
	public void quitar(int c) 
	{	
		array.get(c%tamaño).remove(c);
		
	}
	public boolean buscar(int b) 
	{
		return array.get(b%tamaño).contains(b);
	}
	public void imprimir() 
	{
		for (int i = 0; i< tamaño; i++)
		{
			
			System.out.print(array.get(i));
			
			System.out.println();
		}
	}

	 public static void main(String args[]) throws IOException
	 {	
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		 hashing jemplo = new hashing(t);
		 String aux = br.readLine();
		 String [] temp = aux.split(",");
		 int [] numeros = new int[temp.length];
		 for(int i = 0;i < temp.length ;i++)
		 	 numeros[i]= Integer.parseInt(temp[i]);
		 jemplo.insetar(numeros);
		 jemplo.imprimir();
		 //jemplo.quitar(77);
		 System.out.println(jemplo.buscar(50));
	 }
	 
	
}
