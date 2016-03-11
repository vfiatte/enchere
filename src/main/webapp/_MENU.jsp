<%-- 
    Document   : _MENU
    Created on : 7 mars 2016, 13:52:54
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu"><a href="listearticlesservlet?page=Articles">Rechercher les articles disponibles</a></div>
<div class="menu"><a href="PreferenceServlet?page=Preference">Preferences</a></div>
<div class="menu"><a href="MesArticlesServlet?page=mesArticles">Mes Artciles</a></div>

<div> Bonjour  ${sessionScope.user}</div>