<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<p>Access denied!</p>
	<a href="/login">Back</a>
	<br>
	<c:if test="${not empty error}">
		<div style="color: red">Login or password in not correct!</div>
	</c:if>
</body>
</html>