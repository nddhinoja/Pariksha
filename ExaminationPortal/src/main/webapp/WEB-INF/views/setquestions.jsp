<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/28/22
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Set Questions</title>
</head>
<body>
<center>
    <h1>Set Questions</h1>
    <jsp:include page="headerInfo.jsp"/><br>
    <jsp:include page="home.jsp"/><br>
<form action="savequestion" method="post">
    <table>
        <tr>
        <th>
            <%=session.getAttribute("subject")%><br>
            ${message}<br>
        </th>
        </tr>
        <tr>
            <td>
                <label>Question : </label>
                <input type="text" id="${question.questionContent}" name="questionContent"/><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" id="${question.optionList.get(0).optionContent}" name="optionA"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" id="${question.optionList.get(1).optionContent}" name="optionB"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" id="${question.optionList.get(2).optionContent}" name="optionC"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" id="${question.optionList.get(3).optionContent}" name="optionD"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="correctAnswer">Correct Answer:</label>
                <select name="correctanswer" id="optionId">
                    <option name="correctanswer" value="A">A</option>
                    <option name="correctanswer" value="B">B</option>
                    <option name="correctanswer" value="C">C</option>
                    <option name="correctanswer" value="D">D</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label path="weightage">Weightage:</label>
                <select name="weightage">
                    <option name="weightage" value="0.5" label="0.5">0.5</option>
                    <option name="weightage" value="1.0" label="1.0">1.0</option>
                    <option name="weightage" value="1.5" label="1.5">1.5</option>
                    <option name="weightage"value="2.0" label="2.0">2.0</option>
                    <option name="weightage" value="2.5" label="2.5">2.5</option>
                    <option name="weightage" value="3.0" label="3.0">3.0</option>
                    <option name="weightage" value="3.5" label="3.5">3.5</option>
                </select><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="save" style="font-size:120%" value="Save">Save</button>
            </td>
        </tr>

    </table>
</form>


</center>
</body>
</html>
