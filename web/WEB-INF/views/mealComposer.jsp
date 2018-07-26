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
        <c:forEach items="${dishMetCondition}" var="dish" varStatus="dishStatus">
            <c:forEach items="${dish.value}" var="dishComp" varStatus="status">
                <h2>${dishComp.dishName}</h2>
            </c:forEach>
        </c:forEach>
        <p>------------------------------</p>
        <c:forEach items="${dishNotMetCondition}" var="dish" varStatus="dishStatus">
            <c:forEach items="${dish.value}" var="dishComp" varStatus="status">
                <h2>${dishComp.dishName}</h2>
            </c:forEach>
        </c:forEach>

    </body>
</html>
