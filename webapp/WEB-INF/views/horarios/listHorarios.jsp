<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Listado de Horarios</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/horarios" var="urlHorarios" />
			
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${urlPublic}/js/modalHorario.js"></script>

        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>

	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3>Listado de Horarios</h3>

        <div id="divexcluir">
        </div>
      
        <a href="${urlHorarios}/create" class="btn btn-success" role="button" title="Nuevo horario" >Nuevo</a><br><br>

        <div class="table-responsive">	
	        <table class="table table-hover table-striped table-bordered">
	          <tr>
	              <th>Pelicula</th>
	              <th>Fecha</th>
	              <th>Hora</th>
	              <th>Sala</th>
	              <th>Precio</th>
	              <th>Opciones</th>
	          </tr>
	
				<c:forEach var="horario" items="${horarios.content}">
					<tr id="row-${horario.id}">
						<td>${horario.pelicula.titulo}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${horario.fecha}" /></td>
						<td>${horario.hora}</td>
						<td>${horario.sala} </td>
						<td>$${horario.precio}</td>					
						<td>
							<a href="${urlHorarios}/edit/${horario.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>							
							<%--<a href="${urlHorarios}/delete/${horario.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>--%>

                            <input type="submit" class="btn btn-danger btn-xs" id="${horario.id}" name="${horario.hora}" value="Excluir" />
						</td>
					</tr>
				</c:forEach>
	
			</table>
		</div>
		<nav aria-label="">
		  <ul class="pager">
		    <li><a href="${urlHorarios}/indexPaginate?page=${horarios.number - 1 }">Anterior</a></li>
		    <li><a href="${urlHorarios}/indexPaginate?page=${horarios.number + 1 }">Siguiente</a></li>
		  </ul>
		</nav>

      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>		

	</div> <!-- /container -->

	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="deleteModalLabel">Exclusão</h4>
				</div>

				<div class="modal-body">
					<input type="hidden" />
					<p>Deseja excluir o horário: <em><strong>"<span></span>"</strong></em>&nbsp;?</p>
				</div>

				<div class="modal-footer">
					<button class="btn btn-success" type="button">Confirmar</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


</body>
</html>