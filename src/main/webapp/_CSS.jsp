<%-- 
    Document   : _CSS
    Created on : 7 mars 2016, 14:47:58
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${cookie.stylepage.value eq 'style.css' }">
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:when test="${cookie.stylepage.value eq 'style2.css' }">
        <link href="style/style2.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:when test="${cookie.stylepage.value eq 'style3.css' }">
        <link href="style/style3.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:otherwise>
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
    </c:otherwise>
    </c:choose>