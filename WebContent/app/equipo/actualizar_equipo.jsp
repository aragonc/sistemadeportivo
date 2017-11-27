<%@page import="beans.ModalidadDTO"%>
<%@page import="beans.EquipoDTO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 <%
	EquipoDTO obj = (EquipoDTO)request.getAttribute("registro");
 	List<ComboDTO> listaModalidad = (List<ComboDTO>) request.getAttribute("modalidad");
 	ComboService listaDocumento = new ComboService();
	List<ComboDTO> listaEventos = listaDocumento.listarComboSql("SELECT idevento, nombre FROM evento where estado = 1;");
 %>
 <c:set var="estado" value="<%= obj.getEstado() %>"/>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Equipo</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Actualizar equipo deportivo</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletEquipo?tipo=actualizar" method="post" id="frmequipo">
						<input type="hidden" name="codigo" value="<%= obj.getCodigo() %>">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
			                         <label for="nombre" class="col-sm-4 control-label">Nombre del Equipo</label>
			                         <div class="col-sm-8">
			                           <input type="text" id="nombre" name="nombre" value="<%= obj.getNombre() %>" class="form-control" placeholder="Escribe nombre del equipo">
			                         </div>
			                    </div>
							</div>
							<div class="col-md-6">
		                    	<div class="form-group">
	                    			<label for="color" class="col-sm-4 control-label">Color</label>
	                    			<div class="col-sm-8">
	                    				<input type="text" id="color" name="color" value="<%= obj.getColor() %>" class="form-control" placeholder="Escriba el color uniforme del equipo">
	                    			</div>
	                    		</div>
							</div>
						</div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<div class="form-group">
			                         <label for="evento" class="col-sm-4 control-label">Evento</label>
			                         <div class="col-sm-8">
			                           	<select id="listaevento" name="evento" class="form-control">
			                           		<option value="0">-- Seleccione --</option>
							                    <%
							                    	
							                    	for (ComboDTO item : listaEventos ){
							                    		if(item.getField().equals(obj.getEvento().getCodigo()+"")){
							                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
							                    		} else {
							                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
							                    		}
							                    	}
							                    
							                   	%>
			                           	</select>
			                       	</div>
	                    		</div>
	                    	</div>
	                    	<div class="col-md-6">
	                    		<div class="form-group">
			                         <label for="evento" class="col-sm-4 control-label">Modalidad</label>
			                         <div class="col-sm-8">
			                           	<select id="listamodalidad" name="modalidad" class="form-control">
			                           		<option selected="selected">-- Seleccionar molalidad --</option>
			                           		<%
							                    	for (ComboDTO item : listaModalidad ){
							                    		if(item.getField().equals(obj.getModalidad().getCodigo()+"")){
							                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
							                    		} else {
							                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
							                    		}
							                    	}
							                    
							                   	%>
			                           	</select>
			                       	</div>
	                    		</div>
	                    	</div>
	                    </div>
	                    <div class="form-group">
	                         <label for="txthtml" class="col-sm-2 control-label">Descripción</label>
	                         <div class="col-sm-10">
	                         	<textarea class="form-control" id="txthtml" name="descripcion" rows="3">
	                         		<%= obj.getDescripcion() %>
	                         	</textarea>
	                         </div>
	                    </div>
	                    <div class="row">
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
							<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		                	<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Actualizar equipo</button>
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
