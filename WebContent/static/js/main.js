// Iniciando el codigo del main js
$( document ).ready(function() {
	$("#gratuito").click(function(){
		   $("#txtcosto").attr('disabled',!this.checked)
	});
	 $('#modalidadtable').DataTable();
	 //Para todos lo textarea con CKeditor
	 if($('#txthtml').length > 0){
	 CKEDITOR.replace ('txthtml',{
		 toolbar : 'Basic', /* this does the magic */
	        uiColor : '#FFFFFF'
	 });
	 }
});
$(function () {
    $('.datefechahora').datetimepicker({
    	locale: 'es',
    	format: 'YYYY-MM-DD HH:mm'
    });
});

function setCheckbox(value, table_id) {
    checkboxes = $("#"+table_id+" input:checkbox");
    $.each(checkboxes, function(index, checkbox) {
        checkbox.checked = value;
        /*if (value) {
            $(checkbox).parentsUntil("tr").parent().addClass("row_selected");
        } else {
            $(checkbox).parentsUntil("tr").parent().removeClass("row_selected");
        }*/
    });
    return false;
}

