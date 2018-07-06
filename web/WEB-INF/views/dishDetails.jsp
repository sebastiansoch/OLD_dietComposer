<%-- 
    Document   : dishDetails
    Created on : May 31, 2018, 1:50:48 PM
    Author     : Seba
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        
        <c:forEach var="dc" items="${dishComponents}">
            ${dc} <br />
        </c:forEach>

        
        
    </body>
</html>
