package ejerciciosmoodle1y2;

public class Piolin extends Canario {
	
	// atributo
		int numeroPeliculas;

		
		
		
		// metodo constructor
	
		public Piolin(String sexo, int edad, int numeroPeliculas) {
			super(sexo, edad);
			this.numeroPeliculas = numeroPeliculas;
		}

	
		// metodo main
		public static void main(String[] args) {
		// TODO Auto-generated method stub

			
			// Crear dos instancias de Piolin y Loro
			Piolin Piolin = new Piolin("macho", 3, 18);
			Loro Loro = new Loro("hembra", 4, 'n', "Rojo");
			
			
			// llamar a metodo quiensoy de las dos instancias creadas Piolin y Loro
			
			Piolin.QuienSoy();
			Loro.QuienSoy();
			System.out.println("--------------------------");
			
			// llamar a metodo altura de piolin
			Piolin.Altura();
			System.out.println("--------------------------");
			
			// llamar a metodo de dondeeres de loro
			Loro.DeDondeEres();
			System.out.println("--------------------------");
			
			// modificar Altura y obtener dato modificado
			Piolin.setAltura(40);
			System.out.println("mi nueva altura es de : " + Piolin.getAltura());
			
			// modificar la region del loro
			Loro.setRegion('s');
			System.out.println("mi nueva region es: " + Loro.getRegion());
			Loro.DeDondeEres();
			System.out.println("--------------------------");
			
			// mosotrar el numero de Aves creadas
			System.out.println("El numero de aves que hay es: " + getNumeroAves());
			
			
			
			
			
			
			
			
	}


}
