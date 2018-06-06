package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Universidad {
	
	private Lugar head;
	
	
	public void cargarInfo() throws IOException
	{
		File info = new File("ff");
		
		if(!info.exists())
			info.createNewFile();
		
		Object input;
		BufferedReader br = new BufferedReader(new FileReader(info));
		
		String[] line = br.readLine().split(","); 
		if(line[0].equals("E"))
		{
			//E,Numero,Nombre,X,Y,info,hh:mm:HH:MM-hh:mm:HH:MM-hh:mm:HH:MM-hh:mm:HH:MM
			//double x, double y, String nombre, int numero, String[] hora, String info
			int numero = Integer.parseInt(line[1]);
			String nombre = line[2];
			double x = Double.parseDouble(line[3]);
			double y = Double.parseDouble(line[4]);
			String Informacion = line[5];
			String[] horaOPEN_CLOSE = line[6].split("-");
			
			Lugar newLugar = new Edificio(x, y, nombre, numero, horaOPEN_CLOSE, Informacion,line[0]);
		}
		else
		{
			String nombre = line[2];
			double x = Double.parseDouble(line[3]);
			double y = Double.parseDouble(line[4]);
			String Informacion = line[5];
			Lugar newLugar = new Lugar(x, y, nombre, Informacion, line[0]);	
		}
	
	
	}
	
	
	public static void main(String[] args)
	{
		Edificio e = new Edificio();
		
		String[] hora = new String[]
				{
					"6:30:18:30",
					"13:00:15:54",
					"9:20:12:00",
					"7:00:9:00"
				};
		
		e.setHora(hora);
		
		if(e.isOpen())
			System.out.println("Abierto");
		else
			System.out.println("Cerrado");
	
		Lugar[] lugares= new Lugar[2]; 
	
		
	}
}
