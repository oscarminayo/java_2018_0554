package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplocapas.pojos.PojoException;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { // throws para indicar la clase de los errores que tenemos
		
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario;
		
		try {   // try parecedio a if  . intentanta el siguiente bloque de instrucciones		
			usuario = new Usuario(null, email, password);  //Crear objeto de la clase Usuario.  //	PREGUNTAR PORQUE LE PASO NULL AL PARAMETRO USUARIO
		} catch(PojoException e) { // parecido a else  // si no se puede
			//response.sendRedirect("login.jsp");  // no indica error y te vuelve a mandar a login.jsp para que vuelvas a rellenar
			
			if(email != null && password != null) {
				request.setAttribute("error", "Error en el formato de email o contraseña");
			}
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			return;
		}
		
		if("javier@lete.com".equals(usuario.getEmail()) && "Pa$$w0rd".equals(usuario.getPassword())) {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			usuarios.add(new Usuario(1L, "javier@lete.com", "Pa$$w0rd"));
			usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));
			
			request.setAttribute("usuarios", usuarios);
			
			request.getSession().setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "No tienes permiso para login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//response.getWriter().println("Hola " + usuario.getEmail());
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
