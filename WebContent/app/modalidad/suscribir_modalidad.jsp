<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String nombreEvento = (String)request.getAttribute("nomevento"); %>
<% String codigoEvento = (String)request.getAttribute("codevento"); %>

 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Evento</h1> 
    </section>
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
           	<div class="box-header with-border">
	              <h3 class="box-title">Asignar modalidad a evento al <span class="valor"><%= nombreEvento %></span></h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-9">
	        		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if(codigoEvento!=null) { %>
		              	<div class="alert alert-success" role="alert">
		              		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              		Acabas de crear el evento a continuación procede a asignar las modalidesde de juego para el evento
		              	</div>
		              <% } %>
			       	<!-- FIN DEL MENSAJE -->
			        <div class="toolbar-actions">
			        	<div class="row">
			        		<div class="col-md-6">
			        			
						        	<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">
						        		<img alt="Regresar a lista de eventos" title ="Regresar a lista de eventos" src="${pageContext.request.contextPath}/images/icons/32/back.png">
						        	</a>
						        	<a href="${pageContext.request.contextPath}">
						        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
						        	</a>
							        <a href="${pageContext.request.contextPath}/app/modalidad/registrar_modalidad.jsp">
							        	<img alt="Crear nueva categoria" title="Crear nueva modalidad" src="${pageContext.request.contextPath}/images/icons/32/new_folder.png">
							        </a>
						        
			        		</div>
			        		<div class="col-md-6">
			        			<div class="pull-right">
	            					<form class="form-inline">
									  <div class="form-group">
									    <div class="input-group">
									      <input type="text" name="txtdni" class="form-control" id="txtdni" size="25" placeholder="Buscar modalidad">
									    </div>
									  </div>
									  <button type="submit" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i>
									   Buscar</button>
									</form>
	            				</div>
			        		</div>
			        	</div>
			        	
			       	</div>
			       	
			       	<form action="" id="form-lista">
			        <div class="box-body table-responsive no-padding">
				        <display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletModalidad?tipo=listar"	id="lista">
			                <display:column title="Item" sortable="false" media="html" >
							    	<input type="checkbox" name="modalidad[]" value="${lista.codigo}">
             		 		</display:column>
             		 		<display:column property="disciplina.nombre" title="Disciplina" />
			                <display:column property="categoria.nombre" title="Categoria" />
			                <display:column property="descripcion" title="Descripcion" />
			                <display:column  title="Acciones" sortable="false">
				               	<div class="text-center">
				               		
				               			<a class="btn btn-primary" href="ServletEvento?tipo=suscribirModalidad&codevento=<%= codigoEvento %>&codmodalidad=${lista.codigo}"><i class="fa fa-plus" aria-hidden="true"></i>
				               			 Agregar</a>
				               		
				               	</div>
			                  
				            </display:column>
				        </display:table>
			         </div>
			         </form>
			         <div class="btn-toolbar">
			         	<div class="btn-group">
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selección</a>
			         	</div>
			         	<div class="btn-group">
						  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Acciones <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu">
						    <li><a href="#">Agregar seleccionadas</a></li>
						    
						  </ul>
						</div>
			         </div>
	     	 	</div>
           		<div class="col-md-3">
                 
                </div>  
	        </div>
	    </div>
	   </div>
    </section>
  </div>
 
 <jsp:include page="../_footer.jsp" flush="true" />