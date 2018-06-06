package grafos;
import java.util.LinkedList;
public class grafos 
{
		
	 int valor;
     LinkedList<Integer> adjListArray[];
      
     grafos(int valor)
     {
         this.valor = valor;
         adjListArray = new LinkedList[valor];
         for(int i = 0; i < valor ; i++){
             adjListArray[i] = new LinkedList<>();
         }
     }
 static void agregar(grafos grafo_, int value, int value2)
 {
   
     grafo_.adjListArray[value].addFirst(value2);
 
     grafo_.adjListArray[value2].addFirst(value);
 }
   
 static void imprimir(grafos graph)
 {       
     for(int i = 0; i < graph.valor; i++)
     {
         System.out.println("lista de adyacencia de: "+ i);
         System.out.print("head");
         for(Integer pCrawl: graph.adjListArray[i])
         {
             System.out.print(" - "+pCrawl);
         }
         System.out.println("\n");
     }
 }
   

 public static void main(String args[])
 {
   
     int p = 5;
     grafos graph = new grafos(p);
     agregar(graph, 0, 1);
     agregar(graph, 0, 4);
     agregar(graph, 1, 2);
     agregar(graph, 1, 3);
     agregar(graph, 1, 4);
     agregar(graph, 2, 3);
     agregar(graph, 3, 4);
     imprimir(graph);
}
}