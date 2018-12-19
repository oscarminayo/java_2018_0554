<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="includes/cabecera.jsp"  %>



<a href="login.jsp">INICIO</a><br>


<form action="perros" method="post">
	<fieldset>
		<legend>Crear Perro</legend>
		
		<p>
			<label for="id"></label> <!--lo oculto para que no se vea. id se le sumara 1 cada vez que creemos un nuevo perro-->
			<input type="number" name="id" id="id" value="0" style="visibility:hidden" /> 
		</p>
		<p>
			<label for="chip"></label> <!--lo oculto para que no se vea. chip se le sumara 1 cada vez que creemos un nuevo perro-->
			<input type="number" name="chip" id="chip" value="0" style="visibility:hidden" />
		</p>
		
		<p>
			<label for="name">Nombre:</label>
			<input type="text" name="nombre" id="nombre"  />
		</p>
		<p>
			<label for="password">Raza:</label>
			<input type="text" name="raza" id="raza"  />
		</p>
		
		</p>
			<input type="submit" value="CREAR">  <!-- boton para enviar los parametros al servlet -->
		</p>
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
	</fieldset>
</form>

</body>
</html>