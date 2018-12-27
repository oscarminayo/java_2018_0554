<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- IDIOMAS -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="idioma" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" /> <!--  CREAR VARIABLE -->
<fmt:setLocale value="${idioma}" />  <!-- SETEAR LOCALE -->
<fmt:setBundle basename="i18nmessages" /> <!-- CARGAR FICHERO PROPERTIES -->

<!doctype html>
<html lang="${idioma}"> <!--  INDICAR IDIOMA -->
<!-- FIN IDIOMAS -->

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
		        		<a class="nav-link" href="login"><span><fmt:message key="navbar.login"/></span></a>
		      		</li>
		      		
		     		 <li class="nav-item">
		        		<a class="nav-link"href="logout"><span><fmt:message key="navbar.logout"/></span></a>
		      		</li>
		      		
		      		<li class="nav-item">
		      			<a class="nav-link" href="nuevaPagina.jsp"><span><fmt:message key="navbar.nueva"/></span></a> 
		      		</li> <!-- AGREGAR NUEVA PAGINA -->
		      		
					<li class="nav-item">
						<a class="nav-link" href="borrarPagina.jsp"><span><fmt:message key="navbar.borrar"/></span></a>
					</li>    		
		   	 	<li class="nav-item">
						<a class="nav-link" href="listadoUsuarios.jsp"><span><fmt:message key="navbar.usuarios"/></span></a>
					</li> 
		   	 	
		   	 	</ul>
		
		    <form action="paginaCB" method="get" class="form-inline my-2 my-lg-0">
				<p>
				<input class="form-control mr-sm-2" type="number"  name="buscarPagina" id="buscarPagina" placeholder=<fmt:message key="navbar.buscar"/>/>
				</p>	
			</form>  
		  </div>
		</nav>
	</body>
</html>
