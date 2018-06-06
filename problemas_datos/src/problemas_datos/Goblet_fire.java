package problemas_datos;
/*
 * CORREGIR COMAS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goblet_fire 
{	
	public static void main(String[] args)throws IOException 
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	cola students = new cola();
	cola resultados = new cola();
	
	String entrada1 =  br.readLine();
	int numero_operaciones = Integer.parseInt(entrada1);
	
	for (int i =0; i< numero_operaciones;i++)
	{
		pila aux = new pila();
		String Entrada_i = br.readLine(); 
		String [] operaciones = Entrada_i.split(" ");
		int [] array = new int[2] ;
				
					
		if(operaciones[0].equals("E"))
		{ 	
			array [0] = Integer.parseInt(operaciones[1]);
			array [1] = Integer.parseInt(operaciones[2]);

			if(students.head == null)
				students.llenar_cola(new nodo(array));
				
			else
			{
				nodo temp =  students.head;
				while(temp != null)
				{
					aux.push(new nodo(temp.array));
					temp = temp.next;
					
				}
				
				 nodo temp1 = aux.head;
				 
				while(temp1.array[0] != array [0]  )
				{
					
					temp1 = temp1.next;
					if(temp1 == null)
						break;
				}
				
				if (temp1 == null)
				{
					students.llenar_cola(new nodo(array));
					
				}
				 
				else
				{
					nodo aux2 = students.head;
					while(temp1.array!= aux2.array ) 
					{
						aux2 = aux2.next;
					}
					nodo a =new nodo(array);
					a.next = aux2.next;
					aux2.next= a;
				}
			
			}
			
		}
		
		else if (operaciones[0].equals("D"))
		{	nodo temp = students.head;
			students.vaciar_cola();
			resultados.llenar_cola(new nodo (temp.array));
		}
		else 
			System.out.print("operacion no valida" );
		
		
	}
	resultados.printpila_array(2);
	
	
	}
	
	
}
