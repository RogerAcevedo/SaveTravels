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
		<h1>HELLA EXPENSIVE!</h1>
		<hr>
				<table class="table table-danger">
			<thead>
				<tr>
					<th>Id</th>
					<th>Expense Name</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Info</th>
					<th>Created At</th>
					<th>Updated At</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="oneExpense" items="${ allExpenses}">
					<tr>
					
						<td><c:out value="${ oneExpense.id}" /></td>
			
						<td>
							<a href="/expenses/${ oneExpense.id}">
								<c:out value="${ oneExpense.name}" /> 
							</a>
						</td>	
						<td><c:out value="${ oneExpense.vendor}" /></td>
				
						<td><c:out value="${ oneExpense.amount}" /></td>
				
						<td><c:out value="${ oneExpense.info}" /></td>
				
						<td><c:out value="${ oneExpense.createdAt}" /></td>
						
						<td><c:out value="${ oneExpense.updatedAt}" /></td>
						<td>
							<form action="/expenses/${ oneExpense.id }" method="POST"> 
							<input type="hidden" name="_method" value="delete">
							<button class="btn btn-danger">Delete</button>
							</form>
							<a class="btn btn-warning" href="/expenses/${ oneExpense.id}/edit">Edit</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>	
			</table>
	<form:form modelAttribute="expenseObj" method="POST" action="/expenses/new">
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