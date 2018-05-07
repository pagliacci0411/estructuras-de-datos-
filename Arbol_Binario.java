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
	
	
	public static void main (String[] args)
	{
		Arbol_Binario tree = new Arbol_Binario ();
		tree.insertar(82);	
		tree.insertar(55);	
		tree.insertar(38);
		tree.insertar(2);
		tree.insertar(70);
		tree.insertar(81);
		tree.insertar(85);
		
		tree.inorder(tree.root);
		
		}
}
