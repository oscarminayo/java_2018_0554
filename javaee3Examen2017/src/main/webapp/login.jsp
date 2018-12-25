


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.css"
	rel="stylesheet">
	
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/login.css">


</head>
<body class="text-center"> 	


<form action="login" method="post" class="form-signin">
	<fieldset>
		<legend>Sign up</legend>
	
		<p>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" class="form-control"  value="dfp@ipartek.com" />
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" name="password" id="password" class="form-control"  value="Pa$$w0rd" />
		</p>
		<p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</p>
		
		<c:if "${ error.equals("")}"==false>	  
		 <div class="alert alert-danger alert-dismissible fade show" role="alert">
		  ${error}			 
		 </div>	 	
	  </c:if> 
	  
	</fieldset>
</form>

</body>
</html>
