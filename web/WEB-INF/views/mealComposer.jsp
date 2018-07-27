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

        <c:forEach items="${dishesMetCondition}" var="dishType">
            <c:forEach items="${dishType.value}" var="dish" >
                <form action="dishDetails" method="post">
                    <input type="hidden" name="pickedDish" value="${dish}" />
                    <h2>${dish} <input type="submit" value="Szczegóły" /></h2>

                </form>

            </c:forEach>
        </c:forEach>
        <p>------------------------------</p>
        <c:forEach items="${dishesNotMetCondition}" var="dishType">
            <c:forEach items="${dishType.value}" var="dish" >
                <form action="dishDetails" method="post">
                    <input type="hidden" name="pickedDish" value="${dish}" />
                    <h2>${dish} <input type="submit" value="Szczegóły" /></h2>

                </form>

            </c:forEach>
        </c:forEach>
    </body>
</html>
