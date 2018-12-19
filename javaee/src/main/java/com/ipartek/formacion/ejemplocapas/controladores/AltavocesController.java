package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.AltavozPojo;
import com.ipartek.formacion.modelo.pojos.PerrosPojo;

/**
 * Servlet implementation class AltavocesController
 */
public class AltavocesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AltavocesController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		// atributos
		String id =request.getParameter("id");
		String marca =request.getParameter("marca");
		String modelo =request.getParameter("modelo");
		String spl =request.getParameter("spl");
		
		// Validar campos
		if (marca.equals("")==false&& modelo.equals("")==false && spl.equals("")) {	 													 
			request.setAttribute("error", "No has rellenado el campo SPL" );  			
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);// VUELVO A LOGINPERRO.JSP
		}
		else if (marca.equals("")==false&& modelo.equals("") && spl.equals("")==false) {
			request.setAttribute("error", "No has rellenado el campo Modelo");  					
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);
		}
		else if (marca.equals("")&& modelo.equals("")==false && spl.equals("")==false) {
			request.setAttribute("error", "No has rellenado el campo Marca" );  				
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);
		}
		else if (marca.equals("")&& modelo.equals("") && spl.equals("")) {
			request.setAttribute("error", "No has rellenado ningun campo" );  				
			request.getRequestDispatcher("loginPerro.jsp").forward(request, response);
		}
			
			
	
		try { //INTENTALO			
			if (marca.equals("")==false && modelo.equals("")==false&& spl.equals("")==false) { 		
				
				Long idParseo = (long)Integer.parseInt(id); // parseo atributos Long CASTING
				Long splParseo = (long)Integer.parseInt(spl);

				// creo un objeto de la clase AltavozPojo 		
				AltavozPojo objetoAltavoz = new AltavozPojo(idParseo,splParseo,marca,modelo); // no olvidar importar Altavoz Pojo

				// GENERAR RESPUESTA
				request.setAttribute("altavoz", objetoAltavoz); 							//Guardo el array perros como atributo del parametro perros
				
				//ENVIAR RESPUESTA
				request.getRequestDispatcher("listadoAltavoces.jsp").forward(request, response);		 			
			}		
			
		}//try
		catch (Exception e) { // SI EL TRY NO LO CONSIGUE LANZAR EXCEPCIONES	
				e.printStackTrace();   // aun no lo se
		}
	
	}

}
