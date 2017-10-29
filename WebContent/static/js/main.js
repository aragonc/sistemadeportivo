// Iniciando el codigo del main js
$( document ).ready(function() {
	
	$("#gratuito").click(function(){
		$("#txtcosto").attr('disabled',!this.checked)
	});
	
	
	if( $("#plataforma").is(':checked') ) {
		$("#opciones-usuario").show();
	}
	
	$("#plataforma").click(function(){
		$("#opciones-usuario").toggle();
		//$("#opciones-usuario").attr('disabled',!this.checked)
	});
	
	$("#idMixto").click(function(){
		   $(".mixto").show();
	});
	$("#idVarones").click(function(){
		   $(".mixto").hide();
	});
	$("#idMujeres").click(function(){
		   $(".mixto").hide();
	});
	 $('#modalidadtable').DataTable();
	 //Para todos lo textarea con CKeditor
	 if($('#txthtml').length > 0){
	 CKEDITOR.replace ('txthtml',{
		 toolbar : 'Basic', /* this does the magic */
	        uiColor : '#FFFFFF'
	 });
	}
	 //Ajax para cargar modalidades del evento seleccionado
	 if($('#listaevento').length > 0){
		 $('#listaevento').on('change', function(){
		        $.ajax({
		            type: 'GET',
		            url: 'ServletAjax?tipo=listarModalidad',
		            dataType: "JSON",
		            data: 'codevento='+$('#listaevento').val(),
		            statusCode: {
		                404: function() {
		                    console.log('Pagina no encontrada');
		                },
		                500: function(){
		                    console.log('Error del servidor');
		                }
		            },
		            success: function(datos){
		            	$("#listamodalidad").empty(); // limpiamos la lista
		                if(datos == '')
		                	$("#listamodalidad").append($('<option>', { value:"0", text: "-- Seleccione una modalidad --" }));
		                else{
		                	$("#listamodalidad").append($('<option>', { value:"0", text: "-- Seleccione una modalidad --" }));
		                	$.each(datos, function (i, fila){
		                		 $("#listamodalidad").append($('<option>', { value: String(fila.codigo), text: fila.valor }));
		                	});
		                    //console.log("hola");
		                }
		            }
		        }) 
		        
		    }); 
	 }
	 
	 //CARGAR DATOS DE LA RENIEC
	 $("#btn-sincronizar").click(function(e){
			var $this = $(this);
			e.preventDefault();
			$("#progreso").show();
			$.ajax({
				data: { "ndni" : $("#txtnumdocumento").val() },
				type: "POST",
				dataType: "json",
				url: "https://demos.geekdev.ml/reniec/consulta.php",
			}).done(function( data, textStatus, jqXHR ){
				
				if(data['success']!="false" && data['success']!=false)
				{
					console.log("hay respuesta");
					if(typeof(data['result'])!='undefined')
					{
						$("#progreso").hide();
						$("#txtnombre").val(data['result'].Nombre);
						$("#txtapaterno").val(data['result'].Paterno);
						$("#txtamaterno").val(data['result'].Materno);
						/* $.each(data['result'], function(i, v)
						{
							console.log(v);
							//$("#txtnombre").value(v);
						}); */
					}
				}
				else
				{
					if(typeof(data['msg'])!='undefined')
					{
						alert( data['msg'] );
					}
				}
			}).fail(function( jqXHR, textStatus, errorThrown ){
				alert( "Solicitud fallida:" + textStatus );
				$this.button('reset');
				
			});
		});
	 
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

