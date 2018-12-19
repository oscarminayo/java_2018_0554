package ejerciciosmoodle4;

public class Lavadora extends Aparato {

	//atributos
		
		long alto;
		long bajo;
		
		
		//constructor
		public Lavadora(int consumo, int precio, long alto, long bajo) {
			super(consumo, precio);
			this.alto = alto;
			this.bajo = bajo;
		}
		
	
}
