<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
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
			<div class="col-lg-12 card">
				<p class="h3">The Song</p>
				<a href="/songs">Dashboard!</a><br>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<h1><c:out value="${song.title}"/></h1>
				<p>Title: <c:out value="${song.title}"/></p>
				<p>Artist: <c:out value="${song.artist}"/></p>
				<p>Rating: <c:out value="${song.rating}"/></p>
				
				<form action="/songs/${song.id}/delete" method="post">
				    <input type="hidden" name="aux" value="delete">
				    <input type="submit" class="btn btn-primary" value="Delete">
				</form>				
			</div>
		</div>
	</div>
</body>
</html>