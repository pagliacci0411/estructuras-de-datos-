package problemas_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Piedra_filosofal {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pila bolsa_monk = new pila();
		cola bolsa_harry = new cola ();
		
	int monedas_harry, valor_final, preguntas;
	
	String entrada = br.readLine(); 
	monedas_harry =  Integer.parseInt(entrada);
	
	String valor_monedas = br.readLine();
	String[] parts = valor_monedas.split(" ");
	
	for (int i = 0; i < monedas_harry; i++)
	bolsa_harry.llenar_cola(new nodo(Integer.parseInt(parts[i])));
	
	String entrada1 = br.readLine();
	String[] parts1 = entrada1.split(" ");
	
	preguntas = Integer.parseInt(parts1[0]);
	valor_final = Integer.parseInt(parts1[1]);
	
	for (int i= 0;  i <preguntas ;i++)
	{	String HARRY = "HARRY";
		String REMOVE = "REMOVE";
		String aux = br.readLine();
		if (aux.equals(HARRY))
		{
			bolsa_monk.push(new nodo(bolsa_harry.head.Dato));
			bolsa_harry.vaciar_cola();
		}
		else if(aux.equals(REMOVE))
		{
			bolsa_monk.pop();
		}
		
	}
	System.out.println(bolsa_monk.numero_de_datos()); 
	}

}
