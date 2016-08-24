<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Voluntary Services</h1>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in to access services</h3>
					</div>
					<div class="panel-body">
						<c:if test="${error eq true}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								<br />
							</div>
						</c:if>

						<form action="<c:url value='/login' />" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form:input-large" name='username'
										value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME }"/></c:if>'/>
								</div>
								<div class="form-group">
									<input class=" form:input-large" name='password'
										type="password" value="">
								</div>
								<input class="btn btn-lg btn-success btn-mini" type="submit"
									value="Login">

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>