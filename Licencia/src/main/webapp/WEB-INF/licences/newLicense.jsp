<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">New License</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form action="/licenses" method="post" modelAttribute="license">
				    <p><br>
				    	  
			    	  <select th:field="${persona.license}" >
							<option th:value="1" th:text="${persona.firstName}"/>
							<option th:value="2" th:text="Ingles"/>
					  </select>
	
				    </p>
				    <p>
				       <input type="text" name="state" class="form-control" placeholder="State">
				    </p>
				    <p>
				        <input type="date" name="expirationDate" class="form-control">
				    </p> 
				    <input type="submit" class="btn btn-primary" value="Create"/>
				</form>  
				<p><c:out value="${license.number}"/></p>
			</div>
		</div>
	</div>
</body>
</html>