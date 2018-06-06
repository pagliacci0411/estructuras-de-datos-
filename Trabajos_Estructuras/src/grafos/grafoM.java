package grafos;

public class grafoM 
{
	 int tamaño_matriz;
    private int[][] matriz_de_adyacencia;
    
    public  grafoM (int p)
    {
        this.tamaño_matriz = p;
        matriz_de_adyacencia = new int[this.tamaño_matriz][this.tamaño_matriz];
        for(int i=0; i< tamaño_matriz; i++){
            for(int j=0; j< tamaño_matriz; j++){
            	matriz_de_adyacencia[i][j] = 0;
            }            
        }
    }
    
    public void agregar(int i, int j)
    {
    	matriz_de_adyacencia[i][j] += 1;
    }
    
    public void quitar(int i, int j)
    {
        if(matriz_de_adyacencia[i][j]>0)
        	matriz_de_adyacencia[i][j] -= 1;
    }
    
    public void imprimir()
    {
        for(int i=0; i< tamaño_matriz; i++)
        {
               for(int j=0; j< tamaño_matriz; j++)
                System.out.print( matriz_de_adyacencia[i][j] + "  " );        
            
            System.out.println(" ");
        }
        } 
    
    public static void main(String args[])
    {
    	grafoM  matriz = new grafoM(5);
    	matriz.agregar(0,4);
    	matriz.agregar(3,1);
    	matriz.agregar(0,2);
    	matriz.agregar(2,1);
    	matriz.agregar(4,0);
    	matriz.agregar(2,2);
    	matriz.quitar(3, 1);
    	matriz.imprimir();
    }
    
    }

