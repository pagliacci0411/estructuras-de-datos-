package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Market_list 
{

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese el numero de veces que se va ir al mercado");
		String entrada = br.readLine(); 
		
		int repeticiones =  Integer.parseInt(entrada);
		
		for (int i = 0; i < repeticiones; i ++)
		{
			cola market_list = new cola();
			System.out.println("Ingrese el numero de promociones");
			
			String entrada1 = br.readLine(); 
			int repeticiones1 =  Integer.parseInt(entrada1);
			
			System.out.println("Ingrese las promociones");
			
			for(int j = 0 ;j < repeticiones1; j++)
			{	
				String temp = br.readLine();
			
				String[] parts = temp.split(" ");
				
				float  aux = Float.parseFloat(parts[1]);
				market_list.llenar_cola(new nodo (parts[0],aux));
			}
			
			System.out.println("Ingrese el de articulos a comprar");
			String entrada2 = br.readLine(); 
			int repeticiones2 =  Integer.parseInt(entrada2);
			System.out.println("Ingrese los articulos a comprar");
			float cuenta = 0;
			
			for (int k = 0; k < repeticiones2 ; k++)
			{
				String temp = br.readLine();
				String[] parts = temp.split(" ");
				float  aux = Float.parseFloat(parts[1]);
				cuenta = cuenta + (market_list.buscar_string(parts[0]).dato * aux);
				
			}
			System.out.println("tiene que llevar "+cuenta + " pesos");
		}		
	}
}
