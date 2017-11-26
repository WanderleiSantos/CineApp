<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Noticias</title>

    <spring:url value="/resources" var="urlPublic"/>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->

<jsp:include page="../includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Datos de la Noticia</span></h3>

    <spring:url value="/noticias/save" var="urlForm"/>
    <form action="${urlForm}" method="post">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="titulo">Titulo</label>
                    <input type="text" class="form-control" name="titulo" id="titulo" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="status">Estatus</label>
                    <select id="status" name="status" class="form-control">
                        <option value="Activa">Activa</option>
                        <option value="Inactiva">Inactiva</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <label for="detalhe">Detalles</label>
                    <textarea class="form-control" name="detalhe" id="detalhe" rows="10"></textarea>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
    </form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"/>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script src="${urlPublic}/tinymce/tinymce.min.js"></script>
<script>
    tinymce.init({
        selector: '#detalhe',
        plugins: "textcolor, table lists code",
        toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
    });
</script>
</body>
</html>
