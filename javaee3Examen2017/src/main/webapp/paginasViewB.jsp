<%@page import= "com.ipartek.formacion.modelo.pojo.PaginaPojo2" %> <!-- page para importar clases etc-->
<!DOCTYPE html>
<html>
<head>
	<!-- link a CSS -->	
	<link rel="stylesheet" href="CSS/cabecera.css">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!------ Include the above in your HEAD tag ---------->
	<title>Insert title here</title>
</head>

<header>
	<%@ include file="../includes/cabecera.jsp"  %> <!-- include para incluir otro archivo -->
</header>
	<body>
	<section>  
		<!---------DATOS---------------->
		   <h1>${datosPagina.autor} </h1>        
		   <textarea rows="15" cols="40" >${datosPagina.texto}  </textarea>
		        
		<!-- numero paginacion-->
		    <p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>	

		<!---------pagina atras y siguiente----------------->
		<a class="btn btn-primary" href="paginaCB?pagina=${paginaActual-1}" role="button">Atras</a>  <!-- ENLACE COMO BOTON enviar parametro con la pagina acutal para retroceder-->
		<a class="btn btn-primary" href="paginaCB?pagina=${paginaActual+1}" role="button">Siguiente</a>   <!-- enviar parametro con la pagina acutal para avanzar-->
		
		</section>
		
		<footer>
			<%@ include file="includes/pie.jsp"  %>
		</footer>
	</body>
</html>














  
  