<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/25/22
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>Student Dashboard</h1>

    <jsp:include page="headerInfo.jsp" /><br>
    <jsp:include page="home.jsp"/><br>
<form:form id="studentdashboardForm" style="margin-top:9%" modelAttribute="exam" action="examinitial" method="post">
    <table>
        <tr>
            <td>
                <p>Choose one subject:</p><br>
            </td>
        </tr>
        <tr>
            <td>
                <form:radiobutton path="subject" name="Sub" value="Chemistry"/>
                <label path="subject">Chemistry</label>
            </td>
        </tr>
        <tr>
            <td>
                <form:radiobutton path="subject" name="Sub" value="Mathematics"/>
                <label path="subject">Mathematics</label>
            </td>
        </tr>
        <tr>
            <td>
                <form:radiobutton path="subject" name="Sub" value="Physics"/>
                <label path="subject">Physics</label><br><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <button id ="next" name="next" style="Font-size:140%" value="Next">Next</button><br><br><br><br>
            </td>
        </tr>
    </table>
</form:form>


<table style="border-top-width:thick">
    <tr style="margin-left: 40%;font-size: 140%">
        <td>
            <p>Rules<p>
        </td>
    </tr>
    <tr>
            <td>
                <p>Rule 1: blah blah blah</p>
            </td>
    </tr>
    <tr>
            <td>
                <p>Rule 2: blah blah blah</p>
            </td>
    </tr>
        <tr>
            <td>
                <p>Rule 3: blah blah blah</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>Rule 4: blah blah blah</p>
            </td>
        </tr>
        <tr>
            <td>${message}</td>
        </tr>
</table>
</center>
</body>
</html>
