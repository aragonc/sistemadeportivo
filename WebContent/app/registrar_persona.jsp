<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="_header.jsp" flush="true" />
  <jsp:include page="_sidebar.jsp" flush="true" />
  <!-- INICIO DE CABECERA INFO PAGE  -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Registrar Persona
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Registrar persona</li>
      </ol>
    </section>
	<!-- /.FIN DE CABECERA INFO PAGE -->
	
    <!-- SECCION DE CONTENIDO -->
    <section class="content">
    
    <div class="box box-primary">
    	<div class="row">
    	<div class="col-md-9">
    		<div class="box-header with-border">
  				<h3 class="box-title">Registrar persona</h3>
  			</div>
	  		<form class="form-horizontal" action="../ServletPersona?tipo=registrar" method="post">
	  			<div class="box-body">
		  			<div class="form-group">
					    <label for="txtnombre" class="col-sm-2 control-label">Nombres:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtnombre" name="txtnombre" placeholder="Escribir el nombre">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtapaterno" class="col-sm-2 control-label">Apellido Paterno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtapaterno" name="txtapaterno" placeholder="Escribir el apellido paterno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtamaterno" class="col-sm-2 control-label">Apellido Materno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtamaterno" name="txtamaterno" placeholder="Escribir el apellido materno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbsexo" class="col-sm-2 control-label">Sexo:</label>
					    <div class="col-sm-10">
					      <select class="form-control" id="cmbsexo" name="cmbsexo">
		                    <option value="0">-- Seleccione --</option>
		                    <option value="1">Masculino</option>
		                    <option value="2">Femenino</option>
		                  </select>
					    </div>
					</div>
					<div class="form-group">
					    <label for="cbotipodocumento" class="col-sm-2 control-label">Documento de identidad:</label>
					    <div class="col-sm-10">
					    	 <select class="form-control" id="cbotipodocumento" name="cbotipodocumento">
			                    <option value="0">-- Seleccione --</option>
			                    <option value="1">Documento Nacional de Identidad</option>
			                    <option value="2">Carnet de Extranjeria</option>
			                    <option value="3">Registro Unico de Contribuyentes</option>
			                    <option value="4">Pasaporte</option>
			                    <option value="5">Partida de Nacimiento</option>
			                    <option value="6">Otros</option>
		                  	</select>
					      	<input type="text" class="form-control" id="txtnumdocumento" name="txtnumdocumento" placeholder="Escribir el número de documento">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfechanacimiento" class="col-sm-2 control-label">Fecha Nacimiento:</label>
					    <div class="col-sm-10">
					      <div class="input-group date">
			                  <div class="input-group-addon">
			                    <i class="fa fa-calendar"></i>
			                  </div>
			                  <input type="text" class="form-control midatepicker pull-right" id="txtfechanacimiento" name="txtfechanacimiento">
			                </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtemail" class="col-sm-2 control-label">Email:</label>
					    <div class="col-sm-10">
					      <div class="input-group">
				                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
				                <input type="email" class="form-control" name="txtemail" id="txtemail" placeholder="Escribir el correo electronico">
				          </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfono" class="col-sm-2 control-label">Teléfono:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtfono" name="txtfono" placeholder="Escribir el número de teléfono">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtmovil" class="col-sm-2 control-label">Movil:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtmovil" name="txtmovil" placeholder="Escribir el número de celular">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbestado" class="col-sm-2 control-label">Estado:</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="cmbestado">
		                    <option value="1">Activo</option>
		                    <option value="2">Inactivo</option>
		                  </select>
					    </div>
					</div>
				</div>
				<div class="box-footer">
					<a href="#" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
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
  <jsp:include page="_footer.jsp" flush="true" />
