package com.ipartek.formacion.modelo.pojos;

public class AltavozPojo {

	// atributos
	
	private Long id,spl;
	private String marca,modelo;

	
	// constructor superclase
	
	public AltavozPojo() {
		super();
		this.id = (long) 0;
		this.spl = (long) 0;
		this.marca = "";
		this.modelo = "";
		// TODO Auto-generated constructor stub
	}

// METODO CONSTRUCTOR CON PARAMETROS
	public AltavozPojo(Long id, Long spl, String marca, String modelo) {
		super();
		setId (id);
		setSpl(spl);
		setMarca(marca);
		setModelo(modelo);
	}


//GETTERS AND SETTERS

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getSpl() {
		return spl;
	}


	public void setSpl(Long spl) {
		this.spl = spl;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
		
	@Override
	public String toString() {
		return "AltavozPojo [id=" + id + ", spl=" + spl + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

	
}
