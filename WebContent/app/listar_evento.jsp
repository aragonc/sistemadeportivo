<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>

 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
   <div class="content-wrapper">
    <section class="content-header">
      <h3>
        Eventos
      </h3>
    </section>
    <section class="content">
    	<div class="box box-primary">
    	<div class="box-header with-border">
	              <h3 class="box-title">Listado de eventos</h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<a href="${pageContext.request.contextPath}/app/registrar_evento.jsp" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Nuevo evento</a>
		              <div class="box-body">
		              	<form class="form-horizontal">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" pagesize="10" requestURI="ServletEvento?tipo=listar" excludedParams="tipo" id="lista">
		               		 			<display:column title="Item" sortable="false" media="html" >
		               		 				<div class="checkbox">
											    <input type="checkbox" name="evento[]" value="${lista.codigo}">
											</div>
		               		 			</display:column>
		               		 			<display:column property="codigo" title="Codigo" sortable="false"/>
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