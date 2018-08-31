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
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 5px; 
            }      
            th {
                font-weight: bold;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>

        <h2>Posiłek: ${dishDetails.dishName}</h2>
        <table>
            <tr>
                <th>Składnik</th>
                <th>ilość</th>
                <th>jedn.</th>
                <th>kal/jedn.</th>
            </tr>
            <c:forEach items="${dishDetails.dishesComponents}" var="dishComp">
                <tr>
                    <td><b>${dishComp.dishCompName}</b></td>
                    <td>${dishComp.dishAmount}</td>
                    <td>${dishComp.dishCompUnit}</td>
                    <td>${dishComp.calPerUnit}</td>
                </tr>
            </c:forEach>
        </table>



    </body>
</html>
