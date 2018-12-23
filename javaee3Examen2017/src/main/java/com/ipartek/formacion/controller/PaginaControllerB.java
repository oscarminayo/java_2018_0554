package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.PaginaPojo;

/**
 * Servlet implementation class PaginaControllerB
 */
@WebServlet("/paginaCB")
public class PaginaControllerB extends HttpServlet {
	
	// CONTSTANTES, VARIABLES, OBJETOS Y COLECCIONES
	
		private static final long serialVersionUID = 1L;
    
		private ArrayList<PaginaPojo> libro; // ARRAYLIST para almacenar texto y autor de cada pagina.
		
	
		// METODO INIT
		@Override
		public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
		super.init(config);
	    	libro = new ArrayList <PaginaPojo>();
	    	
	    	libro.add(new PaginaPojo("Erase un hombre a una nariz pegado","autor 1 miguel de Cervantes"));
	    	libro.add( new PaginaPojo("Todo ocurre en un pueblo de la mancha, me puedo sacar la chorra?", "autor2 Jose Luis Cuerda "));
	    	libro.add( new PaginaPojo("no lo se no lo se no le se", "autor3 Miguel Noguera"));
	    	libro.add( new PaginaPojo("grito sordo", "autor4 ignatius"));
	    	libro.add( new PaginaPojo("jibiri jibiri", "autor5 broncano "));
	    	
	    	   // TODO Auto-generated constructor stub
	    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		int paginaActual=0;// Inicializo variable
		boolean redirect = false;

	
		
		// Obtengo string de de pagina actual por paginasview.jsp y lo guardo en string
		String obtenerPaginaActual = request.getParameter("pagina"); // LA PRIMERA VEZ NO OBTENGO NADA PORQUE TODAVIA NO HA IDO A JSP
		
		try {
			// luego si la primera vez no recibo nada la pagina actual es 0 y no puedo hacer parseo
			 // si no hago un if  no puedo hacer parseo ya que la primera vez me llega 0 y el programa falla al intentar parsear 0

				paginaActual = Integer.parseInt(obtenerPaginaActual);    // como recibo un string del .jsp lo parseo y lo convierto en entero
		
			
			
			// OBTENER AUTOR Y TEXTO DE CADA ELEMENTO DEL ARRAY
			// request.setAttribute("datosPagina", libro.get(1)); //CONVERTIR EN DINÁMICO
			request.setAttribute("datosPagina", libro.get(paginaActual)); // obtengo el texto y el autor de la pagina actual

			// GENERAR RESPUESTA PARA PAGINA ACTUAL
			request.setAttribute("paginaActual", (paginaActual)); // 

			// GENERAR RESPUESTA PARA NUMERO TOTAL DE PAGINAS
			request.setAttribute("paginasTotal", (libro.size())); //  -1 para no mostrar el ultimo elemento 
		 
			
			if (paginaActual == (libro.size())) {  // si pongo el tamaño del array se chafa tengo que poner uno menos por lo tanto he creado un elemento mas en el array list.  vacio para solucionar esto 
					redirect = true;
			}
					
			//ENVIAR RESPUESTA		
		}catch (Exception e){
	
			e.printStackTrace();
			
		}finally{
			if (redirect==true) {
					response.sendRedirect ("paginasViewB.jsp");	
				
				}else {
					request.getRequestDispatcher("paginasViewB.jsp").forward(request, response);		
				}
			
					

	
}
		
}
}
