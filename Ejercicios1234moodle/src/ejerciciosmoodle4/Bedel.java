package ejerciciosmoodle4;

public class Bedel extends Persona implements Hablador{

	//Variables
		String turno;
		int antiguedad;
		
		
		//constructor
		public Bedel(String nombre, int edad, String turno, int antiguedad) {
			super(nombre, edad);
			this.turno = turno;
			this.antiguedad = antiguedad;
		}
		
		// implementado por eclipse al implementar la interfaz Hablador. Quitar @overrdie
		public void hablar() {
			System.out.println("soy un bedely estos son mis datos ");
			System.out.println("Bedel [turno=" + turno + ", antiguedad=" + antiguedad + ", nombre=" + nombre + ", edad=" + edad
					+ "]");	
		}

		
		

}
