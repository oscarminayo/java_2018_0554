<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

  

    <main role="main" class="container">
      
      
      <h1>
     conectado ${usuario}
      </h1>
      
      
      
      <div class="jumbotron">
       
			<ol>
				<c:forEach items="${videos}" var="v">
					<li>${v.id} + ${v.nombre}</li>
				</c:forEach>
			</ol>
       
      </div>
    </main>

  
<%@ include file="../includes/footer.jsp"  %>  