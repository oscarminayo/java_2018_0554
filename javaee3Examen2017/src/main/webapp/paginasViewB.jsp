<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<%@page import= "com.ipartek.formacion.modelo.pojo.PaginaPojo" %>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

<!-- MUESTRO AUTOR -->
<p>${datosPagina.autor}  </p>

<!-- MUESTRO TEXTO -->
<textarea>${datosPagina.texto}  </textarea>



<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>
<p> ${mensaje} </p>

<!-- enviar parametro con la pagina acutal -->
<a href="paginaCB?pagina=${paginaActual+1}">Siguiente</a>  <!-- converitr a dinámico -->
<a href="paginaCB?pagina=${paginaActual-1}">atras</a>  <!-- converitr a dinámico --><br>
<a href="index.jsp">INICIO</a>  <!-- converitr a dinámico -->


</body>
</html>