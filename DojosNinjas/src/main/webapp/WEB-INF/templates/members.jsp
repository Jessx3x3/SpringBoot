<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Members</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12">
				<p class="h3">Members of Dojos</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12">
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">FirstName</th>
				      <th scope="col">LastName</th>
				      <th scope="col">Age</th>
				      <th scope="col">Dojo's</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${ninjas}" var="ninja">
				    <tr>
				      <td><c:out value="${ninja.firstName}"/></td>
				      <td><c:out value="${ninja.lastName}"/></td>
				      <td><c:out value="${ninja.age}"/></td>
				      <td><c:out value="${ninja.dojo.name}"/></td>
				    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>