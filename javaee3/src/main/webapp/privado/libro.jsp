<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


    <main role="main" class="container">
      <div class="jumbotron">
			<p><span class="badge badge-secondary">${pagina.autor}</span></p>
			<div class="border border-secondary p-3">${pagina.texto}</div>
			<hr>
			<p>pagina ${paginaActual+1} / ${paginasTotal} </p>			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual}">Anterior</a></li>			    
			    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual+2}">Siguiente</a></li>
			  </ul>
			  <form action="privado/libro" method="get">
			  	<input type="text" name="pagina" value="${paginaActual+1}" required>
			  	<input type="submit" value="buscar">
			  </form>
			</nav>
		</div>
		
		<hr>
		
		
		<h2>Escribir nueva P�gina</h2>
		<form action="privado/libro" method="post">
			<div class="form-group">
				<input type="text" name="autor" value="${usuario.email}"  class="form-control">
			</div>	
			
			<div class="form-group">	
				<textarea name="texto" placeholder="minimo 50 caracteres"  class="form-control"></textarea>
			</div>	
			
			<div class="form-group">
				<input type="submit" value="Nueva" class="btn btn-primary btn-block">
			</div>	
		</form>
		
		
		
	</main>				


<%@ include file="../includes/footer.jsp"  %>  