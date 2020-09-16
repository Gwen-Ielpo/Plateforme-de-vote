<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Titre de l'appli</title>
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <!-- Les CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinCss"/>
    <spring:url value="/resources/css/bsvalidate/style.css" var="styleCss"/>
    <spring:url value="/resources/css/offcanvas/offcanvas.css" var="offCanvasCss"/>
    <spring:url value="/resources/css/verticalmenu/vertical_menu.css" var="VerticalMenuCss"/>
    <spring:url value="/resources/css/datepicker/bootstrap-datepicker3.css" var="DatePickerCss"/>


    <!-- JS -->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>
    <spring:url value="/resources/js/page_navigation/page_navigation6.js" var="navigation6Js"/>

    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">

    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">
    <link rel="stylesheet" href="${DatePickerCss}">
    <link rel="stylesheet" href="${styleCss}">
</head>
<body>
<!-- Barre de navigation au dessus -->
<jsp:include page="../included/nav_bar_top_online.jsp"/>


<!-- Menu de Gauche -->
<div class="container">
    <div class="row row-offcanvas row-offcanvas-left">

        <jsp:include page="../included/left_nav_bar_online.jsp"/>

        <!-- Bouton pour faire apparaitre le menu gauche sur petits écrans -->
        <p class="pull-left col-xs-2 visible-xs">
            <button type="button" class="btn btn-primary btn-md visible-xs" data-toggle="offcanvas">Accès menu</button>
        </p>

        <!-- Contenu de la page -->
        <div class="col-xs-12 col-sm-8">


            <h1>Mes Scrutins <a href="createnewpoll" class="btn btn-info btn-md"> <span class="glyphicon glyphicon-plus"></span>Ajouter un nouveau scrutin</a></h1>
            <p>
                Ceci est la liste des scrutins que vous avez créés. Vous pouvez les consulter ici ou en <a href="createnewpoll">créer un nouveau. </a>
            </p>
            <div class="row" id="result">

                <c:set var="init" value="3" scope="page" />
                <c:forEach var="poll" items="${listP}">
                    <c:if test="${pageScope.init > 2}">
                        <c:set var="init" value="0" scope="page" />
                        <c:set var="gotnew" value="1" scope="page" />
                    </c:if>

                    <c:if test="${pageScope.init < 1}">
                        <div class ="row">
                    </c:if>
                    <div class="col-xs-6 col-lg-4" >
                        <div class="center-block">
                            <a href="https://placeholder.com"><img src="http://via.placeholder.com/200x200"></a>
                        </div>
                        <h4>${poll.title}</h4>
                        <p> ${fn:substring(poll.description , 0 , 230)} ... </p>
                        <p><a class="btn btn-default pull-" href="boardpolling?pid=${poll.id}" role="button">Voir le Tableau de bord &raquo;</a></p>
                    </div><!--/.col-xs-6.col-lg-4-->
                    <c:set var="init" value="${pageScope.init + 1}" scope="page" />
                    <c:if test="${pageScope.init >2}">
                        </div>
                        <c:set var="gotnew" value="0" scope="page" />
                    </c:if>
                </c:forEach>

                <c:if test="${pageScope.gotnew >0}">
            </div>
            <c:set var="gotnew" value="0" scope="page" />
            </c:if>
        </div>
    </div>
</div>

<footer>
    <p> Des trucs en pied de page que personne ne lit...</p>
</footer>



<!-- Les Scripts -->

<script src="${jquery321MinJs}"></script>
<script src="${popperJs}"></script>
<script src="${bootstrapMinJs}"></script>
<script src="${offcanvasJs}"></script>
<script src="${navigation6Js}"></script>

</body>

</html>

