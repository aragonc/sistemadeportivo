<%@page import="beans.ComboDTO"%>
<%@page import="service.ComboService"%>
<%@page import="beans.EventoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
<%
	EventoDTO obj = (EventoDTO)request.getAttribute("registro");
	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaLugar = listaDocumento.listarComboSql("SELECT idlugar, nombre FROM lugar where estado = 1;");
%>
  <c:set var="estado" value="<%= obj.getEstado() %>"/>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Eventos</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Actualizar evento</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletEvento?tipo=actualizar" method="post" id="frmevento">
						<input type="hidden" name="codigo" value="<%= obj.getCodigo() %>">
						<div class="form-group">
	                         <label for="nombre" class="col-sm-2 control-label">Titulo del Evento</label>
	                         <div class="col-sm-10">
	                           <input type="text" id="nombre" name="nombre" value="<%= obj.getNombre() %>" class="form-control" placeholder="Escribe titulo del evento">
	                         </div>
	                    </div>
	                    <div class="form-group">
	                         <label for="txthtml" class="col-sm-2 control-label">Descripción</label>
	                         <div class="col-sm-10">
	                         	<textarea class="form-control" id="txthtml" name="descripcion" rows="2">
	                         		<%= obj.getDescripcion() %>
	                         	</textarea>
	                         </div>
	                    </div>
	                    <div class="form-group">
	                         <label for="txthtml" class="col-sm-2 control-label">Lugar del Evento</label>
	                         <div class="col-sm-10">
                         		<select id="listaevento" name="evento" class="form-control">
		                           		<option value="0">-- Seleccione --</option>
						                    <%
						                    	
						                    	for (ComboDTO item : listaLugar){
						                    		if(item.getField().equals(obj.getLugar()+"")){
						                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
						                    		} else {
						                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
						                    		}
						                    	}
						                    
						                   	%>
		                           	</select>
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
						                  <input type="text" class="form-control datefechahora pull-right" id="fechainicio" value="<%= obj.getFechaInicio() %>" name="fechainicio">
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
						                  <input type="text" class="form-control datefechahora pull-right" id="fechafin" value="<%= obj.getFechaFin() %>" name="fechafin">
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
	                    				<input type="text" id="txtcosto" name="costo" class="form-control" value="<%= obj.getPrecio() %>" placeholder="Ingrese costo S/.">
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
					                    	<option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
                                   			<option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
					                  </select>
								    </div>
								</div>
	                    	</div>
	                    </div>
	                    
                        
                        <div class="box-footer">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		                	<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Actualizar evento</button>
		              	</div>
					</form>
                  </div>
                  <div class="col-md-3">
                  
                  </div> 
        	</div>
        </div>              
    </section>
 </div>	
 <jsp:include page="../_footer.jsp" flush="true" />
