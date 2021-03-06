<%@page import="java.util.ArrayList"%>
<%@page import="beans.EventoDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="java.util.List"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
   <div class="content-wrapper">
    <section class="content-header">
      <h1>Eventos</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    	<div class="box-header with-border">
	              <h3 class="box-title">Listado de eventos</h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-12">
            	
            		<div class="toolbar-actions">
            			<div class="row">
            				<div class="col-md-6">
            					<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/ServletEvento?tipo=agregar">
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
		              	
		              	<form class="form-horizontal" action="ServletEvento?tipo=eliminar" method="post" id="formlista">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered table-hover" pagesize="15" requestURI="ServletEvento?tipo=listar" excludedParams="tipo" id="lista">
		               		 			<display:setProperty name="basic.msg.empty_list">
	               		 					<div class="alert alert-warning" role="alert">No se existe eventos registrados</div>
	               		 				</display:setProperty>
		               		 			
		               		 			<display:column title="Item" sortable="false" media="html" >
											<input type="checkbox" name="cod[]" value="${lista.codigo}">
		               		 			</display:column>
		               		 			
										<display:column property="nombre" title="Titulo Evento" sortable="false" style="width:20%;"/>
										<display:column title="Lugar" sortable="false" media="html" style="width:20%;">
											<strong>${lista.lugar.nombre}</strong><br>
											${lista.lugar.direccion}
										</display:column>
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
												<a onclick="javascript:if(!confirm('Por favor, confirme su elecci�n')) return false;" class="btn btn-default" title="Eliminar" href="ServletEvento?tipo=eliminar&cod[]=${lista.codigo}">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</a>
											</div>
										</display:column>
								</display:table>
		              		</div>
		              		<div class="btn-toolbar">
					         	<div class="btn-group">
					         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
					         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selecci�n</a>
					         	</div>
					         	<div class="btn-group">
								  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Acciones <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="#" id="seleccion">Eliminar</a></li>
								  </ul>
								  <script type="text/javascript">
								  	document.getElementById("seleccion").onclick = function() {
								  		if(confirm('Por favor, confirme su elecci�n')){
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
             </div>
    </section>
    </div>
  <%@ include file="../_footer.jsp" %>