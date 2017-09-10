

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
	  		<form class="form-horizontal" action="">
	  			<div class="box-body">
		  			<div class="form-group">
					    <label for="txtnombre" class="col-sm-2 control-label">Nombres:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtnombre" placeholder="Escribir el nombre">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtapaterno" class="col-sm-2 control-label">Apellido Paterno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtapaterno" placeholder="Escribir el apellido paterno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtamaterno" class="col-sm-2 control-label">Apellido Materno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtamaterno" placeholder="Escribir el apellido materno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbsexo" class="col-sm-2 control-label">Sexo:</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="cmbsexo">
		                    <option>option 1</option>
		                    <option>option 2</option>
		                    <option>option 3</option>
		                    <option>option 4</option>
		                    <option>option 5</option>
		                  </select>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtdni" class="col-sm-2 control-label">N° de documento:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtdni" placeholder="Escribir el número de documento">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfechanacimiento" class="col-sm-2 control-label">Fecha Nacimiento:</label>
					    <div class="col-sm-10">
					      <div class="input-group date">
			                  <div class="input-group-addon">
			                    <i class="fa fa-calendar"></i>
			                  </div>
			                  <input type="text" class="form-control pull-right" id="datepicker">
			                </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtemail" class="col-sm-2 control-label">Email:</label>
					    <div class="col-sm-10">
					      <div class="input-group">
				                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
				                <input type="email" class="form-control" placeholder="Escribir el correo electronico">
				          </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfono" class="col-sm-2 control-label">Teléfono:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtfono" placeholder="Escribir el número de teléfono">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtmovil" class="col-sm-2 control-label">Movil:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtmovil" placeholder="Escribir el número de celular">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbsexo" class="col-sm-2 control-label">Estado:</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="cmbsexo">
		                    <option>Inactivo</option>
		                    <option>Activo</option>
		                  </select>
					    </div>
					</div>
				</div>
				<div class="box-footer">
					<a href="#" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volvar a lista </a>
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
