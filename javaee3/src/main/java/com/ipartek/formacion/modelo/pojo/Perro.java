package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Perro {

	// Atributos
	
	private long id;
	
	@NotNull  // VALIDATE
	@Size(min=2, max=150) // VALIDATE
	private String nombre;
	
	@NotNull
	@Size(min=2, max=20)
	private String raza;

	// Constructores

	public Perro() {
		super();
		this.id = -1;  // el atributo de esta variable (-1) es lo que sale en el formulario
		this.nombre = "";
		this.raza = "";
	}
	
	public Perro(long id, String nombre, String raza ) {
		this();
		setId(id);
		setNombre(nombre);
		setRaza(raza);
	}
	

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza + "]";
	}

}
