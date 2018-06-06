package recurciones;
import java.io.*;
public class recurcion 
{
		public int factorial(int x)
	{
		if(x == 0)
			return 1;
		
		else
			return x * factorial(x - 1);
		
	}
	
	
	
	
	public int mcd_euclides(int a, int b)
	{
		if(a < b) 
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		if(a%b == 0) 
			return b;
		
		else
		return mcd_euclides(b, a%b);
		
	}

	
	public int pascal(int n, int k)
	{
		if(k == n || k == 0) 
				return 1;
		
		else
		return pascal(n - 1, k) + pascal(n - 1, k - 1);
		
	}
	
	public int fibonacci(int x)
	{
		if(x == 1)
			return 1;
		
		else if(x == 0)
			return 0; 	
		
		else
			return fibonacci(x-1) + fibonacci(x-2);
		
	}
	
	public String print_pascal()
	{
		String pascal_matrix = "";
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j <= i; j++)
				pascal_matrix += pascal(i, j) + "\t";
			
			pascal_matrix += "\n";
		}
		
		return pascal_matrix;
	}
	
	
	
	public int multiplicacion(int n, int x)
	{
		if(n == 0 || x == 0)
				return 0;
		
		else
		return x + multiplicacion(n - 1, x);
		
	}
	
	
	
	public String inversa_cadena(String cadena)
	{
		if(cadena.length() == 1)
			return cadena;
		
		else
		{
			char temp = cadena.charAt(cadena.length() - 1);
			return temp + inversa_cadena(cadena.substring(0, cadena.length() - 1));
		}
	}
		
	public static void main(String[] args)
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		recurcion recurrencias = new recurcion();
	
		try
		{
			
			bw.write(recurrencias.factorial(15) + "\n"); 
			
			bw.write(recurrencias.fibonacci(25) + "\n"); 
			
			bw.write(recurrencias.multiplicacion(654, 97) + "\n"); 
			
			bw.write(recurrencias.mcd_euclides(369, 1218) + "\n"); 
			
			bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); 
			
			bw.write(recurrencias.print_pascal() + "\n");
	
			
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
