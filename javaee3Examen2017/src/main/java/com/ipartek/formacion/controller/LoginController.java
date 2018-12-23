package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ipartek.formacion.modelo.pojo.LoginPojo;
import com.ipartek.formacion.modelo.pojo.LoginPojo;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VISTA_EMPEZAR = "login.jsp";
	private static final String VISTA_ACCESO = "paginaCB";
	
	private static ArrayList<LoginPojo> usuarios;
	

	 
		
	// METODO INIT  // me he pasado horas pensando que no estaba bien el programa y todo ha sido por no crear los elementos del array aqui
			@Override
			public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
			super.init(config);
		    	usuarios = new ArrayList <LoginPojo>();
		    	usuarios.add(new LoginPojo("xabier@ipartek.com","Pa$$w0rd"));
		    	usuarios.add(new LoginPojo("dfp@ipartek.com","Pa$$w0rd"));
		 
		    	   // TODO Auto-generated constructor stub
		    }
		
		  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_EMPEZAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String vista = VISTA_EMPEZAR;  // para mas comodidad a la hora de enviar respuesta
		
		// recoger parametros de formularo login
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		

		
		try {
			
				
			
			for ( LoginPojo f : usuarios){
				if (f.getEmail().equals(email)&& f.getPassword().equals(password)){
					vista = VISTA_ACCESO;	
				}else {				
				request.setAttribute("error", "email o password incorrecto");	
				}
			
			}
			
				
				
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		
		
	}

	

	

}