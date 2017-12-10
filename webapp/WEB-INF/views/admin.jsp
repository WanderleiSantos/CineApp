<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%--
  Created by IntelliJ IDEA.
  User: wanderlei
  Date: 29/11/17
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Error</title>

    <spring:url value="/resources" var="urlPublic"/>
    <spring:url value="/" var="urlRoot"/>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="jumbotron">
        <h3>Administrativo do Sistema</h3>
        <p>Bem Vindo(a) <sec:authentication property="principal.username"/></p>
    </div>

    <!-- FOOTER -->
<jsp:include page="includes/footer.jsp"/>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
