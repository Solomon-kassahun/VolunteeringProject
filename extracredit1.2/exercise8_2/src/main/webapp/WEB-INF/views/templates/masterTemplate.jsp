<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voluntary Serivce</title>
<link href="<c:url value='/resources/css/styles.css' /> " rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="header">
		<jsp:include page="header.jsp" />
	</div>
	<div class="header">
		<jsp:include page="sidebar.jsp" />
	</div>
	<div class="content">
		<jsp:include page="${pageToRender}" />
	</div>


	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>