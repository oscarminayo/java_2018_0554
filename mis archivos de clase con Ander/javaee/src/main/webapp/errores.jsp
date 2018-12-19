<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errores</title>
</head>
<body>


<a href="http://localhost:8080/javaee/calculadora.jsp">Inicio</a> <!--  enlace para volver al inicio de la calculadora -->


<% Object resultadoerror = request.getAttribute("error"); %>  	<!-- la variable para guardar los datos obtenidos del parametro error la declaro tipo OBJECT porque string me da problemas con el casting de Integer.parseInt -->
Hay Errores!
    <%=resultadoerror %> 										 <!-- muestro el resultado de la variable de tipo objeto y nombre resultadoerror creada anteriormente -->



</body>
</html>