package Ordenamient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ordenamiento 
{
	public static void Insertion(int[] unsorted)
	{
		for(int i = 1; i < unsorted.length ; i++)
		{
			
			int aux = unsorted[i];
			
			int indice = i;
			while( indice > 0 && unsorted[indice-1] > aux)
			{
				unsorted[indice] = unsorted[indice-1];
				indice= indice -1;
			
			}
			unsorted[indice] = aux;
		
		}
	}
	public static void Bubble(int[] Array)
	{
		
		boolean cambiado; 
		
		int ultimo_indice = Array.length; 
		
		do
		{
			cambiado = false;
		
			for(int i = 0; i < ultimo_indice - 1; i++)
			{
				
				if(Array[i] > Array[i + 1])
			
				{
					int swapp = Array[i];
					Array[i] = Array[i + 1];
				
					Array[i + 1] = swapp;
					cambiado = true;
				}
			}
			ultimo_indice--;
			
		
		}while(cambiado);
	}
	
	public static void Counting(int[] Unsorted)
	{
		int Mayor = Integer.MIN_VALUE;
		int indice = 0;
		for(int i : Unsorted)
			if(i > Mayor)
				Mayor = i;
		
		int[] temp = new int[Mayor + 1];
		
		for(int i : Unsorted)
			temp[i]++;
		
		for(int i = 0; i < temp.length ; i++)
			for(int j = 0 ; j < temp[i]; j++)
			{
				Unsorted[indice] = i;
				indice++;
			}
	}
	
	
	public static int[] MergeSort(int[] unsorted)
	{
		int size;
		
		if(unsorted.length > 1)
		{
			size = unsorted.length / 2;
			int[] left_array = new int[size];
			int[] rigth_array = new int[unsorted.length - size];
		
			for(int i = 0; i < size; i++)
				left_array[i] = unsorted[i];
			for(int i = size ; i < unsorted.length ; i++)
				rigth_array[i- size] = unsorted[i];
			
			left_array = MergeSort(left_array);
			rigth_array = MergeSort(rigth_array);
			
			return Merge(left_array, rigth_array);
		}
		
		return unsorted;
	}
	
	public static int[] Merge(int[] a, int[] b)
	{
		int Size = a.length + b.length;
		int[] c = new int[Size];
		int indice_a = 0, indice_b = 0, indice_c = 0;
		
		while(indice_a < a.length && indice_b < b.length)
		{
			if(a[indice_a] < b[indice_b])
			{
				c[indice_c]  = a[indice_a];
				indice_a++;
			}
			else
			{
				c[indice_c] = b[indice_b];
				indice_b++;
			}
			indice_c++;
		}
		
		while(indice_a < a.length)
		{
			c[indice_c] = a[indice_a];
			indice_a++;
			indice_c++;
		}
		
		while(indice_b < b.length)
		{
			c[indice_c] = b[indice_b];
			indice_b++;
			indice_c++;
		}
			
		return c;
	}
	
	
	public static int[] BigArray(int lenght)
	{
		Random rd = new Random();
		int[] temp = new int[lenght];
		
		for(int i = 0 ; i < lenght ; i++)
			temp[i] = rd.nextInt(40);
		
		return temp;
	}
	
	public static void printArray(int[] Array) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < Array.length ; i++)
		{
			bw.write(Array[i]+",");	 
			if(i%20 == 0 && i !=0)
				bw.write("\n");
		}
		bw.write("\nEOF \n");
		bw.flush();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] array = br.readLine().split(" ");
		int[] arr = new int[array.length];
		
		for(int i = 0 ; i < arr.length ; i++)
		arr[i] = Integer.parseInt(array[i]);
		
		Counting(arr);
		
		printArray(arr);
	}
}
