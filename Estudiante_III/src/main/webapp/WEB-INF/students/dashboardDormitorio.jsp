<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dormitorio</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">Dormitorios <c:out value="${newDormitorio.name}"/></p>
				
				<form action="/student/dormitorio" method="post" modelAttribute="estudiante">
					<select name="estudiante">
						<c:forEach items="${est}" var="estudiante">
						<option value=<c:out value="${estudiante.id}"/>><c:out value="${estudiante.firstName}"/></option>
						</c:forEach>
					</select>
					<input type="submit" class="btn btn-primary" value="Add"/>
				</form>
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">Name</th>
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:forEach items="${list}" var="estudiante">
						    <tr>
						      <td><c:out value="${estudiante.firstName}"/></td>
						      <td><p>Option</p></td>
						    </tr>
					    </c:forEach>
					  </tbody>
				</table>
			</div>
		</div>	
	</div>
</body>
</html>