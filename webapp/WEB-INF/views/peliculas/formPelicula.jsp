<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Peliculas</title>

    <spring:url value="/resources" var="urlPublic"/>
    <spring:url value="/peliculas/save" var="urlForm"/>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="page-header">
        <h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
    </div>

    <form:form action="${urlForm}" method="post" enctype="multipart/form-data" modelAttribute="pelicula">

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <img class="img-rounded" src="${urlPublic}/images/${pelicula.imagem}" title="Imagem Pelicula" width="150" height="200">
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="titulo">Título</label>
                    <form:hidden path="id"/>
                    <form:input type="text" class="form-control" path="titulo" id="titulo" required="required" />
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="duracion">Duracion</label>
                    <form:input type="text" class="form-control" path="duracion" id="duracion" required="required" />
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="clasificacion" class="control-label">Clasificacion</label>
                    <form:select id="clasificacion" path="clasificacion" class="form-control">
                        <form:option value="A">Clasificacion A</form:option>
                        <form:option value="B">Clasificacion B</form:option>
                        <form:option value="C">Clasificacion C</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="genero" class="control-label">Genero</label>
                    <form:select id="genero" path="genero" class="form-control" items="${generos}"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="estatus" class="control-label">Estatus</label>
                    <form:select id="estatus" path="estatus" class="form-control">
                        <form:option value="Activa">Activa</form:option>
                        <form:option value="Inactiva">Inactiva</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="fechaEstreno">Fecha Estreno</label>
                    <form:input type="text" class="form-control" path="fechaEstreno" id="fechaEstreno" required="required" />
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="imagem">Imagen</label>
                    <form:hidden path="imagem"/>
                    <input type="file" id="imagem" name="arquivoImagem" />
                    <p class="help-block">Imagen de la pelicula</p>
                </div>
            </div>
        </div>

        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="director">Director</label>
                    <form:input type="text" class="form-control" path="detalhe.director" id="director" required="required" />
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="actores">Actores</label>
                    <form:input type="text" class="form-control" path="detalhe.actores" id="actores" required="required" />
                </div>
            </div>

            <div class="col-sm-6">
                <div class="form-group">
                    <label for="trailer">URL del Trailer (Youtube)</label>
                    <form:input type="text" class="form-control" path="detalhe.trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="sinopsis">Sinopsis</label>
                    <form:textarea class="form-control" rows="5" path="detalhe.sinopsis" id="sinopsis"></form:textarea>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>

    </form:form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"/>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function () {
            $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
    );
</script>
</body>
</html>

