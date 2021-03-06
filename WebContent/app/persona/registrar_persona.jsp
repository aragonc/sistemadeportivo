<%@page import="service.PerfilService"%>
<%@page import="beans.PerfilDTO"%>
<%@page import="service.ComboService"%>
<%@page import="dao.MySqlComboDAO"%>
<%@page import="interfaces.ComboDAO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%  
	ComboService listaDocumento = new ComboService();
	PerfilService perfiles = new PerfilService();
	List<ComboDTO> listaDoc = listaDocumento.listarCombo("documento");
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
	List<PerfilDTO> listaPerfil = perfiles.listar();
	String validar = (String) request.getAttribute("validaciones"); 
%>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
  <!-- INICIO DE CABECERA INFO PAGE  -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Registrar Persona
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
							    	 <select class="form-control" id="cbotipodocumento" name="cbotipodocumento">
					                    
					                    <%
					                    	for (ComboDTO item : listaDoc ){
					                    %>
					                    	<option value="<%= item.getField() %>"> <%= item.getValor() %> </option>		
					                   	<%
					                   		}  
					                   	%>
				                  	</select>
				                  	<div class="separate">
				                  		<span  id="progreso" style="display: none;">
				                  				<div class="sk-circle">
												  <div class="sk-circle1 sk-child"></div>
												  <div class="sk-circle2 sk-child"></div>
												  <div class="sk-circle3 sk-child"></div>
												  <div class="sk-circle4 sk-child"></div>
												  <div class="sk-circle5 sk-child"></div>
												  <div class="sk-circle6 sk-child"></div>
												  <div class="sk-circle7 sk-child"></div>
												  <div class="sk-circle8 sk-child"></div>
												  <div class="sk-circle9 sk-child"></div>
												  <div class="sk-circle10 sk-child"></div>
												  <div class="sk-circle11 sk-child"></div>
												  <div class="sk-circle12 sk-child"></div>
												</div>
				                  		</span>
				                  		<div class="input-group">
				                  			
				                  			<input type="text" class="form-control" id="txtnumdocumento" name="txtnumdocumento" placeholder="Escribir el n�mero de documento">
				                  			<span class="input-group-btn">
				                  				<button id="btn-sincronizar" class="btn btn-success" type="button"><i class="fa fa-refresh" aria-hidden="true"></i>
				                  				 Sincronizar</button>
				                  			</span>
				                  		</div>
				                  	</div>
							    </div>
							</div>
		  					<!-- FIN OBTENER DOCUMENTO -->
		  					<div class="form-group">
							    <label for="txtnombre" class="col-sm-4 control-label">Nombres:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtnombre" name="txtnombre" placeholder="Escribir el nombre">
							    </div>
							    <div class="col-sm-2"></div>
							</div>
							<div class="form-group">
							    <label for="txtapaterno" class="col-sm-4 control-label">Apellido Paterno:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtapaterno" name="txtapaterno" placeholder="Escribir el apellido paterno">
							    </div>
							    <div class="col-sm-2"></div>
							</div>
							<div class="form-group">
							    <label for="txtamaterno" class="col-sm-4 control-label">Apellido Materno:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtamaterno" name="txtamaterno" placeholder="Escribir el apellido materno">
							    </div>
							    
							</div>
							<div class="form-group">
							    <label for="cmbsexo" class="col-sm-4 control-label">Sexo:</label>
							    <div class="col-sm-8">
							      <select class="form-control" id="cmbsexo" name="cmbsexo">
				                    <option value="0">-- Seleccione --</option>
				                    	<%
					                    	for (ComboDTO item : listaSexo ){
					                    %>
					                    	<option value="<%= item.getField() %>"> <%= item.getValor() %> </option>		
					                   	<%
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
					                  <input type="text" class="form-control fechaformato" id="txtfechanacimiento" data-date-format="yyyy-mm-dd" name="txtfechanacimiento">
					                </div>
							    </div>
							</div>
							
							<div class="form-group">
							    <label for="txtfono" class="col-sm-4 control-label">Tel�fono:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtfono" name="txtfono" placeholder="Escribir el n�mero de tel�fono">
							    </div>
							</div>
							
							<div class="form-group">
							    <label for="txtemail" class="col-sm-4 control-label">Email:</label>
							    <div class="col-sm-8">
							      <div class="input-group">
						                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						                <input type="email" class="form-control" name="txtemail" id="txtemail" placeholder="Escribir el correo electronico">
						          </div>
							    </div>
							</div>
							
							<div class="form-group">
							    <label for="txtemail" class="col-sm-4 control-label"></label>
							    <div class="col-sm-8">
							      <div class="checkbox">
								    <label>
								      <input id="plataforma" name="plataforma" type="checkbox" value="true" > Activar opciones de usuario de plataforma
								    </label>
								  </div>
							    </div>
							</div>
							<div id="opciones-usuario" style="display: none;">
							<div class="form-group">
							    <label for="txtfono" class="col-sm-4 control-label">Perfil:</label>
							    <div class="col-sm-8">
							      	<select class="form-control" id="cmbperfil" name="cmbperfil">
					                    
					                    	<%
						                    	for (PerfilDTO item : listaPerfil ){
						                    %>
						                    	<option value="<%= item.getCodigo() %>"> <%= item.getNombre() %> </option>		
						                   	<%
						                   		}  
						                   	%>
					                  </select>
							    </div>
							</div>

							<div class="form-group">
							    <label for="txtfono" class="col-sm-4 control-label">Contrase�a:</label>
							    <div class="col-sm-8">
							    	<div class="input-group">
							    		<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							      		<input type="password" class="form-control" id="txtpassword" name="txtpassword" placeholder="Escribir una contrase�a">
							      	</div>
							    </div>
							</div>
							</div>
							
							<div class="form-group">
							    <label for="cmbestado" class="col-sm-4 control-label">Estado:</label>
							    <div class="col-sm-8">
							      <select class="form-control" name="cmbestado">
				                    <option value="1">Activo</option>
				                    <option value="2">Inactivo</option>
				                  </select>
							    </div>
							</div>
		  				</div>
		  				<div class="col-md-4">
		  					
		  					<div id="btnaction" class="photo-perfil">
		  						<p><strong>Foto de perfil</strong></p>
		  						
		  						<div id="imagen-crop" class="panel-image" >
                        			<div id="preview-crop" >
			                            <img id="img-crop" width="160px" height="160px" class="thumbnail" src="${pageContext.request.contextPath}/images/avatar.jpg" />
			                        </div>
			                        <div id="preview-upload" style="display: none;">
			                            <img id="img-preview" class="crop" />
			                        </div>
			                        <div id="actions" class="actions" style="display: none;">
			                        	<button id="recortar" class="btn btn-default" type="button" onclick="cropImagen();"><i class="fa fa-crop" aria-hidden="true"></i>
			                        	 Recortar</button>
			                        	 <button class="btn btn-danger" type="button" onclick="deleteImagen();"><i class="fa fa-trash" aria-hidden="true"></i>
			                        	 Quitar</button>
			                        </div>
		                    	</div>
		  						
		  						<input type="file" onchange="uploadImagen();" id="file" name="file" accept="image/x-png,image/gif,image/jpeg" />
		  						<div id="imagen-data" class="form-group">
		  							<input type="hidden" id="avatar" name="avatar" />
		                            <input type="hidden" id="x" name="x" />
		                            <input type="hidden" id="y" name="y" />
		                            <input type="hidden" id="w" name="w" />
		                            <input type="hidden" id="h" name="h" />
                        		</div>
		                    	<div id="imagen-error" class="alert alert-warning" style="display: none;"></div>
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
							//comparamos el tama�o de la imagen
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
  <%@ include file="../_footer.jsp" %>
