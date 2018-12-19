package ejerciciosmoodle4;

public class Television extends Aparato implements Hablador {

	
	String teletexto;
	int antiguedad;
	
	
	//constructor
	
	public Television(int consumo, int precio, String teletexto, int antiguedad) {
		super(consumo, precio);
		this.teletexto = teletexto;
		this.antiguedad = antiguedad;
	}

	// implementado por eclipse al implementar la interfaz Hablador. Quitar @overrdie
	public void hablar() {
		System.out.println("soy una televison y estos son mis datos ");
		System.out.println("Television [teletexto=" + teletexto + ", antiguedad=" + antiguedad + ", consumo=" + consumo
				+ ", precio=" + precio + "]");
			
	}


}

