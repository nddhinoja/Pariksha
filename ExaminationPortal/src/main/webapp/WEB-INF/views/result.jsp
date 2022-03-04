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

    <jsp:include page="home.jsp"/>
    <form:form id="resultform" modelAttribute="marks" method="get">
    <table>
        <tr>
            <td style="font-size: 140%">
                Result:
            </td>
            <td>
                <label for="resultform">${marks}</label>
            </td>
        </tr>
    </table>
    </form:form>
</center>

</body>
</html>
