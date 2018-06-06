import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.io.*;
import java.util.*;

import SpecialData.list;
import SpecialData.nodo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class conecciones 
{	
	
	public boolean se_conectan(int xo,int yo, int xf, int yf) throws IOException
	{	
		FileReader p = new FileReader("posicines_cuadros.txt");
		BufferedReader br2 = new BufferedReader(p);
		String  b  =  br2.readLine();
		String [] puntos_nulos = b.split(",");
		boolean x = false;
		for(int k = 0; k < puntos_nulos.length; k ++)
		{
			boolean evaluar =  true;
			double px = Float.parseFloat(puntos_nulos[k]);
			double py = Float.parseFloat(puntos_nulos[k+1]);
			double m;
			double c;
			
			if(k > puntos_nulos.length -5 )
				x= true;
			
			if(xf> xo)
			{
				if(px< xo|| px > xf )
				{
					evaluar = false;
					
				}
			}
			else 
				if(px<xf|| px > xo )
				{
					evaluar = false;
					
				}
			if(yo > yf)
			{
				if(py > yo || py < yf)
				{
					evaluar = false;
				}
			}
			else
				if(py > yf || py < yo )
				{
					evaluar = false;
					
				}
			
			if(xf - xo == 0 && yf - yo==0 )
			{	
				evaluar = false;
				x=  false;
				k = puntos_nulos.length;
			}
		if(evaluar)
			{	
			
				if(xf - xo != 0 ) 
				{
					m = (yf - yo )/(xf - xo );
					c = yf - (m*xf);
					
					double n = -m*px + py -c;
					
					if (n<0)
						n= n*-1;
					
					double v =  Math.sqrt(m*m + 1);
					double d = n/v;
					//System.out.println(nodo [0] +"/" +nodo [1]+"/"+nodo_next [0]+"/" + nodo_next [1]+"/"+ m+ "/"+ c + "/" +d+"/"+puntos_nulos[k]+"/"+ puntos_nulos[k+1]);
					//r.write( nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+m+","+c+","+n+","+v+","+d +"\n");
					//r.newLine();
					if(d < 1.8 )
					{
						x= false;
						k = puntos_nulos.length;
					}
				}						
				else 
					if( yo <py && py< yf)
					{
						
						x= false;
						k = puntos_nulos.length -1;
					}
				
			}
		
		k = k+1;
			
		}
	
			return x;
	
	}
	
	
	
	public list soluciones(int x,int y) throws IOException 
	{
		FileReader f = new FileReader("posicines_nodos.txt");
		BufferedReader br1 = new BufferedReader(f);
		String  a  =  br1.readLine();
		String [] aux = a.split(";");
		
		FileReader p = new FileReader("posicines_cuadros.txt");
		BufferedReader br2 = new BufferedReader(p);
		String  b  =  br2.readLine();
		String [] puntos_nulos = b.split(",");
		
		list inicio =  new list(); 
	
		for (int i = 0; i < aux.length;i++)
		{
			String [] temp =  aux[i].split(",");
			double [] nodo = new double[2];
			nodo [0]= Double.parseDouble(temp[0]);
			nodo [1]= Double.parseDouble(temp[1]);
			
			for(int k = 0; k < puntos_nulos.length; k ++)
			{
				boolean evaluar =  true;
				double px = Float.parseFloat(puntos_nulos[k]);
				double py = Float.parseFloat(puntos_nulos[k+1]);
				double m;
				double c;
				
				if(k > puntos_nulos.length -5 )
				{
					
					inicio.llenar_lista(new nodo(i));
					k= puntos_nulos.length;
				}	
				if(nodo [0]> x)
				{
					if(px< x|| px > nodo[0] )
					{
						evaluar = false;
						
					}
				}
				else 
					if(px< nodo [0]|| px > x )
					{
						evaluar = false;
						
					}
				if(y > nodo[1])
				{
					if(py > y || py < nodo[1])
					{
						evaluar = false;
					}
				}
				else
					if(py > nodo[1] || py < y )
					{
						evaluar = false;
						
					}
				
				if(nodo[0] - x == 0 && nodo[1] - y==0 )
				{	
					evaluar = false;
					k = puntos_nulos.length;
				}
			if(evaluar)
				{	
				
					if(nodo[0] - x != 0 ) 
					{
						m = (nodo [1] - y )/(nodo[0] - x );
						c = nodo[1]- (m*nodo [0]);
						
						double n = -m*px + py -c;
						
						if (n<0)
							n= n*-1;
						
						double v =  Math.sqrt(m*m + 1);
						double d = n/v;
						//System.out.println(nodo [0] +"/" +nodo [1]+"/"+nodo_next [0]+"/" + nodo_next [1]+"/"+ m+ "/"+ c + "/" +d+"/"+puntos_nulos[k]+"/"+ puntos_nulos[k+1]);
						//r.write( nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+m+","+c+","+n+","+v+","+d +"\n");
						//r.newLine();
						if(d < 1.8 )
						{
							
							k = puntos_nulos.length;
						}
					}						
					else 
						if( y <py && py< nodo[1])
						{
							
							
							k = puntos_nulos.length -1;
						}
					
				}
			
			k = k+1;
				
			}
			
		}
		
		
		
		return inicio ;
	}
		
	
	public void conectar() throws FileNotFoundException, IOException
	{
		
		FileReader f = new FileReader("posicines_nodos.txt");
		BufferedReader br1 = new BufferedReader(f);
		String  a  =  br1.readLine();
		String [] aux = a.split(";");
		FileReader p = new FileReader("posicines_cuadros.txt");
		BufferedReader br2 = new BufferedReader(p);
		String  b  =  br2.readLine();
		String [] puntos_nulos = b.split(",");
	
		int conexiones [][] = new int[aux.length][aux.length];
	
		File archivo = new File("archivo.txt");
		File verificacion = new File("verificacion.txt");
	
		BufferedWriter bw,r;
		bw = new BufferedWriter(new FileWriter(archivo));
		r = new BufferedWriter(new FileWriter(verificacion));   
		for(int i = 0; i < aux.length; i++)
		{
			String [] temp =  aux[i].split(",");
			
			double [] nodo = new double[2];
			
			nodo [0]= Double.parseDouble(temp[0]);
			nodo [1]= Double.parseDouble(temp[1]);
			System.out.println(i);
		
			bw.write( "###"+ nodo [0]+","+nodo [1]+ ":" + "####");
			bw.newLine();
			for (int j = 0; j < aux.length   ; j++ ) 
		 	{	
			
				String [] auxiliar =  aux[j].split(",");
			
				double [] nodo_next = new double[2];
				
				nodo_next [0]= Double.parseDouble(auxiliar[0]);
				nodo_next [1]= Double.parseDouble(auxiliar[1]);
				bw.write(+nodo_next [0]+"-"+ nodo_next [1]+ ":");
				
				for(int k = 0; k < puntos_nulos.length; k ++)
				{
					boolean evaluar =  true;
					double px = Float.parseFloat(puntos_nulos[k]);
					double py = Float.parseFloat(puntos_nulos[k+1]);
					double m;
					double c;
					
					if(k > puntos_nulos.length -5 )
					{
						//r.write(" llegó ");
						//r.newLine();
						bw.write( "1" );
						bw.newLine();
						//bw.write("siguiente!!! ");
						//bw.newLine();
						k= puntos_nulos.length;
					}	
					if(nodo_next [0]> nodo [0])
					{
						if(px< nodo [0]|| px > nodo_next[0] )
						{
							evaluar = false;
							//r.write(nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+ 1);
							//r.newLine();
						}
					}
					else 
						if(px< nodo_next [0]|| px > nodo [0] )
						{
							evaluar = false;
							//r.write(nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+ 2);
							//r.newLine();
						}
					if(nodo[1]> nodo_next [1])
					{
						if(py > nodo[1] || py < nodo_next[1])
						{
							//r.write(nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+ 3);
							evaluar = false;
							//r.newLine();
						}
					}
					else
						if(py > nodo_next[1] || py < nodo[1] )
						{
							evaluar = false;
							//r.write(nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+ 4);
							//r.newLine();
						}
					if(nodo_next [0] - nodo [0] == 0 && nodo_next [1] - nodo [1] ==0 )
					{	
						evaluar = false;
						conexiones [i][j] = 0;
						//r.write("iguales");
						//r.newLine();
						bw.write("0");
						bw.newLine();
						k = puntos_nulos.length;
					}
				if(evaluar)
					{	
					
						if(nodo_next [0] - nodo [0] != 0 ) 
						{
							m = (nodo_next [1] - nodo [1] )/(nodo_next [0] - nodo [0] );
							c = nodo_next [1]- (m*nodo_next [0]);
							
							double n = -m*px + py -c;
							
							if (n<0)
								n= n*-1;
							
							double v =  Math.sqrt(m*m + 1);
							double d = n/v;
							//System.out.println(nodo [0] +"/" +nodo [1]+"/"+nodo_next [0]+"/" + nodo_next [1]+"/"+ m+ "/"+ c + "/" +d+"/"+puntos_nulos[k]+"/"+ puntos_nulos[k+1]);
							//r.write( nodo [0]+","+nodo [1]+","+nodo_next [0] +","+nodo_next [1]+","+px+","+py+","+m+","+c+","+n+","+v+","+d +"\n");
							//r.newLine();
							if(d < 1.8 )
							{
								conexiones [i][j] = 0;
								bw.write("0");
								bw.newLine();
								k = puntos_nulos.length;
							}
						}						
						else 
							if(nodo [1]<py && py< nodo_next [1])
							{
								conexiones [i][j] = 0;
								
								bw.write("0");
								bw.newLine();
								k = puntos_nulos.length -1;
							}
						
					}
				
				k = k+1;
					
				}
			
			bw.flush();
			}
	}

	bw.close();
	
	}
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		conecciones a = new conecciones();
		a.conectar();
	}
	
}
