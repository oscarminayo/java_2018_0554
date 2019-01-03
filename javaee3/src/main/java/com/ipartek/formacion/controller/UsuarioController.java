package com.ipartek.formacion.controller;



import java.io.IOException;
import java.sql.SQLException;
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

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// capturar errores. crea un archivo.log donde se ve todo
	private final static Logger LOG = Logger.getLogger(UsuarioController.class); 
	
	// variables para validator
	private ValidatorFactory factory;
	private Validator validator;
	
	// variables para direciones
	private static final String VIEW_INDEX = "usuarios/index.jsp";
	private static final String VIEW_FORM = "usuarios/form.jsp";
	private String vista;
	
	// variables para switch operacion
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";
	
	// variable para mostrar alerta
	private Alerta alerta;
	
	//parametros	
	private String op;
	private String id;
	private String email;
	private String password;
	
	
	// Objeto UsuarioDao
    private static UsuarioDAO dao = null;   
	
	// metodo init donde se meten dao, colecciones como arraylist y validator
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	
    	dao = UsuarioDAO.getInstance(); // get Instancepara singleton
    	
    	factory  = Validation.buildDefaultValidatorFactory(); // para validator
    	validator  = factory.getValidator(); // para validator
    }
    
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;
		alerta = null;
		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (op) {
				case OP_IR_FORMULARIO:
					irFormulario(request);
					break;
				case OP_GUARDAR:
					guardar(request);
					break;	
				case OP_ELIMINAR:
					eliminar(request);
					break;	
				default:
					listar(request);
					break;
			}
			
			
		}catch (Exception e) {
			LOG.error(e);		
			alerta = new Alerta( Alerta.TIPO_DANGER, "Error inexesperado sentimos las molestias.");
			
		}finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}


	private void listar(HttpServletRequest request) {

		// alerta = "Lista de Usuarios";
		request.setAttribute("usuarios", dao.getAll());		
		
	}


	private void eliminar(HttpServletRequest request) throws SQLException {
	
		int identificador = Integer.parseInt(id);		
		
		if ( dao.delete(identificador) ) {
			alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro eliminado con exito");
		}else {
			alerta = new Alerta( Alerta.TIPO_WARNING, "Registro NO eliminado, sentimos las molestias");
		}
				
		listar(request);		
	}


	private void guardar(HttpServletRequest request) {

		//crear usuario mediante parametros del formulario
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);	
		u.setId( (long)identificador);
		u.setEmail(email);
		u.setPassword(password);
		
		//validar usuario		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		
		
		if ( violations.size() > 0 ) {              // validacion NO correcta
		 
		  alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		 
		  vista = VIEW_FORM; 
		  // volver al formulario, cuidado que no se pierdan los valores en el form
		  request.setAttribute("usuario", u);	
		  
		}else {									  //  validacion correcta
		
			try {
				if ( identificador > 0 ) {
					dao.update(u);				
				}else {				
					dao.insert(u);
				}
				alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro guardado con exito");
				listar(request);
				
			}catch ( SQLException e) {
				alerta = new Alerta( Alerta.TIPO_WARNING, "Lo sentimos pero el EMAIL ya existe");
				vista = VIEW_FORM;
				request.setAttribute("usuario", u);
			}	
		}	
		
	}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Usuario u = new Usuario();
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			
			u = dao.getById(identificador);
		}
		request.setAttribute("usuario", u);		
	}

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		LOG.debug( String.format("parametros: op=%s id=%s email=%s password=%s", op, id, email, password ));
		
	}
	
	

}