<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Add new product</title>
<style type="text/css">

.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="info_panel.jsp" />
	<br>
	<a href="<c:url value='/products' />">List of Products</a>
	<br>


	<h1>Add Product</h1>

	<c:url var="save" value="/product/save"></c:url>



	<form:form action="${save}" commandName="product">
		<table>
			<c:if test="${!empty product.id}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /> <form:errors path="name"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category">
						<c:if test="${!empty product.id}">
							<form:option value="${product.category.id}"
								label="${product.category.name}" />
						</c:if>
					<<c:if test="${empty product.id}">
							<form:option value="" label="--- Select ---" />
						</c:if>
						<form:options items="${categories}" />
					</form:select> <form:errors path="category" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<spring:message text="Description" />
					</form:label></td>
				<td><form:input path="description" /></td>
			</tr>


			<tr>
				<td><form:label path="avaliable">
						<spring:message text="Avaliable" />
					</form:label></td>
				<td><form:select path="avaliable">
						<form:option value="1" selected="selected">Yes</form:option>
						<form:option value="2">No</form:option>
					</form:select></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Save"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
