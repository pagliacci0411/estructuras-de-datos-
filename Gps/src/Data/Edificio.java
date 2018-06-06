package Data;
import java.util.Calendar;
public class Edificio extends Lugar
{
	
	// Aquí se pueden agregar los atributos que definamos para los edificios
	private int numero;
	private String[] hora; // ( hh:min:HH:MIN ) formato 24h
	
	public Edificio(double x, double y, String nombre, int numero, String[] hora, String info, String Tipo)
	{
		super(x, y, nombre, info, Tipo);
		this.numero = numero;
		this.hora = hora;
	}
	
	
	public Edificio()
	{
		super();
	}
	
	public boolean isOpen()
	{	
		Calendar calendar = Calendar.getInstance();
		int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
	
		String[] hora = null;
		if(diaSemana >=2 && diaSemana<= 5) // De lunes a jueves
			hora = this.hora[0].split(":");
		else if(diaSemana == 1) // Domingos
			hora = this.hora[3].split(":");
		else if(diaSemana == 6) // Viernes
			hora = this.hora[1].split(":");
		else // Sabados
			hora = this.hora[2].split(":");
		
		int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
		int MinutoActual = calendar.get(Calendar.MINUTE);
		
		if(horaActual == Integer.parseInt(hora[0]))	
			if(Integer.parseInt(hora[1]) > MinutoActual)
				return false;
			else
				return true;
		else if(horaActual == Integer.parseInt(hora[2]))
			if(Integer.parseInt(hora[3]) > MinutoActual)
				return true;
			else
				return false;
		else if(horaActual > Integer.parseInt(hora[0]) && horaActual < Integer.parseInt(hora[2]))
			return true;
		else
			return false;
	}
	
	public int getNumero()
	{
		return this.numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public void setHora(String[] hora)
	{
		this.hora = hora;
	}
}
