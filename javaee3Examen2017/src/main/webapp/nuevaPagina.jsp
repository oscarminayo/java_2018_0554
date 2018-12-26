
<%@ include file="../includes/cabecera.jsp"  %>

<head>
<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/cabecera.css">
</head>
<body>
	<section>
		<form action="paginaCB" method="post">
			
			<p>
				<label for="autor">Autor</label>
				<input type="text"  name="autor"> 
			</p>
			<p>
				<label for="texto">Texto</label>
				<textarea  rows="15" cols="40" name="texto" placeholder="minimo 50 caracteres"></textarea>
			</p>
			<button type ="submit">Aceptar</button>
			
			
		</form>
	</section>
</body>
<%@ include file="includes/pie.jsp"  %>


