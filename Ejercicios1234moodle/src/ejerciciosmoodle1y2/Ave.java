package ejerciciosmoodle1y2;

public class Ave {

	
	
	
	// atributos de instancia
	private String sexo;
	private int edad;
	
	// atributos de clase
	private static int numeroAves;

	// metodo constructor
	public Ave(String sexo, int edad) {
		super();
		this.sexo = sexo;
		this.edad = edad;
		numeroAves ++;
	}
	
	// metodo numero de Aves  // void porque me lo pide eclipse
	public void NumeroAves () {
		System.out.println(" El numero de Aves que hay es: " + numeroAves);
	}

	
	// metodos setters y getters para numero de Aves
	
	public static int getNumeroAves() {
		return numeroAves;
	}

	public static void setNumeroAves(int numeroAves) {
		Ave.numeroAves = numeroAves;
	}
	
	// metodo para mostrar datos de variables por pantalla
	void QuienSoy()
	{
		System.out.println("Soy " + sexo + " y tengo " + edad + " a�os");
	}


}
