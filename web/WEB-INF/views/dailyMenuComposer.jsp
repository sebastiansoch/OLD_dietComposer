<%-- 
    Document   : dailyMenuComposer
    Created on : 2018-07-20, 11:35:42
    Author     : ssoch
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Menu</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <c:forEach items="${dishesMetCondition}" var="dish">
            <form action="dishDetails" method="post">
                <input type="hidden" name="pickedDish" value="${dish.dishId}" />
                <h2>${dish.dishName} <input type="submit" value="Szczegóły" /></h2>
            </form>
        </c:forEach>

        ----------------------------------------------------
        
        <c:forEach items="${dishesNotMetCondition}" var="dish">
            <form action="dishDetails" method="post" >
                <input type="hidden" name="pickedDish" value="${dish.dishId}" />
                <h2>${dish.dishName} <input type="submit" value="Szczegóły" /></h2>
            </form>
        </c:forEach>
    </body>
</html>
