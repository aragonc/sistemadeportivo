<%@page import="beans.EquipoDTO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 <%
	EquipoDTO obj = (EquipoDTO)request.getAttribute("registro");
 	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaEventos = listaDocumento.listarComboSql("SELECT idevento, nombre FROM evento where estado = 1;");
	List<ComboDTO> listaModalidad = listaDocumento.listarComboModalidad(obj.getCodEvento());
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
		                    			<label for="email" class="col-sm-4 control-label">Email</label>
		                    			<div class="col-sm-8">
		                    				<div class="input-group">
		                    					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
		                    					<input type="text" name="email" id="email" class="form-control" value="<%= obj.getEmail() %>" placeholder="Escriba el email de contacto del equipo">
		                    				</div>
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
							                    		if(item.getField().equals(obj.getCodEvento()+"")){
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
							                    	System.out.println(obj.getCodModalidad());
							                    	for (ComboDTO item : listaModalidad ){
							                    		if(item.getField().equals(obj.getCodModalidad()+"")){
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
	                    			<label for="fono" class="col-sm-4 control-label">Télefono</label>
	                    			<div class="col-sm-8">
	                    				<div class="input-group">
	                    					<span class="input-group-addon"><i class="fa fa-mobile" aria-hidden="true"></i></span>
	                    					<input type="text" id="fono" name="fono" value="<%= obj.getFono() %>" class="form-control" placeholder="Escriba el télefono de contacto del equipo">
	                    				</div>
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
								    <label for="estado" class="col-sm-4 control-label">Estado:</label>
								    <div class="col-sm-8">
								      <select class="form-control" name="estado">
					                    	<option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
                                   			<option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
					                  </select>
								    </div>
								</div>
	                    	</div>
	                    	<div class="col-md-6">
	                    		<div class="form-group">
		                           <label class="col-sm-4 control-label">Logotipo</label>
		                           <div class="col-sm-8">
		                             <input type="file" id="logotipo" name="logotipo" accept=".jpg, .jpeg, .png">
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
