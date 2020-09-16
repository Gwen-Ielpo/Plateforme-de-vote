<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <!-- JS nécessaires pour Bootstrap-->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>

    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="${styleCss}">
    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">
</head>
<body>
<!-- Barre de navigation au dessus -->
<jsp:include page="../included/nav_bar_top_online.jsp"/>

<div class="container">
    <div class="row row-offcanvas row-offcanvas-left">
        <!-- Menu de Gauche -->
        <jsp:include page="../included/left_nav_bar_online.jsp"/>
        <!-- Bouton pour faire apparaitre le menu gauche sur petits écrans -->
        <p class="pull-left col-xs-2 visible-xs">
            <button type="button" class="btn btn-primary btn-md visible-xs" data-toggle="offcanvas">Accès menu</button>
        </p>
        <!-- Contenu de la page -->
        <div class="col-xs-12 col-sm-8">


            <h1 >Accueil</h1>
            <h3>Bonjour ${user.pseudo} !</h3>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse pulvinar nulla a pharetra bibendum. Aliquam bibendum augue vitae imperdiet pulvinar. Aliquam sit amet libero et augue mattis imperdiet imperdiet in nisl. Integer non mauris finibus, ultricies neque et, elementum ipsum. Aenean vehicula urna in suscipit vehicula. Sed nec pulvinar felis. Sed erat magna, volutpat sed vestibulum in, bibendum sit amet turpis. Nam nunc elit, placerat eget commodo sed, efficitur eu dui. Sed finibus est non sapien fermentum, vitae feugiat elit volutpat. Cras facilisis odio nunc, eu maximus eros pulvinar sit amet. Mauris ut metus id lorem gravida scelerisque.
            </p>
            <p>
                Aliquam suscipit vehicula libero, in facilisis risus mattis ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis vel egestas ante. In efficitur, ex vel ornare tincidunt, elit ante tempus metus, ut imperdiet mi leo sed diam. Phasellus ornare laoreet lacus vel pretium. Nulla et tortor dignissim, mollis eros sed, vulputate magna. Quisque aliquet pretium dolor, eget volutpat leo congue vel. Maecenas non lectus eu ex bibendum sodales ut non turpis. Suspendisse potenti. Maecenas ac orci sapien. Proin varius justo sed dui gravida mollis. Donec nec turpis elementum, dignissim ante nec, convallis lacus. Maecenas quis velit porttitor, consectetur felis pharetra, feugiat nunc. Phasellus pretium augue eu turpis feugiat placerat.
            </p>
            <h3> Derniers scrutins ajoutés</h3>
            <div class="row">
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading </h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading </h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>


                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading </h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

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
</body>

</html>
