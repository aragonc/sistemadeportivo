<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
  <div class="content-wrapper">
    <section class="content-header">
      <h3>Categorias de disciplina</h3> 
    </section>
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
           	<div class="box-header with-border">
	              <h3 class="box-title">Listado de categorias</h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-9">
			        <div class="toolbar-actions">
				        <a href="${pageContext.request.contextPath}/app/registrar_categoria.jsp" class="btn btn-primary">
				        	<i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Crear nueva categoria
				        </a>
			       	</div>
			        <div class="box-body table-responsive no-padding">
				        <display:table class="table table-bordered"  name="data" requestURI="../ServletCategoria?tipo=listar"	id="lista">
			                <display:column property="codigo" title="Codigo" />
			                <display:column property="nombre" title="Nombre" />
			                <display:column property="genero" title="Genero" />
			                <display:column property="cantidad" title="Cantidad" />
			                <display:column  title="Estado" sortable="false" >
			                	${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
			                </display:column>
			                
			                <display:column  title="Acciones" sortable="false">
			                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
			                    <a href="ServletCategoria?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
			                    <a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" href="ServletCategoria?tipo=eliminar&cod=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
			                  </div>
				            </display:column>
				        </display:table>
			         </div>
	     	 	</div>
           		<div class="col-md-3">
                 
                </div>  
	        </div>
	    </div>
	   </div>
    </section>
  </div>
 
 <jsp:include page="_footer.jsp" flush="true" />