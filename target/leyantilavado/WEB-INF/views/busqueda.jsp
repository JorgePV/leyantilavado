<%@include file="../includes/header.jsp"%>
<body>
	<div class="container">
		<!-- Default form login -->
		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3>Busqueda Cliente</h3>
				</div>
				<div class="panel-body">
					<form action="contenido?action=mostrar" method="POST">
						<div class="form-row">
							<div class="form-group col-md-17">
								<input class="btn btn-outline-primary" type="submit" value="Buscar"> 
								<input class="btn btn-outline-primary" type="reset" value="Borrar"> 
								<input class="btn btn-outline-primary" type="button" value="Exportar" onclick="fnExcelReport();">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputBusca">Busqueda</label> 
								<input type="text" class="form-control" id="inputBusca" placeholder="">
							</div>
							<div class="form-group col-md-4">
								<label for="inputrfc">RFC</label> <input type="text" class="form-control" id="inputRfc" name="inputRfc" placeholder="">
							</div>
							<div class="form-group col-md-2">
								<label for="inputTipo">Tipo</label> <select id="inputTipo" name="inputTipo" class="form-control">
									<option selected>Selecciona..</option>
									<option value="P">Titular</option>
									<option value="M">Adicional</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputNombre">Nombre</label> <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="">
							</div>
							<div class="form-group col-md-4">
								<label for="inputDoc">Documento</label> <select id="inputDoc" name="inputDoc" class="form-control">
									<option selected>Selecciona..</option>
									<option value="DR" >Por Recuperar</option>
									<option value="DC" >Con Documentacion</option>
									<option value="DS" >Sin Documentacion</option>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="inputVul">Vulnerable</label> <select id="inputVul" name="inputVul" class="form-control">
									<option selected>Selecciona..</option>
									<option value="S1" >Salario 1285</option>
									<option value="S2">Salario 805</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputPeriodo">Periodo</label>
    							<input class="form-control" type="date" name="inputFecha" value="" id="fecha">
								<!--<div class='input-group date' id='datetimepicker11'>
									<input type='text' class="form-control" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>-->
							</div>
							<div class="form-group col-md-4">
								<label for="inputDato">Datos</label> <select id="inputDato" name="inputDato" class="form-control">
									<option selected>Seleciona.</option>
									<option value="INFC" >Completos</option>
									<option value="INFI" >Incompletos</option>
								</select>
							</div>
							<div class="form-group col-md-2"></div>
						</div>
					</form>
					<br></br>
					<table class="table table-bordered" id="tblReporte">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Periodo</th>
								<th scope="col">Cliente</th>
								<th scope="col">Linea</th>
								<th scope="col">Tarjeta</th>
								<th scope="col">Tipo</th>
								<th scope="col">Nombre</th>
								<th scope="col">RFC</th>
								<th scope="col">Monto</th>
								<th scope="col">Completo</th>
								<th scope="col">Adjunto</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="cliente" items="${lista}" >
							<tr>
								<td scope="row">#</td>
								<td>${cliente.periodo}</td>
								<td>${cliente.clienteid}</td>
								<td>${cliente.linea}</td>
								<td>${cliente.tarjeta}</td>
								<td>${cliente.tipocliente}</td>
								<td>${cliente.nombre}</td>
								<td>${cliente.rfc}</td>
								<td>${cliente.montogasto}</td>
								<td>${cliente.estatusid}</td>
								<td>${cliente.tipoidentificacion}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../includes/footer.jsp"%>
<script>
   
</script>
