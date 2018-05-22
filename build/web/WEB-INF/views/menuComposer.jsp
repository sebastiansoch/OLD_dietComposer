<%-- 
    Document   : menuComposer
    Created on : 2018-05-16, 16:04:34
    Author     : Seba
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <h1>Menu Composer</h1>
        
        <c:forEach var="d" items="${dishes}" >
            <a href="login?dish=${d}">${d}</a>
        </c:forEach>
        
    </body>
</html>
