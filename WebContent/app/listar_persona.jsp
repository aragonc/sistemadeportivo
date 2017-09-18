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
        Listar Personas
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Listar personas</li>
      </ol>
    </section>
    <section class="content">
    	<div class="box box-primary">
        	<div class="box-body">
            	<div class="col-md-9">
					<a href="${pageContext.request.contextPath}/app/registrar_persona.jsp" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar persona</a>
		              <div class="box-body">
		              	<form class="form-horizontal">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" pagesize="10" requestURI="ServletPersona?tipo=listar" excludedParams="tipo" id="lista">
		               		 		<display:column property="codigo" title="Codigo" sortable="false"/>
										<display:column property="nombre" title="Nombres" sortable="false"/>
										<display:column property="apaterno" title="Apellido Paterno" sortable="false"/>
										<display:column property="amaterno" title="Apellido Materno" sortable="false"/>
										<display:column property="email" title="Email" sortable="false"/>	
										<display:column title="Sexo" sortable="false">
											${lista.sexo == 1 ? '<span> Masculino </span>' : '<span> Femenino </span>'}
										</display:column>
										<display:column  title="Estado" sortable="false">
											${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
										</display:column>
										<display:column title="Acciones" sortable="false" media="html" >
										
											<div class="btn-group btn-group-sm" role="group">
												<a class="btn btn-default" title="Actualizar" href="ServletPersona?tipo=buscar&cod=${lista.codigo}">
													<i class="fa fa-pencil" aria-hidden="true"></i>
												</a>
												<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" class="btn btn-default" title="Eliminar" href="ServletPersona?tipo=eliminar&cod=${lista.codigo}">
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