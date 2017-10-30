<%@page import="sun.invoke.empty.Empty"%>
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
	String data = request.getParameter("data");
%>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Personas
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
	              <h3 class="box-title">Listado de personas</h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-12">
            		<div class="toolbar-actions">
            			<div class="row">
            				<div class="col-md-3">
            					<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/app/persona/registrar_persona.jsp">
						        	<img alt="Registrar persona" title="Crear nueva categoria" src="${pageContext.request.contextPath}/images/icons/32/nuevo_usuario.png">
						        </a>
            				</div>
            				
            				<div class="col-md-9">
	            				<div class="pull-right">
	            					<form class="form-inline" action="ServletPersona?tipo=buscarPersonaXNombre" method="post">
									  <div class="form-group">
									    <div class="input-group">
									      <a><input type="text" name="txtNombre" class="form-control" id="txtNombre" placeholder="Ingrese Nombre"></a>
									      <a><input type="text" name="txtApellido" class="form-control" id="txtApellido" placeholder="Ingrese Apellido"></a>
									   <a><button type="submit" class="btn btn-primary">Buscar</button></a>
									    </div>
									  </div>
									  
									</form>
	            				</div>
            				</div>
            			</div>
			       	</div>
		              <div class="box-body">
		              	<form class="form-horizontal" action="ServletPersona?tipo=eliminar" method="post" id="formlista">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" requestURI="ServletPersona?tipo=listar" excludedParams="tipo" id="lista">
	               		 			<display:setProperty name="basic.msg.empty_list">
	               		 				<div class="alert alert-warning" role="alert">No se existe personas registradas</div>
	               		 			</display:setProperty>                  		 				               		 			
	               		 			<display:column title="Item" sortable="false"  >
										<input type="checkbox" name="cod[]" value="${lista.codigo}">
	               		 			</display:column>
	               		 			<display:column title="Foto" sortable="false">
	               		 				<img width="40px" src="${pageContext.request.contextPath}${lista.avatar}" class="img-thumbnail">
	               		 			</display:column>
									<display:column title="Apellidos y Nombres" sortable="false">
	               		 				${lista.apaterno} ${lista.amaterno} , ${lista.nombre}
	               		 			</display:column>
									<display:column property="email" title="Email" sortable="false"/>
									<display:column property="numdocumento" title="N° Documento" sortable="false"/>
									<display:column property="fnacimiento" title="Fecha Nacimiento" sortable="false"/>	
									<display:column title="Sexo" sortable="false">
										${lista.sexo == '1' ? '<span> Masculino </span>' : '<span> Femenino </span>'}
									</display:column>
									<display:column  title="Estado" sortable="false">
										${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
									</display:column>
									<display:column title="Acciones" sortable="false" media="html" >
										<div class="btn-group btn-group-sm" role="group">
											<a class="btn btn-default" title="Actualizar" href="ServletPersona?tipo=buscar&cod=${lista.codigo}">
												<i class="fa fa-pencil" aria-hidden="true"></i>
											</a>
											<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" class="btn btn-default" title="Eliminar" href="ServletPersona?tipo=eliminar&cod[]=${lista.codigo}">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</a>
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
								    <li><a href="#" id="seleccion">Eliminar</a></li>
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
             </div>
    </section>
    </div>
  <%@ include file="../_footer.jsp" %>
