
<%@ include file="../includes/cabecera.jsp"  %>

 
<!DOCTYPE html>
<html>
<head>
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/cabecera.css">
</head>
<body>
<div >
        <h1>Listado de Paginas</h1>
        <table class="table table-striped">
    <thead>
      <tr>
        
        <th>Autor</th>
        <th>Texto</th>
      </tr>
    </thead>
    <tbody>

    
    </tbody>
  </table>
  </div>
  
  
  <c:forEach items="${libro2}" var="v">
      <tr>
        <td>${v.getAutor}</td> <!-- aqui esta el fallo del listado el bucle lo hace bien -->
        <td>${v.getTexto}</td>						
      </tr>
      </c:forEach>
</body>
</html>