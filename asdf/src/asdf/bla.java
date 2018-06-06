package asdf;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class bla {
	
	
	public static String cromosoma()
	{
	    Random rd = new Random();
	  return "cromosoma " + (rd.nextInt(23)+1
			  );
	    
	}
	    
	    public static String nucleotide(){
	    
	    Random rd = new Random();
	            switch (rd.nextInt(4))
	            {
	                case 0 : return "A"; 
	                case 1 : return "B"; 
	                case 2: return "C"; 
	                case 3 : return "D"; 
	                default : return "";
	            }
	    }
	    public static String sequence (int len)
	    {
	    if(len ==1)
	        return nucleotide();
	    
	    else 
	        return nucleotide() + sequence (len-1);
	    }
	    
	    public static void add(secuence Head,  File file, Scanner in) 
		{
			if(in.hasNextLine())
			{
				String[] Dato =  in.nextLine().split(",");
				secuence seq = new secuence(Dato[0], Dato[1], Integer.parseInt(Dato[2]), Integer.parseInt(Dato[3]));
				Head.next = seq;
			    add(seq,file,in);
			}
		}
		public static void combinacion(int n, String subsecuense)
		{
			if(n==1)
			{
				subsecuense = subsecuense + "A";
				subsecuense = subsecuense + "C";
				subsecuense = subsecuense + "G";
				subsecuense = subsecuense + "T";
			}
			else
			{
				combinacion(n - 1,subsecuense + "A");
				combinacion(n - 1,subsecuense + "C");
				combinacion(n - 1,subsecuense + "G");
				combinacion(n - 1,subsecuense + "T");
			}
		}
		
	    public static void main(String[] args) throws IOException {
	       /*
	        FileWriter file = new FileWriter("secuencia.txt");
	        BufferedWriter bw=new BufferedWriter(file);
	        
	        Random rd = new Random();
	        
	        int datasize= 1000000;
	        String  experimental_read;
	        for (int i = 0; i < datasize; i++)
	            {
	                int len = rd.nextInt(50) + 1;
	        int start = rd.nextInt(1000 + 1);
	            experimental_read = sequence (len)
	            + "," + cromosoma()+"," + start + ","+(start + len -1);
	            bw.write( experimental_read + "\n");
	                      
	            }
	        bw.flush();
	        bw.close();
	        
	       // System.out.println(sequence(len) + " "+cromosoma()+ " " + start + " " + (start + len -1));
	       */ 
	    }
	    
	

}
