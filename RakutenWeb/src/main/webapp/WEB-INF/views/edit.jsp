<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Add new product</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

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
						<form:options items="${categorys}" />
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
