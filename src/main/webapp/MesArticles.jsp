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
        <div>
            <table>
                <thead>
                    <tr>
                        <td colspan="3">Vos Artciles mis en enchere</td></b>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Apercu</td>
                        <td>Acceder a l enchere</td>
                    </tr>

                    <c:forEach items="${vosArticlesPostes}" var="monArticlePoste">
                        <tr>
                            <td>${monArticlePoste.nom}</td>
                            <td>photo</td>
                            <td><a href = "DetailArticleServlet?idArticle=${monArticlePoste.id}">Enchere</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br>
            <table>
                <thead>
                    <tr>
                <b><td colspan="3">Historique des encheres</td></b>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Articles</td>
                            <td>Acceder a l enchere</td>
                        </tr>

                        <c:forEach items="${mesEncheres}" var="monEnchere">
                            <tr>
                                <td>${monEnchere.nom}</td>
                                <td><a href = "DetailArticleServlet?idArticle=${monEnchere.id}">Enchere</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
            <br><br>
            <table>
                <thead>
                    <tr>
                        <b><td colspan="3">Articles a payer</td></b>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Apercu</td>
                        <td>Acceder aux details</td>
                    </tr>

                    <c:forEach items="${ArticlesAPayer}" var="monArticleAPayer">
                        <tr>
                            <td>${monArticleAPayer.nom}</td>
                            <td>photo</td>
                            <td>photo</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br>
            <table>
                <thead>
                    <tr>
                        <b><td colspan="3">Articles payes</td></b>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Apercu</td>
                        <td>Acceder aux details</td>
                    </tr>

                    <c:forEach items="${ArticlesPayes}" var="monArticlePaye">
                        <tr>
                            <td>${monArticlePaye.nom}</td>
                            <td>photo</td>
                            <td>photo</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <input type="submit">
    </form>

    <br>


    <c:import url="_PIED.jsp"/>
</body>
</html>