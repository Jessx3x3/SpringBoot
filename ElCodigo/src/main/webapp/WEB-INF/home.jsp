<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Secret Code</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		
		<div id="content" role="main" class="container-lg" align="center">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${pass != null}">
			   			<br><p class="h3" style="color:red;"><c:out value="${msg}"/></p><br>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<br><p class="h3">What is the code?</p><br>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form action="/index" method="POST" modelAttribute="user">
						<br><input type="text" name="pass" required><br>
						<br><input type="submit" class="btn btn-primary" value="Try Code">
						<br><p><c:out value="${pass}"/></p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>