
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    <spring:url value="/resources/js/page_navigation/page_navigation6.js" var="navigation6Js"/>
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


            <h1 >Mes Participations</h1>
            <p>
                Ceci est la liste des scrutins auxquels vous avez participé (au moins un vote à l'un des tours).
            </p>
            <div class="row" id="result">

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 1</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 2</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 3</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <!-- Un autre ligne ! -->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 4</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 5</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 6</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <!-- Une autre PAGE ! -->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 7</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 8</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 9</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <!-- Un autre ligne ! -->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 10</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 11</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 12</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <!-- Une autre PAGE ! -->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 13</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 14</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 15</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <!-- Un autre ligne ! -->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 16</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 17</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 18</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <!-- Une autre PAGE ! -->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 19</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->


                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 20</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 21</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <!-- Un autre ligne ! -->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 22</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 23</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

                <div class="col-xs-6 col-lg-4">
                    <a href="https://placeholder.com"><img src="http://via.placeholder.com/150x150"></a>
                    <h4>Heading 24</h4>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">Voir le Tableau de bord &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <!-- Une autre PAGE ! -->


            </div>
            <div id="page_navigation" class="col-lg-8 col-lg-push-4 col-xs-9 col-xs-push-3"> </div>
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
<script src="${navigation6Js}"></script>


</body>

</html>

