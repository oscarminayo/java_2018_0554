<%@page import="com.ipartek.formacion.modelo.pojos.Perro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Listado Videos</h1>

	<%
		ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("perros");
		String busqueda = (String) request.getAttribute("busqueda");
	%>

	<%
		if (busqueda != null) {
	%>
	<p>
		Resultado para la busqueda: <b><%=busqueda%></b>
	</p>
	<%
		} else {
			busqueda = "";
		}
	%>

	<form action="videos" method="post">
		<input type="text" name="busqueda" value="<%=busqueda%>" required>
		<input type="submit" value="filtrar">
	</form>


	<%
		if (perros.isEmpty()) {
	%>
	<p style="color: red;">No existen Perros todavia!!!</p>
	<%
		} // if
	%>

	<ol>
		<%
			for (Perro perro : perros) {
		%>
		<li><%=perro.getNombre()%> <iframe width="150" height="150"
				src="https://www.youtube.com/embed/<%=perro.getImagen()%>"
				frameborder="0"
				allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe></li>
		<%
			}
		%>
	</ol>
</body>
</html>