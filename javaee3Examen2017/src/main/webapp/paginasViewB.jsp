


<%@page import= "com.ipartek.formacion.modelo.pojo.PaginaPojo" %>

<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/paginasView.css">
<link href="/docs/4.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<header>
<%@ include file="../includes/cabecera.jsp"  %>
</header>

<body>
<!---------DATOS---------------->

<section>  
   <h1>${datosPagina.autor} </h1>
        
   <textarea>${datosPagina.texto}  </textarea>
        
    <!-- numero paginacion-->
    <p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>

</section>
	

<!---------pagina atras y siguiente----------------->

<section >	
	<!-- enviar parametro con la pagina acutal para retroceder-->
	<a href="paginaCB?pagina=${paginaActual-1}">atras</a>		
	<!-- enviar parametro con la pagina acutal para avanzar-->
	<a href="paginaCB?pagina=${paginaActual+1}">Siguiente</a> 
<br>
</section>


<footer>
<%@ include file="includes/pie.jsp"  %>
</footer>
	
	

</body>
</html>














  
  