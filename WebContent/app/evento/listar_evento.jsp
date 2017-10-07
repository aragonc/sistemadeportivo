<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>
<% String xnombre = (String)request.getAttribute("nomevento"); %>
<% String xcodigo = (String)request.getAttribute("codevento"); %>

 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
   <div class="content-wrapper">
    <section class="content">
    	<div class="box box-primary">
    	<div class="box-header with-border">
	              <h3 class="box-title">Listado de eventos</h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-9">
            	
            		<div class="toolbar-actions">
            			<div class="row">
            				<div class="col-md-6">
            					<a href="${pageContext.request.contextPath}">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/app/registrar_evento.jsp">
						        	<img alt="Registrar persona" title="Crear nuevo evento" src="${pageContext.request.contextPath}/images/icons/32/nuevo_evento.png">
						        </a>
            				</div>
            				<div class="col-md-6">
	            				<div class="pull-right">
	            					<form class="form-inline">
									  <div class="form-group">
									    <div class="input-group">
									      <input type="text" name="txtdni" class="form-control" id="txtdni" size="25" placeholder="Buscar por nombre de evento">
									    </div>
									  </div>
									  <button type="submit" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i>
									   Buscar</button>
									</form>
	            				</div>
            				</div>
            			</div>
			        	
			       	</div>
					
		              <div class="box-body">
		              <% if(xnombre!=null) { %>
		              	<div class="alert alert-success" role="alert">
		              		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              		Acabas de crear el evento <span class="valor"><%= xnombre %></span> sin modalidades de juego <a href="#cod?<%= xcodigo %>" class="btn btn-success">¿Deseas agregar modalidades?</a>
		              	</div>
		              <% } %>
		              	<form class="form-horizontal">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered table-hover" pagesize="15" requestURI="ServletEvento?tipo=listar" excludedParams="tipo" id="lista">
		               		 			<display:column title="Item" sortable="false" media="html" >
		               		 				<div class="checkbox">
											    <input type="checkbox" name="evento[]" value="${lista.codigo}">
											</div>
		               		 			</display:column>
		               		 			
										<display:column property="nombre" title="Titulo Evento" sortable="false"/>
										<display:column property="descripcion" title="Descripción" sortable="false"/>
										<display:column property="fechaInicio" title="Fecha Inicio" sortable="false">
											
										</display:column>
										<display:column property="fechaFin" title="Fecha Fin" sortable="false"/>	
										
										<display:column  title="Estado" sortable="false">
											${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
										</display:column>
										
										<display:column title="Acciones" sortable="false" media="html" >
											<div class="btn-group btn-group-sm" role="group">
												<a class="btn btn-default" title="Actualizar" href="ServletEvento?tipo=buscar&cod=${lista.codigo}">
													<i class="fa fa-pencil" aria-hidden="true"></i>
												</a>
												<a class="btn btn-default" title="Detalle" href="ServletEvento?tipo=detalle&cod=${lista.codigo}">
													<i class="fa fa-info-circle" aria-hidden="true"></i>
												</a>
												<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" class="btn btn-default" title="Eliminar" href="ServletEvento?tipo=eliminar&cod=${lista.codigo}">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</a>
											</div>
										</display:column>
								</display:table>
		              		</div>
		              	</form>
		              </div>
            		</div>
                  <div class="col-md-3"></div>  
               </div>
             </div>
    </section>
    </div>
  <jsp:include page="_footer.jsp" flush="true" />