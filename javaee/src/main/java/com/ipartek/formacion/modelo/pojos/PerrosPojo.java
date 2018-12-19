package com.ipartek.formacion.modelo.pojos;

public class Perro {

	// atributos
	private long id, chip;
	private String nombre;
	private String raza;
	private String imagen;

// METODOS CONSTRUCTORES

	public Perro() {  // SIN PARAMETROS
		super();
		this.id = -1;
		this.nombre = "Negu";
		this.chip = 1305;
		this.raza = "perro de aguas";
		this.imagen = "https://www.petjiltonclub.com/fe-770x300-ffffff-data/fotos/perro-marron-de-agua.jpgperro de aguas";
	}

	public Perro(long id, long chip, String nombre, String raza, String imagen) { // CON PARAMETROS
		this();
		setId (id);
		setNombre (nombre);
		setChip (chip);
		setRaza (raza);
		setImagen (imagen);

	}
		
	//GETTER Y SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getChip() {
		return chip;
	}

	public void setChip(long chip) {
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	// toString
	@Override
	public String toString() {
		return "Perro [id=" + id + ", chip=" + chip + ", nombre=" + nombre + ", raza=" + raza + ", imagen=" + imagen
				+ "]";
	}

}
