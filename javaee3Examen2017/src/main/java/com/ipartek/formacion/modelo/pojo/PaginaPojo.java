package com.ipartek.formacion.modelo.pojo;

public class PaginaPojo{
	
	private String texto;
	private String autor;
	
	public PaginaPojo() {
		super();
		this.autor = "";
		this.texto = "";
	}
	
	public PaginaPojo(String texto, String autor) {
		this();
		this.autor = autor;
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

	
	// to string
	@Override
	public String toString() {
		return "PaginaPojo [autor=" + autor + ", texto=" + texto + "]";
	}
	
}
