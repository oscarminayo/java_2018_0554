package ejerciciosmoodle4;

public class Profesor extends Persona implements Hablador{

	//Variables
	String despacho;
	String email;
	
	// constructor
	public Profesor(String nombre, int edad, String despacho, String email) {
		super(nombre, edad);
		this.despacho = despacho;
		this.email = email;
	}

	
	// implementado por eclipse al implementar la interfaz Hablador
	public void hablar() {
		System.out.println("soy un profesor y estos son mis datos ");
		System.out.println( "Profesor [despacho=" + despacho + ", email=" + email + ", nombre=" + nombre + ", edad=" + edad + "]");
			
	}



}
