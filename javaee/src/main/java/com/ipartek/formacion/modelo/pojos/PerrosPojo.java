package com.ipartek.formacion.modelo.pojos;

public class PerrosPojo {

	//ATRIBUTOS
	private Long id,chip;
	private String nombre;
	private String raza;
	
	
	// METODO CONSTRUCTOR SUPERCLASE
	public PerrosPojo() {
		super();
		this.id = (long)+1;;  // casting para Long. Que pasaria si declaro la variable Long a primitiva long
		this.chip =(long)+1;;
		this.nombre = "";
		this.raza ="";
		id ++;
		chip ++;
	}
	
	// METODO CONSTRUCTOR CON PARÁMETROS
	public PerrosPojo(Long id, Long chip, String nombre, String raza) {
		super();
		setId (id +1);
		setChip (chip+1); // + 1 para no empezar en 0
		setNombre (nombre);
		setRaza (raza);
		id ++;
		chip ++;
	}
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChip() {
		return chip;
	}

	public void setChip(Long chip) {
		this.chip = chip;
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

	
	
	
	
	//TO STRING
	@Override
	public String toString() {
		return "PerrosPojo [id=" + id + ", chip=" + chip + ", nombre=" + nombre + ", raza=" + raza + "]";
	}
	
	
	
	
}