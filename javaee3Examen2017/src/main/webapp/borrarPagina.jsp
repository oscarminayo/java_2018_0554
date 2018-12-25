<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <!-- PARA EXPRESIONES FOR EACH ETC -->  
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<div class="container">
        <h1>Listado Paginas</h1>
        <table class="table table-striped">
    <thead>
      <tr>
        
        <th>Autor</th>
        <th>Texto</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${libro2}" var="v">
      <tr>
        <td>${v.autor}</td>
        <td>${v.texto}</td>						
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
<p>${datosPagina.autor}  </p>

<form action="paginaCB" method="post">
	<p>
		<label for="borrar">Indica el numero de la pagina que deseas borrar</label>
		<input type="number"  name="borrar" id="borrar"> 
	</p>
	<button type ="submit">Aceptar</button>
</form>



