<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.DisciplinaDTO"%>
<%@page import="java.util.List"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
  <div class="content-wrapper">
  	<section class="content-header">
      <h1>Lugares</h1> 
    </section>
    <!-- Main content -->
    <section class="content">
       <div class="box box-primary">
       		<div class="box-header with-border">
	              <h3 class="box-title">Listado de lugares deportivos</h3>
	        </div>
           <div class="box-body">
	        <div class="col-md-12">
		        <div class="toolbar-actions">
		        	<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
				    	<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
				    </a>
			        <a href="${pageContext.request.contextPath}/app/lugar/registrar_lugar.jsp" >
			        	<img alt="Regresar al escritorio" title ="Registrar nuevo lugar" src="${pageContext.request.contextPath}/images/icons/32/mapmarker.png">
			       	</a>
		       	</div>
	        	
	        		<form class="form-horizontal" action="ServletLugar?tipo=eliminar" method="post" id="formlista">
	        		<div class="table-responsive">
		        	<display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletLugar?tipo=listar"	excludedParams="tipo" id="lista">
		              	<display:column title="Item" sortable="false" media="html" >
							<input type="checkbox" name="cod[]" value="${lista.codigo}">
             		 	</display:column>
		                <display:column property="nombre" title="Nombre Lugar" sortable="false"/>
		                <display:column property="direccion" title="Dirección" sortable="false"/>
		                <display:column property="latitud" title="Latitud" sortable="false"/>
		                <display:column property="longitud" title="Longitud" sortable="false"/>
		                <display:column title="Estado" sortable="false">
		                	${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
		                </display:column>
		                <display:column  title="Acciones" sortable="false">
				              <div class="text-center">
				                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
				                    <a href="${pageContext.request.contextPath}/ServletLugar?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
				                    <a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" href="ServletLugar?tipo=eliminar&cod[]=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
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
           		
	        </div>
	    </div> 
    </section>
  </div>
 
 <%@ include file="../_footer.jsp" %>