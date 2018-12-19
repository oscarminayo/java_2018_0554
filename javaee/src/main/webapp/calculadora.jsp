<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<h1>Calculadora</h1>
 
<section>
<div > 
<!-- action para indicar servlet y method para get o post -->
	<form action="calcular" method="post">
		<!-- action llama al servlet y method indica get o post -->
		<fieldset>
			<table>
			<tr>
			<!-- name para nombre  de parámetro -->
			<td><input type="number" name="op1" /></td>
			<td><input type="number" name="op2" /></td>	
			</tr>
			<tr class="col-sm-2  col-md-3 col-lg-2">
			<td><input class="fila" type="submit" name="sumar"   id="sumar"   value="+"></td>
			<td><input class="fila" type="submit" name="restar"  id="restar"  value="-"></td>
			<td><input class="fila" type="submit" name="dividir" id="dividir" value="/"></td>
			</tr>
			</table>
			
		</fieldset>
	</form>
</div>
</section>
<div>
<%
	String error = (String)request.getAttribute("error");
	if ( error  != null ){
%>	
		<p style="color:red"><%=error%></p>
 <%
	} // if
 %>
 </div>
<!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>