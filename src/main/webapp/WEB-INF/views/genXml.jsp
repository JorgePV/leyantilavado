<%@include file="../includes/header.jsp"%>
<body>
	<div class="container">
		<!-- Default form login -->
		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3>Generar xml</h3>
				</div>
				<div class="panel-body">
					<form action="contenido?action=reporte" method="POST">
						<select name="tipoReporte">
							<option value="0">Seleccionar</option>
							<c:forEach var="repo" items="${reporte}">
								<option value="${repo.reporteid}">${repo.nombre}</option>
							</c:forEach>
						</select>
						<input class="btn btn-outline-primary" type="submit" value="Generar"> 
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../includes/footer.jsp"%>