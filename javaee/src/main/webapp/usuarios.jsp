	+<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
 %>
	 
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<% for(Usuario u: listado) { %>
			<tr>
				<th><%=u.getId() %></th>
				<td><%=u.getEmail() %></td>
				<td><%=u.getPassword() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	
	<hr>
	
	<p style="color:red"><%=request.getAttribute("mensaje")%></p>
	<h2>Crear Nuevo USuario</h2>
	<form action="usuarios" method="post">
	
		<input type="number" name="id" placeholder=<%= (request.getAttribute("idparseo") ==null) ? "" :request.getAttribute("id") %>>
		<input type="text" name="email" placeholder=<%= (request.getAttribute("email") ==null) ? "" :request.getAttribute("email") %>> <!--  si el atributo es nulo me pinta cadena vacia y si ha rellenado correctamente aparece lo que el a puesto. se utiliza para cuando se actaliza la pagina de un formulario para no perder los datos introducidos -->
		<input type="password" name="password" placeholder=<%= (request.getAttribute("password")) ==null ? "" :request.getAttribute("password") %>>
	
		<input type="submit" value="CREAR">
	</form>
	