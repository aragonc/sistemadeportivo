<%@page import="beans.ComboDTO"%>
<%@page import="service.ComboService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>
<%  
	ComboService listaDocumento = new ComboService();
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
%>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
   <div class="content-wrapper">
   <section class="content-header">
      <h1>Equipo</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    	<div class="box-header with-border">
	              <h3 class="box-title">Listado de equipos</h3>
	        </div>
        	<div class="box-body">
					
		              	<div class="toolbar-actions">
            			<div class="row">
            				<div class="col-md-6">
            					<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/ServletEquipo?tipo=agregar">
						        	<img alt="Registrar equipo" title="Registrar equipo" src="${pageContext.request.contextPath}/images/icons/32/add-groups.png">
						        </a>
            				</div>
            				<div class="col-md-6">
	            				<!-- <div class="pull-right">
	            					<form class="form-inline">
									  <div class="form-group">
									    <div class="input-group">
									      <input type="text" name="txtdni" class="form-control" id="txtdni" size="25" placeholder="Buscar por equipo deportivo">
									    </div>
									  </div>
									  <button type="submit" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i>
									   Buscar</button>
									</form>  -->
	            				</div>
            				</div>
            			</div>
			       	</div>
					
		              	<form class="form-horizontal" action="ServletEquipo?tipo=eliminar" method="post" id="formlista">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" pagesize="10" requestURI="ServletEquipo?tipo=listar" excludedParams="tipo" id="lista">
		               		 			
		               		 			<display:setProperty name="basic.msg.empty_list">
	               		 					<div class="alert alert-warning" role="alert">No se existe equipos registrados</div>
	               		 				</display:setProperty>
	               		 				<display:column title="Item" sortable="false"  >
											<input type="checkbox" name="cod[]" value="${lista.codigo}">
	               		 				</display:column>
										<display:column property="nombre" title="Nombre Equipo" sortable="false"/>
										<display:column property="descripcion" title="Descripci�n" sortable="false" style="width:20%"/>
										<display:column property="color" title="Color" sortable="false"/>	
										<display:column title="Delegado">
											${lista.delegado.nombre} ${ lista.delegado.apaterno } ${ lista.delegado.amaterno }
										</display:column>
										<display:column title="Modalidad">
											${lista.modalidad.disciplina.nombre} ${lista.modalidad.categoria.nombre} 
											${lista.modalidad.genero == 1 ? '<span> Varones </span>' : lista.modalidad.genero == 2 ? '<span> Mujeres </span>' : '<span> Mixto </span>'}
										</display:column>
										<display:column title="N� Jugadores">
											${lista.modalidad.numJugadores} 
										</display:column>
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
												<a onclick="javascript:if(!confirm('Por favor, confirme su elecci�n')) return false;" class="btn btn-default" title="Eliminar" href="ServletEquipo?tipo=eliminar&cod[]=${lista.codigo}">
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
    </section>
    </div>
  <%@ include file="../_footer.jsp" %>