<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 <%
 	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaDisciplina = listaDocumento.listarComboSql("SELECT iddisciplina, nombre FROM disciplina where estado = 1;");
	List<ComboDTO> listaCategoria = listaDocumento.listarComboSql("SELECT idcategoria, nombres FROM categoria where estado = 1;");
 %>
  <div class="content-wrapper">
    <section class="content-header">
      <h3>Registrar evento</h3> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Nuevo evento</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletEvento?tipo=registrar" method="post" id="frmevento">
						<div class="form-group">
	                         <label for="nombre" class="col-sm-2 control-label">Nombre del Evento</label>
	                         <div class="col-sm-10">
	                           <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Escribe nombre del evento">
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
						                  <input type="text" class="form-control datefechahora pull-right" id="fechainicio" name="txtfechainicio">
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
						                  <input type="text" class="form-control datefechahora pull-right" id="fechafin"  name="txtfechafin">
						                </div>
	                    			</div>
	                    		</div>
	                    	</div>
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<div class="form-group">
	                    			<label for="costo" class="col-sm-4 control-label">Costo Inscripción S/.</label>
	                    			<div class="col-sm-8">
	                    				<input type="text" id="costo" name="txtcosto" class="form-control" placeholder="Dejar vacio si es evento libre">
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
							<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		                	<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar evento</button>
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
