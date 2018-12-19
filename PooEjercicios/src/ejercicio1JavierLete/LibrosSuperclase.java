/*Preguntas
 * Como hago un menu para elegir lo que quiero hacer entre dar un alta, baja , modificar, buscar por id......
 * Se har�a con una interface?
 * como busco por ID
 * Como hago el m�todo salir
 * Hasta ahora se guardar los datos de un nuevo libro. como hago para guardar de dos y que se queden regitrados
 * 
 * NO entiendo Excepciones
 * ni crudabble ni para que sirve
 *
 *
 *
 *TENGO HECHO
 *LISTADO
 *ALTA
 *BAJA
 *
 *FALTA POR HACER
 *BUSCAR POR ID
 *BUSCAR POR BN
 *MODIFICACION
 *SALIR
 *
 */

package ejercicio1JavierLete;

import java.util.ArrayList;
import java.util.Iterator;

// clase Padre/SuperClase
public class LibrosSuperclase {


	// Metodo mainclase Padre
	public static void main(String[] args) {
		
		//Atributos clase Padre 
		 long id, bn, precio,ejemplares,baja=0,prestados=0;
		 String titulo, editorial;
		 
		// objetos
		//Scanner sc = new Scanner(System.in); //objeto clase Scanner de java util para guardar datos de teclado  NO USO    
		Consola c = new Consola (); // EN LUGAR DE METODO Scanner
		LibroSubclase libroSubclase = new LibroSubclase ();
		//LibroSubclase.menu();
			
		
		//------------------------------CREACION DE OBJETOS DE TIPO LIBRO----------------------------------

				/*
				 * //listados de objetos (cantidad de libros que hay registrados ) LibroSubclase
				 * libro3 = new LibroSubclase(03,03,50,"El patio", "raff",3,0,2); LibroSubclase
				 * libro4 = new LibroSubclase(04,04,30,"Malaka", "el sotano" ,3,2,1);
				 * 
				 * //listados de objetos (cantidad de libros que hay registrados CON ARRAY )
				 * LibroSubclase listaLibros []= new LibroSubclase[2]; // Array para hacer una
				 * lista de libros listaLibros [0] = new LibroSubclase(01,01,50,"El quijote" ,
				 * "santillana" , 3, 0,3); //creo un objeto (un libro) y lo almaceno en la
				 * posicion 0 del array listaLibros [1] = new LibroSubclase(02,02,30,"El deseo",
				 * "santillana",3,1,2);
				 */

				// Con ARRAYLIST
		
		ArrayList<LibroSubclase> listaLibros = new ArrayList<LibroSubclase>(); 

				// Anadir elementos instanciados (new) directamente.
				listaLibros.add(new LibroSubclase(0, 0, 30, 1, 2, 1, "Molusics", "el sotano"));
				listaLibros.add(new LibroSubclase(1, 1, 50, 3, 0, 3, "El quijote", "santillana"));
				listaLibros.add(new LibroSubclase(2, 2, 30, 3, 1, 2, "El deseo", "santillana"));
				listaLibros.add(new LibroSubclase(3, 3, 50, 3, 0, 2, "El patio", "raff"));
				listaLibros.add(new LibroSubclase(4, 4, 30, 3, 2, 1, "Malaka", "el sotano"));
				listaLibros.add(new LibroSubclase(5, 5, 50, 5, 0, 3, "El pop", "santillana"));
				listaLibros.add(new LibroSubclase(7, 7, 30, 3, 1, 6, "Elgujk", "santillana"));
				listaLibros.add(new LibroSubclase(8, 8, 50, 2, 0, 2, "El malafolla", "raff"));

				// Métodos ArrayList

				// 1 recorta los huecos vacios del array para optimizar recursos

				// listaLibros.trimToSize();

				/*
				 * 2 metodo de array list para definir la capacidad. Por defecto un array list
				 * cuando llega a 10 elemento si nos empeñamos en incluir un elemnto mas todo
				 * funciona pero crea una copia preparada para la nueva cantidad y borra la
				 * anterior. Esto puede consumir muchos recursos en principio se usa ArrayList
				 * cuando no sabemos cuantos elementos va tener por tanto definir su capacidad
				 * puedo no sernos util.
				 */

				// listaLibros.ensureCapacity(100);

				// 4 // metodo para incluir un libro indicandole la posicion que ocupa en el
				// array NUEVO LIBRO

				

				// con el metodo toString
				// System.out.println(nuevolibro.toString());

				// 5 //Metodo para que me de el elemento 5
				//System.out.println("Elemento buscado por posicion " + listaLibros.get(5));
				//System.out.println("Elemento busado por id " + listaLibros.get((int) (id = 6 - 1)));
				// 6

				// 7 metodo de clase arraylist que muestra cuantos elementos/libros hay
				//System.out.println(listaLibros.size());

				/*
				 * 8 Forma de recorrer un Array List CON BUCLE FOR int tamañoArray =
				 * listaLibros.size(); //Declaro una variable donde guardo el tamaño del array
				 * mediante el metodo size de la clase Array List for(int
				 * i=0;i<listaLibros.size();i++) { // Recorro el arra
				 * System.out.println(listaLibros.get(i)); // escribo por pantalla los elementos
				 * del array (i) mediante el metodo get de la clase ArrayList }
				 */

				// Metodos de Iterator . INTERFACE ITERATOR PARA ARRAY LIST QUE CONTIENE METODOS
				// PARA RECORRER Y ACCEDER A ELEMENTOS DEL ARRAY

				// para mostrar datos
				Iterator<LibroSubclase> iterador = listaLibros.iterator(); // El iterator queda guardado en iterador
				while (iterador.hasNext()) { // HASNEXT boolan que nos dice si hay libros/elementos o no //mientras haya
												// elementos....
					System.out.println(iterador.next()); // NEXT para recorrer y mostrar todos los datos del array

				}

		//------------------------------FIN DE CREACION DE OBJETOS DE TIPO LIBRO----------------------------------	

		//-----------------------------------ALTA----------------------------

				// objeto para ingresar nuevo libro // CREAR UN ALTA
				LibroSubclase nuevolibro = new LibroSubclase(); // objeto para nuevo libro

				// PEDIR DATOS PARA NUEVO LIBRO. ALTA.
				System.out.print("Introduce titulo de nuevo libro: ");
				titulo = c.leerLinea();
				System.out.print("Introduce autor de nuevo libro: ");
				editorial = c.leerLinea();
				System.out.print("Introduce numero de ejemplares de nuevo libro: "); // leerLinea porque es String
				ejemplares = c.leerLong(); // variables long
				System.out.print("Introduce id de nuevo libro: ");
				id = c.leerLong();
				System.out.print("Introduce bn de nuevo libro: ");
				bn = c.leerLong();
				System.out.print("Introduce precio de nuevo libro: ");
				precio = c.leerLong();

				// LLamadas setter (LOS SETTERS MODIFICAN EL VALOR DE LA VARIABLE PADRE. EL
				// VALOR QUE LE PONEN ES EL DE LA CLASE HIJO
				nuevolibro.setTitulo(titulo);
				nuevolibro.setEditorial(editorial);
				nuevolibro.setId(id);
				nuevolibro.setBn(bn);
				nuevolibro.setPrecio(precio);
				nuevolibro.setBaja(baja);
				nuevolibro.setEjemplares(ejemplares);
				nuevolibro.setPrestados(prestados);

				// mostrar los datos GETTERS DEL OBJETO NUEVO LIBRO. DATOS DEL ALTA CREADA
				System.out.println("Libro nuevo:");
				System.out.println("Titulo: " + nuevolibro.getTitulo());
				System.out.println("Editorial: " + nuevolibro.getEditorial());
				System.out.println("Ejemplares: " + nuevolibro.getEjemplares());
				System.out.println("Id: " + nuevolibro.getId());
				System.out.println("Bn: " + nuevolibro.getBn());
				System.out.println("Precio: " + nuevolibro.getPrecio());
				System.out.println("Prestados: " + nuevolibro.getPrestados());
				System.out.println("Baja: " + nuevolibro.getBaja());
				// -----------------------------------FIN DE ALTA----------------------------

				/*
				 * ---------------mostrar datos de nuevo libro ----------------------------
				 * //con el metodo toString System.out.println(nuevolibro.toString());
				 * 
				 * //Si se ha prestado
				 * 
				 * //se realiza un pr�stamo de libro1. El m�todo devuelve true si se ha podido
				 * //realizar el pr�stamo y false en caso contrario if (nuevolibro.prestamo()) {
				 * System.out.println("Se ha prestado el libro " + nuevolibro.getTitulo()); }
				 * else { System.out.println("No quedan ejemplares del libro " +
				 * nuevolibro.getTitulo() + " para prestar"); }
				 * 
				 * // Si se ha devuelto
				 * 
				 * //se realiza una devoluci�n de libro1. El m�todo devuelve true si se ha
				 * podido //realizar la devoluci�n y false en caso contrario if
				 * (nuevolibro.devolucion()) { System.out.println("Se ha devuelto el libro " +
				 * nuevolibro.getTitulo()); } else {
				 * System.out.println("No hay ejemplares del libro " + nuevolibro.getTitulo() +
				 * " prestados"); }
				 * 
				 * //---------------fin mostrar datos de nuevo libro
				 * ----------------------------
				 */

				// FIN LISTADO3

				// LISTADO

			}



















	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//PresentacionConsola presentacion = new PresentacionConsola ();
		
		//PresentacionConsola.mostrarMenu();
		

		//   ---------------------------------PRESENTACION CONSOLA---------------------
		
		
		
		//METER LOS METODOS EN PRESENTACION CONSOLA

	

	// CON CAPA DE ACCESO DATOS
//	CrudAble<Usuario> usuarios = new UsuarioDaoArrayList();
//
//	usuarios.insert(pedirUsuario());
//	usuarios.update(new Usuario(1L, "javi@lete.com", "Contrase�a1A!"));
//	usuarios.delete(2L);
//
//	for (Usuario usuario : usuarios.getAll()) {
//		System.out.println(usuario);
//	}
//
//	System.out.println(usuarios.getById(1L));

	static void procesarOpcion(String opcion) {
		ArrayList<LibroSubclase> listaLibros = new ArrayList<LibroSubclase>();
		switch (opcion) {
		case "0":
			System.out.println("Salir");
			break;
		case "1":LibroSubclase.altaLibro(listaLibros);

			break;
		case "2":
			;
			break;
		// case "3": modificacion(); break;
		// case "4": baja(); break;
		// case "5": buscar id(); break;
		// case "6": buscar bn(); break;
		// TODO: Otras opciones
		default:
			System.out.println("No existe esa opci�n");
		}
	}

	static void mostrarMenu() {
		System.out.println("libreria virtual");
		System.out.println("--------");
		System.out.println("1. Listado");
		System.out.println("2. Alta");
		System.out.println("3. Modificacion");
		System.out.println("4. Baja");
		System.out.println("5. Buscar id");
		System.out.println("6. Buscar bn");
		// TODO: Resto de opciones
		System.out.println("0. Salir");
	}

	

}

