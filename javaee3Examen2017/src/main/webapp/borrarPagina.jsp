

<%@ include file="../includes/cabecera.jsp"  %>

<head>
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/cabecera.css">
</head>

<form action="paginaCB" method="post">
	<p>
		<label for="borrar">Indica el numero de la pagina que deseas borrar</label>
		<input type="number"  name="borrar" id="borrar"> 
	</p>
	<button type ="submit">Aceptar</button>
</form>

<a class="nav-link" href="paginaCB?listado=ok"><span>Mostrar paginas del Libro</span></a> 

<%@ include file="includes/pie.jsp"  %>
