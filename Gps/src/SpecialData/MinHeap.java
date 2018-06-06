package SpecialData;

import java.util.ArrayList;

import Data.Vector;

public class MinHeap 
{	
	private Node[] Nodes;
	private int size;
	public MinHeap(Node[] nodes)
	{
		this.Nodes = nodes;
		this.size = this.Size();
	}
	
	public boolean isEmpty()
	{
		return this.size == 0 ? true : false;
	}
	
	public MinHeap(int V)
	{
		this.Nodes = new Node[V];
		this.size = 0;
	}
	
	public int Size()
	{
		int size = 0;
		for(int i = 0 ; i < this.Nodes.length ; i++)
			if(this.Nodes[i] != null)
				size++;
		return size;
	}
	
	public int getParent(int i)
	{
		return (i - 1) / 2;
	}

	public int getLeftChild(int i)
	{
		return 2*i + 1;
	}
	
	public int getRightChild(int i)
	{
		return 2*i + 2;
	}
	
	public void swapp(int i, int j)
	{
		/*double size = this.Nodes[i].getSize();
		Vector temp = this.Nodes[i].getVector();
		this.Nodes[i].setSize(this.Nodes[j].getSize());
		this.Nodes[i].setVector(this.Nodes[j].getVector());
		this.Nodes[j].setSize(size);
		this.Nodes[j].setVector(temp);*/
		Node temp = this.Nodes[i];
		this.Nodes[i] = this.Nodes[j];
		this.Nodes[j] = temp;
	}
	
	private void siftUp(int i)
	{
		while(i > 0 && this.Nodes[this.getParent(i)].getSize() > this.Nodes[i].getSize())
		{	
			this.swapp(i, this.getParent(i));
			i = this.getParent(i);
		}
	}
	
	private void siftDown(int i)
	{
		int minIndex = i;
		int left = this.getLeftChild(i);
		if(left <= this.size && this.Nodes[left].getSize() < this.Nodes[minIndex].getSize())
			minIndex = left;
		int right = this.getRightChild(i);
		if(right <= this.size && this.Nodes[right].getSize() < this.Nodes[minIndex].getSize())
			minIndex = right;
		if(i != minIndex)
		{
			this.swapp(i, minIndex);
			this.siftDown(minIndex);
		}
	}
	
	public void Insert(Node newNode)
	{
		if(this.size == this.Nodes.length)
		{
			Node[] temp = new Node[5*this.Nodes.length];
			
			for(int i = 0 ; i < this.Nodes.length; i++)
				temp[i] = this.Nodes[i];
		
			this.Nodes = temp;
		}
		
		this.size = size + 1;
		this.Nodes[this.size - 1] = newNode;
		this.siftUp(this.size - 1);
	}

	public Node getMin()
	{	
		Node toReturn = this.Nodes[0];
		if(this.size != 0)
		{	
			this.Nodes[0] = this.Nodes[this.size - 1];
			this.size -= 1;
			this.siftDown(0);
			this.actualizarAdyacentes(toReturn);
		}
		else
			this.Nodes[0] = null;
		
		
		return toReturn;
	}
	
	public Node remove(int i)
	{
		Node toRemove = this.Nodes[i];
		this.Nodes[i] = new Node(Double.MIN_VALUE, null);
		this.siftUp(i);
		this.getMin();
		return toRemove;
	}

	public void changeKey(int i, double newsize)
	{
		double old = this.Nodes[i].getSize();
		this.Nodes[i].setSize(newsize);
		
		if(this.Nodes[i].getSize() < old)
			this.siftUp(i);
		else
			this.siftDown(i);
	}

	public void actualizarAdyacentes(Node root)
	{
	
			for(int j = 0; j < root.getVector().getRamas().size(); j++) 
			{	
				
				for(int i = 0 ; i < this.Nodes.length; i++)
					if(root.getVector().getRamas().get(j).equals(this.Nodes[i].getVector()) && this.Nodes[i].getSize() > root.getVector().SizeVectorFlotante(this.Nodes[i].getVector()) + root.getSize())
					{
						
						this.Nodes[i].getVector().setPrevId(root.getVector().getId());
						this.changeKey(i, (root.getVector().SizeVectorFlotante(this.Nodes[i].getVector())) + root.getSize());
						
						
					}
			}
			
	}
	
	
	/*public static void main(String[] args)
	{
		
		Node[] Arr = {
			new Node(3,null), new Node(2, null),  new Node(1, null), new Node(15, null), new Node(5, null), new Node(4, null), new Node(45, null)};
		
		
		MinHeap heapObj = new MinHeap(Arr.length);
		
		//for(int i = 0; i < Arr.length; i++)
			//mp.Insert(Arr[i]);		
		heapObj.Insert(new Node(3,null));
		heapObj.Insert(new Node(2,null));
		System.out.println(heapObj.remove(1).getSize());
		heapObj.Insert(new Node(15,null));
		heapObj.Insert(new Node(5,null));
		heapObj.Insert(new Node(4,null));
		heapObj.Insert(new Node(45,null));
		
		System.out.println(heapObj.getMin().getSize());

		heapObj.changeKey(2, 1);
		System.out.println(heapObj.getMin().getSize());
	
	if(root.getSize() != Double.MAX_VALUE && !this.Nodes[i].getVector().stat && root.getVector().getRamas().contains(this.Nodes[i].getVector()) && this.Nodes[i].getSize() > root.getVector().SizeVectorFlotante(this.Nodes[i].getVector()) + root.getSize())
				{	
					this.changeKey(i, (root.getVector().SizeVectorFlotante(this.Nodes[i].getVector()) + root.getSize()));
					this.Nodes[i].getVector().setPrevId(root.getVector().getId());
				}
	}*/
	
	
	
}
