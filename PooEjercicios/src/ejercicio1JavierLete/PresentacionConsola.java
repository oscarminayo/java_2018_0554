package ejercicio1JavierLete;

import java.util.ArrayList;


public class PresentacionConsola {
	private static ArrayList<LibroSubclase> listaLibros = new ArrayList<>();  //cambio 
	
	//SIN CAPA DE ACCESO DATOS
	
	
	
	static  void menu () {
	String opcion;
		do {
		mostrarMenu();
		
		opcion = Consola.leerLinea("Dime qu� opci�n quieres");
		
		procesarOpcion(opcion);
	}while (!"0".equals(opcion));
	}
	//CON CAPA DE ACCESO DATOS
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
		switch(opcion) {
		case "0": System.out.println("Salir"); break;
		case "1": listado(); break;
		case "2": alta(); break;
		//case "3": modificacion(); break;
		//case "4": baja(); break;
		//case "5": buscar id(); break;
		//case "6": buscar bn(); break;
		// TODO: Otras opciones
		default: System.out.println("No existe esa opci�n");
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

	private static void listado() {
		for(LibroSubclase listaLibros: listaLibros) {  //cambio
			System.out.println(listaLibros); 			 //cambio
		}
	}

	private static void alta() {
		   //cambio
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
			
		} while(errorPassword);
		

		return usuario;
	}
}
