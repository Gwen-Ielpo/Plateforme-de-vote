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


            <h1 >Profil Utilisateur</h1>
            <div class="well">
                <h3> Informations du compte</h3>
                <p>Ces informations sont nécessaires à la gestion du compte.</p>

                <div class ="row">
                    <div class="col-sm-6">
                        <h4>Change de Pseudonyme</h4>
                        <form class="form-inline" action="editProfilePseudo" method="PUT">
                            <div class ="form-group col-auto">
                                <input type="text" class="form-control" name="NewPseudo" id="NewPseudo" placeholder="Votre nouveau Pseudo" value="${user.pseudo}">
                                <input type="hidden" name="_method"  value="PUT">
                            </div>
                            <button type="submit" class="btn btn-primary col-auto">Editer</button>
                        </form>

                        <hr>
                        <h4>Changer son e-mail</h4>
                        <form id="form-edit-profile-email" class="form-inline">
                            <label class="sr-only" for="NewEmail"></label>
                            <input type="email" class="form-control " name="NewEmail" id="NewEmail" placeholder="Votre nouvelle adresse email" value="${user.email}">
                            <button type="submit" class="btn btn-primary col-auto">Editer</button>
                        </form>
                        <div class="resEmail">

                        </div>

                        <hr>
                        <h4>Changer son mot de passe</h4>
                        <form class="form-group" action="editProfileMdp" method="PUT">
                            <label class="" for="OldPwd">Ancien mot de passe </label>
                            <div class="form-group">
                                <input type="password" class="form-control mb-2 mr-sm-2 mb-sm-0" id="OldPwd" placeholder="Votre ancien mot de passe">
                            </div>

                            <label class="" for="NewPwd">Nouveau mot de passe </label>
                            <div class="form-group">
                                <input type="password" class="form-control mb-2 mr-sm-2 mb-sm-0" id="NewPwd" placeholder="Votre nouveau mot de passe">
                            </div>

                            <label class="" for="ConfirmPwd">Confirmer le mot de passe </label>
                            <div class="form-group">
                                <input type="password" class="form-control mb-2 mr-sm-2 mb-sm-0" id="ConfirmPwd" placeholder="Confirmer votre mot de passe">
                            </div>
                            <button type="submit" class="btn btn-primary">Editer</button>
                        </form>

                    </div>

                    <div class="col-sm-6">
                        <h4>Changer son avatar</h4>
                        <div class = "show-avatar center-block">
                            <img src="${user.avatar}" class="img-circle img-responsive">
                        </div>
                        <div>
                            <form class="form-inline" action="editProfileAvatar" method="PUT">
                                <label class="sr-only" for="NewAvatar"></label>
                                <input type="url" class="form-control " id="NewAvatar" placeholder="L'URL de votre nouvel avatar" value="${user.avatar}">
                                <button type="submit" class="btn btn-primary col-auto">Editer</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>

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
    });

    $.ready(function () {
        var $formEditProfileEmail = $('#form-edit-profile-email');
        $formEditProfileEmail.on('submit', function(event) {
            // on annule l'envoi
            event.preventDefault();
            var newEmail = $formEditProfileEmail.find('input #NewEmail').val();
            if(!newEmail) return;
            $.ajax({
                url: '/editProfileEmail',
                method: 'PUT',
                data: {
                    newEmail: newEmail
                }
            }).success(function (data) {
                    // en cas de succès ; data contient la réponse du serveur
                    // data.status
                var wrapper = document.getElementsByClassName("resEmail");
                var newEmail = "<div class = 'alert alert-success' id = 'alertSuccessEmail'>"
                                     + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                                     + data.status
                                     + "</div>" ;
                    wrapper.appendChild(newEmail);
                }

            ).fail(function (data) {
                // en cas d'échec ; data contient la réponse du serveur
            });
        });
    });
</script>


</body>

</html>
