<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Employer</title>
</head>
<body>
	<h1>Update BlogUser</h1>
	<form action="employerupdate" method="post">
		<p>
			<label for="employername">EmployerName</label>
			<input id="employername" name="employername" value="${fn:escapeXml(param.employername)}">
		</p>

		<p>
			<label for="NumOfEmployee">New NumOfEmployee</label>
			<input id="NumOfEmployee" name="NumOfEmployee" value="">
		</p>

		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>