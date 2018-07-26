<%-- 
    Document   : dailyMenuComposer
    Created on : 2018-07-20, 11:35:42
    Author     : ssoch
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Menu</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <c:forEach items="${dishMetCondition}" var="dishType">
            ${dishType}
        </c:forEach>
        
        ----------------------------------------------------
        
        <c:forEach items="${dishesNotMetConditions}" var="dishType">
            ${dishType}
        </c:forEach>
    </body>
</html>
