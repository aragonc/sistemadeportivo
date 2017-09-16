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
      <h3>Lista de disciplinas</h3> 
    </section>

    <!-- Main content -->
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
	        <div class="col-md-9">
	        <div class="toolbar-actions">
		        <a href="registrar_disciplina.jsp" class="btn btn-primary">
		        	<i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar disciplina</a>
		        	<a href="../ServletDisciplina?tipo=listar" class="btn btn-primary">
		        	<i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Listar</a>
	       	</div>
	        <div class="box-body table-responsive no-padding">
	        
		        <display:table class="dataTable"  name="data" requestURI="../ServletDisciplina?tipo=listar"	excludedParams="tipo" id="f">
		              
		                <display:column property="codigo" title="Codigo" sortable="true"/>
		                <display:column property="nombre" title="Nombre" sortable="true"/>
		                <display:column property="estado" title="Estado" sortable="true"/>
		                <display:column  title="Acciones" sortable="false">
		              
		              
		                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
		                    <a href="../ServletDisciplina?tipo=buscar&cod=${f.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
		                    <a href="../ServletDisciplina?tipo=eliminar&cod=${f.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
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