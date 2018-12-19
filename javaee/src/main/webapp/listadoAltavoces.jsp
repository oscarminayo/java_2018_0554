<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.ipartek.formacion.modelo.pojos.AltavozPojo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Altavoces</title>
</head> 
<body>

<a href="incluirAltavoz.jsp">Incluir Altavoz</a><br> 

<%// guardo en un ArrayList los atributos del Array list creado en perrosController
AltavozPojo listadoAltavoces= (AltavozPojo)request.getAttribute("altavoz");  // no olvidar import="com.ipartek.formacion.modelo.pojos.AltavozPojo"

//objetoPerros.setId(id);
// no olvidar importar java util array y clase AltavozPojo
%>

<table>  																<!-- TABLA PARA METER LOS DATOS DEL ARRAY -->
	<thead>
		<tr> 														<!--  CABECERA COLUMNAS -->
			<th>ID</th>
			<th>Spl</th>
			<th>Marca</th>
			<th>Modelo</th>	
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=listadoAltavoces.getId() %></td>	
			<td><%=listadoAltavoces.getSpl() %></td>	
			<td><%=listadoAltavoces.getMarca()%></td>	
			<td><%=listadoAltavoces.getModelo()%>
		</tr>									
	</tbody>
	</table>
	
</body>
</html>