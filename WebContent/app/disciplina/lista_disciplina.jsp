<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.DisciplinaDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 
  <div class="content-wrapper">
  	<section class="content-header">
      <h1>Disciplina</h1> 
    </section>
    <!-- Main content -->
    <section class="content">
       <div class="box box-primary">
       		<div class="box-header with-border">
	              <h3 class="box-title">Listado de disciplinas deportivas</h3>
	        </div>
           <div class="box-body">
	        <div class="col-md-9">
		        <div class="toolbar-actions">
		        	<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
				    	<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
				    </a>
			        <a href="${pageContext.request.contextPath}/app/disciplina/registrar_disciplina.jsp" >
			        	<img alt="Regresar al escritorio" title ="Registrar nueva disciplina" src="${pageContext.request.contextPath}/images/icons/32/nueva_disciplina.png">
			       	</a>
		       	</div>
	        	
	        		<form class="form-horizontal" action="ServletDisciplina?tipo=eliminar" method="post" id="formlista">
	        		<div class="table-responsive">
		        	<display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletDisciplina?tipo=listar"	excludedParams="tipo" id="lista">
		              	<display:setProperty name="basic.msg.empty_list">
	               		 					<div class="alert alert-warning" role="alert">No se existen disciplinas registradas</div>
	               		 				</display:setProperty>
		              	<display:column title="Item" sortable="false" media="html" >
							<input type="checkbox" name="cod[]" value="${lista.codigo}">
             		 	</display:column>
		                <display:column property="nombre" title="Nombre" sortable="false"/>
		                <display:column title="Estado" sortable="false">
		                	${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
		                </display:column>
		                <display:column  title="Acciones" sortable="false">
				              <div class="text-center">
				                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
				                    <a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
				                    <a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" href="ServletDisciplina?tipo=eliminar&cod[]=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
				                  </div>
				              </div>
		                  </display:column>
		                </display:table>
		                </div>
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
							    <li><a href="#" id="seleccion">Eliminar de la plataforma</a></li>
							  </ul>
							  	<script type="text/javascript">
									  	document.getElementById("seleccion").onclick = function() {
									  		if(confirm('Por favor, confirme su elección')){
									  			document.getElementById("formlista").submit();
									  		} else {
									  			false;
									  		}  
										}
								</script>
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
 
 <jsp:include page="../_footer.jsp" flush="true" />