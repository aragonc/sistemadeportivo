// Iniciando el codigo del main js
$( document ).ready(function() {
	$("#gratuito").click(function(){
		   $("#txtcosto").attr('disabled',!this.checked)
	});
	 $('#modalidadtable').DataTable();
	 //Para todos lo textarea con CKeditor
	 CKEDITOR.replace ('txthtml',{
		 toolbar : 'Basic', /* this does the magic */
	        uiColor : '#FFFFFF'
	 });
});
$(function () {
    $('.datefechahora').datetimepicker({
    	locale: 'es',
    	format: 'YYYY-MM-DD HH:mm'
    });
});


