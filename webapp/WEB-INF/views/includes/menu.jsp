<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<spring:url value="/" var="urlRoot"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <sec:authorize access="isAnonymous()">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${urlRoot}">My CineSite</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${urlRoot}about">Acerca</a></li>
                    <li><a href="${urlRoot}formLogin">Login</a></li>
                </ul>
            </div>
        </sec:authorize>

        <sec:authorize access="hasAnyAuthority('EDITOR')">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${urlRoot}admin/index">My CineSite</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
                    <li><a href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
                    <li><a href="${urlRoot}noticias/index">Noticias</a></li>
                    <li><a href="${urlRoot}admin/logout">SAIR</a></li>
                </ul>
            </div>
        </sec:authorize>

        <sec:authorize access="hasAnyAuthority('GERENTE')">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${urlRoot}/admin/index">My CineSite</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
                    <li><a href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
                    <li><a href="${urlRoot}noticias/index">Noticias</a></li>
                    <li><a href="${urlRoot}banners/index">Banners</a></li>
                    <li><a href="${urlRoot}admin/logout">SAIR</a></li>
                </ul>
            </div>
        </sec:authorize>

    </div>
</nav>