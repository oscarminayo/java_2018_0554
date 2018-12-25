package com.ipartek.formacion.modelo.pojo;

public class PaginaPojo2 {


	private String autor;
	private String texto;
	
	public PaginaPojo2( String autor, String texto) {
		super();
		
		this.autor = autor;
		this.texto = texto;
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
		PaginaPojo2 other = (PaginaPojo2) obj;
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
