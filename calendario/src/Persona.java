import java.io.*;
/**
 * Write a description of class Personas here.
 * 
 * @author BOo
 * @version 0.2
 */
public class Persona implements Serializable
{
	String nombre, apellido, email, direccion, comuna;
	String telefono1, telefono2, celular1, celular2;

	
	public Persona(String name, String surname, String number, String number2, String number3, String number4)
	{
	    nombre = name;
        apellido = surname;
		telefono1 = number;
        telefono2 = number2;
        celular1 = number3;	
        celular2 = number4;
    }

    public Persona(String name, String surname, String number, String number2, String number3, String number4, String mail, String page, String address, String city, String work)
	{
	    nombre = name;
        apellido = surname;
		telefono1 = number;
        telefono2 = number2;
        celular1 = number3;	
        celular2 = number4;
        email = mail; 
        direccion = address; 
        comuna = city;
	}

	public void setTel(String number)
	{
	    telefono1 = number;
	}
	
	public String toString()
	{
	    return nombre +":"+ apellido +":"+telefono1+":"+telefono2+":"+celular1+":"+ celular2+":"+ email +":"+direccion+":"+comuna;
	}  
	
	public String[] toStringArray()
	{
	    String arr[] = {apellido+", "+nombre, direccion,comuna,telefono1,telefono2,celular1,celular2, email};
	    return arr;
	}
	
	public String getName()
	{
	    return nombre;
	}
	
	public String getSurname()
	{
	    return apellido;
	}
	
	public String getAddress()
	{
	    return direccion;
	}
	
	public String getCity()
	{
	    return comuna;
	}
	
	public String getMail()
	{
	    return email;
	}
	
	public String getPhone()
	{
	    return telefono1;
	}
	
	public String getFax()
	{
	    return telefono2;
	}
	
	public String getMovil()
	{
	    return celular1;
	}
	
	public String getPager()
	{
	    return celular2;
	}
	
	public boolean apellidoStartWith(String letra)
	{
	    return apellido.toUpperCase().startsWith(letra);
	}
}
