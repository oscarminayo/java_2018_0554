<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%> 									<!--  IMPORTADO PARA PODER CREAR UN ARRAY LIST -->
<%@page import="com.ipartek.formacion.modelo.pojos.PerrosPojo"%>  		<!--  IMPORTADO PARA CREAR EL ARRAY DE LA CLASE PERROSPOJO -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listado de perros</title>
</head>
<body>
<h1>listado de perros</h1>

<a href="login.jsp">INICIO</a><br> 										<!--  ENLACE INICIO -->
<a href="loginPerro.jsp">CREAR NUEVO PERRO</a><br>  					<!--  ENLACE A CREAR NUEVO PERRO -->
	
	
										
<%// guardo en un ArrayList los atributos del Array list creado en perrosController
ArrayList<PerrosPojo> listadoPerros =(ArrayList<PerrosPojo> )request.getAttribute("perros"); // recojo el objeto perros (atributo) del parametro perros creado en el servlet

//PerrosPojo objetoPerros = new PerrosPojo();
//objetoPerros.setId(id);

// no olvidar importar java util array y clase del Array
%>

<table>  																<!-- TABLA PARA METER LOS DATOS DEL ARRAY -->
		<thead>
			<tr> 														<!--  CABECERA COLUMNAS -->
				<th>ID</th>
				<th>Chip</th>
				<th>Nombre</th>
				<th>Raza</th>
				
			</tr>
		</thead>
		<tbody>
		
				<% for ( PerrosPojo p: listadoPerros){ %> <!--  FOR EACH DE ARRAY LIST -->
				<tr>
							<td><%=p.getId() %></td>	
							<td><%=p.getChip() %></td>	
							<td><%=p.getNombre()%></td>	
							<td><%=p.getRaza()%></tr>	
								
							
				<% } %><!--  NO OLVIDAR CERRAR EL BULCE -->
		</tbody>
	</table>
	
	
</body>
</html> <!-- kjgñfljgñfldkjgkñldfsg -->