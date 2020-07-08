<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HomePage</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<div id="content" role="main" class="container-lg" align="center">
			<div class="row">
				<div class="col-lg-12">
					<br><p class="h3">Inscription</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 card">
					<form action="/index" method="POST" modelAttribute="information" >
					  <div class="form-group">    
					  	  <div class="col-auto my-1">
					      	  <br><input type="text" class="form-control" placeholder="Your Name" name="name" required>
					      </div>
					  </div>
					  <div class="form-group">
						  <div class="col-auto my-1">
						      <br><input type="text" class="form-control" placeholder="Your Location" name="location" required>
						   </div>
					  </div>
					  <div class="form-group">
						  <div class="col-auto my-1">
						      <br><input type="text" class="form-control" placeholder="Your Favorite Language" name="language" required><br>
						   </div>
					  </div>
					  <div class="form-group">
						  <div class="mb-3">
						    <textarea class="form-control" name="comment" placeholder="Comment (optional)" ></textarea>
						  </div>
					  </div>
					  <button type="submit" class="btn btn-success">Confirm</button><br>
					</form>
					
				</div>
			</div>
		</div>
	</body>
</html>