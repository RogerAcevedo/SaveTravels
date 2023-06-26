<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>JUAN EXPENSE!</h1>
		<hr>
		<h2>
			Expense Name:
			<c:out value="${expense.name}"></c:out>
		</h2>
		<h2>
			Vendor:
			<c:out value="${expense.vendor}"></c:out>
		</h2>
		<h2>
			Amount:
			<c:out value="${expense.amount}"></c:out>
		</h2>
		<h2>
			Info:
			<c:out value="${expense.info}"></c:out>
		</h2>
		
	</div>
</body>
</html>