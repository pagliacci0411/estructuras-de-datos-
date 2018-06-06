package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monk_and_Prisoner_of_Azkaban 
{

	public static void main(String[] args)throws IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Array_lenght;
		pila LHI = new pila();
		cola RHI = new cola();
		String entrada1 = br.readLine(); 
		Array_lenght = Integer.parseInt(entrada1);
		String entrada2 = br.readLine(); 
		String [] numeros = entrada2.split(" ");
	for(int i= 0; i< Array_lenght;i++)
	{
		LHI.push(new nodo(Integer.parseInt(numeros[i])));
		RHI.llenar_cola(new nodo(Integer.parseInt(numeros[i])));
	}
		//RHI.printcola();
		//LHI.printpila();
		int [ ] x = new int[Array_lenght];//PILA LHI
		int [ ] y = new int[Array_lenght];
		int [ ] Xplusy = new int[Array_lenght];
		
		nodo temp = RHI.head;
		nodo temp_RHI ;
		nodo aux= LHI.head;
		nodo aux_LHI ;
	
		int i = 0;
		int j =Array_lenght -1 ;
			while(temp != null) 
			{
			
			temp_RHI = temp.next;
			if(temp_RHI != null)
			while(temp_RHI.Dato < temp.Dato)
			{	
				temp_RHI = temp_RHI.next;
				if(temp_RHI == null)
					break;
			}
			
			if(temp_RHI ==null)
				x[i] = -1;
				
			else
				x[i] =  RHI.encontrar_posicion(temp_RHI.Dato);
			
			i = i+1;
			
			temp = temp.next;
			}
			
			while(aux != null) 
			{			
			aux_LHI = aux.next;
			if(aux_LHI != null)
			while(aux_LHI.Dato < aux.Dato)
			{	
				aux_LHI = aux_LHI.next;
				if(aux_LHI == null)
					break;
			}
			
			if(aux_LHI ==null)
				y[j] = -1;
				
				
			else
				y[j] = RHI.encontrar_posicion(aux_LHI.Dato);
			
			j= j-1;
			
			aux = aux.next;
			}
			
			for(int u= 0; u< Array_lenght;u++)
			{
			 Xplusy[u]= x[u] +y[u];
			 System.out.print( Xplusy[u]+ " ");
			}
			
	}

}
