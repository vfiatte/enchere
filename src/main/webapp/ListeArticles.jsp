<%-- 
    Document   : ListeFilm
    Created on : 8 mars 2016, 14:50:29
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>5by5 : Liste des Articles disponibles</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/><br>
        <form method="post" action="listearticlesservlet">
            <div>
                <Option>
                <select name = "categorie">
                    <option value="listerTous"> Lister tous </option>
                    <c:forEach items="${categorie}" var="maCategorie">
                        <option value="${maCategorie.id}"> ${maCategorie.nom} </option>
                    </c:forEach>
                </select>
                </Option>
                <table>
                    <tr>
                        <td>Nom</td>
                        <td>Aperçu</td>
                        <td>Acceder a l enchere</td>
                    </tr>

                    <c:forEach items="${Articles}" var="monArticle">
                        <tr>
                            <td>${monArticle.nom}</td>
                            <td>photo</td>
                            <td><a href = "DetailArticleServlet?idArticle=${monArticle.id}">Enchere</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <a href = "AjoutArticleServlet?page=AjoutArticle">Ajouter un article</a>
            </div>
            <input type="submit">
        </form>

        <br>


        <c:import url="_PIED.jsp"/>
    </body>
</html>
