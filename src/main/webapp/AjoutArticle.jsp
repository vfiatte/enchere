<%-- 
    Document   : AjoutFilm
    Created on : 8 mars 2016, 14:50:53
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"/>
    </head>
    <c:import url="_TITRE.jsp"/>
    <c:import url="_MENU.jsp"/>

    <body>
        <form method="post" action="AjoutArticleServlet">
            <table>
                <tr>
                    <td>Nom</td>
                    <td><input type="text" name="nom"></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><textarea name="description"></textarea></td>
                </tr>
                <tr>
                    <td><label>Prix de depart</label></td>
                    <td><input name="prixDepart" value= "0" type="number" min="0"></td>
                </tr>
                <tr>
                    <td><label>Temps de validité een jour</label></td>
                    <td><input name="tempsValidite" value= "0" type="number" min="0"></td>
                </tr>
                <tr><td><label>Categorie</label></td>
                    <td>
                <Option>
                <select name = "categorie">
                    <c:forEach items="${categorie}" var="maCategorie">
                        <option value="${maCategorie.id}"> ${maCategorie.nom} </option>
                    </c:forEach>
                </select>
                </Option>
                </td>

                </tr>


                <tr>
                    <td colspan="2"><input type="Submit"></td>
                </tr>
            </table>
        </form>
        <c:import url="_PIED.jsp"/>
    </body>

</html>
