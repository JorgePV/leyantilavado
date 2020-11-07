$(function () {
	$('#datetimepicker11').datetimepicker({
	daysOfWeekDisabled: [0, 6]
	});
});


function descargarExcel(){
        //Creamos un Elemento Temporal en forma de enlace
        var tmpElemento = document.createElement('a');
        // obtenemos la información desde el div que lo contiene en el html
        // Obtenemos la información de la tabla
        var data_type = 'data:application/vnd.ms-excel';
        var tabla_div = document.getElementById('tblReporte');
        var tabla_html = tabla_div.outerHTML.replace(/ /g, '%20');
        tmpElemento.href = data_type + ', ' + tabla_html;
        //Asignamos el nombre a nuestro EXCEL
        tmpElemento.download = 'Nombre_De_Mi_Excel.xls';
        // Simulamos el click al elemento creado para descargarlo
        tmpElemento.click();
}
