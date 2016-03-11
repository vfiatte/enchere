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
        <div class="centrer">
            <table>
                <tr>
                    <td>Nom</td>
                    <td>Categorie</td>
                    <td>Description</td>
                    <td>Prix actuel</td>
                    <td>Fin de l'enchere</td>
                </tr>

                <tr>
                    <td>${monArticle.nom}</td>
                    <td>${monArticle.categorie.nom}</td>
                    <td>${monArticle.description}</td>
                    <td>${monArticle.prixActuel}</td>
                    <td>${monArticle.finDeVente}</td>
    
                    <td><a href = "FaireEnchereServlet?idArticle=${monArticle.id}">Encherir</a></td> 
                </tr>
                <tr>

                </tr>
            </table>
                ${votreArticle}
        </div>

        <br>


        <c:import url="_PIED.jsp"/>
    </body>
</html>
