<%@page import="java.util.ArrayList"%> 									<!--  IMPORTADO PARA PODER CREAR UN ARRAY LIST -->
<%@page import="com.ipartek.formacion.modelo.pojo.Video"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Esto funciona


YUYUY soy princila.jsp
										
<%// guardo en un ArrayList los atributos del Array list creado en perrosController
ArrayList<Video> listadoVideos =(ArrayList<Video> )request.getAttribute("perros"); // recojo el objeto perros (atributo) del parametro perros creado en el servlet

//PerrosPojo objetoPerros = new PerrosPojo();
//objetoPerros.setId(id);

// no olvidar importar java util array y clase del Array
%>

<table>  																<!-- TABLA PARA METER LOS DATOS DEL ARRAY -->
		<thead>
			<tr> 														<!--  CABECERA COLUMNAS -->
				<th>ID</th>
				<th>Nombre</th>
				<th>Url</th>
				
				
			</tr>
		</thead>
		<tbody>
		
				<% for (Video p: listadoVideos){ %> <!--  FOR EACH DE ARRAY LIST -->
				<tr>
							<td><%=p.getId() %></td>						
							<td><%=p.getNombre()%></td>	
							<td><%=p.getUrl()%></tr>	
								
							
				<% } %><!--  NO OLVIDAR CERRAR EL BULCE -->
		</tbody>
	</table>
	

</body>
</html>