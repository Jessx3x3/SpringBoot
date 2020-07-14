
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">Edit Language</p>
				<a href="/lenguajes">Go Back!</a>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form action="/lenguajes/${lenguaje.id}" method="post" modelAttribute="lenguaje">
				    	<div class="row">
						    <div class="col">
						      <input type="text"  name="name" class="form-control"><c:out value="${lenguaje.name}"/>
						    </div><br>
						    <div class="col">
						      <input type="text" name="creator" class="form-control"><c:out value="${lenguaje.creator}"/>
						    </div><br>
						    <div class="col">
						      <input type="text" name="version" class="form-control"><c:out value="${lenguaje.version}"/><br>
						    </div><br>
					 	</div>
				    <input class="btn btn-success" type="submit" value="Submit"/><br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
