
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="loginPerro.jsp">CREAR PERRO</a><br>

<form action="login" method="post">
	<fieldset>
		<legend>Login</legend>
		
		<p>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" value="xabier@ipartek.com" />
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" name="password" id="password" value="Pa$$w0rd" />
		</p>
		<p>
			<button>Login</button>
			<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
		</p>
	</fieldset>
</form>

</body>
</html>