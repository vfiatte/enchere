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
                        <td colspan="3">Articles en cours d'enchere</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Aperçu</td>
                        <td>Acceder a l enchere</td>
                    </tr>

                    <c:forEach items="${Articles}" var="monArticle">
                        <tr>
                            <td>${monArticle.nom}</td>
                            <td>photo</td>
                            <td>photo</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table>
                <thead>
                    <tr>
                        <td colspan="3">Articles a payer</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Aperçu</td>
                        <td>Acceder aux details</td>
                    </tr>

                    <c:forEach items="${Articles}" var="monArticle">
                        <tr>
                            <td>${monArticle.nom}</td>
                            <td>photo</td>
                            <td>photo</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table>
                <thead>
                    <tr>
                        <td colspan="3">Articles paye</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Aperçu</td>
                        <td>Acceder aux details</td>
                    </tr>

                    <c:forEach items="${Articles}" var="monArticle">
                        <tr>
                            <td>${monArticle.nom}</td>
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