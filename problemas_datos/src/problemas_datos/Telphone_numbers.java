package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Telphone_numbers {

	public static void main(String[] args)  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list numeros =  new list();
				
		System.out.println("ingrese el numero de números");
		String entrada = br.readLine(); 
		int numero_numeros =  Integer.parseInt(entrada);
		
		for(int i = 1; i < numero_numeros + 1; i ++)
		{   
			System.out.println("ingrese el numero " + i);
			String entrada1 = br.readLine(); 
			int temp = Integer.parseInt(entrada1);
			numeros.llenar_lista(new nodo(temp));;
		}
		
		nodo temp = numeros.head;
		pila temptelefonos = new pila();
		
		
		for (int i = 0 ; i < numero_numeros; i++)
		{
					
			while (temp.Dato / 10 != 0)
			{
			 temptelefonos.push(new nodo(temp.Dato % 10));
			
			 temp.Dato = temp.Dato / 10;
			}
			temptelefonos.push(new nodo(temp.Dato));
			 temp = temp.next;
			
		}	
	
		
		pila telefonos = new pila();
		int tamaño_del_arreglo =  temptelefonos.numero_de_datos() /  numero_numeros;
		
		for (int i = 0; i < numero_numeros; i++)
		{
			int [] arreglo = new int [tamaño_del_arreglo ] ;
			
			for(int j = 0; j < tamaño_del_arreglo; j++)
			{	
				arreglo[j] = temptelefonos.head.Dato;
				temptelefonos.pop();
			}
			
			telefonos.push(new nodo ( arreglo));
		}
		
		int contador = 0;
			
		for (int j = 0; j < tamaño_del_arreglo; j++) 
		{	
			nodo aux = telefonos.head;				
			
			while (aux.next != null ) 
			{	
				if(aux.array[j] ==aux.next.array[j])
					contador = contador +1;
				
				aux = aux.next;
			}		
		}
		System.out.println(contador);			
		
	}

}
