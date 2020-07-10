<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninja Gold</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<input type="hidden" value="${gold}" name="user_id" />
		<div id="content" role="main" class="container-lg" align="center">
			<div class="row">
				<div class="col-lg-12 card" align="left">
					<br><p class="h3">Your Gold:</p>
					<p class="card"><c:out value="${gold}"/></p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 card" >
					<br><p>Farm</p>
					<p>(earns 10-20 gold)</p>
					<br>
					<form method="POST" action="gold">
						<input type="hidden" name="aux" value="farm"> 
						<input type="submit" class="btn btn-success" value="Find Gold!" name="farmBtn"><br>
					</form>
				</div>
				<div class="col-lg-3 card" >
					<br><p>Cave</p>
					<p>(earns 5-10 gold)</p>
					<form method="POST" action="gold"><br>
						<input type="hidden" name="aux" value="cave"> 
						<input type="submit" class="btn btn-success" value="Find Gold!" name="caveBtn"><br>
					</form>
				</div>
				<div class="col-lg-3 card" >
					<br><p>House</p>
					<p>(earns 5-2 gold)</p>
					<form method="POST" action="gold"><br>
						<input type="hidden" name="aux" value="house"> 
						<input type="submit" class="btn btn-success" value="Find Gold!" name="houseBtn"><br>
					</form>
				</div>
				<div class="col-lg-3 card" >
					<br><p>Casino!</p>
					<p>(earns 0-50 gold)</p>
					<form method="POST" action="gold"><br>
						<input type="hidden" name="aux" value="casino"> 
						<input type="submit" class="btn btn-success" value="Find Gold!" name="casinoBtn"><br>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 card" align="left">
					<br><p class="h3">Activities:</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<br><p class="h4"><c:out value="${activities}"/></p>
				</div>
			</div>
		</div>
	</body>
</html>