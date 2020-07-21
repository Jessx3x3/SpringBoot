<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Contact</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">Add Contact</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form action="/contactos" method="post" modelAttribute="contacto">
				
					<input type="text" name="adress" placeholder="Adress">
					<input type="text" name="city" placeholder="City">
					<input type="text" name="state" placeholder="State">
					
					<select name="estudiante">
						<c:forEach items="${contactos}" var="contacto">
							<option value="<c:out value="${contacto.estudiante.id}"/>"><c:out value="${contacto.estudiante.firstName}"/></option>
						</c:forEach>
					</select>
				    
				    <input type="submit" class="btn btn-primary" value="Submit"/>
				</form>  
			</div>
		</div>
	</div>
</body>
</html>