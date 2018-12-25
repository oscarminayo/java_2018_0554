package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.LoginPojo;
import com.ipartek.formacion.modelo.pojo.PaginaPojo;
import com.ipartek.formacion.modelo.pojo.PaginaPojo2;

/**
 * Servlet implementation class PaginaControllerB
 */
@WebServlet("/paginaCB")
public class PaginaControllerB extends HttpServlet {
	
// CONTSTANTES, VARIABLES, OBJETOS Y COLECCIONES
	// Constante genereada por eclipse
	private static final long serialVersionUID = 1L;
	//ArrayList
	private ArrayList<PaginaPojo> libro; // declaro array list
	//HashMap	
	private HashMap<Integer, PaginaPojo2> libro2 = new  HashMap<Integer, PaginaPojo2>();
	 
	
// METODO INIT
	@Override
	public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
	super.init(config);
				
	//ARRAY LIST
		//Creo array list	
		libro = new ArrayList <PaginaPojo>(); //Creo array list
		// añado elementos al arraylist
		libro.add(new PaginaPojo("Erase un hombre a una nariz pegado","autor 1 miguel de Cervantes"));
		libro.add( new PaginaPojo("Todo ocurre en un pueblo de la mancha, me puedo sacar la chorra?", "autor2 Jose Luis Cuerda "));
		libro.add( new PaginaPojo("no lo se no lo se no le se", "autor3 Miguel Noguera"));
		libro.add( new PaginaPojo("grito sordo", "autor4 ignatius"));
		libro.add( new PaginaPojo("jibiri jibiri", "autor5 broncano "));
					
	//HASHMAP
		//Creo objetos de clase PaginaPojo 
		PaginaPojo2 pagina1 = new PaginaPojo2 ("autor 1 miguel de Cervantes", "Erase un hombre a una nariz pegado");	
		PaginaPojo2 pagina2 = new PaginaPojo2 ( "autor2 Jose Luis Cuerda ","Todo ocurre en un pueblo de la mancha, me puedo sacar la chorra?");
		PaginaPojo2 pagina3= new PaginaPojo2 ( "autor3 Miguel Noguera","no lo se no lo se no le se");
		PaginaPojo2 pagina4 = new PaginaPojo2 ("autor4 ignatius","grito sordo");
		PaginaPojo2 pagina5 = new PaginaPojo2 ("autor5 broncano ","jibiri jibiri");
		// creo hashMap			
		libro2 = new HashMap<Integer, PaginaPojo2> ();
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
			
			
		// LOGICA AVANCE Y RETROCESO PAGINA
			// si no parseo dentro de un if me da error
			if (obtenerPaginaActual != null){	
				//Parseo de paginaActual
				paginaActual = Integer.parseInt(obtenerPaginaActual);    // como recibo un string del .jsp lo parseo y lo convierto en entero	
			}
			// para ultima pagina
			if (paginaActual > (libro2.size()-1)) {  // -1 para que coincidan los numeros a nivel usuario. ( se debe a contar la posicion 0)
				paginaActual  = (libro2.size()-1);
			}
			// para primera pagina
			if (paginaActual < 0) {  // si pongo el tamaño del array se chafa tengo que poner uno menos por lo tanto he creado un elemento mas en el array list.  vacio para solucionar esto 
				paginaActual  = 0;
			}
	
			// Obtener AUTOR Y TEXTO
				// request.setAttribute("datosPagina", libro.get(1)); //CONVERTIR EN DINÁMICO
				request.setAttribute("datosPagina", libro2.get(paginaActual)); // obtengo el texto y el autor de la pagina actual
	
			// Generar respuesta para PAGINA ACTUAL y NUMERO TOTAL paginas
				request.setAttribute("paginaActual", (paginaActual)); // 
				request.setAttribute("paginasTotal", (libro2.size())); // 
		
		//---FIN LOGICA AVANCE RETROCESO
		
		// LOGICA BUSCAR PAGINA	
			
			if (buscarPagina != null){			
				paginaPedida=Integer.parseInt(buscarPagina); 	//parseo
				paginaActual= (paginaPedida -1);				// la pagina actual es la que recibo por parametro buscarPagina
				
				//Genero respuesta PAGINA ACTUAL Y AUTOR Y TEXTO y DIRECCION
				request.setAttribute("paginaActual", (paginaActual));  			// pagina Actual
				request.setAttribute("datosPagina", libro2.get(paginaActual)); 	// autor y texto
				redirect=true; 													// direccion
			}
			
		// LOGICA CREAR PAGINA	
		
			if (nuevoTexto!= null && nuevoAutor!=null) {  
				
				PaginaPojo2 nuevaPagina = new PaginaPojo2 (nuevoAutor,nuevoTexto);	 // Creo nuevo objeto para añadir al hashmap 
				libro2.put((libro2.size() ),nuevaPagina);  // añado nuevo objeto con los datos de los parametrosal hasmap	
				paginaActual=(libro2.size()-1); 
				
				// Genero respuesta para PAGINA ACTUAL, TOTAL , AUTOR Y TEXTO
				request.setAttribute("paginaActual", (paginaActual)); // 
				request.setAttribute("paginasTotal", (libro2.size()));
				request.setAttribute("datosPagina", libro2.get(paginaActual));
				
			}
			
			
		// LOGICA BORRAR ELEMENTO
			
			if (borrado !=null) {
				
			borrar=Integer.parseInt (borrado);
				libro2.remove(borrar-1);
				 
			
			}
			
			
		
			
		}catch (Exception e){ // CAPTURO EXCEPCIONES
	
			e.printStackTrace(); // pinto excepciones
			
		}finally{//ENVIAR RESPUESTA		 creo que no hace falta redirect
			if (redirect==true) {
				request.getRequestDispatcher("paginasViewB.jsp").forward(request, response);
				
				}else {
					request.getRequestDispatcher("paginasViewB.jsp").forward(request, response);		
				}
		}
		
}//d
}//fin

