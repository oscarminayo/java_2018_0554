package ejerciciosmoodle4;

public class ProgramaMain  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		//Array para objetos de la misma clase
	
		Loro ArrayMismaClase [] = {new Loro ("macho", 2, 'n', "Azul"), new Loro ("macho", 6, 's', "verde")}; 
		
		
		
		
		
		// Crear objetos de cada clase que tenga la interfaz hablador implementada     
			
		Loro loro = new Loro("macho", 2, 'n', "Azul");
		Piolin piolin= new Piolin("macho", 6, "En la ducha", 10);
		Alumno alumno= new Alumno ("Marta", 22, "Informatia" , 3);
		Profesor profesor = new Profesor  ("jesus", 53, "Informatia" , "juanitoprof@pro.prof");
		Bedel bedel= new Bedel ("Edu", 40, "tarde" , 10);
		Television television= new Television (100,30000,"si",28);
		Radio radio= new Radio (50,15000,"no", 25);
	
		// Array para objetos de clase distinta
		
		Hablador[] habladores =  new Hablador[7] ;
				
		// introducir objetos de distinta clase y con distintos parámetros en el Array. 
		//Como ya he creado los objetos no necesito new.

		habladores [0] = loro;
		habladores [1] = piolin;
		habladores [2] = alumno;
		habladores [3] = profesor;
		habladores [4] = bedel;
		habladores [5] = television;
		habladores [6] = radio;

		//recorrer Array e invocar metodo hablar de la interfaz Hablador
				for (int i= 0; i<habladores.length; i++) {
					habladores[i].hablar();
					}
		// Añadir elementos a una Array que previamente no están creados
		
		Hablador[] habladores2 =  new Hablador[7] ;
		habladores2 [0] = new Loro("macho", 2, 'n', "Azul");
		habladores2 [1] = new Piolin("macho", 6, "En la ducha", 10);
		habladores2 [2] = new  Alumno ("Marta", 22, "Informatia" , 3);
		habladores2 [3] = new Profesor  ("jesus", 53, "Informatia" , "juanitoprof@pro.prof");
		habladores2 [4] = new Bedel ("Edu", 40, "tarde" , 10);
		habladores2 [5] = new Television (100,30000,"si",28);
		habladores2 [6] = new Radio (50,15000,"no", 25);
		
		
		//recorrer Array e invocar metodo hablar de la interfaz Hablador
		for (int i= 0; i<habladores2.length; i++) {
			habladores2[i].hablar();
			}
		
		// con bucle for each    clase/ e / nombre array
		
		System.out.println("-----------------------------------------------------");// para separar
		for(Hablador e: habladores2) {
			e.hablar();

		
		}


	
	}// fin main
} // fin clase

	




