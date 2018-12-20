package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

													// id servlet. nombre para llamarlo
public class CalculadoraController extends HttpServlet { 										// generado por eclipse
	private static final long serialVersionUID = 1L; 											// generado por eclipse
	public CalculadoraController() { 															// generado por eclipse
		super(); 																				// generado por eclipse
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 				// generado por eclipse
	throws ServletException, IOException,NullPointerException{ 												// generado por eclipse
	response.getWriter().append("Served at: ").append(request.getContextPath());				// generado por eclipse
	
	//Para mandar los parámetros request, response a doPost
	//doPost(request, response);  
	
	
	// generado por eclipse
			String op1 = request.getParameter("op1"); 												// guardo el parametro (name "op1") en una varibale tipo string porque																						// html solo trabaja con texto
			String op2 = request.getParameter("op2"); 												// para guardar el parámetro utilizo el metodo.getParameter // numero que introduce el ususario mediante el formulario de Calculadora.jsp
			String sumar = request.getParameter("sumar");
			String restar = request.getParameter("restar");
			String dividir = request.getParameter("dividir");

			// Validar campos
			if (op1.equals("")==false&& op2.equals("")) {	 													 
				request.setAttribute("error", "No has rellenado el campo del segundo numero" );  			
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);// VUELVO A LOGINPERRO.JSP
			}else if (op2.equals("")==false&& op1.equals("")) {
				request.setAttribute("error", "No has rellenado el campo del primer numero");  					
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			}else if (op1.equals("")&& op2.equals("") ) {
				request.setAttribute("error", "No has rellenado ningun campo" );  				
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			}

			try { //PARA EXCEPCIONES
				//GENERAR RESPUESTA
				if (op1 != "" && op2 != "") {  														//si en el campo op1 y en el op2 se han introducido datos 
					
					//PARSEO CASTING
					int sum1 = Integer.parseInt(op1); 												// es mejor declarar aqui las variables para evitar problems con el integer.parseInt											
					int sum2 = Integer.parseInt(op2); 												// convierto el paramétro mediante casting String to int (Integer.parseInt)

					// GENERAR RESPUESTA con if 
					/*
					if (sumar != null && restar == null && dividir == null) {						// sumar Si sumar se ha pulsado esta lleno y los demas vacios
						int resultadoSuma = (sum1 + sum2); 											// sumo op1 y op2 y guardo en varible resultadoSuma
						request.setAttribute("resultado", resultadoSuma);							// resultado es parámetro y resultadoSuma atributo. 																				
					}else if (sumar == null && restar != null && dividir == null) {// restar
						int resultadoResta = (sum1 - sum2);
						request.setAttribute("resultado", resultadoResta);
					}else if (sumar == null && restar == null && dividir != null) {// dividir
						int resultadoDivision = (sum1 / sum2);
						request.setAttribute("resultado", resultadoDivision);
					}	
					*///
					
					//GENERAR RESPUESTA CON SWITCH CASE
					int paso = 0;
					switch (paso) {
					case 0:
						if (sumar != null && restar == null && dividir == null) {						// sumar Si sumar se ha pulsado esta lleno y los demas vacios
							int resultadoSuma = (sum1 + sum2); 	
							request.setAttribute("resultado", resultadoSuma);
						}
					case 1:
						if (sumar == null && restar != null && dividir == null) {// restar
							int resultadoResta = (sum1 - sum2);
							request.setAttribute("resultado", resultadoResta);
						}
					case 2:
						if (sumar == null && restar == null && dividir != null) {// dividir
							int resultadoDivision = (sum1 / sum2);
							request.setAttribute("resultado", resultadoDivision);
						}	
					
					}
					// ENVIA LA RESPUESTA A RESULTADO.JSP	
					//request.getRequestDispatcher("resultado.jsp").forward(request, response);
					request.getRequestDispatcher("resultado.jsp").forward(request, response);		
				}	
			}catch (Exception e) { 																	// si el try falla lanza la excepcion	
			}
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)		 		// generado por eclipse
			throws ServletException, IOException { 												// generado por eclipse	
	
	//IMPORTANTE: envio la respuesta mediante el metodo do doGet. 
		
		
		//SE RESUME en que tengo que elegir por que metodo envio  la respuesta que he creado con getRequestDispatcher.dispacher.forward 
		// es diferente dar una direccion al .forward que elegir el metodo para mandar los parámetros (request,response) a esa direccion.
		
		//Para mandar los parámetros request, response a doGet
		//doGet(request, response);  
		
		
					
	
}
}
		
