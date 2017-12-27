<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@include file="navigation.jsp"%>
	<div class="container">
		<sf:form class="form-horizontal" method="POST"
			modelAttribute="userModel">
			<h4>Login</h4>
			<div class="form-group">
				<sf:label path="">Username </sf:label>
				<sf:input path="username" type="text" />
			</div>
			<div class="form-group">
				<sf:label path="password">Password </sf:label>
				<sf:input path="password" type="password" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</sf:form>
	</div>

</body>
</html>