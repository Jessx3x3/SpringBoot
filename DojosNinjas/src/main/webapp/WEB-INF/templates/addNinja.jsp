<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Ninja</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">Add Ninja</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form action="/ninjas" method="post" modelAttribute="ninja">
				
					<input type="numeric" name="dojo" placeholder="dojo's ID">
					<input type="text" name="firstName" placeholder="Ninja's Name">
					<input type="text" name="lastName" placeholder="Ninja's LastName">
					<input type="text" name="age" placeholder="Ninja's Age">
				    
				    <input type="submit" class="btn btn-primary" value="Add"/>
				</form>  
			</div>
		</div>
	</div>
</body>
</html>