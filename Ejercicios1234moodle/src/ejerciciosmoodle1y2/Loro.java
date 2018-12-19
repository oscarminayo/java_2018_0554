package ejerciciosmoodle1y2;

public class Loro extends Ave{
// Atributos
	char region;
	String color;
	
	// metodo construcor con todos los parametros (hijos y padres)
	public Loro(String sexo, int edad, char region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}
	
	
	// getter y setters para modificar region
	public char getRegion() {
		return region;
	}

	public void setRegion(char region) {
		this.region = region;
	}

	
	// metodo para saber de donde procede. Utilizo switch case. Ojo al dato de case y la comilla simple
	public void DeDondeEres () {
		switch ( region) {
		case 'n': System.out.println("Soy del norte");break;
		case 's': System.out.println("Soy del sur");break;
		case 'e': System.out.println("Soy del este");break;
		case 'o': System.out.println("Soy del oeste");break;
		}
		
	}
	
	}
	
