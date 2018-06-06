package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Data.Vector;

public class Controler {

	public ArrayList<Vector> cargarVectores()
	{
		ArrayList<Vector> vectores = new ArrayList<>();
		File y = new File("Vectores.txt");
		if(!y.exists())
			try {
				y.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		BufferedReader br;
		try {
			br = new BufferedReader( new FileReader(y) );
			int id = 0;
			
			String input = br.readLine();
			
			while(input != null)
			{
				String[] vector = input.split("-");
				Vector newVector = new Vector(Double.parseDouble(vector[0]), Double.parseDouble(vector[1]));
				newVector.setId(id);
				id++;
				vectores.add(newVector);
				input = br.readLine();
			}
			br.close();
			
			this.defineLink(vectores);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vectores;
	}

	private void defineLink(ArrayList<Vector> vectores) throws IOException
	{	
		File x = new File("Link.txt");
		if(!x.exists())
			x.createNewFile();
		
		BufferedReader br = new BufferedReader( new FileReader(x) );
		Vector temp = null;
		String input = br.readLine();
		while(input != null)
		{
			if((input.charAt(0)+"").equals("-"))
				temp = vectores.get(Integer.parseInt(input.replace("-", "").replace(" ", "")));
			else
				temp.getRamas().add(vectores.get(Integer.parseInt(input.replace(" ", ""))));
			input = br.readLine();  
		}
		br.close();
	}

	private void reparar(File f, File x) throws IOException
	{
		BufferedReader br = new BufferedReader( new FileReader(f) );
		BufferedWriter bw = new BufferedWriter( new FileWriter(x) );
		String s = br.readLine();
		int contador = 0;
		int contador2 = 0;
		while(s != null)
		{
			if((s.charAt(0)+"").equals("#"))
			{
				bw.write("-" + contador2 + "\n");
				contador = 0;
				contador2++;
			}
			else
			{
				String [] ss = s.split(":");
				if(ss[1].equals("1"))
					bw.write(contador + "\n");
				contador++;
			}
			s = br.readLine();
		}
		br.close();
		bw.flush();
	}
}






