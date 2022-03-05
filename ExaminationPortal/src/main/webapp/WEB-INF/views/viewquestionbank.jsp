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
<center>
    <h1>View Question Bank</h1>
    <jsp:include page="headerInfo.jsp" />
    <jsp:include page="home.jsp"/>

    <form method="post">
        <p>${subject}</p>
            <table style="border: solid black">
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
<%--
    <form:form id="viewquestionbankform" modelAttribute="displayQuestion" method="get">
        <p>${subject}<p>--%>
       <%-- <table style="border: solid black;">
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
                     Correct Ans
                 </th>
                 <th>
                     Weightage
                 </th>
            </tr>--%>
            <%--<tr>
                <td>${displayQuestion.examList.get(0).question}</td>
                <td>${displayQuestion.examList.get(0).answerOptions.get(0)}</td>
                <td>${displayQuestion.examList.get(0).answerOptions.get(1)}</td>
                <td>${displayQuestion.examList.get(0).answerOptions.get(2)}</td>
                <td>${displayQuestion.examList.get(0).answerOptions.get(3)}</td>
                <td>${displayQuestion.examList.get(0).correctAnswer}</td>
                <td>${displayQuestion.examList.get(0).weightage}</td>
            </tr>
            <tr>
                <td>${displayQuestion.examList.get(1).question}</td>
                <td>${displayQuestion.examList.get(1).answerOptions.get(0)}</td>
                <td>${displayQuestion.examList.get(1).answerOptions.get(1)}</td>
                <td>${displayQuestion.examList.get(1).answerOptions.get(2)}</td>
                <td>${displayQuestion.examList.get(1).answerOptions.get(3)}</td>
                <td>${displayQuestion.examList.get(1).correctAnswer}</td>
                <td>${displayQuestion.examList.get(1).weightage}</td>
            </tr>
            <tr>
                <td>${displayQuestion.examList.get(2).question}</td>
                <td>${displayQuestion.examList.get(2).answerOptions.get(0)}</td>
                <td>${displayQuestion.examList.get(2).answerOptions.get(1)}</td>
                <td>${displayQuestion.examList.get(2).answerOptions.get(2)}</td>
                <td>${displayQuestion.examList.get(2).answerOptions.get(3)}</td>
                <td>${displayQuestion.examList.get(2).correctAnswer}</td>
                <td>${displayQuestion.examList.get(2).weightage}</td>
            </tr>
            <tr>
                <td>${displayQuestion.examList.get(3).question}</td>
                <td>${displayQuestion.examList.get(3).answerOptions.get(0)}</td>
                <td>${displayQuestion.examList.get(3).answerOptions.get(1)}</td>
                <td>${displayQuestion.examList.get(3).answerOptions.get(2)}</td>
                <td>${displayQuestion.examList.get(3).answerOptions.get(3)}</td>
                <td>${displayQuestion.examList.get(3).correctAnswer}</td>
                <td>${displayQuestion.examList.get(3).weightage}</td>
            </tr>--%>

      <%--  </table>
    </form:form>--%>
</center>
</body>
</html>
