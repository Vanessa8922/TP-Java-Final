package com.codoacodo.dto;
import java.sql.Timestamp;

//CLASE ORADOR
public class Orador {
	private int id_orador; 
	private String nombre;
	private String apellido;
	private String mail; 
	private String tema;
        private Timestamp fecha_alta;
	
	//CONSTRUCTOR
public Orador(String nombre, String apellido, String mail, String tema) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
              
}
        
	public Orador(int id_orador,String nombre, String apellido, String mail, String tema,Timestamp ts) {
		this.id_orador = id_orador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
                this.fecha_alta = ts;
	
	}

	public int getid_orador() {
		return id_orador;
	}

	public void setid_orador(int id_orador) {
		this.id_orador = id_orador;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String  getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}
        public String getmail() {
		return mail;
	}
	public void setemail(String mail) {
		this.mail = mail;
	}

	public String gettema() {
		return tema;
	}

	public void settema(String tema) {
		this.tema = tema;
	}
         public Timestamp getfecha_alta() {
        return fecha_alta;
    }

    public void setfecha_alta(Timestamp ts) {
        this.fecha_alta = ts;
    }
    
   


	

	
}
