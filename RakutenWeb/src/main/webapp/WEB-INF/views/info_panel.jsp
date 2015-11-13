<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

	<security:authorize access="isAuthenticated()">
		<p>
			Hello : ${pageContext.request.userPrincipal.name} | <a
				href="<c:url value="/j_spring_security_logout" />">logout</a>
		</p>
	</security:authorize>

</body>
</html>