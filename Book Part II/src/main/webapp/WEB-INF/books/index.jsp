<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Books</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">All Books</p>
				<a href="/books/new">New Book</a>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Title</th>
				      <th scope="col">Description</th>
				      <th scope="col">Language</th>
				      <th scope="col">N°Pages</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${books}" var="book">
				    <tr>
				      <th scope="row"><c:out value="${book.title}"/></th>
				      <td scope="row"><c:out value="${book.description}"/></td>
				      <td scope="row"><c:out value="${book.language}"/></td>
				      <td scope="row"><c:out value="${book.numberOfPages}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>