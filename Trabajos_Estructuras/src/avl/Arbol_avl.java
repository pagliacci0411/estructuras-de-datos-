package avl;

public class Arbol_avl
{
	
	nodo_avl A;
	
	boolean aux;
	
	public boolean ArbolVacio(nodo_avl R)
	{
		return (R == null);
	}
	
	public  class nodo_avl
	{
		int a;
		int Factbalance;
		nodo_avl right, left;
		
		nodo_avl (int valor, String Nom, String nac)
		{
			a = valor;
			nodo_avl right=null;
			nodo_avl left = null;
		}
	}
	public  boolean Miembro(int a, nodo_avl p)
	{
		nodo_avl Aux = p;
		boolean miembro = false;
		while (Aux != null){
			if (a==Aux.a)
			{
				miembro = true;
				Aux = null;
			}
			else{
				if (a>Aux.a)
					Aux = Aux.right;
				else{
					Aux = Aux.left;
					if (Aux == null)
						miembro = false;
				}
			}
		}
		return miembro;
	}
	
	public nodo_avl rotacion_derecha_izquierda(nodo_avl N, nodo_avl N1)
	{
		nodo_avl N2;
		
		N2 = N1.left;
		
		N.right = N2.left;
		
		N2.left=N;
		
		N1.left=N2.right;
		N2.right=N1;
		if (N2.Factbalance==1){
			N.Factbalance=-1;
		}
		else{
			N.Factbalance=0;
		}
		if (N2.Factbalance==-1)
			N1.Factbalance=1;
		else
			N1.Factbalance=0;
		N2.Factbalance=0;
		N=N2;
		return N;
	}
	
	public nodo_avl rotacion_izquierda_derecha(nodo_avl N, nodo_avl N1){
		nodo_avl N2;
		N2=N1.right;
		N.left=N2.right;
		N2.right=N;
		N1.right=N2.left;
		N2.left=N1;
		if (N2.Factbalance==1)
			N1.Factbalance=-1;
		else
			N1.Factbalance=0;
		if (N2.Factbalance==-1)
			N.Factbalance=1;
		else
			N.Factbalance=0;
		N2.Factbalance=0;
		N=N2;
		return N;
	}
	public nodo_avl Rotacion_Izquierda_Izquierda(nodo_avl N, nodo_avl N1)
	{
		N.left = N1.right;
		N1.right = N;
		if (N1.Factbalance==-1){
			N.Factbalance=0;
			N1.Factbalance=0;
		}
		else{
			N.Factbalance=-1;
			N1.Factbalance=1;
		}
		N=N1;
		return N;
	}
	
	
	
	int nuemro_de_nodos(nodo_avl A)
	{
		int cont = 0;
		if (A == null) 
			cont = cont;
		else{
			cont = cont + 1 + nuemro_de_nodos(A.left) + nuemro_de_nodos(A.right);
		}
		return cont;
	}
	
}


