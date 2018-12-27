package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;  //validation api no se usarla
import javax.validation.ConstraintViolation;//validation api
import javax.validation.Validator;//validation api
import javax.validation.ValidatorFactory;//validation api



import com.ipartek.formacion.modelo.pojo.LoginPojo;




@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	// variables 
	private static final long serialVersionUID = 1L;
	private static final String VISTA_EMPEZAR = "login.jsp";
	private static final String VISTA_ACCESO = "home";
	

	
	private ValidatorFactory factory;//validation api
	private Validator validator;//validation api
	
	
	// array list
	private static ArrayList<LoginPojo> usuarios;
	
	LoginPojo usuario = new LoginPojo();
	
	// METODO INIT  // me he pasado horas pensando que no estaba bien el programa y todo ha sido por no crear los elementos del array aqui
			
	
	// metodo init donde instancio el array y creo usuarios
	@Override
			public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
			super.init(config);
		    	usuarios = new ArrayList <LoginPojo>();
		    	usuarios.add(new LoginPojo("xabier@ipartek.com","Pa$$w0rd"));
		    	usuarios.add(new LoginPojo("dfp@ipartek.com","Pa$$w0rd"));
		    	
		    	
		    	factory  = Validation.buildDefaultValidatorFactory(); //validation api
		    	validator  = factory.getValidator();//validation api
	
	}

	
	// doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_EMPEZAR).forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String vista = VISTA_EMPEZAR;  // para mas comodidad a la hora de enviar respuesta
		
		// recoger parametros de formularo login
		String email = request.getParameter("email");
		String password = request.getParameter("password");	

		String idioma = request.getParameter("idioma");
	
		try {	
			// para logout // tb se usará para validator pero no se usarlo aun
			
			usuario.setEmail(email);
			usuario.setPassword(password);
			
			HttpSession session = request.getSession();  // creo session para enviar sesion.setatribute   para idiomas
			
			// mi validacion // al no saber usar validator 
			
			for ( LoginPojo f : usuarios){
				if (f.getEmail().equals(email)&& f.getPassword().equals(password)){
					vista = VISTA_ACCESO;
					session.setAttribute("usuarioEmail", usuario.getEmail()); // // para mostrar usuario
					session.setAttribute("usuario", usuario); // para logout // tambien para validator pero aun no se usarlo
				}else if (f.getEmail().equals(email)&& f.getPassword().equals(password)==false){
					vista = VISTA_EMPEZAR;				
					request.setAttribute("error", " Password incorrecto");	
				}else if (f.getEmail().equals(email)==false && f.getPassword().equals(password)){
					vista = VISTA_EMPEZAR;	
					request.setAttribute("error", " Email incorrecto");		
				}else if (f.getEmail().equals(email)==false&& f.getPassword().equals(password)==false){
					vista = VISTA_EMPEZAR;
					request.setAttribute("error", " Email y password incorrectos");
				}
				session.setAttribute("idioma", idioma );  // modifico atributo idioma
			
				 
			}
		
				
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	
	}// doGet
}//fin


