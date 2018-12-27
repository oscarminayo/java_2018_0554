
<%@ include file="../includes/cabecera.jsp"  %>

<%@ page import= "com.ipartek.formacion.modelo.pojo.HomePojo"  %> 

<!DOCTYPE html>
<html>
<head>
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/extra.css">
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

     <c:forEach items="${libro}" var="v">
      <tr>
        <td>${v.autor}</td> <!-- aqui esta el fallo del listado el bucle lo hace bien -->
        <td>${v.texto}</td>						
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
  </div>
    
 
      
      

</body>
</html>