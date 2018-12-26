


<%@page import= "com.ipartek.formacion.modelo.pojo.PaginaPojo2" %>


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
<%@ include file="../includes/cabecera.jsp"  %>
</header>

<body>


<section>  
<!---------DATOS---------------->
   <h1>${datosPagina.autor} </h1>
        
   <textarea rows="15" cols="40" >${datosPagina.texto}  </textarea>
        
<!-- numero paginacion-->
    <p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>	

<!---------pagina atras y siguiente----------------->
	<button><a href="paginaCB?pagina=${paginaActual-1}">atras</a></button>          <!-- enviar parametro con la pagina acutal para retroceder-->
	<button><a href="paginaCB?pagina=${paginaActual+1}">Siguiente</a></button>  	<!-- enviar parametro con la pagina acutal para avanzar-->
	
</section>
	
<footer>
	<%@ include file="includes/pie.jsp"  %>
</footer>

<!-- NUEVO CODIGO PARA MOSTRAR ALERTA -->
 
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	${alerta}			 
	</div>	

	  
	
</body>
</html>














  
  