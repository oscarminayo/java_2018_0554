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

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelos.daos.UsuarioDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_LOGIN = "index.jsp";
	private static final String CONTROLER_VIDEOS = "privado/videos";
	private ValidatorFactory factory;
	private Validator validator;
	private UsuarioDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vista = VIEW_LOGIN;

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		try {
			// validar parametros
			Usuario usuarioLogin = new Usuario();
			usuarioLogin.setEmail(email);
			usuarioLogin.setPassword(pass);
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuarioLogin);

			if (violations.size() > 0) {// Validaciones NO PASADAS
				String errores = "<ul>";
				for (ConstraintViolation<Usuario> violation : violations) {
					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

				}
				errores +="</lu>";
				request.setAttribute("mensaje", errores);
			} else {// Validaciones correctas

				usuarioLogin = dao.login(email, pass);
				if (usuarioLogin != null) {
					vista = CONTROLER_VIDEOS;
					
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60*5); //5minutos
					session.setAttribute("usuario", usuarioLogin);
					

				} else {
					request.setAttribute("mensaje", "Usuario no valido");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(vista.equals(CONTROLER_VIDEOS)) {
				response.sendRedirect(CONTROLER_VIDEOS);
			}else {
				request.getRequestDispatcher(vista).forward(request, response);
			}
			
		}
	}

}