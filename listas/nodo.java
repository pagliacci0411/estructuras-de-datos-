package bla;

public class nodo 
{
	String grade;
	double value;
	nodo next = null;// pointer
	/**
	 * zero parametros del constructor
	 */

	
	public nodo (String grade, double value)
	{
		this.grade =grade;
		this.value = value;
	}
public String toString()
	{
	return "grade : " + this.grade +  "\t"
			+ "value : " + this.value + "\n";
	}
public nodo clon()
	{
	nodo temp = new nodo(this.grade, this.value);
	return temp;
	}
}
