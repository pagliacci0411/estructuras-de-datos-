package arbol_avl;

public class complete 
{

		public Complete(){}
		
		public in_and pre(String pre, String in)
		{
			
			
			if(in.length() == 0)
				return new arbol_binario();	
			else
			{	
			arbol_binario  temp = new arbol_binario();
			if(in.length() == 1)
				temp.root = new Node(in);
			else
			{	
				int[] Arr = new int[in.length()];
					for(int i = 0; i < in.length() ; i++)
				Arr[i] = pre.indexOf(in.substring(i,i+1));
			
				int min = Integer.MAX_VALUE;
				int index = -1;
					for(int i = 0; i < Arr.length ; i++)
						if(Arr[i] < min)
						{	
							min = Arr[i];
							index = i;
						}
					String Dw = in.substring(0, index);
					String Up = in.substring(index + 1, in.length());
				
					temp.root = new Node(in.charAt(index) + "");
					temp.root.left = this.in_PreToPost(pre, Dw).root;
					temp.root.right = this.in_PreToPost(pre, Up).root;
				}	
				return temp;
			}
		}

}
