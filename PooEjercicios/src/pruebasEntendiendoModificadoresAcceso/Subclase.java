package pruebasEntendiendoModificadoresAcceso;

public class Subclase {

	// variables 
	long hijoA, hijoB, hijoC;
	int hijoD;
	String textoHijoA, textoHijoB;
	
	// constructor po defecto
	
	public Subclase () {
		
	}

	// constructor con parámetros
	public Subclase(long hijoA, long hijoB, long hijoC, int hijoD, String textoHijoA, String textoHijoB) {
		super();
		this.hijoA = hijoA;
		this.hijoB = hijoB;
		this.hijoC = hijoC;
		this.hijoD = hijoD;
		this.textoHijoA = textoHijoA;
		this.textoHijoB = textoHijoB;
		
		// getter and setter
		
	}

	public long getHijoA() {
		return hijoA;
	}

	public void setHijoA(long hijoA) {
		this.hijoA = hijoA;
	}

	public long getHijoB() {
		return hijoB;
	}

	public void setHijoB(long hijoB) {
		this.hijoB = hijoB;
	}

	public long getHijoC() {
		return hijoC;
	}

	public void setHijoC(long hijoC) {
		this.hijoC = hijoC;
	}

	public int getHijoD() {
		return hijoD;
	}

	public void setHijoD(int hijoD) {
		this.hijoD = hijoD;
	}

	public String getTextoHijoA() {
		return textoHijoA;
	}

	public void setTextoHijoA(String textoHijoA) {
		this.textoHijoA = textoHijoA;
	}

	public String getTextoHijoB() {
		return textoHijoB;
	}

	public void setTextoHijoB(String textoHijoB) {
		this.textoHijoB = textoHijoB;
	}


//fin getters and setters
	
	
	// string to owerride
	
	@Override
	public String toString() {
		return "Subclase [hijoA=" + hijoA + ", hijoB=" + hijoB + ", hijoC=" + hijoC + ", hijoD=" + hijoD
				+ ", textoHijoA=" + textoHijoA + ", textoHijoB=" + textoHijoB + "]";
	}

}
