<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Information</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<div id="content" role="main" class="container-lg card" align="center">
			<div class="row">
				<div class="col-lg-12 ">
					<div class="col-auto my-1">
					     <br><p class="h4"><strike>Submitted Info</strike></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p>Name: </p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p><c:out value="${name}"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p>Dojo Location: </p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p><c:out value="${location}"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p>Favorite Language: </p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p><c:out value="${language}"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p>Comment: </p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-auto my-1">
					     <br><p><c:out value="${comment}"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form action="back">
						<br><button type="submit" class="btn btn-success">Go back</button><br><br>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>