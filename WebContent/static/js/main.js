// Iniciando el codigo del main js
$( document ).ready(function() {
	$("#gratuito").click(function(){
		   $("#txtcosto").attr('disabled',!this.checked)
	});
	 $('#modalidadtable').DataTable();
});
$(function () {
    $('.datefechahora').datetimepicker({
    	locale: 'es',
    	format: 'YYYY-MM-DD HH:mm'
    });
});

