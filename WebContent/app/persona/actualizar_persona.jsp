
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="service.ComboService"%>
<%@page import="dao.MySqlComboDAO"%>
<%@page import="interfaces.ComboDAO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
 
<%  
	PersonaDTO pe = (PersonaDTO) request.getAttribute("registro");
	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaDoc = listaDocumento.listarCombo("documento");
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
	String validar = (String) request.getAttribute("validaciones"); 
%>
<c:set var="estado" value="<%= pe.getEstado() %>"/>

<jsp:include page="../_header.jsp" flush="true" />
  <jsp:include page="../_sidebar.jsp" flush="true" />
  <!-- INICIO DE CABECERA INFO PAGE  -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Actualizar Persona
      </h1>
      
    </section>
	<!-- /.FIN DE CABECERA INFO PAGE -->
	
    <!-- SECCION DE CONTENIDO -->
    <section class="content">
    
    <div class="box box-primary">
    	<div class="row">
    	<div class="col-md-12">
    		<div class="box-header with-border">
  				<h3 class="box-title">Datos personales</h3>
  			</div>
	  		<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletPersona?tipo=registrar" method="post" enctype="multipart/form-data">
	  			<div class="box-body">
	  				<input type="hidden" name="codigo" value="<%= pe.getCodigo() %>">
	  				<div class="col-md-9">
					<% if (validar != null) { %>
                    	<div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                    <% } %>
	  				<div class="row">
		  				<div class="col-md-8">
		  					<!-- OBTENER DNI -->
		  					<div class="form-group">
							    <label for="cbotipodocumento" class="col-sm-4 control-label">Documento de identidad:</label>
							    <div class="col-sm-8">
							    	 <select class="form-control" id="cbotipodocumento" name="cbotipodocumento" disabled="disabled">
					                   <%
					                    	for (ComboDTO item : listaDoc ){
					                    		if(item.getField().equals(pe.getTipodocumento()+"")){
					                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
					                    		} else {
					                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
					                    		}
					                    	}
					                   	%>
				                  	</select>
				                  	<div class="separate">
				                  		<input type="text" class="form-control" id="txtnumdocumento" value="<%= pe.getNumdocumento() %>" name="txtnumdocumento" disabled="disabled">
				                  	</div>
							    </div>
							</div>
		  					<!-- FIN OBTENER DOCUMENTO -->
		  					<div class="form-group">
							    <label for="txtnombre" class="col-sm-4 control-label">Nombres:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtnombre" name="txtnombre"  value="<%= pe.getNombre() %>" placeholder="Escribir el nombre">
							    </div>
							    <div class="col-sm-2"></div>
							</div>
							<div class="form-group">
							    <label for="txtapaterno" class="col-sm-4 control-label">Apellido Paterno:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtapaterno" name="txtapaterno"  value="<%= pe.getApaterno() %>" placeholder="Escribir el apellido paterno">
							    </div>
							    <div class="col-sm-2"></div>
							</div>
							<div class="form-group">
							    <label for="txtamaterno" class="col-sm-4 control-label">Apellido Materno:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtamaterno" name="txtamaterno"  value="<%= pe.getAmaterno() %>" placeholder="Escribir el apellido materno">
							    </div>
							    
							</div>
							<div class="form-group">
							    <label for="cmbsexo" class="col-sm-4 control-label">Sexo:</label>
							    <div class="col-sm-8">
							      <select class="form-control" id="cmbsexo" name="cmbsexo">
				                    <option value="0">-- Seleccione --</option>
				                    	<%
					                    	for (ComboDTO item : listaSexo ){
					                    		if(item.getField().equals(pe.getSexo())){
					                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
					                    		} else {
					                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
					                    		}
					                    	}
					                    
					                   	%>
				                  </select>
							    </div>
							    
							</div>
							
							<div class="form-group">
							    <label for="txtfechanacimiento" class="col-sm-4 control-label">Fecha Nacimiento:</label>
							    <div class="col-sm-8">
							      <div class="input-group date">
					                  <div class="input-group-addon">
					                    <i class="fa fa-calendar"></i>
					                  </div>
					                  <input type="text" class="form-control midatepicker pull-right" id="txtfechanacimiento"  value="<%= pe.getFnacimiento() %>" data-date-format="yyyy-mm-dd" name="txtfechanacimiento">
					                </div>
							    </div>
							</div>
							<div class="form-group">
							    <label for="txtemail" class="col-sm-4 control-label">Email:</label>
							    <div class="col-sm-8">
							      <div class="input-group">
						                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						                <input type="email" class="form-control" name="txtemail" id="txtemail"  value="<%= pe.getEmail() %>" placeholder="Escribir el correo electronico">
						          </div>
							    </div>
							    
							</div>
							<div class="form-group">
							    <label for="txtfono" class="col-sm-4 control-label">Teléfono:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtfono" name="txtfono"  value="<%= pe.getFono() %>" placeholder="Escribir el número de teléfono">
							    </div>
							</div>
							<div class="form-group">
							    <label for="cmbestado" class="col-sm-4 control-label">Estado:</label>
							    <div class="col-sm-8">
							      <select class="form-control" name="cmbestado">
				                    <option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
				                    <option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
				                  </select>
							    </div>
							</div>
		  				</div>
		  				<div class="col-md-4">
		  					
		  					<div id="btnaction" class="photo-perfil">
		  						<p><strong>Foto de perfil</strong></p>
		  						
		  						<% //condición para mostrar si tiene imagen o no
		  						
									if(pe.getAvatar().equals("/images/avatar.jpg")){  						
		  						%>
		  						
		  						<div id="imagen-crop" class="panel-image" >
                        			<div id="preview-crop" >
			                            <img id="img-crop" width="160px" height="160px" class="thumbnail" src="${pageContext.request.contextPath}/images/<%= pe.getAvatar() %>" />
			                        </div>
			                        <div id="preview-upload" style="display: none;">
			                            <img id="img-preview" class="crop" />
			                        </div>
			                        <div id="actions" class="actions" style="display: none;">
			                        	<button id="recortar" class="btn btn-default" type="button" onclick="cropImagen();"><i class="fa fa-crop" aria-hidden="true"></i>
			                        	 Recortar</button>
			                        	 <button class="btn btn-danger" type="button" onclick="deleteImagen();"><i class="fa fa-crop" aria-hidden="true"></i>
			                        	 Quitar</button>
			                        </div>
		                    	</div>
		  						
		  						<input type="file" onchange="uploadImagen();" id="file" name="file" accept="image/x-png,image/gif,image/jpeg" />
		  						<div id="imagen-data" class="form-group">
		  							<input type="hidden" id="avatar" name="avatar"  value="<%= pe.getAvatar() %>" />
		                            <input type="hidden" id="x" name="x" />
		                            <input type="hidden" id="y" name="y" />
		                            <input type="hidden" id="w" name="w" />
		                            <input type="hidden" id="h" name="h" />
                        		</div>
		                    	<div id="imagen-error" class="alert alert-warning" style="display: none;"></div>
		                    	<% } else { %>
		                    		
		                    		<div id="imagen-crop" class="panel-image" >
	                        			<div id="preview-crop" >
				                            <img id="img-crop" width="160px" height="160px" class="thumbnail" src="${pageContext.request.contextPath}/uploads/<%= pe.getAvatar() %>" />
				                        </div>
				                        <div id="actions" class="actions">
			                        	 	<button class="btn btn-danger" type="button" onclick="deleteImagen();"><i class="fa fa-trash" aria-hidden="true"></i> Quitar</button>
			                        	</div>
			                        </div>
			                        
		                    	
		                    	<% } %>
		  					</div>
		  				</div>
	  				</div>
	  			</div>
	  			<div class="col-md-3">
	  				<script type="text/javascript">
	  					function updateInfo(e) {
	  					    $('#x').val(parseInt(e.x));
	  					    $('#y').val(parseInt(e.y));
	  					    $('#w').val(e.w);
	  					    $('#h').val(e.h);
	  					    
	  					};
	  					function clearInfo() {
  						    $('#w').val('');
  						    $('#h').val('');
  						  	$('#x').val('');
	  					    $('#y').val('');
	  					};

	  					function uploadImagen(){
	  						
	  						var oFile = $("#file")[0].files[0];
	  						
	  						//ocultamos todos los errores
	  						$("#imagen-error").hide();
	  						//filtramos la imagen en JPG o PNG
	  						var rFilter = /^(image\/jpeg|image\/png)$/i;
	  						if (! rFilter.test(oFile.type)) {
						    	$("#imagen-error").html("Seleccionar una imagen JPG o PNG").show();
  							    return;
	  						}
							//comparamos el tamaño de la imagen
	  						if (oFile.size >  1024 * 1024) {
	  					        $("#imagen-error").html("Solo se permite subir imagenes menor a 2,5 MB").show();
	  					        return;
	  					    }
							
							if (oFile){
								if (window.FormData !== undefined) {
			                        var formData = new FormData();
			                        formData.append("file", oFile);
			                        $.ajax({
			                            type: "POST",
			                            url: '${pageContext.request.contextPath}/ServletImagen?tipo=upload',
			                            contentType: false,
			                            processData: false,
			                            data: formData,
			                            success: function (result) {
			                                imagenName = result
			                                console.log(imagenName);
			                            },
			                            error: function (xhr) {
			                                console.log(xhr.responseText);
			                            }
			                        });
			                    } else {
			                        alert("Error al subir imagen");
			                    }
							}
							$("#actions").show();
							$("#preview-upload").show();
	  						var oImagen = document.getElementById('img-preview');
	  						
	  						var oReader = new FileReader();
							
	  							oReader.onload = function (e) {
	  								
	  		                    oImagen.src = e.target.result;
	  		                    oImagen.onload = function () {
	  		                        // Eliminar el Jcrop si este Existe
	  		                        if (typeof jcrop_api != 'undefined') {
	  		                            jcrop_api.destroy();
	  		                            jcrop_api = null;
	  		                         	//$('#img-preview').width(oImage.naturalWidth);
										//$('#img-preview').height(oImage.naturalHeight);
	  		                        }
	  		                      //mostramos la vista previa en segundo
	  		                      setTimeout(function(){
		  		                    	$('#img-preview').Jcrop({
		  		                            minSize: [32, 32], // min crop size
		  		                            onSelect: updateInfo,
		  		                          	onChange: updateInfo,
		  		                          	onRelease: clearInfo,
		  		                            bgOpacity: .3,
		  		                            setSelect: [350, 350, 50, 50],
		  		                            aspectRatio: 1,
		  		                            boxWidth: 200
		  		                        }, function () {
		  		                       // use the Jcrop API to get the real image size
		  		                        	var bounds = this.getBounds();
		  		                        	boundx = bounds[0];
		  		                        	boundy = bounds[1];
		  		                            jcrop_api = this;
		  		                        });
	  		                      },10);
	  		                        
	  		                    };
	  		                }
	  						
	  		                oReader.readAsDataURL(oFile);
	  						
	  					}
	  					
	  					function cropImagen(){
	  						
	  						var imgX = $("#x").val();
	  			            var imgY = $("#y").val();
	  			            var imgW = $("#w").val();
	  			            var imgH = $("#h").val();
	  			            var datos = {
	  			                'ladox': Math.round(imgX),
	  			                'ladoy': Math.round(imgY),
	  			                'ancho': Math.round(imgW),
	  			                'alto': Math.round(imgH),
	  			                'nombre' : imagenName
	  			            }
	  			            
	  			          $.ajax({
	  		                type: "POST",
	  		                url: '${pageContext.request.contextPath}/ServletImagen?tipo=crop',
	  		              	dataType: "json", 
	  		                contentType: "application/json; charset=utf-8",
	  		                processData: false,
	  		                data: JSON.stringify(datos),
	  		                success: function (result) {
	  		                    $fileupload = $('#file');
	  		                    $fileupload.replaceWith($fileupload.clone(true));
	  		                    $("#img-crop").attr('src', result);
	  		                  	$("#avatar").attr('value', imagenName);
	  		                    $('#recortar').hide();
	  		                    $("#preview-upload").hide();
	  		                  	$("#file").hide();
	  		                  	$("#preview-crop").show();
	  		                },
	  		               	 	error: function (xhr) {
	  		                    	console.log(xhr.responseText);
	  		                	}
	  		            	});
	  			            
	  					}
						function deleteImagen(){
							
				            var imgAvatar = {
				            		'nombre' : $("#avatar").val()
				            }
				            
				            $.ajax({
				                type: "POST",
				                url: "${pageContext.request.contextPath}/ServletImagen?tipo=delete",
				                contentType: "application/json; charset=utf-8",
				                processData: false,
				                data: JSON.stringify(imgAvatar),
				                success: function (result) {
				                    $("#img-crop").attr('src', '${pageContext.request.contextPath}/images/avatar.jpg');
				                    $('#actions').hide();
				                    $('#recortar').show();
				                    $("#file").val("");
				                    $("#file").show();
				                    
				                }
				            });
						}
	  					
	  				</script>
	  			</div>

				</div>
				<div class="box-footer">
					<a href="${pageContext.request.contextPath}/ServletPersona?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
                	<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar persona</button>
              	</div>
	  		</form>
    	</div>
    	<div class="col-md-3">
    	
    	</div>
  	</div>
	</div>
      
    </section>
    <!-- /.FIN DE CABECERA INFO PAGE-->
  </div>
  <!-- /.FIN DE SECCION DE CONTENIDO -->
  <jsp:include page="../_footer.jsp" flush="true" />
