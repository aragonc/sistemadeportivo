<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>

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
					<a href="" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar persona</a>
		              <div class="box-body">
		              	<form class="form-horizontal">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-hover" pagesize="10" requestURI="ServletPersona?tipo=listar" export="true" excludedParams="tipo" id="userTable">
		               		 		<display:column property="codigo" title="Codigo" sortable="true"/>
										<display:column property="nombre" title="Nombres" sortable="true"/>
										<display:column property="apaterno" title="A. Paterno" sortable="true"/>
										<display:column property="amaterno" title="A. Materno" sortable="true"/>
										<display:column property="email" title="Email" sortable="true"/>	
										<display:column property="sexo" title="Sexo" sortable="true"/>
										<display:column property="estado" title="Estado" sortable="true"/>
										<display:column title="Acciones" sortable="false" media="html" >
										
											<div class="btn-group btn-group-sm" role="group">
												<a class="btn btn-default" title="Actualizar" href="ServletPersona?tipo=buscar&cod=${userTable.codUser}">
													<i class="fa fa-pencil" aria-hidden="true"></i>
												</a>
												<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" class="btn btn-default" title="Eliminar" href="ServletPersona?tipo=eliminar&cod=${userTable.codUser}">
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