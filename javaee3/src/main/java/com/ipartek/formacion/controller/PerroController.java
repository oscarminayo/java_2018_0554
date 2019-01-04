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

import com.ipartek.formacion.modelo.dao.PerroDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class perroController
 */
@WebServlet("/privado/perros")
public class PerroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// capturar errores. crea un archivo.log donde se ve todo
	private final static Logger LOG = Logger.getLogger(PerroController.class); 
	
	// variables para validator
	private ValidatorFactory factory;
	private Validator validator;
	
	// variables para direciones
	private static final String VIEW_INDEX = "perros/index.jsp";
	private static final String VIEW_FORM = "perros/form.jsp";
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
	private String nombre;
	private String raza;
	
	
	// Objeto perroDao
    private static PerroDAO dao = null;   
	
	// metodo init donde se meten dao, colecciones como arraylist y validator
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	
    	dao = PerroDAO.getInstance(); // get Instancepara singleton
    	
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
			// mensaje para el perro
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}


	private void listar(HttpServletRequest request) {

		// alerta = "Lista de perros";
		request.setAttribute("perros", dao.getAll());		
		
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

		//crear perro mediante parametros del formulario
		Perro u = new Perro();
		int identificador = Integer.parseInt(id);	
		u.setId( (long)identificador);
		u.setNombre(nombre);
		u.setRaza(raza);
		
		//validar perro		
		Set<ConstraintViolation<Perro>> violations = validator.validate(u);
		
		
		if ( violations.size() > 0 ) {              // validacion NO correcta
		 
		  alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		 
		  vista = VIEW_FORM; 
		  // volver al formulario, cuidado que no se pierdan los valores en el form
		  request.setAttribute("perro", u);	
		  
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
				alerta = new Alerta( Alerta.TIPO_WARNING, "Lo sentimos pero el nombre ya existe");
				vista = VIEW_FORM;
				request.setAttribute("perro", u);
			}	
		}	
		
	}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Perro u = new Perro();
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			
			u = dao.getById(identificador);
		}
		request.setAttribute("perro", u);		
	}

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		raza = request.getParameter("raza");
		
		LOG.debug( String.format("parametros: op=%s id=%s nombre=%s raza=%s", op, id, nombre, raza ));
		
	}
	
	

}