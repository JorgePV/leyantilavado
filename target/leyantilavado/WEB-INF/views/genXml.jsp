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
					<select multiple="multiple" name="prodSKUs">
            <c:forEach items="${lista}" var="reporte">
          <option value="${reporte}"${repote == reporte ? 'selected' : ''}>${reporte.nombre}</option>
         </c:forEach>
        </select>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../includes/footer.jsp"%>