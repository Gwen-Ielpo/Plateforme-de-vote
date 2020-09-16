<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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


    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="${styleCss}">
    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">

    <!-- JS -->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>

</head>
<body>
<!-- Barre de navigation au dessus -->
<jsp:include page="../included/navbar_top.jsp"/>


<!-- Menu de Gauche -->
<div class="container">
    <div class="row row-offcanvas row-offcanvas-left">
        <jsp:include page="../included/left_nav_bar.jsp"/>

        <!-- Bouton pour faire apparaitre le menu gauche sur petits écrans -->
        <p class="pull-left col-xs-2 visible-xs">
            <button type="button" class="btn btn-primary btn-md visible-xs" data-toggle="offcanvas">Accès menu</button>
        </p>

        <!-- Contenu de la page -->
        <div class="col-xs-12 col-sm-8">
            <h1>Nom du scrutin </h1>
            <div class ="col-xs-12 col-sm-6">
                <h3 class="toggle-info"> Informations sur le scrutin
                    <arrow-info>
                        <span class="glyphicon glyphicon-menu-up"></span>
                    </arrow-info>
                </h3>
                <div class="hide-and-show-info">
                    <p>Auteur : ${polling.owner.firstname} ${polling.owner.lastname} (Nom de l'auteur) </p>
                    <p>Type du scrutin : ${polling.type}</p>
                    <p> Date de début : ${polling.creationDate }</p>
                    <p> Date de fin : ${polling.endDate}</p>
                    <p>Temps restant : $ </p>
                    <p>Nombre de tours: ${polling.nbTurn}</p>
                    <p> Nombre de choix de ce tour : 00 </p>
                </div>


                <h3 class="toggle-desc"> Description
                    <arrow-desc>
                        <span class="glyphicon glyphicon-menu-up"></span>
                    </arrow-desc>
                </h3>
                <div class="description hide-and-show-desc">

                </div>

            </div>
            <div class ="col-xs-12 col-sm-6">
                <div class="img-poll text-center">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/350x300"></a>
                </div>
                <h4>Résulats</h4>
                <c:forEach var="choice" items="${polling.options}">
                    <h5> ${choice}</h5>
                    <div class="progress">
                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50"
                             aria-valuemin="0" aria-valuemax="100" style="width:50%">
                            <span class=""> 50% </span>
                        </div>
                    </div>
                </c:forEach>
                <!--
                <h5> Choix 1</h5>
                <div class="progress">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50"
                         aria-valuemin="0" aria-valuemax="100" style="width:50%">
                        <span class=""> 50% </span>
                    </div>
                </div>
                <h5> Choix 2</h5>
                <div class="progress">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                         aria-valuemin="0" aria-valuemax="100" style="width:20%">
                        <span class=""> 20%</span>
                    </div>
                </div>
                <h5> Choix 3</h5>
                <div class="progress">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="10"
                         aria-valuemin="0" aria-valuemax="100" style="width:10%">
                        <span class="">10% </span>
                    </div>
                </div>
                <h5> Choix 4</h5>
                <div class="progress">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                         aria-valuemin="0" aria-valuemax="100" style="width:20%">
                        <span class=""> 20% </span>
                    </div>
                </div>
                -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary" value="Submit" disabled>Participer au Scrutin</button>
                    <p>Vous êtes hors ligne : cliquez ici pour vous connecter ! </p>
                </div>
            </div>
        </div>




    </div>

</div>
<hr>
<footer>
    <p> Des trucs en pied de page que personne ne lit...</p>
</footer>
<!-- Les Scripts -->
<script src="${jquery321MinJs}"></script>
<script src="${popperJs}"></script>
<script src="${bootstrapMinJs}"></script>
<script src="${offcanvasJs}"></script>
<script >
    $(document).ready(function() {
        $("h3.toggle-info").click(function(){
            $("div.hide-and-show-info").toggle("blind");
            $("arrow-info").children('span').toggleClass("glyphicon-menu-down");
            $("arrow-info").children('span').toggleClass("glyphicon-menu-up");
        });

        $("h3.toggle-desc").click(function(){
            $("div.hide-and-show-desc").toggle("blind");
            $("arrow-desc").children('span').toggleClass("glyphicon-menu-down");
            $("arrow-desc").children('span').toggleClass("glyphicon-menu-up");
        });

    })
</script>
</body>

</html>

