
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />

  <div class="content-wrapper">
    <section class="content-header">
      <h1>Registrar evento</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Añadir un nuevo evento a la agenda</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletEvento?tipo=registrar" method="post" id="frmevento">
						<div class="form-group">
	                         <label for="nombre" class="col-sm-2 control-label">Titulo del Evento</label>
	                         <div class="col-sm-10">
	                           <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Escribe titulo del evento">
	                         </div>
	                    </div>
	                    <div class="form-group">
	                         <label for="nombre" class="col-sm-2 control-label">Descripción</label>
	                         <div class="col-sm-10">
	                         	<textarea class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
	                         </div>
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<div class="form-group">
	                    			<label for="fechainicio" class="col-sm-4 control-label">Fecha/Hora Inicio</label>
	                    			<div class="col-sm-8">
	                    				<div class="input-group date">
						                  <div class="input-group-addon">
						                    <i class="fa fa-calendar"></i>
						                  </div>
						                  <input type="text" class="form-control datefechahora pull-right" id="fechainicio" name="fechainicio">
						                </div>
	                    			</div>
	                    		</div>
	                    	</div>
	                    	<div class="col-md-6">
	                    		<div class="form-group">
	                    			<label for="fechafin" class="col-sm-4 control-label">Fecha/Hora Fin</label>
	                    			<div class="col-sm-8">
	                    				<div class="input-group date">
						                  <div class="input-group-addon">
						                    <i class="fa fa-calendar"></i>
						                  </div>
						                  <input type="text" class="form-control datefechahora pull-right" id="fechafin"  name="fechafin">
						                </div>
	                    			</div>
	                    		</div>
	                    	</div>
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<div class="form-group">
	                    			<label for="costo" class="col-sm-4 control-label">Costo S/.</label>
	                    			<div class="col-sm-8">
	                    				<input type="text" id="txtcosto" name="costo" class="form-control" placeholder="Ingrese costo S/.">
	                    				<div class="checkbox">
										  <label>
										    <input id="gratuito" name="gratuito" type="checkbox" value="1" checked="checked">
										    Desmarcar si es un evento gratuito
										  </label>
										</div>
	                    				
	                    			</div>
	                    		</div>
	                    	</div>
	                    	<div class="col-md-6">
	                    		<div class="form-group">
								    <label for="estado" class="col-sm-4 control-label">Estado:</label>
								    <div class="col-sm-8">
								      <select class="form-control" name="estado">
					                    <option value="1">Activo</option>
					                    <option value="2">Inactivo</option>
					                  </select>
								    </div>
								</div>
	                    	</div>
	                    </div>
	                    
                        
                        <div class="box-footer">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		                	<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar evento</button>
		              	</div>
					</form>
                  </div>
                  <div class="col-md-3">
                  
                  </div> 
        	</div>
        </div>              
    </section>
 </div>	
 <jsp:include page="_footer.jsp" flush="true" />
