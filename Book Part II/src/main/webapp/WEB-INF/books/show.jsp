<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>A Book</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">The Book</p>
				<a href="/books">Go Back!</a>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<h1><c:out value="${book.title}"/></h1>
				<p>Description: <c:out value="${book.description}"/></p>
				<p>Language: <c:out value="${book.language}"/></p>
				<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
				<a href="/books/${book.id}/edit">Edit Book</a>
				<form action="/books/${book.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
			</div>
		</div>
	</div>
</body>
</html>