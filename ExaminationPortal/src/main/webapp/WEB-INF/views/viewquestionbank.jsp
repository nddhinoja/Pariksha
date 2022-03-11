<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/28/22
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Question Bank</title>
</head>
<body>

<form action="home" method="get">
    <button type="submit" name="Home">Home Interceptor</button>
</form>
<a href="facultydashboard.jsp" style="font-size: large">Home</a>
<center>
    <h1>View Question Bank</h1>
    <jsp:include page="headerInfo.jsp" /><br>
    <jsp:include page="home.jsp"/><br>

    <form method="post">
        <p>${subject}</p>
            <table style="border: solid black" border="1">
            <tr>
                <th>
                 Question
                </th>
                <th>
                    Option A
                </th>
                    <th>
                      Option B
                     </th>
        <th>
            Option C
        </th>
        <th>
            Option D
        </th>
        <th>
            Weightage
        </th>
        <th>
            Correct Ans
        </th>
    </tr>
    <tr>
     <c:forEach items="${questionlist}" var="questionl">
        <tr>
            <td>
                ${questionl.questionContent}
            </td>
            <c:forEach var="option" items="${questionl.optionList}">
                <td>
                    ${option.optionContent}
                </td>
            </c:forEach>
            <td>
                <p>${questionl.weightage}</p>
            </td>
            <td>
                <c:forEach var="option" items="${questionl.optionList}">
                    <c:choose>
                        <c:when test="${option.flag==true}">
                            ${option.optionContent}
                        </c:when>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tr>
</table>
</form>
</center>
</body>
</html>
