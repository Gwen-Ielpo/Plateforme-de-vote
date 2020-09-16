<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <spring:url value="/resources/css/funkyradio/funkyradio.css" var ="funkyradioCss"/>

    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${styleCss}">
    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">
    <link rel="stylesheet" href="${funkyradioCss}">

    <!-- JS -->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>


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


            <h1>Voter pour le scrutin : "nom du scrutin" </h1>
            <p>
                Faites votre choix dans la liste disponible.
            </p>
            <p>
                Une petite explication des modalités choisies par le créateur ici.
            </p>
            <div class="row" id="result">

                <form   id='voteforOne'
                        action="addVote"
                        method="post"
                        class="funkyradio well"
                >

                    <c:forEach var="choice" items="polling.option">

                    </c:forEach>
                    <div class="funkyradio">
                        <div class ="funkyradio-primary">
                            <input type="radio" id="opt1" name="opt" checked>
                            <label for="opt1">Choix 1</label>
                        </div>


                        <div class="funkyradio">
                            <div class ="funkyradio-primary">
                                <input type="radio" id="opt2" name="opt">
                                <label for="opt2">Choix 2</label>
                            </div>
                        </div>

                        <div class="funkyradio">
                            <div class ="funkyradio-primary">
                                <input type="radio" id="opt3" name="opt">
                                <label for="opt3">Choix 3</label>
                            </div>
                        </div>

                        <div class="funkyradio">
                            <div class ="funkyradio-primary">
                                <input type="radio" id="opt4" name="opt">
                                <label for="opt4">Choix 4</label>
                            </div>
                        </div>

                        <div class="funkyradio">
                            <div class ="funkyradio-primary">
                                <input type="radio" id="opt5" name="opt">
                                <label for="opt5">Choix 5</label>
                            </div>
                        </div>

                        <div class="form-button">
                            <button type="submit" class="btn btn-default" value="Submit">Envoyer</button>
                        </div>
                    </div>
                </form>
            </div>
            <hr>

        </div>
            <footer>
                <p> Des trucs en pied de page que personne ne lit...</p>
            </footer>



        <!-- Les Scripts -->
        <script src="${jquery321MinJs}"></script>
        <script src="${popperJs}"></script>
        <script src="${bootstrapMinJs}"></script>
        <script src="${offcanvasJs}"></script>

</body>

</html>
