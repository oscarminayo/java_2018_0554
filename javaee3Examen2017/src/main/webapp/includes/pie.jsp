

<footer>
    <nav class="nav-footer row">      
        <ul class="menu-aux">
			<li class=><a href="index.jsp">INICIO</a>  </li> <!-- volver a inicio -->
			<li class=><a href="nuevaPagina.jsp">CREAR NUEVA PAGINA</a> <br> </li> <!-- AGREGAR NUEVA PAGINA -->
			<li class=><a href="borrarPagina.jsp?hashMap=${datosPagina.autor}&&${datosPagina.texto}">BORRAR PAGINA</a> </li>
		</ul>  		
    </nav>
  
  	<form action="paginaCB" method="get">
				<p>
				<label for="buscarPagina">Buscar pagina metodo get</label>
				<input type="number"  name="buscarPagina" id="buscarPagina" />
				</p>	
	</form>   
</footer>



	

<!-- BUSCAR PAGINA -->
	<!--  Formulario por get para q coincida la Url  COMO PUEDO HACER ESTO SIN UN FORMULARIO-->








 



</div>