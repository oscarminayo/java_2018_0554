package ejerciciosmoodle4;

public class Alumno extends Persona implements Hablador{
// atributos
	String carrera;
	int curso;
	
	//constructor
	public Alumno(String nombre, int edad, String carrera, int curso) {
		super(nombre, edad);
		this.carrera = carrera;
		this.curso = curso;
	}

	// implementado por eclipse al implementar la interfaz Hablador
		public void hablar() {
			System.out.println("soy una alumno y estos son mis datos ");
			System.out.println("Alumno [carrera=" + carrera + ", curso=" + curso + ", nombre=" + nombre + ", edad=" + edad + "]");	
		}

		
}
