<%@ include file="../includes/cabecera.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div >
        <h1>Listado de Usuarios</h1>
        <table class="table table-striped">
    <thead>
      <tr>
        
        <th>Usuario</th>
        <th>Password</th>
      </tr>
    </thead>
    <tbody>

     <c:forEach items="${usuariosLogeados}" var="v">
      <tr>
        <td>${v.email}</td> <!-- aqui esta el fallo del listado el bucle lo hace bien -->
        <td>${v.password}</td>						
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
  </div>
    
 



</body>
</html>