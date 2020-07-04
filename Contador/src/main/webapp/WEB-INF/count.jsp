<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Counter</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script type="text/javascript" src="js/script.js"></script>
	</head>
	<body>
		<div id="content" role="main" class="container-lg" align="center">
			<div class="row">
				<div class="col-lg-12">
					<br><p class="h3">You have visited <span style="color: blue">http://localhost:8080/</span> <c:out value="${contador}"/> times.</p><br>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<br><a href="/" name="action">Test another visit?</a><br>
				</div>
			</div>
		</div>
	</body>
</html>