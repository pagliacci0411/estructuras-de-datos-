import java.io.FileNotFoundException;
import java.io.IOException;

import Data.Vector;
import SpecialData.Grafo;
import SpecialData.Stack;
import SpecialData.nodo;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;


//PApplet.main("packageName.ClassName");

public class Graphic_interface extends PApplet
{	
	public static void main(String[] args) {
	
		
		PApplet.main("Graphic_interface");
		
	}
	
	 public void settings()
	 {
		 size(781,856);
	
	  }

	 /////////////////////////

	 boolean click = false ;
	 int contador = 0 ;
	 int posicion_x = 0;
	 int posicion_y  = 0;
	 int posicionf_x = 0;
	 int posicionf_y  = 0;
	 PImage img;
	 PImage img2;
	 PImage mapa;
	 boolean taster = false;
	 int contador2 = 0;
	 float zoom_value = 1;
	 float x_mapa = 781;
	 float y_mapa = 856;
	 float xo_mapa = 0;
	 float yo_mapa = 0;
	 boolean doris = false;
	 conecciones solucion =  new conecciones();
	 Grafo doris_aguanta_resto = new Grafo();
	 String instrucciones = "precione el circulo blanco para marcar la posicion final o inicial, cunado haya terminado presione cualquier tecla para ver su solucion.";
	 public void setup()
	 {	
		 noStroke();
		 img = loadImage("pointer.png");
		 img2 = loadImage("pointer2.png");
	 	 mapa = loadImage("mapa.png");
		 background(0);
		 imageMode(CORNERS);
		 image(mapa, xo_mapa,yo_mapa,x_mapa,y_mapa);
	 }
	 
	
	 /////////////////////////
	 public void draw()
	 {	
		 
		 if(doris)
	 	{
		background(0);
		image(mapa, xo_mapa,yo_mapa,x_mapa,y_mapa);
	
	 	}
		button();
		seleccionar_lugar( );
		zoom();
		try {
			buscarsolucion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textSize(15);
		fill(255,0,0);
		text(instrucciones, 10, 10, 220, 840); 
		
	}
	 
	
	 
	 public  void button() 
	 {	
		 float distancia_x = (width /10 *9) - mouseX;
		 float distancia_y = (height /15) - mouseY;
		 float distancia = sqrt((distancia_x*distancia_x)+(distancia_y*distancia_y)); 
		 fill(255);
		
		 ellipse(width /10 *9,height /15 , 50,50);
		 
		if(distancia < 25 && click)
		 {				
			contador = contador + 1;
			doris = true;
		 }	

			
		if( click && taster && contador != 0) 
		{	
			 float x_mapa = 781;
			 float y_mapa = 856;
			 float xo_mapa = 0;
			 float yo_mapa = 0;
			taster = false;
			contador = 0;
			contador2=0;
			zoom_value =1 ;
			doris = false;
			background(0);
			image(mapa, xo_mapa,yo_mapa,x_mapa,y_mapa);
			fill(0);
			ellipse(posicion_x,posicion_y,5,5);
			ellipse(posicionf_x,posicionf_y,5,5);
		}
	}
	 public void seleccionar_lugar( )
	 {	float distancia_x = (width /10 *9) - mouseX;
	 	float distancia_y = (height /15) - mouseY;
	 	float distancia = sqrt((distancia_x*distancia_x)+(distancia_y*distancia_y)); 
	 	
		
		if (contador != 0 )
		{	
			noCursor();
			
			if (!taster)
			{	
				image(img, mouseX -20, mouseY -40, mouseX + 20, mouseY );
				if(click &&  distancia > 25)
				{
				posicion_x = mouseX;
				posicion_y = mouseY;	
						
				taster = true;
				
				}
			}
			
			if (taster )
			{	
				image(img2, mouseX -20, mouseY -40, mouseX + 20, mouseY );
				posicionf_x = mouseX;
				posicionf_y = mouseY;	
				
			}
			fill(0);
			ellipse(mouseX,mouseY,5,5);			 			
		}
		else
		{
			cursor();
		}
		
	}
	
	
	 public void mouseWheel (MouseEvent event) 
	 {		 
		if (contador != 0 )
		{	
			 float e = -1* event.getCount();
			zoom_value = zoom_value +(float) (e * 0.08);
			contador2 = contador2 + 1;
		}
		 
	 }
	 public void zoom() 
	 {
		 if (contador != 0 && contador2!=0 )
		 {
			 x_mapa= mouseX + ((781- mouseX)*zoom_value);
			 y_mapa= mouseY + ((856- mouseY)*zoom_value);
			 xo_mapa = (-mouseX*zoom_value)+ mouseX;
			 yo_mapa = (-mouseY*zoom_value)+ mouseY;
			 contador2= 0;
			
		 }
		 
		 
	 }
	 public void mousePressed()
	 {
		click = true;		
	 }
	
	 public void mouseReleased()
	 {
		click = false;		
	 }
	
	public void buscarsolucion() throws FileNotFoundException, IOException 
	{
		int xo,yo,xf,yf;
		xo = posicion_x;
		yo = posicion_y;
		xf = posicionf_x;
		yf = posicionf_y;
		
		 if (keyPressed == true) 
		 {	
			
			 
			 if ( solucion.se_conectan(xo, yo, xf, yf))
			{	
				pushStyle();
				stroke(255,0,0);
				strokeWeight(2);
				line(xo,yo,xf,yf);
				popStyle();
				
			}
			 
			else 
			{	
				
				 doris_aguanta_resto.addNewNode(new Vector(xo,yo), solucion.soluciones(xo, yo));
				 doris_aguanta_resto.addNewNode(new Vector(xf,yf), solucion.soluciones(xf, yf));
				 Stack s = doris_aguanta_resto.getMinPath(doris_aguanta_resto.getNodos().size()-2, doris_aguanta_resto.getNodos().size()-1);
				 nodo temp = s.head;
				 while(temp.next != null)
				 {
					 pushStyle();
					 stroke(255,0,0);
					 strokeWeight(2);
					 line((float)temp.vector.getX(),(float)temp.vector.getY(),(float)temp.next.vector.getX(),(float)temp.next.vector.getY());
					 
					 popStyle();
					 
					 temp = temp.next;
					 /*Vector v = s.popV();
					 Vector p = s.popV();
					 pushStyle();
					 stroke(255,0,0);
					 line((float)v.getX(),(float)v.getY(),(float)p.getX(),(float)p.getY());
					 println((float)v.getX());
					 popStyle();
					 */
					 
				 }
				 
			}
			
		 }
		
	}
	
	 	
}
 
