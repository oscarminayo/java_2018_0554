package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcularconexcepcionesservlet") 													// id servlet. nombre para llamarlo
public class CalcularConExcepcionesServlet extends HttpServlet { 								// generado por eclipse
	private static final long serialVersionUID = 1L; 											// generado por eclipse

	public CalcularConExcepcionesServlet() { 													// generado por eclipse
		super(); 																				// generado por eclipse
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 				// generado por eclipse
			throws ServletException, IOException { 												// generado por eclipse

		response.getWriter().append("Served at: ").append(request.getContextPath());			// generado por eclipse

		String op1 = request.getParameter("op1"); 												// guardo el parametro (name "op1") en una varibale tipo string porque
																								// html solo trabaja con texto
		String op2 = request.getParameter("op2"); 												// para guardar el parámetro utilizo el metodo.getParameter // numero que introduce el ususario mediante el formulario de Calculadora.jsp
		String sumar = request.getParameter("sumar");
		String restar = request.getParameter("restar");
		String dividir = request.getParameter("dividir");

		// cambio de string op1 y op2 a enteros mediante casting con Integer.parseInt
		int sum1 = Integer.parseInt(op1); 														// convierto el paramétro mediante casting String to int (Integer.parseInt)
		int sum2 = Integer.parseInt(op2); 														// si no cambio el String a tipo int no puedo sumarlos

		// generar respuesta

		try {
			if (op1 != null && op2 != null) {

				// sumar Si sumar se ha pulsado esta lleno y los demas vacios
				if (sumar != null && restar == null && dividir == null) {
					int resultadoSuma = (sum1 + sum2); 											// suma y la guardo en varible resultado
					request.setAttribute("resultado", resultadoSuma);							// suma es parámetro y resultado atributo. suma es
																								// el nombre por el que llamare para obtener el
																								// valor del atributo
				}

				// restar
				if (sumar == null && restar != null && dividir == null) {
					int resultadoResta = (sum1 - sum2);
					request.setAttribute("resultado", resultadoResta);
				}

				// dividir
				if (sumar == null && restar == null && dividir != null) {
					int resultadoDivision = (sum1 / sum2);
					request.setAttribute("resultado", resultadoDivision);
				}

				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}
		} catch (Exception e) {
			if (op1 != null && op2 == null) { 													// si el primer campo esta lleno y el segundo vacio
				if ((sumar != null && restar == null && dividir == null)		 				// si input sumar esta lleno y los demas vacios
						|| (sumar == null && restar == null && dividir != null)					// O si input restar esta lleno y los demas vacios
						|| (sumar == null && restar != null && dividir == null)) { 				// o si input dividir esta lleno y los demas vacios
					request.setAttribute("error", "Error, no has rellenado el primer numero");  // envio parametro error con valor string menssaje
				}
				request.getRequestDispatcher("errores.jsp").forward(request, response);
			} else if (op1 != null && op2 == null) { 											// si el segundo campo esta lleno y el primero vacio
				if ((sumar != null && restar == null && dividir == null)
						|| (sumar == null && restar == null && dividir != null)
						|| (sumar == null && restar != null && dividir == null)) {
					request.setAttribute("error", "Error, no has rellenado el segundo numero");
				}
				request.getRequestDispatcher("errores.jsp").forward(request, response);
			} else if (op1 == null && op2 == null) { 											// si ambos campos estan vacios
				if ((sumar != null && restar == null && dividir == null)
						|| (sumar == null && restar == null && dividir != null)
						|| (sumar == null && restar != null && dividir == null)) {
					request.setAttribute("error", "Error, no has rellenado ningun numero");
				}
				request.getRequestDispatcher("errores.jsp").forward(request, response);
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)		 		// generado por eclipse
			throws ServletException, IOException { 												// generado por eclipse
		
		doGet(request, response); 
		
			String op1 = request.getParameter("op1"); 											// guardo el parametro (name "op1") en una varibale tipo string porque
			String op2 = request.getParameter("op2"); 											// para guardar el parámetro utilizo el metodo.getParameter // numero que introduce el ususario mediante el formulario de Calculadora.jsp
			String sumar = request.getParameter("sumar");
			String restar = request.getParameter("restar");
			String dividir = request.getParameter("dividir");
			
			// cambio de string op1 y op2 a enteros mediante casting con Integer.parseInt
			int sum1 = Integer.parseInt(op1); 													// convierto el paramétro mediante casting String to int (Integer.parseInt)
			int sum2 = Integer.parseInt(op2); 													// si no cambio el String a tipo int no puedo sumarlos
			
			// generar respuesta
			
			try {
			if (op1 != null && op2 != null) {
			
			// sumar Si sumar se ha pulsado esta lleno y los demas vacios
			if (sumar != null && restar == null && dividir == null) {
			int resultadoSuma = (sum1 + sum2); 													// suma y la guardo en varible resultado
			request.setAttribute("resultado", resultadoSuma);									// suma es parámetro y resultado atributo. suma es
					// el nombre por el que llamare para obtener el
					// valor del atributo
			}
			
			// restar
			if (sumar == null && restar != null && dividir == null) {
			int resultadoResta = (sum1 - sum2);
			request.setAttribute("resultado", resultadoResta);
			}
			
			// dividir
			if (sumar == null && restar == null && dividir != null) {
			int resultadoDivision = (sum1 / sum2);
			request.setAttribute("resultado", resultadoDivision);
			}
			
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}
			} catch (Exception e) {
			if (op1 != null && op2 == null) { 													// si el primer campo esta lleno y el segundo vacio
			if ((sumar != null && restar == null && dividir == null)		 					// si input sumar esta lleno y los demas vacios
			|| (sumar == null && restar == null && dividir != null)								// O si input restar esta lleno y los demas vacios
			|| (sumar == null && restar != null && dividir == null)) { 							// o si input dividir esta lleno y los demas vacios
			request.setAttribute("error", "Error, no has rellenado el primer numero");  		// envio parametro error con valor string menssaje
			}
			request.getRequestDispatcher("errores.jsp").forward(request, response);
			} else if (op1 != null && op2 == null) { 											// si el segundo campo esta lleno y el primero vacio
			if ((sumar != null && restar == null && dividir == null)
			|| (sumar == null && restar == null && dividir != null)
			|| (sumar == null && restar != null && dividir == null)) {
			request.setAttribute("error", "Error, no has rellenado el segundo numero");
			}
			request.getRequestDispatcher("errores.jsp").forward(request, response);
			} else if (op1 == null && op2 == null) { 											// si ambos campos estan vacios
			if ((sumar != null && restar == null && dividir == null)
			|| (sumar == null && restar == null && dividir != null)
			|| (sumar == null && restar != null && dividir == null)) {
			request.setAttribute("error", "Error, no has rellenado ningun numero");
			}
			request.getRequestDispatcher("errores.jsp").forward(request, response);
			}
			
			}
			}	
					
					
						
				}
			
			
			
			
			
			
