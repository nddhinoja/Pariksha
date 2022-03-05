<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/25/22
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<center>
<h1>Faculty Dashboard</h1>
    <jsp:include page="headerInfo.jsp" /><br>
    <jsp:include page="home.jsp"/><br>
<form:form id="facultydashboardForm" style="margin-top:9%" action="setquestion" modelAttribute="exam" method="post">
    <table>
        <tr>
            <td>
                <p>Choose one subject:</p>
            </td>
        </tr>
        <tr>
            <td>
            <form:radiobutton path="subject" name="Sub" value="Physics"/>
            <form:label path="subject">Physics</form:label><br>
            </td>
        </tr>
        <tr>
            <td>
            <form:radiobutton path="subject" name="Sub" value="Chemistry"/>
            <form:label path="subject">Chemistry</form:label><br>
            </td>
        </tr>
        <tr>
            <td>
            <form:radiobutton path="subject" name="Sub" value="Mathematics"/>
            <form:label path="subject">Mathematics</form:label><br><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <form:button id ="viewquestion" name="viewquestion" style="Font-size:140%" formaction="viewquestions">Bank viewquestions</form:button>
                <form:button id ="setquestion" name="setQuestion" style="Font-size:140%" formaction="setquestion">Set Questions</form:button>
            </td>
        </tr>
    </table>
</form:form>
</center>
<center>
    <form method="get">
        <table>
            <tr>
                <td>
                    <c:forEach items="${displayData}" var="examlist">
                        <p>Student Name: </p><c:out value="${examlist.user.name}"/><br>
                        <p>Exam Date: </p><c:out value="${examlist.examDate}"/><br>
                        <p>Exam Subject: </p><c:out value="${examlist.subject}"/><br>
                        <p>Exam Marks: </p><c:out value="${examlist.marks}"/><br>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </form>
<%--<form:form id="dispalyForm" modelAttribute="displayData" method="get">
    <table style="border: solid black">
        <tr>
            <td>
            <p style="font-size: 140%">Results<p>
            </td>
        </tr>
        <tr>
            <td>${displayData.listOfUser.get(0).name}</td>
            <td>${displayData.listOfUser.get(0).exam.subject}</td>
            <td>${displayData.listOfUser.get(0).exam.examDate}</td>
            <td>${displayData.listOfUser.get(0).exam.marks}</td>
        </tr>
        <tr>
            <td>${displayData.listOfUser.get(1).name}</td>
            <td>${displayData.listOfUser.get(1).exam.subject}</td>
            <td>${displayData.listOfUser.get(1).exam.examDate}</td>
            <td>${displayData.listOfUser.get(1).exam.marks}</td>
        </tr>
        <tr>
            <td>${displayData.listOfUser.get(2).name}</td>
            <td>${displayData.listOfUser.get(2).exam.subject}</td>
            <td>${displayData.listOfUser.get(2).exam.examDate}</td>
            <td>${displayData.listOfUser.get(2).exam.marks}</td>
        </tr>
        <tr>
            <td>${displayData.listOfUser.get(3).name}</td>
            <td>${displayData.listOfUser.get(3).exam.subject}</td>
            <td>${displayData.listOfUser.get(3).exam.examDate}</td>
            <td>${displayData.listOfUser.get(3).exam.marks}</td>
        </tr>
        <tr>
            <td>${message}</td>
        </tr>
    </table>
</form:form>--%>
</center>
</body>
</html>
