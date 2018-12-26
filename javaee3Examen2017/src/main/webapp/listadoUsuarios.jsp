<%@ include file="../includes/cabecera.jsp"  %>



<meta http-equiv="refresh" content="5; URL=${pageContext.request.contextPath}/listadoUsuarios.jsp">

<main role="main" class="container">
	<p>*recargamos esta pagina cada 5 segundos mediantes etiqueta <b>http-equiv="refresh"</b> </p>
	
	<ul class="list-group">
	<c:forEach items="${usuariosLogeados}" var="u">
		<li class="list-group-item">${u}</li>
	</c:forEach>
	</ul>
	
</main>	
