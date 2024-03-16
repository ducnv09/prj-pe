<%-- 
    Document   : MyExam
    Created on : Mar 16, 2024, 11:07:48 AM
    Author     : Asus
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="get">
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="number" name="code" value="${requestScope.code}"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${requestScope.name}"></td>
                </tr>
                <tr>
                    <td>Train schedule:</td>
                    <td><input type="date" name="time" value="${requestScope.time}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="ADD"></td>
                    <td>${requestScope.error}</td>
                </tr>
            </table>
        </form>

        <div>
            List of train:
            <table border="1">
                <tr>
                    <td>Code</td>
                    <td>Name</td>
                    <td>Train schedule</td>
                </tr>
                <c:forEach items="${requestScope.trains}" var="train">
                    <tr>
                        <td>${train.code}</td>
                        <td>${train.name}</td>
                        <td><fmt:formatDate value="${train.time}" pattern="dd/MM/yyyy"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
