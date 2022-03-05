<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 2/1/22
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>

    <jsp:include page="home.jsp"/><br>
    <jsp:include page="headerInfo.jsp"/><br>
    <form:form id="resultform" modelAttribute="marks" method="get">
    <table>
        <tr>
            <td style="font-size: 140%">
                Your Result for Subject: <%=session.getAttribute("subject")%><br>
                Exam Id:<%=session.getAttribute("examId")%>
            </td>
        </tr>
        <tr>
            <td>
                Result :<label for="resultform" style="font-size: large">${marks}</label>
            </td>
        </tr>
    </table>
    </form:form>
</center>

</body>
</html>
