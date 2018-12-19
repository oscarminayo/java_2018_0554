package ejerciciosmoodle4;

public class Piolin extends Canario implements Hablador{

	int numeroPeliculas;

	
	
	public Piolin(String sexo, int edad, String canta, int numeroPeliculas) {
		super(sexo, edad, canta);
		this.numeroPeliculas = numeroPeliculas;
	}

	// implementado por eclipse al implementar la interfaz Hablador. Quitar @overrdie
	public void hablar() {
		System.out.println("soy PIOLIN y estos son mis datos ");
		System.out.println("Piolin [numeroPeliculas=" + numeroPeliculas + ", Canta=" + Canta + ", sexo=" + sexo + ", edad=" + edad
				+ "]");
	}


	
}
