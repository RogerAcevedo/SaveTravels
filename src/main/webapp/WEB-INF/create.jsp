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
		<h1>CREATE A USER: (data binding)</h1>
		<form:form modelAttribute="expenseObj" method="POST" action="/expenses/new/dataBinding">
			<p>
				Expense Name:
				<!-- PATH MUST MATCH THE NAME IN OUR MODEL -->
				<form:input type="text" path="name"/>
				<!-- DISPLAYS VALIDATIONS -->
				<form:errors path="name" />
			</p>
			<p>
				Vendor:
				<!-- PATH MUST MATCH THE NAME IN OUR MODEL -->
				<form:input type="text" path="vendor"/>
				<!-- DISPLAYS VALIDATIONS -->
				<form:errors path="vendor" />
			</p>
			<p>
				Amount:
				<!-- PATH MUST MATCH THE NAME IN OUR MODEL -->
				<form:input type="number" path="amount"/>
				<!-- DISPLAYS VALIDATIONS -->
				<form:errors path="amount" />
			</p>
			<p>
				Info:
				<!-- PATH MUST MATCH THE NAME IN OUR MODEL -->
				<form:input type="text" path="info"/>
				<!-- DISPLAYS VALIDATIONS -->
				<form:errors path="info" />
			</p>
			<button>Submit</button>
		</form:form>
	</div>
</body>
</html>