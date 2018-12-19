<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	#mensaje{
		color: red;
		font-size: 20px;
	}
</style>

<body>
<a href="login.jsp">INICIO (login.jsp)</a><br>


<form action="altvocesServlet" method="post">
	<fieldset>
		<legend>Incluir Altavoz</legend>
		
		<p>
			<label for="id"></label> <!--lo oculto para que no se vea. id se le sumara 1 cada vez que creemos un nuevo perro-->
			<input type="number" name="id" id="id" value="0" style="visibility:hidden" /> 
		</p>	
		<p>
			<label for="marca">Marca:</label>
			<input type="text" name="marca" id="marca"  />
		</p>
		<p>
			<label for="modelo">Modelo:</label>
			<input type="text" name="modelo" id="modelo"  />
		</p>
		<p>
			<label for="spl">SPL peak a 1 metro:</label>
			<input type="number" name="spl" id="spl"  />
		</p>
		
		<p>
			<input type="submit" value="CREAR">  <!-- boton para enviar los parametros al servlet -->
		</p>
		
		
	
		<div id= "mensaje">
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
		</div>
	
	</fieldset>
</form>

</body>
</html>