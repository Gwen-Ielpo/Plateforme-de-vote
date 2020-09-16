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
    <spring:url value="/resources/css/datepicker/bootstrap-datepicker3.css" var="DatePickerCss"/>
    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="${styleCss}">
    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">
    <link rel="stylesheet" href="${DatePickerCss}">
    <!-- JS nécessaires pour Bootstrap-->
    <spring:url value="/resources/js/jquery-3.2.1.min.js" var="jquery321MinJs"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" var="popperJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
    <spring:url value="/resources/js/offcanvas/offcanvas.js" var="offcanvasJs"/>

    <!-- Validation de formulaire -->
    <spring:url value="/resources/js/bsvalidate/jquery.bsvalidate.js" var="bsValidateJs"/>
    <spring:url value="/resources/js/bsvalidate/main_validate_new_poll.js" var="bsValidateNewPollJs"/>

    <!-- Date Picker -->
    <spring:url value="/resources/js/datepicker/bootstrap-datepicker.js" var="datePickerJs"/>
    <spring:url value="/resources/js/datepicker/bootstrap-datepicker.fr.min.js" var="datePickerMinJS"/>

    <!-- Dynamic form-->
    <spring:url value="/resources/js/dynamic_form/dynamic_form.js" var="dynamicFormJs"/>


</head>
<body>
<!-- Barre de navigation au dessus -->
<jsp:include page="../included/nav_bar_top_online.jsp" />

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


            <h1 >Créer un nouveau scrutin</h1>
            <p>
            </p>
            <form   id='createNewPoll'
                    action="createpoll"
                    method="post"
                    class="well"
            >
                <h4>Configuration générale</h4>
                <div class="form-group">
                    <label for="title" class="form-control-label">Titre</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Le titre de votre scrutin" required>
                </div>

                <!-- DatePicker creationDate-->
                <div class="form-group">
                    <label for="creationDate" class="form-control-label">Date d'ouverture</label>
                    <div class="input-group date">
                        <input type="text" class="form-control" id="creationDate" name="endDate"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                    </div>
                    <small id="help_creationDate" class="text-muted">
                        Sélectionnez une date ou laissez vide pour aujourd'hui.
                    </small>
                </div>

                <!-- DatePicker endDate-->
                <div class="form-group">
                    <label for="endDate" class="form-control-label">Date de fermeture</label>
                    <div class="input-group date">
                        <input type="text" class="form-control" id="endDate" name="endDate"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                    </div>
                    <small id="help_endDate" class="text-muted">
                        Sélectionnez une date ou laissez vide pour un temps indéterminé.
                    </small>
                </div>

                <div class="form-group">
                    <label for="description" class="form-control-label">Description</label>
                    <textarea class="form-control" rows="10" name="description" id="description" placeholder="Une courte description de votre scrutin : pourquoi, de quoi, pour qui,... cette description vous permet aussi de communiquer avec les votants" required></textarea>
                </div>

                <div class ="form-group">
                    <label for="pollType"> Type de scrutin</label>
                    <select class="form-control" id="pollType" name="pollType">
                        <c:forEach var="pollingType" items="${listTypes}">
                            <option value="${pollingType.shortName}">
                                    ${pollingType.longName}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class ="form-group dynamicInput">
                    <h4>Configuration des choix</h4>
                    <div id="choice_1" class="form-group">
                        <label for="choice1"> Choix 1</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Votre nouveau choix" name="choice1" id="choice1">
                        </div>
                    </div>
                    <div id="choice_2" class="form-group">
                        <label for="choice2"> Choix 2</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Votre nouveau choix" name="choice2" id="choice2">
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <input type="button" class="btn btn-default btn-add-field" value="Ajouter un nouveau choix">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default" value="Submit">Envoyer</button>
                </div>
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
<script src="${bsValidateNewPollJs}"></script>
<!-- Date Picker-->
<script src="${datePickerJs}"></script>
<script src="${datePickerMinJS}"></script>
<!-- Dynamic Form -->
<script src="${dynamicFormJs}"></script>

<script>
    $('#createNewPoll .input-group.date').datepicker({
        language: "fr",
        startDate: '+1d'//On force à prendre une date supérieure à "aujourd'hui"
    });
</script>


</body>

</html>

