package SpecialData;

import java.io.IOException;
import java.util.ArrayList;

import Data.Vector;
import GUI.Controler;

public class Grafo {
	
	private ArrayList<Vector> Nodos ;
	Controler cn = new Controler();
	public Grafo() 
	{
		this.Nodos = new ArrayList<>();
		this.setNodos(cn.cargarVectores());
	}
	
	public ArrayList<Vector>  getNodos()
	{
		return this.Nodos;
	}
	
	public void setNodos(ArrayList<Vector> newListNodos)
	{
		this.Nodos = newListNodos;
	}
	
	public void addNewNode(Vector newVector, list lista)
	{
		newVector.setId(this.Nodos.size());
		nodo temp = lista.head;
		while(temp != null)
		{
			newVector.getRamas().add(this.Nodos.get(temp.Dato));
			this.Nodos.get(temp.Dato).getRamas().add(newVector);
			temp = temp.next;
		}
		
		this.Nodos.add(newVector);
	}
	
	private ArrayList<Node> dijkstra(Vector Origen)
	{
		MinHeap mp = new MinHeap(this.Nodos.size());
		
		for(int i = 0; i < this.Nodos.size(); i++)
		{
			double size = Double.MAX_VALUE;
			if(this.Nodos.get(i).equals(Origen))
				size = 0;
			mp.Insert(new Node(size, this.Nodos.get(i)));
		}
		
		ArrayList<Node> nodos  = new ArrayList<>();
		
 		while(!mp.isEmpty())
		{
			Node yo = mp.getMin();
			nodos.add(yo);
		}
 		
 		return nodos;
	}
	
	private Stack minPath(Vector destino) throws IOException
	{	
		Stack s = new Stack();
		int i = destino.getPrevId();
		while(i != -1)
		{ 
			System.out.println("I " + destino.getId());
			System.out.println("p " + destino.getPrevId());
			nodo newNode = new nodo();
			newNode.vector = destino;
			s.push(newNode);
			destino = this.getNodos().get(i);

			i = destino.getPrevId();
		}
		nodo newNode = new nodo();
		newNode.vector = destino;
		s.push(newNode);
		return s;
	}
	
	public Stack getMinPath(int Origen, int destino) throws IOException
	{
		ArrayList<Node> nodo = this.dijkstra(this.Nodos.get(Origen));
		Stack minPath = new Stack();
		for( Node n : nodo )
		{
			System.out.println( "Distancia minina " + n.getSize() + "to Vector "  + n.getVector().getId() + "( " + n.getVector().getX() + ", " + n.getVector().getY() +")" + " Padre: " + n.getVector().getPrevId());
			if(n.getVector().equals(this.getNodos().get(destino)))
			{		
				minPath.push(this.minPath(n.getVector()).head);
				break;
			}
		}
		return minPath;
	}
	
	/*public static void main(String[] agrs) throws IOException
	{
		Grafo gf = new Grafo();
		gf.getMinPath(45, 200).printStack();
	}*/


}
