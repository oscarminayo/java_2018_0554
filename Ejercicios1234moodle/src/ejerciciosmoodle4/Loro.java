package ejerciciosmoodle4;

public class Loro extends Ave implements Hablador {

	// Atributos
		char region;
		String color;
		

		
		public Loro(String sexo, int edad, char region, String color) {
			// TODO Auto-generated constructor stub
			super(sexo, edad);
			this.region = region;
			this.color = color;
		}

		

		// implementado por eclipse al implementar la interfaz Hablador. Quitar @overrdie
		public void hablar() {
			System.out.println("soy un loro y estos son mis datos ");
			System.out.println("Loro [region=" + region + ", color=" + color + ", sexo=" + sexo + ", edad=" + edad + "]");
		}


	
}
