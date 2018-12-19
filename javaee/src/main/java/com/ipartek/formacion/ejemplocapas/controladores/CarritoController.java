package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;


/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recibir parametros => id
		
		String id= request.getParameter ("id");
	
		
		// buscar en base datos el Video por Id
		
		VideoDAO dao= new VideoDAO();
		Video videoRecogido= dao.getById(Long.parseLong(id));
		
		//recuperar carrito de session del usuario
		HttpSession session = request.getSession();

		ArrayList<Video>  carrito = (ArrayList<Video> )session.getAttribute("carrito");
		
		if (carrito == null) {
			carrito = new ArrayList<>();
		}
		
		// a�adimos el nuevo video
		
		carrito.add(videoRecogido);
		
		// guardamos el carrito en session
		
			session.setAttribute("carrito", carrito);
		// redirect a => http://localhost:8080/javaee/videos
		response.sendRedirect("videos"); // Obliga a pasar por Video Controller. forward 
		
		
	}

}