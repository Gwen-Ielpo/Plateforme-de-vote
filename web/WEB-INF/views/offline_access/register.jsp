<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Titre de l'appli</title>


    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <!-- CSS -->
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
    <spring:url value="resources/js/jquery-3.2.1.min.js" var="jqueryJs" />
    <spring:url value="resources/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="resources/js/bsvalidate/jquery.bsvalidate.js" var="bsvalidateJqueryJs" />
    <spring:url value="resources/js/bsvalidate/main_validate_register.js" var="bsvalidateRegisterJs" />
    <spring:url value="resources/js/offcanvas/offcanvas.js" var="offcanvasJs" />
</head>
<body>
<jsp:include page="../included/navbar_top.jsp"/>

<div class="container">
    <div class="row row-offcanvas row-offcanvas-left">
        <jsp:include page="../included/left_nav_bar.jsp"/>

        <p class="pull-left col-xs-2 visible-xs">
            <button type="button" class="btn btn-primary btn-md visible-xs" data-toggle="offcanvas">Accès menu</button>
        </p>
        <div class="col-xs-12 col-sm-8">
            <c:if test="${param.already_exist}">
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    Inscription échouée : identifiant et/ou l'adresse e-mail sont déjà utilisés.
                </div>
            </c:if>
            <h1 >Inscription</h1>


            <form   id='registerUser'
                    action="registration"
                    method="post"
                    class="well"
            >
                <div class="form-group">
                    <label for="pseudo" class="form-control-label">Pseudonyme</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Votre nom ou surnom." required>
                </div>
                <div class="form-group">
                    <label for="email" class="form-control-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="ex : votrejolie@dresse.qqlc" required>
                </div>
                <div class="form-group">
                    <label for="pwd" class="form-control-label">Mot de passe</label>
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Votre mot de passe. Minimum 8 caractères." required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="pwdConfirm" name ="pwdConfirm" placeholder="Confirmez votre mot de passe" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default" value="Submit">Envoyer</button>
                </div>

            </form>
        </div>

    </div>

    <!-- Les Scripts -->

    <script src="${jqueryJs}"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${bsvalidateJqueryJs}"></script>
    <script src="${bsvalidateRegisterJs}"></script>
    <script src="${offcanvasJs}"></script>
</body>

</html>