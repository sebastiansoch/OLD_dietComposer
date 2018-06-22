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

        <c:forEach items="${dishList}" var="dish" varStatus="dishStatus">
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
                    <c:forEach items="${dish.dishItems}" var="dishItems" varStatus="status">
                        <c:set var = "sufix" value = "${dishStatus.getIndex() * 100 + status.getIndex()}"/>                        

                        <tr>
                            <td>${dishItems.dishComponent.dishComponentName}</td>
                            <td><input type="number" id="amount_${sufix}" value="${dishItems.amount}" /></td>
                            <td>${dishItems.dishComponent.unit}</td>
                            <td>${dishItems.dishComponent.caloriesPerUnit}</td>
                            <td><input type="number" id="calories_${sufix}" value="" /></td>
                        </tr>
                        
                        <script>
                                document.getElementById("calories_${sufix}").value = document.getElementById("amount_${sufix}").value * ${dishItems.dishComponent.caloriesPerUnit};
                        </script>
                    </c:forEach>
                </table>                
                <input type="submit" name="Zapisz posiłek" />
            </form>

        </c:forEach>
    </body>
</html>
