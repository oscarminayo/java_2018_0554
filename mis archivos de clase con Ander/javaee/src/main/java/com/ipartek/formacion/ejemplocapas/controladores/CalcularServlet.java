package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/calcularservlet") // id servlet. nombre para llamarlo
public class CalcularServlet extends HttpServlet {									//generado por eclipse
	private static final long serialVersionUID = 1L;								//generado por eclipse

	public CalcularServlet() {														//generado por eclipse
		super();																	//generado por eclipse	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	//generado por eclipse
			throws ServletException, IOException {									//generado por eclipse
		
		response.getWriter().append("Served at: ").append(request.getContextPath());//generado por eclipse

		String op1 = request.getParameter("op1"); // guardo el parametro (name "op1")   en una varibale tipo string porque html solo trabaja con texto
		String op2 = request.getParameter("op2"); // para guardar el par�metro utilizo el metodo.getParameter   // numero que introduce el ususario
		String sumar = request.getParameter("sumar"); 
		String restar= request.getParameter("restar");
		String dividir = request.getParameter("dividir"); 
		
		
		// cambio de string op1 y op2  a enteros mediante casting con Integer.parseInt
		int sum1 = Integer.parseInt(op1); 	// convierto el param�tro mediante casting String to int (Integer.parseInt) 
		int sum2 = Integer.parseInt(op2);  	// si no cambio el String a tipo int no puedo sumarlos
		
		
		//generar respuesta
		
		// sumar  Si sumar se ha pulsado esta lleno y los demas vacios
		if (sumar != null && restar==null && dividir==null) {
		int resultadoSuma = (sum1 + sum2);  	// suma y la guardo en varible resultado
		request.setAttribute("resultado", resultadoSuma);// suma es par�metro y resultado atributo. suma es el nombre por el que llamare para obtener el valor del atributo
		}

		
		// restar
		if (sumar == null && restar!=null && dividir==null) {
		int resultadoResta =  (sum1 - sum2); 
		request.setAttribute("resultado", resultadoResta);
		}
		
		
		// dividir
		if (sumar == null && restar==null && dividir!=null)  {
		int resultadoDivision =  (sum1 / sum2); 
		request.setAttribute("resultado", resultadoDivision);
		}
		
		
		
		
		//enviar respuesta
		
		request.getRequestDispatcher("resultado.jsp").forward(request, response);

		//try {}catch(Exception e) {}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	//generado por eclipse
			throws ServletException, IOException {									//generado por eclipse
		// TODO Auto-generated method stub
		doGet(request, response);													//generado por eclipse
	
	
	
	
	
	
	}

}