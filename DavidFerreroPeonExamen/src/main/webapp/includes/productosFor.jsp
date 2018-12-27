<%@page import= "com.ipartek.formacion.modelo.pojo.HomePojo" %> <!-- page para importar clases etc -->

<html>
<head>
	
	
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/productos.css">

	<!------ Include the above in your HEAD tag ---------->
	<title>Productos</title>
</head>

	<section class= "productos">
    	<h2><span class="glyphicon glyphicon-eye-open"></span>PRODUCTOS</h2> 
		<div class="row">
			<article class="col-lg-4"> 
			
				<c:forEach items="${libro}" var="v">
				<a title="${v.autor}"><img src="${v.imagen}" alt="" /></a> 		
					<header>
						<h2>${v.autor}</h2> 
					</header>
					<p>${v.texto} </p>	<!-- mostrar datos del arrylist -->		
					<p><a  href="#">Añadir al carrito</a></p>
				</c:forEach>
			
			</article>
		</div><!-- .proyectos-wrap -->
	</section>  	

</html>








