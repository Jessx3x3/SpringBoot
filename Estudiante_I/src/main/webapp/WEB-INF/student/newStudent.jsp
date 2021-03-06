<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Student</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">Add Student</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form action="/estudiantes" method="post" modelAttribute="estudiante">
					<input type="text" name="firstName" placeholder="First Name">
					<input type="text" name="lastName" placeholder="Last Name">
					<input type="numeric" name="age" placeholder="Age">
				    
				    <input type="submit" class="btn btn-primary" value="Submit"/>
				</form>  
			</div>
		</div>
	</div>
</body>
</html>