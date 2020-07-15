<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Song</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">New Song</p>
				<a href="/songs">Dashboard!</a>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form:form action="/songs" method="post" modelAttribute="song">
				    <p>
				        <form:label path="title">Title</form:label>
				        <form:errors path="title"/>
				        <form:input path="title"/>
				    </p>
				    <p>
				        <form:label path="artist">Artist</form:label>
				        <form:errors path="artist"/>
				        <form:input path="artist"/>
				    </p>
				    <p>
				        <form:label path="rating">Rating</form:label>
				        <form:errors path="rating"/>
				        <form:input path="rating" maxlength="2"/>
				    </p> 
				    <input type="submit" value="Submit"/>
				</form:form>  
			</div>
		</div>
	</div>
</body>
</html>