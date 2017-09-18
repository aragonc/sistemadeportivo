<%@page import="beans.ComboDTO"%>
<%@page import="service.ComboService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>
<%  
	ComboService listaDocumento = new ComboService();
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Equipos deportivos
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    	<div class="box-header with-border">
	              <h3 class="box-title">Listado de equipos</h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<a href="${pageContext.request.contextPath}/app/registrar_equipo.jsp" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar nuevo equipo</a>
		              <div class="box-body">
		              	<form class="form-horizontal">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" pagesize="10" requestURI="ServletEquipo?tipo=listar" excludedParams="tipo" id="lista">
		               		 		<display:column property="codigo" title="Codigo" sortable="false"/>
										<display:column property="nombre" title="Nombre Equipo" sortable="false"/>
										<display:column property="email" title="Email" sortable="false"/>
										<display:column title="Telefono Contacto" sortable="false">
											${lista.fono == '' ? 'No registrado' : lista.fono }
										</display:column>
										<display:column property="color" title="Color" sortable="false"/>	
										
										<display:column  title="Estado" sortable="false">
											${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
										</display:column>
										<display:column title="Acciones" sortable="false" media="html" >
										
											<div class="btn-group btn-group-sm" role="group">
												<a class="btn btn-default" title="Actualizar" href="ServletEquipo?tipo=buscar&cod=${lista.codigo}">
													<i class="fa fa-pencil" aria-hidden="true"></i>
												</a>
												<a class="btn btn-default" title="Detalle" href="ServletEquipo?tipo=detalle&cod=${lista.codigo}">
													<i class="fa fa-info-circle" aria-hidden="true"></i>
												</a>
												<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" class="btn btn-default" title="Eliminar" href="ServletEquipo?tipo=eliminar&cod=${lista.codigo}">
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