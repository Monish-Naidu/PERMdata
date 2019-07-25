<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Soc System</title>
</head>
<body>
	<h1>Create Soc System</h1>
	<form action="socsystemcreate" method="post">
		<p>
			<label for="prevailingwagesoccode">SOC Code</label>
			<input id="prevailingwagesoccode" name="prevailingwagesoccode" value="">
		</p>
		<p>
			<label for="prevailingwagesoctitle">SOC Title</label>
			<input id="prevailingwagesoctitle" name="prevailingwagesoctitle" value="">
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