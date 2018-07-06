<%-- 
    Document   : home
    Created on : 2018-05-16, 15:34:37
    Author     : Seba
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>

        <h1>Diet Composer</h1>

        <form action="menuComposer">
            Wybierz posiłek :
            <select name="meal">
                <c:forEach items="${dishType}" var ="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
            <br />
            Wybierz ilość kalorii na dzień: 
            <input type="text" name="calories"><br />
            <input type="submit" value="Generuj" />
            <input type="submit" value="Przydział kal." />
        </form>

    </body>
</html>
