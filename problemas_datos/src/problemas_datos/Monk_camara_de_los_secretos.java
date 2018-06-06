package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monk_camara_de_los_secretos 
{
	public static void main(String[] args)throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numero_arañas, numero_seleccion;
		 
		 cola arañas = new cola();
		 cola arañas_posiciones = new cola();
		 list temp = new list();
		 
		 String entrada = br.readLine(); 
		 String[] parts = entrada.split(" ");
		 numero_arañas = Integer.parseInt(parts[0]);
		 numero_seleccion = Integer.parseInt(parts[1]);
		 String aux =  br.readLine();
		 String[] araña = aux.split(" ");
		 for(int i = 0; i < numero_arañas  ; i++)
		 {
			 arañas.llenar_cola(new nodo(Integer.parseInt(araña[i])));
			 arañas_posiciones.llenar_cola(new nodo(Integer.parseInt(araña[i])));
		 }
		   
		 
		 
		 for(int i = 0 ; i < numero_seleccion; i++)
		 {
			 int k =arañas.numero_de_datos();
			 if(k >numero_seleccion )
			 for(int j= 0 ; j < numero_seleccion; j++)
			  {
				  temp.llenar_lista(new nodo(arañas.head.Dato));
				  arañas.vaciar_cola();
		 
			  }
			 else 
				 for(int j= 0 ; j < k; j++)
				  {
					  temp.llenar_lista(new nodo(arañas.head.Dato));
					  arañas.vaciar_cola();
			 
				  }
				 
			 
			
			  int valor_mayor ;
			  
			  nodo temp1 = temp.head;
				 if (temp1.Dato < temp1.next.Dato)
					 valor_mayor = temp1.next.Dato;
				 else
					 valor_mayor = temp1.Dato; 
				 
				
				 while(temp1.next.next != null)
				 {
					 temp1= temp1.next;
					 
					 if(temp1.next.Dato > valor_mayor)
						 valor_mayor = temp1.next.Dato;
					 
				 }
				 System.out.print(arañas_posiciones.encontrar_posicion(valor_mayor)+ " ");
				 
				 if(temp.encontrar_posicion(valor_mayor) ==1)
					 temp.eliminaralinicio();
				 else
				 temp.eliminarEnElmedio(temp.encontrar_posicion(valor_mayor) - 1);
				 int y = temp.numero_de_datos();
				 for(int j = 0; j < y ; j++)
				 {
					 arañas.llenar_cola(new nodo(temp.head.Dato));
					 temp.eliminaralinicio();
				 }
				 
		 }	

	}
}