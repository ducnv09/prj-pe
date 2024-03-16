<%-- 
    Document   : show
    Created on : Mar 8, 2024, 11:25:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
        </style>
        <script type="text/javascript">
            function change() {
                document.getElementById("f1").submit();
            }
        </script>
    </head>
    <body>
       
        <form id="f1" action="show" method="get">
            List of Subjects:
            <select name="subject" onchange="change()">
                <option value="all" href="show?Subject=all">All subjects</option>
                <c:forEach items="${requestScope.subjs}" var="subj">
                    <option ${sessionScope.suid eq subj.subjectID ? "selected" : ""} value="${subj.subjectID}">${subj.subjectName}</option>
                </c:forEach>
            </select>
        </form>

        <p>List of Students:</p>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Gender</td>
                <td>Subject</td>
                <td>Select</td>
            </tr>
            <c:forEach items="${requestScope.students}" var="stu">
                <tr>
                    <td>${stu.studentID}</td>
                    <td>${stu.studentName}</td>
                    <td>${stu.birthDate}</td>
                    <td>${stu.gender ? "Male" : "Female"}</td>
                    <td>${stu.subject.subjectName}</td>
                    <td><a href="detail?stuid=${stu.studentID}">Select</a></td>
                </tr>
            </c:forEach>
        </table><br>
        <div>
            <c:set value="${sessionScope.student}" var="stu"/>
            Detail ìnormation:
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="input" name="code" value="${stu.studentID}" readonly style="outline: none"></td>
                    <td>Name:</td>
                    <td><input type="input" name="name" value="${stu.studentName}" readonly style="outline: none"></td>
                </tr>
                <tr>
                    <td>Date of birth:</td>
                    <td><input type="input" name="dob" value="${stu.birthDate}" readonly style="outline: none"></td>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="1" disabled ${stu.gender == true ? "checked" : ""}>Male
                        <input type="radio" name="gender" value="0" disabled ${stu.gender == false ? "checked" : ""}>Female
                    </td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input type="input" name="code" value="${stu.subject.subjectName}" readonly style="outline: none"></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </body>
</html>
