//PREGUNTAS:



	// 1 no he utilizado setters ni getters y muchos de los metodos los he escrito en la clase main. Estoy haciendo algo mal?


package ejercicionuevointento;

public class Libro { 											// clase Libros de la que instanciaremos objetos

	// Variables
	private long idClaseLibro, bnClaseLibro, precioClaseLibro, bajaClaseLibro, prestadosClaseLibro, ejemplaresClaseLibro; 	//  tipo long porque me viene mejor para la clase consola
	private String tituloClaseLibro, editorialClaseLibro; 							//  string tipo texto

	// Constructor por defecto 									//  no lo he utilizado ******************************* pregunta
	public Libro() {

	}

	// Constructor con parametors
	public Libro(long idParametro, long bn2Parametro, long precioParametro, long prestadosParametro, long ejemplaresParametro, long bajaParametro, String tituloParametro,
			String editorialParametro) {
		this.idClaseLibro = idParametro; 											//  con el this hago referencia a la variable/atributo de nombre "id" de esta clase y le doy el valor del argumento del método contructor.
		this.bnClaseLibro = bn2Parametro;
		this.precioClaseLibro = precioParametro;
		this.tituloClaseLibro = (tituloParametro);
		this.editorialClaseLibro = editorialParametro;
		this.ejemplaresClaseLibro = ejemplaresParametro;
		this.bajaClaseLibro = bajaParametro;
		this.prestadosClaseLibro = prestadosParametro;

	}

	// ------------------------------ Getters y Setters------	//NO HE UTILIZADO NINGUNO ******************************* pregunta

	// MODIFICADORES SETTERS                            
	public void setTitulo(String titulo) {  					// metodo set; MODIFICA valor de la variable del metodo contructor. 	NO devuelve valor.
		this.tituloClaseLibro = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorialClaseLibro = editorial;
	}

	public void setId(long id) {
		this.idClaseLibro = id;
	}

	public void setBn(long bn) {
		this.bnClaseLibro = bn;
	}

	public void setPrecio(long precio) {
		this.precioClaseLibro = precio;
	}

	public void setEjemplares(long ejemplares) {
		this.ejemplaresClaseLibro = ejemplares;
	}

	public void setPrestados(long prestados) {
		this.prestadosClaseLibro = prestados;
	}

	public void setBaja(long baja) {
		this.bajaClaseLibro = baja;
	}

	// ACCESORES/OBTENER GETTERS

	public String getTitulo() {                         		 // metodos get; OBTIENE EL VALOR DE LA VARIABLE DEL METODO CONSTRUCTOR
		return tituloClaseLibro;
	}

	public long getPrecio() {
		return precioClaseLibro;
	}

	public String getEditorial() {
		return editorialClaseLibro;
	}

	public long getBaja() {
		return bajaClaseLibro;
	}

	public long getPrestados() {
		return prestadosClaseLibro;
	}

	public long getEjemplares() {
		return ejemplaresClaseLibro;
	}

	public long getId() {
		return idClaseLibro;
	}

	public long getBn() {
		return bnClaseLibro;
	}
	
	
	
	
	//METODO GETTER PROPIO
	public String getDameDatos() {   // METODO PARA OFRECER LOS DATOS DE CADA LIBRO. GETTER QUE DEVUELVE CADA VALOR DE LAS VARIABLES DEL METODO CONTRUCTOR
		return "Id " + idClaseLibro + ". Bn " + bnClaseLibro + ". Precio" + precioClaseLibro + ". Prestados " + prestadosClaseLibro + ". Ejemplares "
				+ ejemplaresClaseLibro + ". Baja " + bajaClaseLibro + ". Titulo " + tituloClaseLibro + ". Editorial " + editorialClaseLibro;
	}

	

	
	
	// ----------------Final Getters y Setters ---------------------------------

	


}



