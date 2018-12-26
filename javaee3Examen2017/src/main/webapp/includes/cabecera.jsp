<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>CABECERA</title>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<link rel="stylesheet" href="CSS/cabecera.css">

</head>
	<body>
		<nav class="navbar navbar-expand-sm   navbar-light bg-light">
		  
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation"></button>
		
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		    	<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      		<li class="nav-item">
		        		<a class="nav-link" href="login"><span>LOGIN</span></a>
		      		</li>
		      		
		     		 <li class="nav-item">
		        		<a class="nav-link"href="logout"><span>LOGOUT</span></a>
		      		</li>
		      		
		      		<li class="nav-item">
		      			<a class="nav-link" href="nuevaPagina.jsp"><span>CREAR NUEVA PAGINA</span></a> 
		      		</li> <!-- AGREGAR NUEVA PAGINA -->
		      		
					<li class="nav-item">
						<a class="nav-link" href="borrarPagina.jsp"><span>BORRAR PAGINA</span></a>
					</li>    		
		   	 	<li class="nav-item">
						<a class="nav-link" href="listadoUsuarios.jsp"><span>USUARIOS CONECTADOS</span></a>
					</li> 
		   	 	
		   	 	</ul>
		
		    <form action="paginaCB" method="get" class="form-inline my-2 my-lg-0">
				<p>
				<input class="form-control mr-sm-2" type="number"  name="buscarPagina" id="buscarPagina" placeholder="busca una pagina"/>
				</p>	
			</form>  
		  </div>
		</nav>
	</body>
</html>
