package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Video {

	// Atributos
	
	private long id;
	
	@NotNull  // VALIDATE
	@Size(min=5, max=150) // VALIDATE
	private String nombre;
	
	@NotNull
	@Size(min=11, max=11)
	private String codigo;
	
	private Usuario usuario; // para base de datos relacionadas 

	// Constructores

	public Video() {
		super();
		this.id = -1;  // el atributo de esta variable (-1) es lo que sale en el formulario
		this.nombre = "";
		this.codigo = "";
		this.usuario= new Usuario();  // para tener un usuario en video
	}
	
	// metodo getter para obtener usuario
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Video(long id, String nombre, String codigo ) {
		this();
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
