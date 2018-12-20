package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginControler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDAO dao; // objeto de la clase UsuarioDao para metodo login 
	private ValidatorFactory factory; //DECLARO OBJETO DE TIPO VALIDATOR // para poder usar la clase de la api
	private Validator validator; // igual que la anterior 
	
	public static final String VIEW_LOGIN = "index.jsp";  // TEXTOS RUTAS PARA QUE SEA MAS COMODA LA PROGRAMACIONCON  
	public static final String CONTROLLER_VIDEOS = "videos"; 
	
       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = UsuarioDAO.getInstance();
    	
    	//Crear Factoria y Validador
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");  //recojo parametros
		String pass = request.getParameter("pass");
		String view = VIEW_LOGIN;
		
		try {
		
			// validar  
			// CREO UN OBJETO Y LE DOY PARAMETROS QUE HE RECOGIDO
			Usuario usuario = new Usuario(); // instancio clase usuario
			usuario.setEmail(email); // valor1 
			usuario.setPassword(pass);//valor 2  // la clase usuario tiene 3 parametros. la id es automatica ?
			
			// ARRAY LIS PARA VALIDAR
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);  // el array lis de constrain lo igualo al metodo validate que tiene como parámetro el objeto usuario
			
			
			if ( violations.size() > 0) {			// validacion NO PASA
				
				 String errores = "<ul>";   // estoy escribiendo en el jsp  // lo mejor seria hacerlo alli
				 for (ConstraintViolation<Usuario> violation : violations) {
					 	
					 errores += "<li>" + violation.getPropertyPath() + ": " +violation.getMessage() + "</li>";
						
						// violation.getPropertyPath()
				 }
				 errores += "</ul>"; 
				request.setAttribute("errores", violations);
				request.setAttribute("mensaje", errores);
				
			}else {                                // validacion OK
			
				// LOGIN PARA COMPROBAR SI EXISTE ESE EMAIL Y EL PASSWOER 
				usuario = dao.login(email, pass);  // el metodo login compara el usuario con los que hay
				
				if ( usuario == null ) {  // si no lo encuentra 
					
					request.setAttribute("mensaje", "Credenciales incorrectas");  
				
				
				}else { // si lo encuentra 
					
					HttpSession session = request.getSession();  //objeto session que guarda la request para dar respuesta
					session.setAttribute("usuario", usuario); // le doy respuesta al objeto
					view = CONTROLLER_VIDEOS;  // indico ruta para enviar respuesta
				}
			}	
				
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(view).forward(request, response);  // envia respuesta . si 	
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// POR AQUÍ LLEGA EL FORMULARIO Y LO REENVIO A GET
		doGet(request, response);  // se recibe el formulario por aqui y se envia a doGet
	}

}