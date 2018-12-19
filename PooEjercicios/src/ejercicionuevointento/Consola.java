package ejercicionuevointento;



import java.util.Scanner;

public class Consola {
	
	// TEXTO
	
	private static final String FORMATO = "[%s]: ";
	
	private static Scanner sc = new Scanner(System.in);
	
	//MENSAJE
	private static void mostrarMensaje(String mensaje) {
		if(mensaje != null) {
			System.out.print(String.format(FORMATO, mensaje));
		}
	}
	
	// LINEA
	public static String leerLinea(String mensaje) {
		mostrarMensaje(mensaje);
		
		return sc.nextLine();
	}
	
	public static String leerLinea() {
		return leerLinea(null);
	}
	
	
	


	
	
	
	
	//LONG
	public static Long leerLong(String mensaje) {
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
				
				System.out.println("El dato no es un n�mero");
				hayErrores = true;
			} finally {
				//sc.nextLine();
			}
			
		} while(hayErrores);
		
		return l;
	}


	public static Long leerLong() {
		return leerLong(null);
	}

	}

