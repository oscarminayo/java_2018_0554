package com.ipartek.formacion.modelo.pojos;

public class Perro {

	// Atributos
	private long id;
	private String raza;
	private String img;

	// Constructores

	public Perro() {
		super();
		this.id = -1;
		this.raza = "Chihuahua";
		this.img = "https://t1.ea.ltmcdn.com/es/images/8/2/2/img_adiestrar_a_un_chihuahua_20228_600.jpg";
	}
	
	public Perro(String raza) {
		this();
		this.raza = raza;
	}
	

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	// Otros metodos => toString
	
	@Override
	public String toString() {
		return "Perro [id=" + id + ", raza=" + raza + ", img=" + img + "]";
	}
	

}