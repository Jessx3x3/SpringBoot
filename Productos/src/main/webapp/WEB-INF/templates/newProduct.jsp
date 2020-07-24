<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row">
			<div class="col-lg-12 card">
				<p class="h3">New Product</p>
			</div>
		</div>	
		<div class="row">
			<div class="col-lg-12 card">
				<form:form action="/products" method="post" modelAttribute="product">
				    
				    <input type="text" name="name" placeholder="Name of Product">
				    
				    <input type="text" name="description" placeholder="Description of product">
				    
				    <input type="number" name="price" placeholder="Insert Price">   
				    
				    <input type="submit" class="btn btn-primary" value="Submit"/>
				</form:form>  
			</div>
		</div>
	</div>
</body>
</html>