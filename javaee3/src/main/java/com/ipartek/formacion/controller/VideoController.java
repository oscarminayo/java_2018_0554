package com.ipartek.formacion.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/videos")
public class VideoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideoController.class);
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";
	
	private Alerta alerta;
	
	//parametros	
	private String op;
	private String id;
	private String nombre;
	private String codigo;
	private String tipo;

	private String  id_usuario;
	
	
    private static VideoDAO videoDao = null;   
    
    private static UsuarioDAO usuarioDao = null;  // marca

	
	
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	videoDao = VideoDAO.getInstance();
    	
    	
    	usuarioDao= UsuarioDAO.getInstance(); // marca 	
    
    	
    	
    	// marca
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
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
		
		request.setAttribute("videos", videoDao.getAll());		
		
	}


	private void eliminar(HttpServletRequest request) throws SQLException {
	
		int identificador = Integer.parseInt(id);		
		
		if ( videoDao.delete(identificador) ) {
			alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro eliminado con exito");
		}else {
			alerta = new Alerta( Alerta.TIPO_WARNING, "Registro NO eliminado, sentimos las molestias");
		}
				
		listar(request);		
	}


	private void guardar(HttpServletRequest request) {

//1 crear video mediante parametros del formulario
		
		//VIDEO
		Video v = new Video(); 						// video; objeto

		int identificador = Integer.parseInt(id);	//paseo para id
		v.setId( (long)identificador); 				// guardo atributo id del formulario en el nuevo video
		v.setCodigo(codigo);						// Lo mismo 
		v.setNombre(nombre);
		v.setTipo(tipo);// Lo mismo
		
		
// 2. crear usuario mediante parametro del formulario (campo en el que puedo elegir usuario)
		
		//USUARIO
		Usuario u = new Usuario(); 					// usuario; objeto
		u.setId(Long.parseLong(id_usuario)); 		// GUARDO ID DEL FORMULARIO		
		v.setUsuario(u);  							// GUARDO EL USUARIO EN EL VIDEO  // En el pojo hay un METODO CONSTRUCTOR con parametros. (1 objeto usuario)
		

// 3. VALIDATOR
		
		// violations
		Set<ConstraintViolation<Video>> violations = validator.validate(v);  // creo violations para validator
	
		//SI PASA
		/*(Si al crear un video introducimos mal algun valor, al dar a guardar, por un lado se muestra la alerta avisando de que los campos no so correctos...
		 * y por el otro se vuelven a enviar los parametros introducidos por el usuario al rellenar el formulario
		 * para que no se pierda todo lo que ha rellenado. Puede que se haya equivocado en un solo campo y asi no pierde 
		 * los demas que si estan bien rellenados
		 */
		if ( violations.size() > 0 ) {              // validacion NO correcta
		 
		  alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		//aviso al usuario 
		  vista = VIEW_FORM;  // volver al formulario. 
		
		   
		  request.setAttribute("video", v);	
		  request.setAttribute("usuarios", usuarioDao.getAll()); // para elegir usuario en el formulario de creacion de video
		  request.setAttribute("videos", videoDao.getAll()); // para elegir tipo
		 
		}else {									  //  validacion correcta
		
			try {
				if ( identificador > 0 ) {
					videoDao.update(v);				
				}else {				
					videoDao.insert(v);
				}
				alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro guardado con exito");
				listar(request);
				
			}catch ( SQLException e) {
				alerta = new Alerta( Alerta.TIPO_WARNING, "Lo sentimos pero el EMAIL ya existe");
				vista = VIEW_FORM;
				//NO PERDER LOS PARAMETROS 
				request.setAttribute("video", v);
				request.setAttribute("usuarios", usuarioDao.getAll()); 
				request.setAttribute("videos", videoDao.getAll());
			}	
		}	
		
	}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Video v = new Video();
		
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			     //  si el parametro id que envio por enlace al pulsar sobre un video es mayor que 0 es que existe si es -1 es para crear video
			v = videoDao.getById(identificador);  // muestra el usuario en el formulario	
		}
		
		request.setAttribute("video", v);
		request.setAttribute("videos", videoDao.getAll() );
		request.setAttribute("usuarios", usuarioDao.getAll() );  // para mostrar usuario que he elegido
		
		  // para mostrar tipo 
				
	}


	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		id_usuario = request.getParameter("id_usuario"); // marca
		tipo = request.getParameter("tipo");
		
		//TODO nuevo parametro para id_usuario
		
	}
	
	

}