<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/videos?op=2&id=-1">Crear Nuevo Video</a>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">nombre</th>
		      <th scope="col">codigo</th>	
		  
		      	      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${videos}" var="u">
			    <tr>
			      <th scope="row">${u.id}</th>
			      <td><a href="privado/videos?op=2&id=${u.id}">${u.nombre}</a></td>
			      <td><iframe width="640" height="360" src="https://www.youtube.com/embed/${u.codigo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>	
			      	      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


<%@ include file="../../includes/footer.jsp"  %>  
