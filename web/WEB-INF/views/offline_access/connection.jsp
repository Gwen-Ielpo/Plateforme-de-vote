<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Titre de l'appli</title>
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <!-- Les CSS et JS par défaut-->
    <!-- Les CSS et JS par défaut-->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinCss"/>
    <spring:url value="/resources/css/offcanvas/offcanvas.css" var="offCanvasCss"/>
    <spring:url value="/resources/css/verticalmenu/vertical_menu.css" var="VerticalMenuCss"/>

    <!-- JS nécessaires pour Bootstrap-->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>

    <!-- Validation de formulaire -->
    <spring:url value="/resources/js/bsvalidate/jquery.bsvalidate.js" var="bsValidateJs"/>
    <spring:url value="/resources/js/bsvalidate/main_validate_connection.js" var="bsValidateConnectionJs"/>
    <spring:url value="/resources/css/bsvalidate/style.css" var="styleCss"/>
    <spring:url value="/ressources/js/bootbox/bootbox.min.js" var="bootboxJs"/>

    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">

    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">


    <link rel="stylesheet" href="${styleCss}">
</head>
<body>

<!-- Nav_bar on top -->
<jsp:include page="../included/navbar_top.jsp"/>



<div class="container">
    <div class="row row-offcanvas row-offcanvas-left">
        <!-- Lateral Nav bar --->
        <jsp:include page="../included/left_nav_bar.jsp"/>

        <p class="pull-left col-xs-2 visible-xs">
            <button type="button" class="btn btn-primary btn-md visible-xs" data-toggle="offcanvas">Accès menu</button>
        </p>
        <div class="col-xs-12 col-sm-8">

            <!-- La connexion a échoué -->
            <c:if test="${param.connection_failed}">

                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    Connexion échouée : identifiant et/ou mot de passe incorrect(s).
                </div>
            </c:if>

            <h1 >Connexion</h1>
            <p> Ou si vous n'avez pas encore de compte, <a href="register">vous pouvez en créer un. </a></p>
            <form id="connect" method="post" action="login">
                <div class="form-group">
                    <label for="ids">Identifiant</label>
                    <input type="text" class="form-control" name="ids" id="ids" placeholder="Votre email ou pseudonyme">
                </div>
                <div class="form-group">
                    <label for="pwd">Mot de passe</label>
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Votre mot de passe">
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"> Se souvenir des mes identifiants</label>
                </div>
                <button type="submit" class="btn btn-default">Connexion</button>

            </form>
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
<!-- Validation du formulaire coté client-->
<script src="${bsValidateJs}"></script>
<script src="${bsValidateConnectionJs}"></script>
<script src="${bootboxJs}"></script>

<script>
</script>


</body>

</html>

