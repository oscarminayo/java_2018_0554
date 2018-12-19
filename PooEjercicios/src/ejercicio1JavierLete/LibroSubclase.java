package ejercicio1JavierLete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibroSubclase {

	// Variables
	private long id, bn, precio, baja, prestados, ejemplares;
	private String titulo, editorial;

	// Constructor por defecto
	public LibroSubclase() {

	}

	// Constructor con par�metors
	public LibroSubclase(int id, int bn, int precio, int prestados, int ejemplares, int baja, String titulo,
			String editorial) {
		this.id = id; // con el this hago referencia a id de esta clase y le doy el valor del
						// argumento de la funcion/metodo
		this.bn = bn;
		this.precio = precio;
		this.titulo = (titulo);
		this.editorial = editorial;
		this.ejemplares = ejemplares;
		this.baja = baja;
		this.prestados = prestados;

	}

//------------------------------ Getters y Setters--------------------------

	// MODIFICADORES SETTERS
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBn(long bn) {
		this.bn = bn;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public void setEjemplares(long ejemplares) {
		this.ejemplares = ejemplares;
	}

	public void setPrestados(long prestados) {
		this.prestados = prestados;
	}

	public void setBaja(long baja) {
		this.baja = baja;
	}

	// ACCESORES/OBTENER GETTERS

	public String getTitulo() {
		return titulo;
	}

	public long getPrecio() {
		return precio;
	}

	public String getEditorial() {
		return editorial;
	}

	public long getBaja() {
		return baja;
	}

	public long getPrestados() {
		return prestados;
	}

	public long getEjemplares() {
		return ejemplares;
	}

	public long getId() {
		return id;
	}

	public long getBn() {
		return bn;
	}
// ----------------Final Getters y Setters	---------------------------------

	public  static void  menu(){
	String opcion;
	do {
		LibrosSuperclase.mostrarMenu();
		opcion = Consola.leerLinea("Dime qu� opci�n quieres");
		LibrosSuperclase.procesarOpcion(opcion);
	} while (!"0".equals(opcion));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// m�todo de nombre PRESTAMO para realizar el prestamo de un libro
	public boolean prestamo() {
		boolean prestado = true; // INICIO VARIABLE
		if (prestados < ejemplares) {
			prestados++;
		} else {
			prestado = false;
		}
		return prestado;
	}

	// m�todo de nombre DEVOLUCION para realizar la devoluci�n de un libro // 0=no
	public boolean devolucion() {
		boolean devuelto = true;
		if (baja == 0) {
			devuelto = false;
		} else {
			baja--;
		}
		return devuelto;
	}

	// METODO OVERRIDE
	// MOSTRAR LIBRO
	@Override
	public String toString() {
		return "LibroSubclase [id=" + id + ", bn=" + bn + ", precio=" + precio + ", baja=" + baja + ", prestados="
				+ prestados + ", ejemplares=" + ejemplares + ", titulo=" + titulo + ", editorial=" + editorial + "]";
	}

	
	
	
	
	
	private static void listado() {
		;
	}

	private static void alta() {
		;
	}

	private static Usuario pedirUsuario() {
		Usuario usuario = new Usuario();

		usuario.setId(Consola.leerLong("ID"));

		boolean errorEmail;

		do {
			errorEmail = false;

			try {
				usuario.setEmail(Consola.leerLinea("Email"));
			} catch (Exception e) {
				errorEmail = true;
				System.out.println(e.getMessage());
			}
		} while (errorEmail);

		boolean errorPassword;

		do {
			errorPassword = false;

			try {
				usuario.setPassword(Consola.leerLinea("Contrase�a"));
			} catch (Exception e) {
				errorPassword = true;
				System.out.println(e.getMessage());
			}

		} while (errorPassword);

		return usuario;

	}
	
    public static void altaLibro () {
    	
    }
    
	public static void altaLibro (ArrayList<LibroSubclase> listaLibros) {
			  
		listaLibros.add(1, new LibroSubclase(6, 6, 30, 1, 2, 1, "segundo lugar", "el sotano"));
			}
		
	
}
