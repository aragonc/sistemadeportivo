<%@page import="service.ComboService"%>
<%@page import="dao.MySqlComboDAO"%>
<%@page import="interfaces.ComboDAO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaDoc = listaDocumento.listarCombo("documento");
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
%>
 <jsp:include page="../_header.jsp" flush="true" />
  <jsp:include page="../_sidebar.jsp" flush="true" />
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
	  				<div class="row">
		  				<div class="col-md-6">
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
				                    <option value="">-- Seleccione --</option>
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
					                  <input type="text" class="form-control midatepicker pull-right" id="txtfechanacimiento" data-date-format="yyyy-mm-dd" name="txtfechanacimiento">
					                </div>
							    </div>
							</div>
							
							<div class="form-group">
							    <label for="cbotipodocumento" class="col-sm-4 control-label">Documento de identidad:</label>
							    <div class="col-sm-8">
							    	 <select class="form-control" id="cbotipodocumento" name="cbotipodocumento">
					                    <option value="0">-- Seleccione --</option>
					                    <%
					                    	for (ComboDTO item : listaDoc ){
					                    %>
					                    	<option value="<%= item.getField() %>"> <%= item.getValor() %> </option>		
					                   	<%
					                   		}  
					                   	%>
				                  	</select>
				                  	<div class="separate">
				                  		<input type="text" class="form-control" id="txtnumdocumento" name="txtnumdocumento" placeholder="Escribir el número de documento">
				                  	</div>
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
							    <label for="txtfono" class="col-sm-4 control-label">Teléfono:</label>
							    <div class="col-sm-8">
							      <input type="text" class="form-control" id="txtfono" name="txtfono" placeholder="Escribir el número de teléfono">
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
		  				<div class="col-md-6">
		  					
		  					<div id="btnaction" class="action-toolbars">
		  						<p>Seleccione una imagen</p>
		  						<input type="file" onchange="cargarImagen()" id="avatar" name="avatar" accept="image/x-png,image/gif,image/jpeg" />
		  						<div id="data-imagen" class="form-group">
		  							<input type="hidden" id="file" name="file" />
		                            <input type="hidden" id="x" name="x" />
		                            <input type="hidden" id="y" name="y" />
		                            <input type="hidden" id="w" name="w" />
		                            <input type="hidden" id="h" name="h" />
                        		</div>
                        		<div id="cerror" class="alert alert-warning" style="display: none;"></div>
		  					</div>
		  					
		  					<div id="panel-crop" class="panel-image">
		                        <div class="preview-image">
		                            <img id="img-preview" class="crop" />
		                        </div>
		                    </div>
		  					
		  					
		  				</div>
	  				</div>
	  			</div>
	  			<div class="col-md-3">
	  				<script type="text/javascript">
	  				
		  				$(document).ready(function () {
		  		            /* $("#cerror").hide();
		  		            $("#recortarImagen").hide(); */
		  		        });
	  					
	  					var jcrop_api, boundx, boundy;

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

	  					function cargarImagen(){
	  						
	  						var oFile = $("#avatar")[0].files[0];
	  						
	  						//ocultamos todos los errores
	  						$("#cerror").hide();
	  						//filtramos la imagen en JPG o PNG
	  						var rFilter = /^(image\/jpeg|image\/png)$/i;
	  						if (! rFilter.test(oFile.type)) {
						    	$('.cerror').html('Seleccionar una imagen JPG o PNG').show();
  							    return;
	  						}
							//comparamos el tamaño de la imagen
	  						if (oFile.size >  1024 * 1024) {
	  					        $('.cerror').html('Solo se permite subir imagenes menor a 2,5 MB').show();
	  					        return;
	  					    }
							
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
		  		                            bgOpacity: .4,
		  		                            setSelect: [350, 350, 50, 50],
		  		                            aspectRatio: 1,
		  		                            boxWidth: 300
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
	  			            var img = {
	  			                'CorX': Math.round(imgX),
	  			                'CorY': Math.round(imgY),
	  			                'CorW': Math.round(imgW),
	  			                'CorH': Math.round(imgH),
	  			                NombreImagen
	  			            }
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
    	
  		</div>
	</div>
      
    </section>
    <!-- /.FIN DE CABECERA INFO PAGE-->
  </div>
  <!-- /.FIN DE SECCION DE CONTENIDO -->
  <jsp:include page="../_footer.jsp" flush="true" />
