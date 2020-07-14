<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Language</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">All Language</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Creator</th>
				      <th scope="col">Version</th>
				      <th scope="col">Delete</th>
				      <th scope="col">Modify</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${lenguajes}" var="lenguaje">
				    <tr>
				      <th scope="row"><a href="lenguajes/show/${lenguaje.id}"><c:out value="${lenguaje.name}"/></a></th>
				      <td scope="row"><c:out value="${lenguaje.creator}"/></td>
				      <td scope="row"><c:out value="${lenguaje.version}"/></td>
				      <td>
				      	  <form action="/lenguajes/${lenguaje.id}/delete" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn btn-danger" type="submit" value="Delete">
					  	  </form>
					  </td>
				      <td><a href="/lenguajes/${lenguaje.id}/edit" class="btn btn-success">Edit</a></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
		
		

		<div class="row">
			<div class="col-lg-6 card">
				<form action="/lenguajes" method="post" modelAttribute="lenguaje"><br>
					<div class="row">
					    <div class="col">
					      <input type="text"  name="name" class="form-control" placeholder="Name">
					    </div>
					    <div class="col">
					      <input type="text" name="creator" class="form-control" placeholder="Creator">
					    </div>
					    <div class="col">
					      <input type="text" name="version" class="form-control" placeholder="Version"><br>
					    </div>
					 </div>
					 <br><input class="btn btn-primary" type="submit" value="Submit"/><br>
				</form><br>
			</div>
		</div>
		
		
	</div>
</body>
</html>