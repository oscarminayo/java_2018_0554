<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import= "com.ipartek.formacion.modelo.pojo.PaginaPojo" %>



<p>AUTOR: ${pagina.autor}</p>
<textarea>${pagina.texto}</textarea>


<hr>

<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>

<a href="libro?pagina=${paginaActual+1}">Siguiente</a>









</body>
</html>