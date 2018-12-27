package com.ipartek.formacion.modelo.pojo;

import java.util.HashMap;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class HomePojo {

	@NotEmpty
	@Size(min=50, max=255)
	private String texto;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	
	public HomePojo( ) {
		super();
		
		this.autor = autor;
		this.texto = texto;
	}

	

	public HomePojo (String autor, String texto) {		
		this();
		setAutor(autor);
		setTexto(texto);
	
	}



	@Override
	public String toString() {
		return "Pagina [ autor=" + autor + ", texto=" + texto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HomePojo other = (HomePojo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		
		return true;
	}

	

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	

	
	
}
