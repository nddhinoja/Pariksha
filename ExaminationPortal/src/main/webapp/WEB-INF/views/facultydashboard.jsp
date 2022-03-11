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
        <table style="border-style: solid; border-color: black; border-collapse: collapse; padding: 10px" border="1">
                <c:forEach items="${displayData}" var="examlist" varStatus="i">
                    <tr>
                        <td>
                            Student: ${i.count}
                        </td>
                    </tr>
                    <tr>
                        <td>
                        Student Name:
                        </td>
                        <td>
                            <c:out value="${examlist.user.name}"/>
                        </td>
                    </tr>
                     <tr>
                        <td>
                            Exam Date:
                        </td>
                        <td>
                            <c:out value="${examlist.examDate}"/>
                        </td>
                     </tr>
                    <tr>
                        <td>
                            Exam Subject:
                        </td>
                        <td>
                            <c:out value="${examlist.subject}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        Exam Marks:
                        </td>
                        <td>
                            <c:out value="${examlist.marks}"/>
                        </td>
                    </tr>
                </c:forEach>
        </table>
    </form>
</center>
</body>
</html>
