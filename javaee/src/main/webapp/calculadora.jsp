<%@ include file="cabecera.jsp" %>
<h1>Calculadora</h1>
<%
String mensaje = (String)request.getAttribute("mensaje");
if(mensaje!=null){

%>
<p style="color:red"><%=mensaje%></p>
<%
}
%>

<form action="calcular" method="post">
	<input type="text" name="p1">
	
	<input type="text" name="p2">
	<input type="submit" value="sumar">


</form>