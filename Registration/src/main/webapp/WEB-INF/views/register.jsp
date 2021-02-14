<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.html" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
.error{
	color: #FF0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<f:form modelAttribute="userObj" action="process" method="POST">
	<table>
	<tr>
		<td>First Name: </td>
		<td><f:input path="firstName"/></td>
		<td><f:errors path="firstName" cssClass="error"/></td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><f:input path="lastName"/></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><f:password path="password"/></td>
		<td><f:errors path="password" cssClass="error"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Register"/></td>
		<td><input type="reset" value="Reset"/></td>
	</tr>
	</table>
</f:form>
</body>
</html>