package com.codoacodo.dto;



public class Orador {
	private Long idOrador; 
	private String nombre;
	private String apellido;
	private String email; 
	private String tema;
	
	
	public Orador(Long idOrador, String nombre, String apellido, String email, String tema) {
		this.idOrador = idOrador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
	
	}

	public Long getIdOrador() {
		return idOrador;
	}

	public void setIdOrador(long idOrador) {
		this.idOrador = idOrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String  getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String gettema() {
		return tema;
	}

	public void settema(String tema) {
		this.tema = tema;
	}

	

	
}
