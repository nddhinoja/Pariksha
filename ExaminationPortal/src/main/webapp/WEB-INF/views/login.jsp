<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<jsp:useBean id="message" scope="request" type=""/>--%>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/24/22
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function showHideDiv(ele) {
            var srcElement = document.getElementById(ele);
            if (srcElement != null) {
                if (srcElement.style.display == "block") {
                    srcElement.style.display = 'none';
                }
                else {
                    srcElement.style.display = 'block';
                }
                return false;
            }
        }
    </script>
</head>
<body>
<a href="index.jsp" style="margin-left: 20%;font-size: 140%">Home</a>

<center>
<form:form id="loginForm" modelAttribute="login" action="loginprocess" method="post">
    <table align="center" style="margin-top: 5%">

        <tr>
            <td>
                <form:label path="userName">Username:</form:label>

                <form:input path="userName" name="userName" id="userName" /><br><br>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="password">Password:</form:label>

                <form:password path="password" name="password" id="password" /><br><br>
            </td>
        </tr>
        <tr>
            <td>
                <form:button id="login" style="font-size:140%;margin-left:30%" name="login" value="Login">Login</form:button>
            </td>
        </tr>
    </table>
        </form:form>
 <%--       <form id="loginForm" action="loginprocess" method="post">
            <table align="center" style="margin-top: 5%">

                <tr>
                    <td>
                        <label for="userName">Username:</label>

                        <input type="text" name="userName" id="userName" /><br><br>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label for="password">Password:</label>

                        <input type="password" name="password" id="password" /><br><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" id="login" style="font-size:140%;margin-left:30%" name="login" value="Login">Login</input>
                    </td>
                </tr>
            </table>
        </form>--%>
</center>

<table align="center">
        <tr>
            <td>
                <input type="button" value="Forgot Password??" style="font-size:100%;margin-top:20%" onClick="showHideDiv('divMsg')"/><br><br>
                <div id="divMsg" style="height: 200px; width: 200px; text-align: center; display:none">
                    <form:form id="forgotPasswordForm" action="emailverifying" method="post">
                        <label for="emailId">Email Id:</label>
                        <input type="text" name="emailId" id="emailId">
                        <input type="submit" name="send" value="Send">
                    </form:form>
                </div>
            </td>
        </tr>
</table>

<table align="center">
    <tr>
        <td style="font-style: italic; color: red;">${message}</td>
    </tr>
</table>

<form id="registrationForm" action="registration" method="get">
    <table align="center">
    <tr>
        <td>
            <label path="newUser">New User??</label><br><br>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" style="font-size:140%;" name="register" value="Register Yourself"/>
        </td>
    </tr>
    </table>
</form>




</body>
</html>
