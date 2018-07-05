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
        <c:if test="${dishMetCondition.size() == 0}" >
            <h1>Brak posiłków mieszczących się w zadanych warunkach</h1>
        </c:if>
        <c:forEach items="${dishMetCondition}" var="dish" varStatus="dishStatus">
            <c:set var="sumPerMeal" value="0" />
            <form>
                <h2>${dish.dishName}</h2>
                Składniki:<br />
                <table style="width: 50%">
                    <tr>
                        <th>Składnik</th>
                        <th>Ilość</th>
                        <th>Jednostka miary</th>
                        <th>Kalorii na jednostkę</th>
                        <th>Kalorii na posiłek</th>
                    </tr>
                    <c:forEach items="${dish.dishComponentInfo}" var="dishComp" varStatus="status">
                        <c:set var = "sufix" value = "${dishStatus.getIndex() * 100 + status.getIndex()}"/>                        
                        <tr>
                            <td>${dishComp.dishCompName}</td>
                            <td><input type="number" id="amount_${sufix}" value="${dishComp.dishAmount}" onchange="calculateCalories(${sufix}, ${dishComp.calPerUnit})" /></td>
                            <td>${dishComp.dishCompUnit}</td>
                            <td>${dishComp.calPerUnit}</td>
                            <td id="calories_${sufix}" onchange="">${dishComp.dishAmount * dishComp.calPerUnit}</td>
                        </tr>
                    </c:forEach>
                </table>                
                <input type="submit" name="Zapisz posiłek" />
            </form>
        </c:forEach>
            <h1>##################################################################################################</h1>
                    <c:forEach items="${dishNotMetCondition}" var="dish" varStatus="dishStatus">
            <c:set var="sumPerMeal" value="0" />
            <form>
                <h2>${dish.dishName}</h2>
                Składniki:<br />
                <table style="width: 50%">
                    <tr>
                        <th>Składnik</th>
                        <th>Ilość</th>
                        <th>Jednostka miary</th>
                        <th>Kalorii na jednostkę</th>
                        <th>Kalorii na posiłek</th>
                    </tr>
                    <c:forEach items="${dish.dishComponentInfo}" var="dishComp" varStatus="status">
                        <c:set var = "sufix" value = "${dishStatus.getIndex() * 100 + status.getIndex()}"/>                        
                        <tr>
                            <td>${dishComp.dishCompName}</td>
                            <td><input type="number" id="amount_${sufix}" value="${dishComp.dishAmount}" onchange="calculateCalories(${sufix}, ${dishComp.calPerUnit})" /></td>
                            <td>${dishComp.dishCompUnit}</td>
                            <td>${dishComp.calPerUnit}</td>
                            <td id="calories_${sufix}" onchange="">${dishComp.dishAmount * dishComp.calPerUnit}</td>
                        </tr>
                    </c:forEach>
                </table>                
                <input type="submit" name="Zapisz posiłek" />
            </form>
        </c:forEach>

    </body>
</html>
