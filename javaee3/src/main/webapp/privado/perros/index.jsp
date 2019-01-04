<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>



<main role="main" class="container">

<h1>Mis perros</h1>

<a href="privado/perros?op=2&id=-1" class="btn btn-outline-success mb-2">Añadir Nuevo perro</a>

<table class="table table-striped">
		<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>perro</th>
				</tr>
		</thead>		
		<tbody>
			<c:forEach items="${perros}" var="vid">		
				<tr>		
					<th scope="row">${vid.id}</th> <!-- TH ES IGUAL QUE TD PERO EN NEGRITA  -->
					<td><a href="privado/perros?op=2&id=${vid.id}">${vid.nombre}</a></td>
					<td>${vid.raza}" </td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</main>			


<%@ include file="../../includes/footer.jsp"  %>  