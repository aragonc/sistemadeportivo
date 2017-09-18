<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.DisciplinaDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h3>Disciplinas deportivas</h3> 
    </section>

    <!-- Main content -->
    <section class="content">
       <div class="box box-primary">
       		<div class="box-header with-border">
	              <h3 class="box-title">Listado de disciplinas</h3>
	        </div>
           <div class="box-body">
	        <div class="col-md-9">
	        <div class="toolbar-actions">
		        <a href="${pageContext.request.contextPath}/app/registrar_disciplina.jsp" class="btn btn-primary">
		        	<i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar disciplina</a>
		       
	       	</div>
	        <div class="box-body table-responsive no-padding">
	        
		        <display:table class="table table-bordered"  name="data" requestURI="../ServletDisciplina?tipo=listar"	excludedParams="tipo" id="lista">
		              
		                <display:column property="codigo" title="Codigo" sortable="false"/>
		                <display:column property="nombre" title="Nombre" sortable="false"/>
		                <display:column title="Estado" sortable="false">
		                	${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
		                </display:column>
		                <display:column  title="Acciones" sortable="false">
		              
		              <div class="text-center">
		                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
		                    <a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
		                    <a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" href="ServletDisciplina?tipo=eliminar&cod=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
		                  </div>
		              </div>
		                  
		                  </display:column>
		                 </display:table>
		        	
	         </div>
	     	 </div>
           		<div class="col-md-3">
                 
                 </div>  
	        </div>
	    </div> 
    </section>
  </div>
 
 <jsp:include page="_footer.jsp" flush="true" />