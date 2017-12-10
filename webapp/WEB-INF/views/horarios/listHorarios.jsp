<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
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
        <meta name="_csrf_header" content="${_csrf.headerName}"/>

	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3>Lista de Horários</h3>

        <div id="divInfo">
        </div>

      
   		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalCadastro">
			Novo
		</button>

        <br><br>


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
							<a href="${urlHorarios}/edit/${horario.id}" class="btn btn-success btn-sm" role="button" title="Edit">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>

							<button type="submit" class="btn btn-danger btn-sm" id="${horario.id}" name="${horario.hora}" value="" >
								 <span class="glyphicon glyphicon-trash"></span>
							</button>

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


	<!-- Modal -->
	<div class="modal fade" id="modalCadastro" tabindex="-1" role="dialog" aria-labelledby="cadastroModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="cadastroModalLabel">Incluir Horário</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
                <form id="form-salvar">
                    <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="idPelicula" class="control-label">Pelicula</label>
                                        <select id="idPelicula" name="pelicula.id"	class="form-control">
                                            <c:forEach var="c" items="${peliculas}">
                                                <option value="${c.id}">${c.titulo}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="fecha">Fecha</label>
                                        <input type="text"	class="form-control" name="fecha" id="fecha" required="required" />
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="hora">Hora</label>
                                        <input type="text" class="form-control" name="hora" id="hora"
                                                    placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="sala" class="control-label">Sala</label>
                                        <select id="sala" name="sala" class="form-control">
                                            <option value="Premium">Sala Premium</option>
                                            <option value="Sala 1">Sala 1</option>
                                            <option value="Sala 2">Sala 2</option>
                                            <option value="Sala 3">Sala 3</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="text" class="form-control" name="precio" id="precio" required="required" />
                                    </div>
                                </div>

                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </form>
			</div>
		</div>
	</div>


</body>
</html>