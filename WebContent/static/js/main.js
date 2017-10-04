// Iniciando el codigo del main js
$( document ).ready(function() {
	$("#maxactive").click(function(){
		   $("#maxpersonas").attr('disabled',!this.checked)
	});
	 $('#modalidadtable').DataTable();
});
$(function () {
    $('.datefechahora').datetimepicker();
});

