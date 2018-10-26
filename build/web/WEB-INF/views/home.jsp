<%-- 
    Document   : home
    Created on : 2018-05-16, 15:34:37
    Author     : Seba
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <h3>Skomponuj dzienne menu</h3>
        <form action="dailyMenuComposer">
            <b>Ilość kalorii na dzień:</b>
            <input type="number" name="calories" /><br />
            <table >
                <tr>
                    <th colspan="2">Wybierz ilość posiłki w ciągu dnia oraz przydziel procent kalorii dla poszczególnych posiłków</th>
                </tr>
                <tr>
                    <td>
                        <ul style="list-style-type: none">
                            <li><input type="checkbox" name="breakfast" checked="checked" />Śniadanie</li>
                            <li><input type="checkbox" name="second_breakfast" />Drugie śniadanie</li>
                            <li><input type="checkbox" name="soup" />Zupa</li>
                            <li><input type="checkbox" name="main_course" checked="checked" />Danie główne</li>
                            <li><input type="checkbox" name="tea" />Podwieczorek / Przekąska</li>
                            <li><input type="checkbox" name="supper" checked="checked" />Kolacja</li>
                        </ul>

                    </td>
                    <td>
                        <ul style="list-style-type: none">
                            <li><input type="number" name="cal_breakfast" min = "0" max="100" value="0" />%</li>
                            <li><input type="number" name="cal_second_breakfast"  min = "0" max="100" value="0" />%</li>
                            <li><input type="number" name="cal_soup"  min = "0" max="100" value="0" />%</li>
                            <li><input type="number" name="cal_main_course" min = "0" max="100" value="0" />%</li>
                            <li><input type="number" name="cal_tea"  min = "0" max="100" value="0" />%</li>
                            <li><input type="number" name="cal_supper" min = "0" max="100" value="0" />%</li>
                        </ul>

                    </td>
                </tr>

            </table>
            <input type="submit" value="Generuj" />
        </form>
        
<!--        <h3>Skomponuj konkretny posiłek</h3>
        <form action="mealComposer">
            Wybierz posiłek :
            <select name="meal">
                <c:forEach items="${dishType}" var ="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
            <br />
            Wybierz ilość kalorii na posiłek: 
            <input type="number" name="calories" /><br />
            <input type="submit" value="Generuj" />
        </form>-->

    </body>
</html>
