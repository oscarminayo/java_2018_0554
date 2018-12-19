package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcularconexcepcionesb") 													// id servlet. nombre para llamarlo
public class CalcularConExcepcionesB extends HttpServlet { 								// generado por eclipse
	private static final long serialVersionUID = 1L; 											// generado por eclipse

	public CalcularConExcepcionesB() { 													// generado por eclipse
		super(); 																				// generado por eclipse
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 				// generado por eclipse
			throws ServletException, IOException,NullPointerException{ 												// generado por eclipse

		response.getWriter().append("Served at: ").append(request.getContextPath());			// generado por eclipse

		String op1 = request.getParameter("op1"); 												// guardo el parametro (name "op1") en una varibale tipo string porque
																								// html solo trabaja con texto
		String op2 = request.getParameter("op2"); 												// para guardar el parámetro utilizo el metodo.getParameter // numero que introduce el ususario mediante el formulario de Calculadora.jsp
		String sumar = request.getParameter("sumar");
		String restar = request.getParameter("restar");
		String dividir = request.getParameter("dividir");

		// cambio de string op1 y op2 a enteros mediante casting con Integer.parseInt
																// si no cambio el String a tipo int no puedo sumarlos

// GENERAR RESPUESTA 

		try { //PARA EXCEPCIONES
			
			if (op1 != "" && op2 != "") {  														//si en el campo op1 y en el op2 se han introducido datos 
				int sum1 = Integer.parseInt(op1); 												// es mejor declarar aqui las variables para evitar problems con el integer.parseInt											
				int sum2 = Integer.parseInt(op2); 												// convierto el paramétro mediante casting String to int (Integer.parseInt)

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
			}
// ENVIA LA RESPUESTA A RESULTADO.JSP	
			
			request.getRequestDispatcher("resultado.jsp").forward(request, response);			// si lo pongo dentro del if no pasa al catch
		
		} catch (Exception e) { 																// si el try falla lanza la excepcion
			if (op1 == "" && op2 != "") {	 													// utilizo "" en vez de null para indicar el campo vacio (en el que no se han introducido datos) porque Op1 ES UN STRING. NO ES ENTERO
				request.setAttribute("error", "No has rellenado el primer numero" );  			// envio parametro error con valor string menssaje
		
				request.getRequestDispatcher("errores.jsp").forward(request, response);			// ENVIO LA RESPUESTA A ERRORES.JSP
			}
			else if (op1 !="" && op2 == "") {
				request.setAttribute("error", "No has rellenado el segundo numero");  			
			
				request.getRequestDispatcher("errores.jsp").forward(request, response);
			}
			else if (op1 == "" && op2 == "") {
				request.setAttribute("error", "No has rellenado ningun numero" );  				
			
				request.getRequestDispatcher("errores.jsp").forward(request, response);
			}
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)		 		// generado por eclipse
			throws ServletException, IOException { 												// generado por eclipse
		
		doGet(request, response); 																// generado por eclipse
		
			
					
					
						
				}
}
			
			
			
			
			
			
