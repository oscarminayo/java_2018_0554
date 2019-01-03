package com.ipartek.formacion.modelo.pojo;

public class Mensajes {

	public String tipo, mensaje;

	public Mensajes() {
		super();
		this.tipo = tipo;
		this.mensaje = mensaje;
		// TODO Auto-generated constructor stub
	}

	public Mensajes(String tipo, String mensaje) {
		super();
		setTipo(tipo);
		setMensaje(mensaje);
	
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	@Override
	public String toString() {
		return "Mensajes [tipo=" + tipo + ", mensaje=" + mensaje + "]";
	}

}
