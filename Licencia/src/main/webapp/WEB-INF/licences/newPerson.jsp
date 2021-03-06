<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New person</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">New person</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form:form action="/persons" method="post" modelAttribute="person">
				    <p>
				        <form:label path="firstName">First Name: </form:label>
				        <form:errors path="firstName"/>
				        <form:input path="firstName"/>
				    </p>
				    <p>
				        <form:label path="lastName">Last Name:</form:label>
				        <form:errors path="lastName"/>
				        <form:input path="lastName"/>
				    </p>   
				    <input type="submit" class="btn btn-primary" value="Submit"/>
				</form:form>  
			</div>
		</div>
	</div>
</body>
</html>