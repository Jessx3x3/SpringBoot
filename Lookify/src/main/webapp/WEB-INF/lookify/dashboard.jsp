<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<header class="header">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="col-lg-4"><a href="songs/new">Add New Song</a></div>
				<div class="col-lg-4"><a href="search/topten">Top Ten Song</a></div>
				<div class="col-lg-4">
					<form action="/search" method="get" class="form-inline">
					    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchArtist" >
					    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search Artist</button>
					 </form>
				</div>
			</nav>
		</header>
		<div class="row">
			<div class="col-lg-12">
				
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12">
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Title</th>
				      <th scope="col">Rating</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${songs}" var="song">
				    <tr>
				      <td><a href="songs/${song.id}"><c:out value="${song.title}"/></a></td>
				      <td><c:out value="${song.rating}"/></td>
				      <td>
					      	<form action="/songs/${song.id}/delete" method="post">
							    <input type="hidden" name="aux" value="delete">
							    <input type="submit" class="btn btn-primary" value="Delete">
							</form>
				      </td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>