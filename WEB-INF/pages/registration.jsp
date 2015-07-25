<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Login page</title>

    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label {width:70px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>

</head>
<body>
<h1>Login page</h1>

<div class="container">
<form:form action="user" modelAttribute="userDto" method="post">
    <label for="loginInput">Login: </label>
    <input name="login" id="loginInput"/>
    <form:errors path="login" cssClass="error"/>
    <br/>

    <label for="passwordInput">Password: </label>
    <input name="password" id="passwordInput"/>
    <form:errors path="password" cssClass="error"/>
    <br/>

    <label for="firstNameInput">First Name: </label>
    <input name="firstName" id="firstNameInput"/>
    <form:errors path="firstName" cssClass="error"/>
    <br/>

    <label for="lastNameInput">Last Name: </label>
    <input name="lastName" id="lastNameInput"/>
    <form:errors path="lastName" cssClass="error"/>
    <br/>

    <label for="emailInput">Email: </label>
    <input name="email" id="emailInput"/>
    <form:errors path="email" cssClass="error"/>
    <br/>

    <label for="phoneInput">Phone: </label>
    <input name="phone" id="phoneInput"/>
    <form:errors path="phone" cssClass="error"/>
    <br/>

    <label for="cityInput">City: </label>
    <input name="city" id="cityInput"/>
    <form:errors path="city" cssClass="error"/>
    <br/>

    <label for="descriptionInput">Description: </label>
    <input name="description" id="descriptionInput"/>
    <form:errors path="description" cssClass="error"/>
    <br/>

    <label for="dateOfBirthInput">Birthday: </label>
    <input name="dateOfBirth" id="dateOfBirthInput" placeholder="MM/DD/YYYY"/>
    <form:errors path="dateOfBirth" cssClass="error"/>
    <br/>

    <select name="select" id="s" multiple>
        <c:if test="${not empty allSports}">

            <c:forEach var="sport" items="${allSports}">

                <option value="${sport.name}">"${sport.name}"</option>
            </c:forEach>

        </c:if>
    </select>
    <br/>
    <input type="submit" value="Submit"/>
</form:form>
</div>

</body>
</html>