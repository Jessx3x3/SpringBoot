<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Song</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12"><br>
				<p class="h2">The Top Ten</p>
				<a href="/songs">Dashboard!</a><br>
			</div>
		</div>		
		<div class="row">
			<div class="col-lg-12 card">
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Rating</th>
				      <th scope="col">Title</th>
				      <th scope="col">Artist</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${songs}" var="song">
				    <tr>
				      <td><c:out value="${song.rating}"/></td>
				 	  <td><a href="songs/${song.id}"><c:out value="${song.title}"/></a></td>
				 	  <td><c:out value="${song.artist}"/></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>		
			</div>
		</div>
	</div>
</body>
</html>