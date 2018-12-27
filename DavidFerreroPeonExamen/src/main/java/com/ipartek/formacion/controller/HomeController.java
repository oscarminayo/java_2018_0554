package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import com.ipartek.formacion.modelo.pojo.HomePojo;

/**
 * Servlet implementation class PaginaControllerB
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	
// CONTSTANTES, VARIABLES, OBJETOS Y COLECCIONES
	// Constante genereada por eclipse
	private static final long serialVersionUID = 1L;
	//ArrayList
	private ArrayList<HomePojo> libro; // declaro array list
	//HashMap	
	private HashMap<Integer, HomePojo> libro2 = new  HashMap<Integer, HomePojo>();
	 
	
	// para validation
	private ValidatorFactory factory;
	private Validator validator;
	
	
	
// METODO INIT
	@Override
	public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
	super.init(config);
	
	// PARA VALIDATION
	factory  = Validation.buildDefaultValidatorFactory();
	validator  = factory.getValidator();
				
	//ARRAY LIST
		//Creo array list	
		libro = new ArrayList <HomePojo>(); //Creo array list
		// añado elementos al arraylist
		libro.add(new HomePojo("1.Cervantes","Erase un hombre a una nariz pegado"));
		libro.add( new HomePojo("2.Jose Luis Cuerda ","Todo ocurre en un pueblo de la mancha, me puedo sacar la chorra?" ));
		libro.add( new HomePojo("3.Miguel Noguera","no lo se no lo se no le se" ));
		libro.add( new HomePojo("4.Ignatius","grito sordo" ));
		libro.add( new HomePojo( "5.Broncano","jibiri jibiri"));
					
	//HASHMAP
		//Creo objetos de clase PaginaPojo 
		HomePojo pagina1 = new HomePojo ("1 Cervantes", "Erase un hombre a una nariz pegado");	
		HomePojo pagina2 = new HomePojo ("2 Jose Luis Cuerda ","Todo ocurre en un pueblo de la mancha, me puedo sacar la chorra?");
		HomePojo pagina3= new HomePojo ( "3 Miguel Noguera","no lo se no lo se no le se");
		HomePojo pagina4 = new HomePojo ("4 Ignatius","grito sordo");
		HomePojo pagina5 = new HomePojo ("5 Broncano ","jibiri jibiri");
		// creo hashMap			
		libro2 = new HashMap<Integer, HomePojo> ();
		//añado elementos al hasmap
		libro2.put(0,pagina1);
		libro2.put(1,pagina2);
		libro2.put(2,pagina3);
		libro2.put(3,pagina4);
		libro2.put(4,pagina5);
		
	
	}
				
//DOGET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	//Lo que recibo por deGet lo envio a doPost
	}

//DOPOST	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		// Inizializo variables
		int paginaActual=0;// Inicializo variable
		boolean redirect = false;
		int paginaPedida = 0;
		int borrar = 0;
		String listado= null;
		
		
		
	
		try {  // para excepciones. Lo intento

		// RECOGER PARAMETROS
			// Obtengo string de de pagina actual por paginasview.jsp y lo guardo en string
			String obtenerPaginaActual = request.getParameter("pagina"); // LA PRIMERA VEZ NO OBTENGO NADA PORQUE TODAVIA NO HA IDO A JSP
			
			//recojo el parametro para buscar pagina
			String buscarPagina = request.getParameter("buscarPagina");
		
			// recojo parametro de texto nuevo en nuevaPagina.jsp
			String nuevoTexto = request.getParameter("texto");
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoAutor = request.getParameter("autor");
			
			// recojo parametro para borrar Pagina.jsp
			String borrado = request.getParameter("borrar");
			
			// recojo parametro para listadoPagina.jsp
			listado = request.getParameter("listado");
			
			
		// LOGICA AVANCE Y RETROCESO PAGINA
			// si no parseo dentro de un if me da error
			if (obtenerPaginaActual != null){	
				//Parseo de paginaActual
				paginaActual = Integer.parseInt(obtenerPaginaActual);    // como recibo un string del .jsp lo parseo y lo convierto en entero	
			
				// para ultima pagina
				if (paginaActual > (libro.size()-1)) {  // -1 para que coincidan los numeros a nivel usuario. ( se debe a contar la posicion 0)
					paginaActual  = (libro.size()-1);
				}
				// para primera pagina
				if (paginaActual < 0) {  // si pongo el tamaño del array se chafa tengo que poner uno menos por lo tanto he creado un elemento mas en el array list.  vacio para solucionar esto 
					paginaActual  = 0;
				}
			}
			
	
			//GENERAR RESPUESTA Obtener AUTOR Y TEXTO
				// request.setAttribute("datosPagina", libro.get(1)); //CONVERTIR EN DINÁMICO
				request.setAttribute("datosPagina", libro.get(paginaActual)); // obtengo el texto y el autor de la pagina actual
	
			// Generar respuesta para PAGINA ACTUAL y NUMERO TOTAL paginas
				request.setAttribute("paginaActual", (paginaActual)); // 
				request.setAttribute("paginasTotal", (libro.size())); // 
		
	
		
		// LOGICA BUSCAR PAGINA	
			
			if (buscarPagina != null){			
				paginaPedida=Integer.parseInt(buscarPagina); 	//parseo
				paginaActual= (paginaPedida -1);				// la pagina actual es la que recibo por parametro buscarPagina
				
				//Genero respuesta PAGINA ACTUAL Y AUTOR Y TEXTO y DIRECCION
				request.setAttribute("paginaActual", (paginaActual));  			// pagina Actual
				request.setAttribute("datosPagina", libro.get(paginaActual)); 	// autor y texto
																// direccion
			}
			
			
		// LOGICA CREAR PAGINA	
		 // to do javax validation
			
				if (nuevoTexto!= null && nuevoAutor!=null) {  
			
				HomePojo nuevaPagina = new HomePojo (nuevoAutor,nuevoTexto);	
	    
				// Creo nuevo objeto para añadir al hashmap 
				libro.add((libro.size() ),nuevaPagina);  // OJO UTILIZAR .PUT EN LUGAR DE .ADD CUANDO USE HASHMAP
				paginaActual=(libro.size()-1); 
	   
				// Genero respuesta para PAGINA ACTUAL, TOTAL , AUTOR Y TEXTO
				request.setAttribute("paginaActual", (paginaActual)); // 
				request.setAttribute("paginasTotal", (libro.size()));
				request.setAttribute("datosPagina", libro.get(paginaActual));
				redirect = false;
			}
		
			
				
				
		// LOGICA BORRAR ELEMENTO
		
			if (borrado !=null) {
			//respuesta
			borrar=Integer.parseInt (borrado);
				libro.remove(borrar-1);
			}	
		
		
			
			// LOGICA PARA LISTADO	
			// to do con el hashmap
			if (listado !=null) {			
				request.setAttribute("libro", libro ); 
				redirect=true;
			// PROBLEMA CON EL CAMBIO DE HASHMAP A ARRAYLIST
			}
			
			
		
		}catch (Exception e){ // CAPTURO EXCEPCIONES
	
			e.printStackTrace(); // pinto excepciones
			
		}finally{//ENVIAR RESPUESTA		 creo que no hace falta redirect
			if (redirect==true) {
				request.getRequestDispatcher("listado.jsp").forward(request, response);
				
				}else {
					request.getRequestDispatcher("principal.jsp").forward(request, response);		
				}
		}
		
}//d
}//fin

