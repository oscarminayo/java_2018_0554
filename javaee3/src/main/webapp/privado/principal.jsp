<!doctype html>
<html lang="en">
 
<%@ include file="../includes/cabecera.jsp"  %>
<%@ include file="../includes/nav.jsp"  %>
 
 
 
 
  <body>
      <div class="container">
        <h1>Listado Videos</h1>
        <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Video</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${videos}" var="v">
      <tr>
        <td>${v.id}</td>
        <td>${v.nombre}</td>
        <td><iframe width="150" height="150" src="https://www.youtube.com/embed/${v.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
							
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>

 <%@ include file="../includes/footer.jsp"  %>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  </body>
</html>

