<%-- 
    Document   : MyExam
    Created on : Mar 8, 2024, 10:26:55 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sum" method="post">
            <table width="40%">
                <tr>
                    <td>Enter an integer n:</td>
                    <td><input type="number" name="num" value="${requestScope.num}"></td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td><input type="text" name="num" readonly value="${requestScope.sum}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="SUM"></td>
                    <td>${requestScope.error}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
