<%--
  Created by IntelliJ IDEA.
  User: liliane
  Date: 16/11/17
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
       <div class="col-xs-12 col-sm-4 sidebar-offcanvas vertical-menu" id="sidebar">
            <header> Menu </header>
           <a href="index" class="">Accueil </a>
           <a href="polllist" class="">Liste des scrutins</a>
              <form>
                  <div class="input-group">
                      <input type="text" class="form-control" placeholder="Rechercher">
                      <div class="input-group-btn">
                          <button class="btn btn-default" type="submit">
                              <i class="glyphicon glyphicon-search"></i>
                         </button>
                      </div>
                  </div>
              </form>
         <!--  <a href="#" class=""><i class="glyphicon glyphicon-remove"></i>Déconnexion </a> -->
   </div>
</html>