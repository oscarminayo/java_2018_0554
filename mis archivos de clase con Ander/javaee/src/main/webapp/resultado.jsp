<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<a href="http://localhost:8080/javaee/calculadora.jsp">Inicio</a>

<!-- creo variable para guardar el valor del parámetro -->
<% int operacionMatematica = (Integer)request.getAttribute("resultado"); %>  
<!--  obtengo el resultado del parámetro suma y  Integer es por el casting  -->

El resultado de la operacion es:	 <!-- texto que se muestra -->			

<%=operacionMatematica %> 	 <!--  obtener valor (atributo) del parámetro resultado   -->						




</body>
</html>