<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Products</title>

</head>
<body>

	<jsp:include page="info_panel.jsp" />

	<security:authorize access="hasRole('ROLE_ADMIN')">
		<a href="<c:url value='/create' />">Add new Product</a>
		<br />
	</security:authorize>
	<a href="<c:url value='/products' />">Show All Products</a>
	<br>
	<h3>Products</h3>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Name</th>

				<th width="120">Price</th>
				<th width="120">Description</th>
				<th width="120">Avaliable</th>
				<th width="120">Category</th>
				<th width="120">Path Category</th>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</security:authorize>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<td>${product.avaliable}</td>
					<td>${product.category.name}</td>

					<td>
						<table>
							<tr>
								<c:forEach items="${product.path}" var="category">
									<td>									
									<a href="<c:url value='/products/${category.id}' />">${category.name}</a>
									</td>
								</c:forEach>
							</tr>
						</table>
					</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<td><a href="<c:url value='/edit/${product.id}' />">Edit</a></td>
						<td><a href="<c:url value='/delete/${product.id}' />">Delete</a></td>
					</security:authorize>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
