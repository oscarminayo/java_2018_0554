<c:if test="${not empty alerta}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  ${alerta}
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>