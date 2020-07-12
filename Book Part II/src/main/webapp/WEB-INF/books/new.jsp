<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Book</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">New Book</p>
				<a href="/books">Go Back!</a>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form:form action="/books" method="post" modelAttribute="book">
				    <p>
				        <form:label path="title">Title</form:label>
				        <form:errors path="title"/>
				        <form:input path="title"/>
				    </p>
				    <p>
				        <form:label path="description">Description</form:label>
				        <form:errors path="description"/>
				        <form:textarea path="description"/>
				    </p>
				    <p>
				        <form:label path="language">Language</form:label>
				        <form:errors path="language"/>
				        <form:input path="language"/>
				    </p>
				    <p>
				        <form:label path="numberOfPages">Pages</form:label>
				        <form:errors path="numberOfPages"/>     
				        <form:input type="number" path="numberOfPages"/>
				    </p>    
				    <input type="submit" value="Submit"/>
				</form:form>  
			</div>
		</div>
	</div>
</body>
</html>