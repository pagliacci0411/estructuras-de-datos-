package asdf;


public class secuence
		{
	    public String sequence;
	    public String cromosoma;
	    public int start;
	    public int end;
	  
	    public secuence next;
	    public secuence (){};
	    
	   public secuence(String sequence, String cromosoma, int start, int end) 
	        	{
	            this.sequence = sequence;
	            this.cromosoma = cromosoma;
	            this.start = start;
	            this.end = end;
	        	}
	        
	        public String toString() 
	    	{
	    		return "Secuencia : " + this.cromosoma + "," + this.sequence +","+ this.start + ", "+ this.end;
	    	}
	    
	    
	    }
	     
	  
	    
	


