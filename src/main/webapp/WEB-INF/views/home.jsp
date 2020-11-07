<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pag Principal</title>
<%@include file="../includes/header.jsp"%>
<%
if(session.getAttribute("name") ==null) {
    //El usuario no esta logeado, haces lo que corresponda...
	response.sendRedirect("/leyantilavado");
}
%>
</head>
<body>
	<div class="container">
		<!-- Default form login -->
		<div class="row">
			<div class="col-lg-2">
				<h1 align="center">Principal</h1>
			</div>
		</div>
		<!-- Default form login -->
	</div>
</body>
<%@include file="../includes/footer.jsp"%>
</html>