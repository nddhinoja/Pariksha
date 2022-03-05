<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dipalidhinoja
  Date: 1/25/22
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Registration</h1>

    <form:form id="registrationform" action="successfullregistration" modelAttribute="user" method="post">

        <form:radiobutton path="userCategory" name="Cat" value="Student"/>
        <form:label path="userCategory">Student</form:label><br>

        <form:radiobutton path="userCategory" name="Cat" value="Faculty"/>
        <form:label path="userCategory">Faculty</form:label><br><br>

        <form:label path="name">Name:</form:label>
        <form:input path="name" name="name" id="name"/><br><br>

        <form:label path="birthDate">BirthDate:</form:label>
        <form:input path="birthDate" name="birthDate" id="birthDate"/><br><br>

        <form:label path="emailId">EmailId:</form:label>
        <form:input path="emailId" name="emailId" id="emailId"/><br><br>

        <form:label path="userName">userName:</form:label>
        <form:input path="userName" name="userName" id="userName"/><br><br>

        <form:label path="password">Password:</form:label>
        <form:input path="password" name="password" id="password"/><br><br>

        <form:button id="register" name="register" style="font-size:120%" value="Register">Register YourSelf</form:button>

    </form:form>

</center>
</body>
</html>
