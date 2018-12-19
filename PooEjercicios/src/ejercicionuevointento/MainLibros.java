
// me lio con donde poner cada boque "pestañas"

// como puedo buscar un elemento concreto del array list por ejemplo por titulo.

package ejercicionuevointento;

import java.util.ArrayList;
import java.util.Iterator;
// para LISTADO. 
import java.util.Scanner; // PARA MOSTRAR DATOS

public class MainLibros { // CLASE PRINCIPAL. SUPERCLASE
	public static ArrayList<Libro> listaLibros; // Declarar en clase principal para que sea común

	public static Scanner sc = new Scanner(System.in); // public static Consola c = new Consola(); // EN LUGAR DE METODO
														// Scanner

	// ATRIBUTOS/VARIABLES CLASE PRINCIPAL
	public static long idClasePrincipal, bnClasePrincipal, precioClasePrincipal, ejemplaresClasePrincipal,
			bajaClasePrincipal, prestadosClasePrincipal, numeroLibrosClasePrincipal;
	public static String tituloClasePrincipal, editorialClasePrincipal;
	static Libro Libro = new Libro();

	// Metodo mainclase SUPERCLASE
	public static void main(String[] args) {

		// Intanciar la clase libros para poder usar sus metodos. CREACION DE OBJETO CON
		// NOMBRE LIBROS DE LA CLASE LIBROS. "LE PONGO EL MISMO NOMBRE

		// ArrayList con libros
		listaLibros = new ArrayList<Libro>(); // lista para almacenar los Libros. Array

		// Anadir elementos instanciados (new) directamente.
		listaLibros.add(new Libro(0, 0, 30, 1, 2, 1, "Molusics", "el sotano")); // con el metodo .add añadimos elemento
																				// a la lista del Array
		listaLibros.add(new Libro(1, 1, 50, 3, 0, 3, "El quijote", "santillana"));
		listaLibros.add(new Libro(2, 2, 30, 3, 1, 2, "El deseo", "santillana"));
		listaLibros.add(new Libro(3, 3, 50, 3, 0, 2, "El patio", "raff"));
		listaLibros.add(new Libro(4, 4, 30, 3, 2, 1, "Malaka", "el sotano"));
		listaLibros.add(new Libro(5, 5, 50, 5, 0, 3, "El pop", "santillana"));
		listaLibros.add(new Libro(6, 7, 30, 3, 1, 6, "Elgujk", "santillana"));
		listaLibros.add(new Libro(7, 8, 50, 2, 0, 2, "El malafolla", "raff"));

		// Modifico el valor del parametro del metodo setter y sustituyendolo por el
		// valor de la clase principal
		Libro.setTitulo(tituloClasePrincipal);
		Libro.setEditorial(editorialClasePrincipal);
		Libro.setId(idClasePrincipal);
		Libro.setBn(bnClasePrincipal); // PREGUNTA EN QUE CASOS ME VIENE BIEN ESTO PORQUE NO LO HE
										// UTILIZADO?**************
		Libro.setPrecio(precioClasePrincipal);
		Libro.setBaja(bajaClasePrincipal);
		Libro.setEjemplares(ejemplaresClasePrincipal);
		Libro.setPrestados(prestadosClasePrincipal);

		// Presentacion consola

		String opcion;

		int interruptor = 1; // no funciona. INTENTO QUE NO SE VUELVA A REINICIAR LA PRESENTACION
		if (interruptor == 1) {
			do { // HACER ESTO HASTA QUE OPCION SEA 0
				interruptor = 0;
				System.out.println("Base de datos de la librería: "); // PIDO AL USUARIO QUE INDICQUE LO QUE KIERE HACER
				System.out.println("--------");
				System.out.println("1. Listado");
				System.out.println("2. Alta");
				System.out.println("3. Modificacion");
				System.out.println("4. Baja");
				System.out.println("5. Buscar id");
				System.out.println("6. Buscar titulo");

				// TODO: Resto de opciones
				System.out.println("0. Salir");

				opcion = Consola.leerLinea("Dime que opcion quieres"); // GUARDO EL NUMERO EN LA VARIABLE OPCION

				switch (opcion) { // MAKINA DE ESTADOS
				case "0":
					System.out.println("Salir");
					break;
				case "1":
					bucleDameDatos();
					Libro.getDameDatos();
					break; // recorro el arrayList Y LUEGO PIDO DATOS

				case "2":
					alta();
					break; // ANALIZAR METODO ALTA ETC

				case "3":
					modificacion();
					break;

				case "4":
					baja();
					break;

				case "5":
					buscarid();
					break;

				case "6":
					buscarLibro();
					break;
				// TODO: Otras opciones
				default:
					System.out.println("No existe esa opcion"); // SI EL NUMERO MARCADO NO COINCIDE CON LAS OPCIONES
																// DISPONIBLES APARECE ESTE MENSAEJ
					System.out.println("--------------------");
				}

			} while (!"0".equals(opcion) || interruptor == 0); // EL BUCLE SE REPITE MIENTRAS 0 SE DIFERENTE A LA
																// VARIABLE DE CONTROL OPCION

		} else {
			System.out.println("MENSAJE PARA REINICIAR CONSOLA"); // A PARTIR DE AQUI FALTAN INTRUCCIONES QUE NO PONDRÉ
																	// HASTA QUE CONSIGA LO DEL INTERRUPTOR
		}

	}// -------------------------- fin metodo
		// main---------------------------------------


	

	private static void alta() { // METODO PARA DAR DE ALTA UN LIBRO

		System.out.println("¿Cuántos libros desea dar de alta?: ");
		numeroLibrosClasePrincipal = Consola.leerLong();

		for (int i = 0; i < numeroLibrosClasePrincipal; i++) { // menor que numeroLibros para dar de alta UNICAMENTE AL
																// NUMERO DE LIBRO INDICADO
			System.out.println("Escriba las características del libro: " + (i + 1)); // (i+1) PARA LIBRO 1, LIBRO 2 ,
																						// ETC
			// PEDIR DATOS PARA NUEVO LIBRO. ALTA.
			System.out.print("Introduce titulo de nuevo libro: ");
			tituloClasePrincipal = Consola.leerLinea(); // el dato introducido se guarda en la variable/argibuto de
														// nombre titulo de la Superclase.
			System.out.print("Introduce autor de nuevo libro: ");
			editorialClasePrincipal = Consola.leerLinea();
			System.out.print("Introduce numero de ejemplares de nuevo libro: "); // leerLinea porque es String
			ejemplaresClasePrincipal = Consola.leerLong(); // variables long
			System.out.print("Introduce numero de ejemplares prestados de nuevo libro: "); // leerLinea porque es String
			prestadosClasePrincipal = Consola.leerLong(); // variables long

			// La id no se introduce. Se pone automáticamente
			idClasePrincipal = (listaLibros.size()); // la id se pone la primera libre. como size siempre da un numero
														// mas que el numero total de elementos del arrayList debido a
														// que el primer elemento empieza por 0; no hace falta sumarle 1

			System.out.print("Introduce precio de nuevo libro: ");
			bnClasePrincipal = Consola.leerLong(); // no puedo hacer lo mismo que en id xq el nº bn es muy distinto a id
													// (sirve para bases de datos) aunque en este ejemplo sea igual
			System.out.print("Introduce precio de nuevo libro: ");
			precioClasePrincipal = Consola.leerLong();
			System.out.print("introduce Numero de ejemplares que se han dado de baja ");
			bajaClasePrincipal = Consola.leerLong();

			// guardamos los libros dados de alta como nuevos elementos del Array mediante
			// le método .add
			listaLibros.add(new Libro(idClasePrincipal, bnClasePrincipal, precioClasePrincipal, prestadosClasePrincipal,
					ejemplaresClasePrincipal, bajaClasePrincipal, tituloClasePrincipal, editorialClasePrincipal));
		}

	}

	private static void modificacion() { // METODO PARA MODIFICAR UN ELEMENTO DEL ARRAY, ES DECIR MODIFICAR LOS DATOS DE
											// UN LIBRO

		System.out.println("Id del libro que desea modificar ");
		int idBuscar = sc.nextInt(); // guarda el dato introducido en la variable idBuscar y utlizo SCANNER PORQUE
										// CONSOLA AUN NO ESTÁ PREPARADA PARA INT

		for (int i = 0; i < listaLibros.size(); i++) { // recorro el ARRay List con for
			// Libros e =listaLibros.get(i); no utilizado // creo que coge la id propia del
			// array list

			if (idBuscar == i) { // si el dato introducido es igual a la variable de control con la que recorro
									// el Array, es decir si el dato es igual a la id del Array . LA PROPIA. NO LA
									// QUE YO LE DOY
				System.out.print("modifica el titulo del libro con numero de  ID " + i + ":");
				tituloClasePrincipal = Consola.leerLinea();
				System.out.print("modifica el  autor del libro con numero de ID  " + i + ":");
				editorialClasePrincipal = Consola.leerLinea();// variables LINEA para texto
				System.out.print("modifica el numero de ejemplares del libro con numero de ID  " + i + ":"); // leerLinea
																												// porque
																												// es
																												// String
				ejemplaresClasePrincipal = Consola.leerLong(); // variables long para int
				System.out.print("modifica el numero de ejemplares prestados del libro con numero de ID  " + i + ":"); // leerLinea
																														// porque
																														// es
																														// String
				prestadosClasePrincipal = Consola.leerLong();
				System.out.print("modifica el numero id del libro con numero de ID   " + i + ":");
				idClasePrincipal = Consola.leerLong();
				System.out.print("modifica el numero bn del libro con numero de ID   " + i + ":");
				bnClasePrincipal = Consola.leerLong();
				System.out.print("modifica el precio del libro con numero de ID  : " + i + ":");
				precioClasePrincipal = Consola.leerLong();
				System.out
						.print("modifica el numero de ejemplares que se han dado de baja del libro con numero de ID   "
								+ i + ":");
				bajaClasePrincipal = Consola.leerLong();

				// guardamos las modificaciones como nuevos elementos del Array mediante le
				// método .add
				System.out.println(listaLibros.set(idBuscar,
						new Libro(idClasePrincipal, bnClasePrincipal, precioClasePrincipal, prestadosClasePrincipal,
								ejemplaresClasePrincipal, bajaClasePrincipal, tituloClasePrincipal,
								editorialClasePrincipal)));
			}
		}

	}

	private static void baja() { // dar de baja un libro. ELIMINAR
		System.out.println("id del libro que desea dar de baja ");

		int idBaja = sc.nextInt(); // GUARDAMOS LA ID INTRODUCIDA EN IDBAJA // UTILIZO CONSOLA CON LEERLONG
		System.out.println("¿Estas seguro?, escribe Si o No ");
		String respuestaEliminar = Consola.leerLinea(); // si la respuesta es si eliminar mediante el metodo .remove de
														// ArrayList

		if (respuestaEliminar.equals("si") || respuestaEliminar.equalsIgnoreCase("SI")) { // if
																							// (respuestaEliminar.equalsIgnoreCase
																							// ("m")){ para ignorar
																							// maúsculas es igual a si
																							// lo eliminanos
			System.out.println("El libro que se ha eliminado es  " + listaLibros.get(idBaja).getDameDatos()); // mostrar
																												// el
																												// elemento
																												// borrado
			listaLibros.remove(idBaja); // Elimina el elemento cuya ipPropia coincide con el valor introducido por
										// teclado
			System.out.println("------------------------------------------------");
		} else {
			System.out.println("operacion eliminar cancelada"); // si la respuesta es diferente a si se cancela y no se
																// elimina el elemento del arrayList
		}
	}

	public static void bucleDameDatos() { // RECORRE EL ARRAY LIST
		for (Libro e : listaLibros) { // BULCE FOR EACH
			System.out.println(e.getDameDatos()); // IMPRIME EN PANTALLA EL METODO GETDAMEDATOS DEL ARRAY LIST. "SE HACE
													// CON "e"
		}
	}

	private static void buscarid() { // METODO PARA BUSCAR POR ID

		System.out.println("numero id que desea buscar ");
		long idBuscar = Consola.leerLong(""); // GUARDAMOS LA ID INTRODUCIDA EN IDBUSCAR // UTILIZO CONSOLA CON LEERLONG
		for (int i = 0; i < listaLibros.size(); i++) { // RECORRO EN ARRAYlIST CON FOR DESDE 0 HASTA SIZE QUE MARCA EL
														// TAMAÑO/ LA CANTIDAD DE ELEMENTOS
			Libro e = listaLibros.get(i); // METODO GET DE LA CLASE aRRAY LIST CON I QUE COINCIDE CON LA ID PROPIA. PARA
											// UTILIZR E HAY QUE INDICAR QUE OBJETO ES . eN ESTE CASO LIBROS
			if (idBuscar == i) { // SI EL VALOR INTRODUCIDO ES IGUAL A LA ID PROPIA
				System.out.println(e.getDameDatos()); // imprimo damedatos de ese elemento "el que coincida con i==
														// idBuscar
			}
		}
	}

	public static void buscarLibro() {  // metodo buscar por nombre
		System.out.print("Digite nombre del título: ");
		String nombre = Consola.leerLinea();
		
		for (int i = 0; i < listaLibros.size(); i++) {
			Libro e = listaLibros.get(i);
			if (e.getTitulo().equalsIgnoreCase(nombre)) {
				System.out.println(e.getDameDatos());
				return;
			}
		}
	}

}
	
/// METODO BUSCAR POR STRING PERO CON BUCLE FOR EACH

//public static void buscarLibro() {  // metodo buscar por nombre
	//System.out.print("Digite nombre del título: ");
	//String nombre = Consola.leerLinea();
		
	//for (Libro e :listaLibros) {
		
			//if (e.getTitulo().equals(nombre)) {
				//System.out.println(e.getDameDatos());
				//return;
			//}
			
		//}

		

