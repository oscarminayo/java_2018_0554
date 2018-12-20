package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.PerrosPojo;

public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // para enviar la respuesta a doget IMPORTANTE
	//
		// guardar parametros en atributos
		String id = request.getParameter("id");  									// GUARDO EL PARAMETRO EN UN ATRIBUTO
		String chip= request.getParameter("chip");
		String nombre = request.getParameter("nombre"); 							// guardo el valor del parametro email en un string 
		String raza = request.getParameter("raza");	
		
		// crear ArrayList
		ArrayList<PerrosPojo> perros = new ArrayList<>();
		
		
		// Validar campos
		if (nombre.equals("")==false&& raza.equals("")) {	 													 
			request.setAttribute("error", "No has rellenado el campo SPL" );  			
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);// VUELVO A LOGINPERRO.JSP
		}
		else if (raza.equals("")==false&& nombre.equals("")){
			request.setAttribute("error", "No has rellenado el campo Modelo");  					
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);
		}
		else if (nombre.equals("")&& raza.equals("")) {
			request.setAttribute("error", "No has rellenado el campo Marca" );  				
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);
		}
		
		
		try { //INTENTALO			
			if (nombre != "" && raza != "") { 		
				// CASTING
				Long numeroId = (long) Integer.parseInt(id);  						// COMO EL ATRIBUTO ID ES TIPO STRING LE HAGO CASTING CON PARSEINT para tener un entero
				Long numeroChip = (long)Integer.parseInt(chip);
	
				// creo un array list de la clase PerrosPojo 
				//para crear elementos con el constructor de esta clase
			
				perros.add(new PerrosPojo(numeroId,numeroChip,nombre,raza) ); // no olvidar importar PerrosPojo 		// añado elementos con el constructor con parametros de la clase PerrosPojo
			
				// GENERAR RESPUESTA
				request.setAttribute("perros", perros); 							//Guardo el array perros como atributo del parametro perros
				
				//ENVIAR RESPUESTA
				request.getRequestDispatcher("listadoPerros.jsp").forward(request, response);				 
			}
			}catch (Exception e) { // SI EL TRY NO LO CONSIGUE LANZAR EXCEPCIONES	
		
			e.printStackTrace();
			
			}
		}

}//
