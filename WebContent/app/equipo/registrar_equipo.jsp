<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 <%
 	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaEventos = listaDocumento.listarComboSql("SELECT idevento, nombre FROM evento where estado = 1;");
	String validar = (String) request.getAttribute("validaciones"); 
 %>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Equipo</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Asignar nuevo equipo deportivo</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletEquipo?tipo=registrar" method="post" id="frmequipo">
						
						<div class="row">
						
						<% if (validar != null) { %>
                                 <div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                                 <% } %>
                                 
							<div class="col-md-6">
								<div class="form-group">
								
			                         <label for="nombre" class="col-sm-4 control-label">Nombre del Equipo</label>
			                         <div class="col-sm-8">
			                           <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Escribe nombre del equipo">
			                         </div>
			                    </div>
							</div>
							<div class="col-md-6">
		                    		<div class="form-group">
		                    			<label for="email" class="col-sm-4 control-label">Email</label>
		                    			<div class="col-sm-8">
		                    				<div class="input-group">
		                    					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
		                    					<input type="text" name="email" id="email" class="form-control" placeholder="Escriba el email de contacto del equipo">
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
							                    %>
							                    	<option value="<%= item.getField() %>"> <%= item.getValor() %> </option>		
							                   	<%
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
			                           		<option value="0">-- Seleccionar molalidad --</option>
			                           	</select>
			                       	</div>
	                    		</div>
	                    	</div>
	                    </div>
	                    <div class="form-group">
	                         <label for="txthtml" class="col-sm-2 control-label">Descripción</label>
	                         <div class="col-sm-10">
	                         	<textarea class="form-control" id="txthtml" name="descripcion" rows="3"></textarea>
	                         </div>
	                    </div>
	                    <div class="row">
	                 		<div class="col-md-6">
	                 			<div class="form-group">
	                    			<label for="fono" class="col-sm-4 control-label">Télefono</label>
	                    			<div class="col-sm-8">
	                    				<div class="input-group">
	                    					<span class="input-group-addon"><i class="fa fa-mobile" aria-hidden="true"></i></span>
	                    					<input type="text" id="fono" name="fono" class="form-control" placeholder="Escriba el télefono de contacto del equipo">
	                    				</div>
	                    			</div>
	                    		</div>
	                 		</div>   
	                 		<div class="col-md-6">
	                 			<div class="form-group">
	                    			<label for="color" class="col-sm-4 control-label">Color</label>
	                    			<div class="col-sm-8">
	                    				<input type="text" id="color" name="color" class="form-control" placeholder="Escriba el color uniforme del equipo">
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
					                    <option value="1">Activo</option>
					                    <option value="2">Inactivo</option>
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
		                	<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar equipo</button>
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
