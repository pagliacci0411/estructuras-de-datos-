package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trowing_cars_away 
{

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cola carts = new cola();
		 System.out.println("Ingese el numero de cartas");
		 String entrada = br.readLine(); 
		 int numero_de_cartas =  Integer.parseInt(entrada);
		 if (numero_de_cartas != 0) {
		for (int i = 1;  i < numero_de_cartas +1 ; i ++)
		{
			carts.llenar_cola(new nodo(i));
		}
		 
		int [] cartas_eliminadas = new int [numero_de_cartas -1];
		for(int i = 0 ; i < numero_de_cartas -1 ; i++)
			{
				cartas_eliminadas[i]= carts.head.Dato;
				carts.vaciar_cola();
				carts.llenar_cola(new nodo(carts.head.Dato));
				carts.vaciar_cola();		
			}
		System.out.print("cartas eliminadas :");
		for(int i  = 0; i < numero_de_cartas -1; i ++ )
		System.out.print(cartas_eliminadas[i] + " ");
		
		System.out.print(" \n"+"cartas final :" + carts.head.Dato);
		 }
		 else
			 System.out.print("cartas eliminas 0, carta de final 0");
			 
	}

}
