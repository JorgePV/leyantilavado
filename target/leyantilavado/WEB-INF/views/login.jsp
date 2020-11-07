<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="../includes/header.jsp"%>
</head>
<body>
	<div class="container">
		<!-- Default form login -->
		<div class="row">
			<form class="text-center border border-light p-5" action="contenido?action=login" method="post">


				<p class="h4 mb-4">Login</p>

				<!-- Email -->
				<input type="text" id="username" name="username" class="form-control mb-4"
					placeholder="usuario">

				<!-- Password -->
				<input type="password" id="password" name="password" class="form-control mb-4"
					placeholder="Password">


				<!-- Sign in button -->
				<button class="btn btn-info btn-block my-4" type="submit">Entrar</button>


			</form>
		</div>
	</div>
</body>
<%@include file="../includes/footer.jsp"%>
</html>
