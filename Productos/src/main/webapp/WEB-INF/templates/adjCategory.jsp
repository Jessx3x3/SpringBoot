<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TEST</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div id="content" role="main" class="container-lg" align="center">
		<div class="row"><div class="col-lg-12"></div><br><br><br><br></div>
		<div class="row">
			<div class="col-lg-4">
				<p class="h1" align="left"><c:out value="${category.name}"/></p><br>
				<p class="h3">Products</p>	
				<ul>
					<c:forEach items="${itemProducts}" var="product">
					<li><c:out value="${product.name}"/></li>
					</c:forEach>	
				</ul>	
			</div>
			<div class="col-lg-6"><br><br><br>
				<form action="/create/${product.id}" method="post" modelAttribute="product">
					<select name="/product">
						<c:forEach items="${itemProducts}" var="product">
						    <option value=<c:out value="${product.id}"/>><c:out value="${product.name}"/></option>
					    </c:forEach><br><br>
					    <input type="submit" class="btn btn-primary" value="Add"/>
					</select>
				</form>
			</div>
		</div>	
	</div>
</body>
</html>