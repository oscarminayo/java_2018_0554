package ejerciciosmoodle4;

public class Radio extends Aparato implements Hablador {

	
	//atributos
	String casette;
	int potencia;
	
	
	//constructor
	
	public Radio(int consumo, int precio, String casette, int potencia) {
		super(consumo, precio);
		this.casette = casette;
		this.potencia = potencia;
	}
	

	// implementado por eclipse al implementar la interfaz Hablador. Quitar @overrdie
	public void hablar() {
		System.out.println("soy una radio y estos son mis datos ");
		System.out.println("Radio [casette=" + casette + ", potencia=" + potencia + ", consumo=" + consumo + ", precio=" + precio
				+ "]");	
	}


	

}
