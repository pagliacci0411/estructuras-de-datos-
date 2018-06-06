package busqueda;

public class busqueda 
{
	public static int binary(int[] Array, int n, int Up, int dw)
	{
		int tamaño ;
		
		tamaño  = (Up + dw)/2;

		
		if(n > Array[tamaño ])
			return binary(Array, n, Up, tamaño  + 1);
		
		else if(n < Array[tamaño ])
			
			return binary(Array, n, tamaño  - 1, dw);
		
		else if(n == Array[tamaño ])
			return tamaño ;
		return -1;
	}
	
	public static int binary(int Array[], int n)
	{
		int dw = 0;
		int Up = Array.length;
		
		while(dw <= Up)
		{
			int punto_medio = (dw + Up) / 2;
			if(n == Array[punto_medio])
				return punto_medio;
			if(Array[punto_medio] < n )
				dw = punto_medio + 1;
			else
				Up = punto_medio - 1;
		}
		return -1;
	}
	public static int lineal(int Array[], int n)
	{
		for(int i = 0; i < Array.length ; i++)
		
			if(Array[i] == n)
				
				return i;
		
		return -1;
	}
	public static int interpolation(int Array[], int n)
	{
		
		int dw = 0;
		
		int Up = Array.length - 1;
		
		while(dw <= Up)
		{
			int punto_medio = dw + ((Up - dw)/(Array[Up] - Array[dw])) * (n - Array[dw]);
			
			if( n == Array[punto_medio])
			
				return punto_medio;
			
			if( punto_medio > n )
			
				Up = punto_medio - 1;
			
			else
				
				dw = punto_medio + 1;
		}	
		return -1;
	}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.print(binary(Array,14));
		System.out.println(lineal(Array,14));
		System.out.println(binary(Array,14,Array.length-1, 0));
		System.out.println(interpolation(Array,14));
	
		
	}
}
