package com.domain.modelo;

import java.util.Objects;

public class Alumno implements Modelo, Vaciable {

	private int codigo;
	private String nombre;
	private String apellido;
	private String email;
	private String estudios;
	private String linkArepositorio;
	
	//observaciones no lo ponemos
	
	public Alumno() {
	
	}	
	
	public Alumno(int codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Alumno(int codigo, String nombre, String apellido, String email, String estudios, String linkArepositorio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estudios = estudios;
		this.linkArepositorio = linkArepositorio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getLinkArepositorio() {
		return linkArepositorio;
	}

	public void setLinkArepositorio(String linkArepositorio) {
		this.linkArepositorio = linkArepositorio;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && codigo == other.codigo
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", estudios=" + estudios + ", linkArepositorio=" + linkArepositorio + "]";
	}

	@Override
	public boolean isEmpty() {
		
		return codigo == 0 &&
				(nombre == null || nombre.isEmpty()) &&
				(apellido == null || apellido.isEmpty()) &&
				(email == null || email.isEmpty()) &&
				(estudios == null || estudios.isEmpty()) &&
				(linkArepositorio == null || linkArepositorio.isEmpty());			
		
	}
}
