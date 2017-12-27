<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp" %>
<title>Insert title here</title>
</head>
<body>
	
	<!-- Navigation -->
	<%@ include file="navigation.jsp" %>
	
	
	<div class="container">
	<h4>Admin Page</h4><br>
	
	<p>Add New Product</p>
		<a class="btn btn-primary btn-default" href="addNewProduct">New Product</a>
		
		<br> <br>
		
	<p>List All Products</p>
		<a class="btn btn-primary btn-default" href="listAllProducts">Refresh</a>
	</div>
	
	<div class="container">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Available</th>
				<th>Price</th>
				<th>Brand</th>
				<th>Action</th>
			</tr>
			<c:if test="${not empty allProductsList}">
				<c:forEach items="${allProductsList}" var="product">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.available}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer.name}</td>
						<td>
							<a class="btn btn-primary btn-sm" href="updateProduct/${product.id}">Edit</a>
							<a class="btn btn-danger btn-sm" href="deleteProduct/${product.id }">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>