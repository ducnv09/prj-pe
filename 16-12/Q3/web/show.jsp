<%-- 
    Document   : show
    Created on : Mar 16, 2024, 2:49:36 PM
    Author     : Asus
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
        Supplier filter:
        <table style="border-collapse: collapse" border="1">
            <form action="show" method="get">
                <tr>
                    <td>Sublier name:</td>
                    <td><input type="text" name="name"></td>
                    <td><input type="submit" value="Filter by name"></td>
                </tr>
            </form>
            <form action="show" method="get">
                <tr>
                    <td>Year of birth:</td>
                    <td><input type="number" name="year"></td>
                    <td><input type="submit" value="Filter by year"></td>
                </tr>
            </form>
        </table><br>
        List of Suppliers:
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Address</th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.data}" var="item">
                <tr>
                    <td>${item.customerID}</td>
                    <td>${item.customerName}</td>
                    <td>${item.birthDate}</td>
                    <td>${item.gender ? "Male" : "Female"}</td>
                    <td>${item.address}</td>
                    <td><a href="delete?id=${item.customerID}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
