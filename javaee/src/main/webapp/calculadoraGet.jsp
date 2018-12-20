<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<a href="calcular?op1=1"><input class="fila" type="submit" name="dividir"   id="sumar"   value="1"></a>
<a href="calcular?op2=2"><input class="fila" type="submit" name="restar"   id="sumar"   value="2"></a>
<a href="calcular?op2=2&op1=1&sumar=sumar"><input class="fila" type="submit" name="sumar"   id="sumar"   value="1 y 2"></a>

<%
	String error = (String)request.getAttribute("error");
	if ( error  != null ){
%>	
		<p style="color:red"><%=error%></p>
 <%
	} // if
 %>

</body>
</html>