package pruebasEntendiendoModificadoresAcceso;

import java.util.ArrayList;
import java.util.Iterator;

import ejercicionuevointento.Libro;



public class Superclase {

// variables  y metodos static en la superclase
	
	//variables
	private static long padreA=10;
	
	//métodos si los hubiera clases utililes, collecciones...
		
	// Creo un ArrayList en la superclase
	public static ArrayList<Subclase> ArrayList1;
	
	
	public static void bucleDameDatosArrayList() { // RECORRE EL ARRAY LIST
	for (Subclase e : ArrayList1) { // BULCE FOR EACH
		System.out.println(e.toString()); // IMPRIME EN PANTALLA EL METODO GETDAMEDATOS DEL ARRAY LIST. "SE HACE
												// CON "e"
	}
}
	
	
//-------------------------principio metodo main ------------------------
	public static void main(String[] args) {
		
//Instancio la clase hijo "Subclase" con la creacion de objeto1 y así utilizar sus metodos
		Subclase objeto1 = new Subclase ();
		

		
//Pido todos los datos del metodo constructor de la subclase hijo mediante toString
		System.out.println(objeto1.toString()); //todas las variables dan cero
	
		
// Escribo la variable HijoA de la Subclae Hijo mediante el metodo getHijo
		System.out.println(objeto1.getHijoA()); //resultado 0. Este metodo devuelve el valor que hemos modificado anteriormente
		objeto1.setHijoA(10);//modifico la variable setHijo de la Subclase y le pongo valor 10
		System.out.println(objeto1.getHijoA());//// vuelvo a consultar el valor y el resutado es 10
		
		
		
		System.out.println(objeto1.toString());// vuelvo a pedir todos los datos y compruebo que se ha guardado como 10
	
// igualar variables de la clase padre con las variables de la clase hijo 
		
		//modificamos el valor de la variable HijoA de la clase Hijo Subclase
		//por el valor de la variable "padreA" de la clase Padre Superclase
		objeto1.setHijoA(padreA); //setter 
		
		// Muestro el resultado de la variable hijoA de la Subclase que ha sido modificado 
		// por el valor de la variable padreA de la Superclase.
		System.out.println(objeto1.getHijoA()); //getter
	
	
	
		
// Instancio el ArrayList declarado en la superclase para poder utilizarlo en el metodo main		
		ArrayList1 = new ArrayList<Subclase>();
		
		
		//Añado 4 elementos al ArrayList
		ArrayList1.add ( new Subclase (1,2,3,4,"si","si"));
		ArrayList1.add ( new Subclase (5,6,7,8,"no","no"));
		ArrayList1.add ( new Subclase (0, 10,11,12,"--","--"));
	
		
		//ejecuto metodo para recorrer array list declarado en esta clase fuera del metodo main
		bucleDameDatosArrayList();
		
		System.out.println(ArrayList1.toString());
		
		
	
	
	
	
	
	
	
	}
	
//--------------------------principio metodo main ------------------------	
	
	

}
