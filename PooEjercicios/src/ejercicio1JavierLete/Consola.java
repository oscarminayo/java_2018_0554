package ejercicio1JavierLete;



import java.util.Scanner;

public class Consola {
	private static final String FORMATO = "[%s]: ";
	
	private static Scanner sc = new Scanner(System.in);
	
	// MOSTRAR MENSAJE
		private static void mostrarMensaje(String mensaje) {
			if(mensaje != null) {
				System.out.print(String.format(FORMATO, mensaje));
			}
		}
		
	
	//LEER LINEA
	
	public static String leerLinea() {  // METODO POR DEFECTO
		return leerLinea(null);
	}
	
	public static String leerLinea(String mensaje) { // METODO CON PARAMETROS
		mostrarMensaje(mensaje);
		
		return sc.nextLine();
	}
	
	
	// LEER LONG
	
	public static Long leerLong() { // METODO CONSTRUCTOR POR DEFECTO
		return leerLong(null);
	}
	
	public static Long leerLong(String mensaje) { // METODO CONSTRUCTOR CON PARAMETROS
		boolean hayErrores;
		Long l = null;
		
		do {
			hayErrores = false;
			
			mostrarMensaje(mensaje);
			
			try {
				//l = sc.nextLong();
				l = Long.parseLong(sc.nextLine());
			} catch (Exception e) {
				//System.err.println("El error es " +e);
				
				System.out.println("El dato no es un numero");
				hayErrores = true;
			} finally {
				//sc.nextLine();
			}
			
		} while(hayErrores);
		
		return l;
	}
	
	

	
}
