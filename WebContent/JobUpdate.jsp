<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a User</title>
</head>
<body>
	<h1>Update BlogUser</h1>
	<form action="jobupdate" method="post">
		<p>
			<label for="jobid">UserName</label>
			<input id="jobid" name="jobid" value="${fn:escapeXml(param.jobid)}">
		</p>
		<p>
			<label for="jobtitle">New Job Title</label>
			<input id="jobtitle" name="jobtitle" value="">
		</p>
		<p>
			<label for="amount">New Amount</label>
			<input id="amount" name="amount" value="">
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