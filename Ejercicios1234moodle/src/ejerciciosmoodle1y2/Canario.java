package ejerciciosmoodle1y2;

public class Canario extends Ave{

	// Atributo:
	int altura;

	
	//metodo constructor con los parametros de la clase Padre
	public Canario(String sexo, int edad) {
		super(sexo, edad);  // SUPER para clase Padre
	}
	
	
	// metodo constructor con los parametros de la clase HIJO Y PADRE
	 public Canario(String sexo, int edad, int tamano) {
		super(sexo, edad);  
		this.altura = tamano; // THIS para parametros de la clase hijo. 
	}
	
	// setters y getters para modificar altura
	 
	 public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	// metodo Altura
	 public void Altura () {
		 if (altura >= 30) {
			 System.out.println("Alto");
		 }else if (altura >15 && altura<30) {
			 System.out.println("Mediano");
		 } else if (altura <15 ) {
			 System.out.println("Bajo");
		 }
	 }
}
