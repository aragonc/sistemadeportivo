<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 <%  
	ComboService listas = new ComboService();  
	List<ComboDTO> listaCategoria = listas.listarComboSql("SELECT idcategoria, nombre FROM categoria where estado = 1;");
	List<ComboDTO> listaDisciplina = listas.listarComboSql("SELECT iddisciplina, nombre FROM disciplina where estado = 1;");
	List<ComboDTO> listaGenero = listas.listarCombo("genero");
	String error = (String)request.getAttribute("errorMessage");
	String validar = (String) request.getAttribute("validaciones");
%>
 <div class="content-wrapper">
    <section class="content-header">
      <h1>Modalidad</h1> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Agregar modalidad de juego</h3>
            </div>
        	<div class="box-body">
        	
            	<div class="col-md-9">
            	
            		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if( error != null) { %>
		              	<div class="alert alert-danger" role="alert">
		              		<%= error %>
		              	</div>
		              <% } %>
			       	<!-- FIN DEL MENSAJE -->
            	
					<form action="${pageContext.request.contextPath}/ServletModalidad?tipo=registrar" class="form-horizontal" id="frmregistrar" method="post">
                         
                         <div class="row">
                         
                         <% if (validar != null) { %>
                                 <div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                                 <% } %>
                         
                         	<div class="col-md-6">
                         		<div class="form-group">
                         		 
		                           <label class="col-sm-4 control-label">Disciplina</label>
		                           <div class="col-sm-8">
		                             <select id="cbodisciplina" name="cbodisciplina" class="form-control">
		                                   <option value="">-- Seleccione --</option>
						                    	<%
							                    	for (ComboDTO item : listaDisciplina ){
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
		                           <label class="col-sm-4 control-label">Categoria</label>
		                           <div class="col-sm-8">
		                             <select id="cbocategoria" name="cbocategoria" class="form-control">
		                                   <option value="">-- Seleccione --</option>
						                    	<%
							                    	for (ComboDTO item : listaCategoria ){
							                    %>
							                    	<option value="<%= item.getField() %>"> <%= item.getValor() %> </option>		
							                   	<%
							                   		}  
							                   	%>
		                             </select>
		                           </div>
		                         </div>  
                         	</div>
                         	
                         </div>
                         
                         <div class="form-group">
	                           <label class="col-sm-2 control-label">Descripcion</label>
	                           <div class="col-sm-10">
	                             <textarea id=txthtml name="descripcion" rows="3" class="form-control"></textarea>
	                           </div>
		                 </div>
                         
                         <div class="row">
                         	<div class="col-md-12">
                         		<div class="form-group">
	                         		<label class="col-sm-2 control-label">N° Jugadores</label>
		                            <div class="col-sm-2">
		                             	<input type="text" name="cantidad" id="cantidad" class="form-control" placeholder="Ingrese cantidad">
		                            </div>
		                            <div class="col-sm-4">
		                            	<%
		                            		String check = null;
							              for (ComboDTO item : listaGenero ){
							            	 if(item.getField().equals("V")){
							            		 check = "checked='checked'";
							            	 }else{
							            		 check = "";
							            	 }
							             %>
					                    	<label class="radio-inline">
					                    		<input type="radio" name="genero" id="id<%= item.getValor() %>" value="<%= item.getField() %>" <%= check %> > <%= item.getValor() %>
					                    	</label>		
					                   	<%
					                   		}  
					                   	%>
		                            </div>
		                            <div class="col-sm-4">
		                            	<div id="mixto" class="mixto" style="display:none;">
					                   		<div class="row">
					                   			<div class="col-md-6">
						                   			<div class="form-group">
						                   				<input type="text" name="varones" id="txtvarones" class="form-control" placeholder="N° Varones">
						                   			</div>
					                   			</div>
					                   			<div class="col-md-6">
						                   			<div class="form-group">
						                   				<input type="text" name="mujeres" id="txtmujeres" class="form-control" placeholder="N° Mujeres">
						                   			</div>
					                   			</div>
					                   			
					                   		</div>
					                   	</div>
		                            </div>
	                            </div>
                         	</div>
                         	
                         	
                         </div>                                                       
                         
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-10">
                             <a href="${pageContext.request.contextPath}/ServletModalidad?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-success" >
                             <i class="fa fa-plus" aria-hidden="true"></i> Registrar Modalidad</button>
                           </div>
                         </div>
                       </form>
                 </div> 
                 <div class="col-md-3">
	                  
	             </div>
			</div>
		</div>
    </section>
  </div>
 
 <%@ include file="../_footer.jsp" %>
 