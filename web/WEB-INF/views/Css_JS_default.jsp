<%--
  Created by IntelliJ IDEA.
  User: liliane
  Date: 16/11/17
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

    <link rel="stylesheet" href="${bootstrapMinCss}">
    <link rel="stylesheet" href="${bootstrapCss}">

    <link rel="stylesheet" href="${offCanvasCss}">
    <link rel="stylesheet" href="${VerticalMenuCss}">
</html>
