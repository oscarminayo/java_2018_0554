<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container">




<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Mail</th>
			<th scope="col">Contraseņa</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${usuarios}" var="u">
			<tr>
				<th scope="row">$u.id</th>
				<td>$u.email</td>
				<td>$u.password</td>
			</tr>
		</c:forEach>


	</tbody>
</table>

</main>


<%@ include file="../../includes/footer.jsp"%>
