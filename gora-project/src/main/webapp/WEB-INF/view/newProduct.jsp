<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<!-- Navigation -->
	<%@ include file="navigation.jsp"%>


	<div class="container">

		<h4>New Product</h4>
		<sf:form class="form-horizontal" method="POST" action="saveProduct"
			modelAttribute="product">

			<sf:input path="id" hidden="true" />

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Product</label>
				<div class="col-sm-10">
					<sf:input type="text" class="form-control" placeholder="Product"
						path="name" />
					<sf:errors path="name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<label for="manufacturer">Manufacturer</label>
					<sf:select path="manufacturer.id" >
						<c:forEach items="${manufacturerList}" var="manufacturer">
							<sf:option value="${manufacturer.id}">
								${manufacturer.name}
							</sf:option>
						</c:forEach>
					</sf:select>
				</div> 
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<sf:textarea class="form-control" placeholder="Description"
						path="description" rows="5" />
					<sf:errors path="description" />
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<sf:input type="text" class="form-control" placeholder="Price"
						path="price" />
					<sf:errors path="price" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label for="available" class="col-sm-2 control-label">Available</label>
						<sf:checkbox path="available" value="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
		</sf:form>

	</div>
</body>
</html>