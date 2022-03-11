<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/31/22
  Time: 7:54 PM
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

    <form action="result" method="post">
        <table>

                <%--<td>
                    <script>
                        var timeleft = 10;
                        var downloadTimer = setInterval(function(){
                            if(timeleft <= 0){
                                clearInterval(downloadTimer);
                                document.getElementById("countdown").innerHTML = "Finished";
                                window.setTimeout(function (){
                                    alert('it is already 10 sec');
                                },1)
                                window.location="login";
                            } else {
                                document.getElementById("countdown").innerHTML = timeleft + " seconds remaining";
                            }
                            timeleft -= 1;
                        }, 1000);
                    </script>
                    <div id="countdown"></div>

                </td>--%>
            <th>
            <td>
               <%-- <p>${exam.subject}<p><br><br>--%>
               <%-- <%=session.getAttribute("abc")%>--%>
            </td>
            </th>
            <tr>
                <td>
                    <label>::Question Sheet:: <%=session.getAttribute("subject")%></label>
                </td>
            </tr>
            <c:forEach items="${question}" var="question" varStatus="i">

                <tr>
                    <td>
                            Question : ${i.count}<br>
                            ${question.questionContent}
                    </td>
                </tr>
                <tr>
                    <td>
                    <input type="hidden" name="questionId" value="${question.questionId}">
                        <c:forEach var="option" items="${question.optionList}">
                            <input type="radio" name="${question.questionId}" value="${option.optionId}"/>
                            <label>${option.optionContent}</label><br><br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
               <tr>
                   <td>
                       <button id="submit" type="submit" name="submit" value="submit">Submit</button>
                   </td>
               </tr>
        </table>
    </form>

<%--<from:form id="examform" modelAttribute="questionsAnswer" action="examinitial" method="post">
    <table>
        <tr>
            <td>
                <form:button id="submit" name="submit" value="submit" style="font-size:140%" formaction="result">Submit</form:button>
            </td>
            <td>

                &lt;%&ndash;<div id="time" style="border: 3px solid blue; text-align: center;font-size: 2em; margin-bottom: 10px">10:00</div>
                <script>

                    window.addEventListener("load", function() {
                        const clock = document.getElementById("time");
                        let time = -1, intervalId;
                        function incrementTime() {
                            time++;
                            clock.textContent =
                                ("0" + Math.trunc(time / 60)).slice(-2) +
                                ":" + ("0" + (time % 60)).slice(-2);
                        }
                        incrementTime();
                        window.setTimeout(function (){
                            alert('its already 10 min');
                        }, 10000)
                        intervalId = setInterval(incrementTime, 1000);
                    });

                </script>
&ndash;%&gt;
                <script>
                    var timeleft = 10;
                    var downloadTimer = setInterval(function(){
                        if(timeleft <= 0){
                            clearInterval(downloadTimer);
                            document.getElementById("countdown").innerHTML = "Finished";
                            window.setTimeout(function (){
                                alert('it is already 10 sec');
                            },1)
                            window.location="login";
                        } else {
                            document.getElementById("countdown").innerHTML = timeleft + " seconds remaining";
                        }
                        timeleft -= 1;
                    }, 1000);
                </script>
                <div id="countdown"></div>

            </td>
        </tr>--%>
        <%--<th>
            <td>
            <p>${exam.subject}<p><br><br>
            </td>
        </th>
        <tr>
            <td>
                <label for="examform">Question:  </label>

                ${questionsAnswer.examList.get(0).question}<br><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <input type="radio" name="optionA" value="${questionsAnswer.examList.get(0).answerOptions.get(0)}"/>
                <label for="examform">${questionsAnswer.examList.get(0).answerOptions.get(0)}</label><br>
                <input type="radio" name="optionB" value="${questionsAnswer.examList.get(0).answerOptions.get(1)}"/>
                <label for="examform">${questionsAnswer.examList.get(0).answerOptions.get(1)}</label><br>
                <input type="radio" name="optionC" value="${questionsAnswer.examList.get(0).answerOptions.get(2)}"/>
                <label for="examform">${questionsAnswer.examList.get(0).answerOptions.get(2)}</label><br>
                <input type="radio" name="optionD" value="${questionsAnswer.examList.get(0).answerOptions.get(3)}"/>
                <label for="examform">${questionsAnswer.examList.get(0).answerOptions.get(3)}</label><br>
            </td>
        </tr>--%>
    <%--<table>
        <tr>
            <td>
                <form:button id="next" name="next" value="Next" style="font-size:140%; margin-top:140%" formaction="examinitial">Next</form:button>
                <form:button id="previous" name="previous" value="Previous" style="font-size:140%; margin-top:140%" formaction="examinitial">Previous</form:button>
            </td>
        </tr>
    </table>--%>
<%--</from:form>--%>

<%--<form id="examform" action="/examinitial" method="post">
    <c:forEach items="${listOfExam}" var="question" varStatus="loopCounter">
        <c:if test="${question.isCurrentQuestion == true}">
            &lt;%&ndash;<input type="text" name="quesSet" value="${question.question}">&ndash;%&gt;
            <textarea rows="3" cols="5" readonly="readonly">${question.question}</textarea>

            <c:forEach items="${question.answerOptions}" var="answer">
                &lt;%&ndash;<c:if test="${answer.questions.quesId == question.quesId}">&ndash;%&gt;
                    <input type="radio" name="response" value="${question.answerOptions.get(0)}">
                    <label for="examform">${question.answerOptions.get(0)}</label>
                    <input type="radio" name="response" value="${question.answerOptions.get(1)}">
                    <label for="examform">${question.answerOptions.get(1)}</label>
                    <input type="radio" name="response" value="${question.answerOptions.get(2)}">
                    <label for="examform">${question.answerOptions.get(2)}</label>
                    <input type="radio" name="response" value="${question.answerOptions.get(3)}">
                    <label for="examform">${question.answerOptions.get(3)}</label>
                &lt;%&ndash;</c:if>&ndash;%&gt;
            </c:forEach>
        </c:if>
    </c:forEach>
    <button type="submit" >Next</button>
</form>--%>
    <%--<script>
        timer();
        //-->
    </script>--%>
</center>
</body>
</html>