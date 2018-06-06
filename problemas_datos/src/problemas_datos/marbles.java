package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class marbles {
	
		public static void main(String[] args) throws IOException
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 
			list marbles = new list();
						
			 System.out.println("Ingese el tamaño de lista a buscar");
			 String entrada = br.readLine(); 
			 int listaaux_tamaño =  Integer.parseInt(entrada);
			
			 
			 System.out.println("Ingese el numero de preguntas");
			 String entrada2 = br.readLine();
			 int preguntas = Integer.parseInt(entrada2);
			 
			 System.out.println("ingrese la lista");
			 
			 int [] cuestion_list = new int[preguntas];
			
			 String [] aux_array = new String [listaaux_tamaño ];
			 String [] temp_array = new String [ preguntas];
			
			 for(int i = 0; i < listaaux_tamaño ; i++)
			 {	
			 	aux_array[i]=br.readLine(); 
			 	marbles.llenar_lista(new nodo(Integer.parseInt(aux_array[i])));
			 					 		
			 } 
			 
			 System.out.println("ingrese la lista de preguntas");
			
			 for(int i = 0; i < preguntas ; i++)
			 {	
			 	temp_array[i]=br.readLine(); 
			 	cuestion_list [i] = Integer.parseInt(temp_array[i]);
			 				 			
			 }
			 
				marbles.buscar_en_lista_marbles(cuestion_list);	

	}
}
