package asfddsafdsf;

public class Arbol_Binario {
	
	nodo root = null;
	
	public Arbol_Binario () 
	{
		
	}
	
	
	public void insertar (int valor)
	{
		nodo node = new nodo (valor);
		if (root  == null) 
			root = node;
		else 
		{
			nodo temp = root;
			nodo padre = null;
			boolean left = false;
			
			while(temp!= null)
			{	
				padre = temp;
				if(valor < temp.value)
				{
					temp = temp.izq;
					left = true;
				}
				else
				{
					temp= temp.der ;
					left = false;
				}
							
			}
			temp = node;
			if (left)
				padre.izq = temp;
			else 
				padre.der= temp;
		}
	}
	public int offspring (nodo node)
	{
		return(node.izq != null) ? (node.der != null ? 2:1) : (node.der != null ? 1:0);
	}
	public void preorder (nodo node)
	{	if(node != null)
		{
		System.out.println(node.tostring());
		preorder(node.izq);
		preorder(node.der);
		}
	}
	
	public void posrder (nodo node)
	{	if(node != null)
		{
		posrder(node.izq);
		posrder(node.der);
		System.out.println(node.tostring());
		}
	}
	
	public void inorder (nodo node)
	{	if(node != null)
		{
		inorder(node.izq);
		System.out.println(node.tostring());
		inorder(node.der);
		}
	}
	public void delete (int a) 
	{
		nodo temp = root;
		
		nodo padre = this.root;
		boolean left = false;
		if(a == root.value)
		padre = null;

		while (temp!= null)
		{
			if (temp.value == a)
				break;
			else 
			{
				padre = temp ;
				if (a < temp.value)
				{
					temp = temp.izq;
				left = true;
				}
				else
				{
					temp = temp.der;
					left = false;
				}	
			}
		}
		if (temp!= null)
		{
			int contador = this.offspring(temp);
			if(contador == 0)
			{
				if (left)
					padre.izq = null;
				else 
					padre.der = null;
			}
			else
			{
					if (contador == 1)
					{
						 if ( temp.izq != null)
						 {
							 if(left)
								 padre.izq = temp.izq;
							 else 
								 padre.der = temp.izq;
							 
						 }
						 else
							 if(left)
								 padre.izq = temp.der;
							 else 
								 padre.der = temp.der;						 
					}	
					else 
					{
					nodo less = temp.der;
					nodo less_padre = less;
					while (less.izq != null)
					{
						less_padre = less;
						less = less.izq;
					}
					if(!less_padre.equals(less))
					{
						if(less.der != null)
							less_padre.izq = less.der;
						
						
						less.der = temp.der;
					}
									
					less.izq = temp.izq;
					
					if(left)
						padre.izq = less;
					else
						padre.der = less;
					
					}	
			}
		}
	}
	
	
	public nodo buscar(int a)
	{
		nodo temp = root;
		while (temp!= null)
			if (temp.value == a)
				return temp;
			else 
				if (a < temp.value)
					temp = temp.izq;
				else
					temp = temp.der;
			
		
		return null;
	}
	
	
	public static void main (String[] args)
	{
		Arbol_Binario tree = new Arbol_Binario ();
		tree.insertar(52);	
		tree.insertar(18);	
		tree.insertar(60);
		tree.insertar(87);	
		tree.insertar(83);
		
		tree.insertar(100);
		tree.insertar(85);
		
		tree.delete(87);
		tree.delete(52);
		tree.inorder(tree.root);
		}
}
