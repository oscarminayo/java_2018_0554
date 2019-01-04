package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	// varible objeto dao
	private UsuarioDAO dao;
	
	//varibles para validator
	private ValidatorFactory factory; 	//VALIDATOR
	private Validator validator;		//VALIDATOR
	
	public static final String VIEW_LOGIN = "login.jsp";
	//public static final String CONTROLLER_VIDEOS = "privado/videos";
	
       
    @Override // metodo init para colecciones, validator y singleton
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	
    	dao = UsuarioDAO.getInstance(); 						// get instance para singleton
    	
    	//Crear Factoria y Validador EN METODO INIT
    	factory  = Validation.buildDefaultValidatorFactory(); 	//VALIDATOR
    	validator  = factory.getValidator();					// VALIDATOR
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response); // LO QUE VENGA POR GET VA A LOGIN
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Recojo PARAMETROS
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		
		// Variables para direcciones y redirect
		String view = VIEW_LOGIN;
		boolean redirect = false;
		
		try {
			
			HttpSession session = request.getSession();  // CONEXION BDD
		
			//idioma  
			Locale locale = new Locale("eu_ES");
			ResourceBundle messages = ResourceBundle.getBundle("i18nmessages", locale );
			LOG.debug("idioma=" + idioma);		
			
			//guardar cookie
			Cookie cIdioma = new Cookie("cIdioma", idioma);
			cIdioma.setMaxAge(60*10); //TODO poner que no expire nunca			
			response.addCookie(cIdioma);
			
			
			// validar
			Usuario usuario = new Usuario(); // CREO objeto y le doy como atributos los parámetros recogidos mediante setter
			usuario.setEmail(email);
			usuario.setPassword(pass);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);  //VALIDATOR
			
			
			if ( violations.size() > 0) {			// si  NO PASA la validacion
				
				 String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {					 	
					 errores += String.format("<li> %s : %s </li>" , violation.getPropertyPath(), violation.getMessage() );					
				 }
				 errores += "</ul>";				 
				 request.setAttribute("mensaje", errores);				
				
			}else {                                // si PASA validacion 
			
				usuario = dao.login(email, pass); // EL OBJETO USUARIO QUE HE CREADO COMPRUEBA SUS ATRIBUTOS EN LA BASE DE DATOS MEDIANTE LOGIN DEL DAO
				
				if ( usuario == null ) {
					
					request.setAttribute("mensaje", messages.getString("login.incorrecto"));
				}else {
					
					
					session.setMaxInactiveInterval(60*5);
					// asociamos un listener para listar usuarios @see UsuariosListener
					session.setAttribute("usuario", usuario);
					session.setAttribute("idioma", idioma );
					redirect = true;					
					LOG.debug("guardamos en session usuario e idioma");			
				}
			}	
				
			
		}catch (Exception e) {			
			LOG.error(e);
		}finally {
			
			if(redirect) {				
				response.sendRedirect( request.getContextPath() + "/privado/usuarios");
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
			
		
		
	}

	

}
