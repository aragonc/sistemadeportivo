<%@page import="sun.invoke.empty.Empty"%>
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
	String data = request.getParameter("data");
%>
<% String nombreEquipo = (String)request.getAttribute("nomequipo"); %>
<% String codigoEquipo = (String)request.getAttribute("codequipo"); %>

 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Equipo
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
	              <h3 class="box-title">Asignar jugadores a equipo <span class="valor"><%= nombreEquipo %></span></h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-12">
            		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if(codigoEquipo!=null) { %>
		              	<div class="alert alert-info" role="alert">
		              		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              		Acabas de crear un equipo a continuación procede a asignar a sus <strong>JUGADORES </strong>
		              	</div>
		              <% } %>
			       	<!-- FIN DEL MENSAJE -->
            		<div class="toolbar-actions">
            			<div class="row">
            				<div class="col-md-3">
            					<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar">
						        		<img alt="Regresar a lista de eventos" title ="Regresar a lista de eventos" src="${pageContext.request.contextPath}/images/icons/32/back.png">
						        </a>
            					<a href="${pageContext.request.contextPath}">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/app/registrar_persona.jsp">
						        	<img alt="Registrar persona" title="Crear nueva categoria" src="${pageContext.request.contextPath}/images/icons/32/nuevo_usuario.png">
						        </a>
            				</div>
            				
            				<div class="col-md-9">
	            				<div class="pull-right">
	            					<form class="form-inline">
									  <div class="form-group">
									    <div class="input-group">
									      <input type="text" name="txtdni" class="form-control" id="txtdni" size="25" placeholder="Buscar persona">
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
		              	<form class="form-horizontal" action="ServletPersona?tipo=suscribirPersona" method="post" id="formlista">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" requestURI="ServletPersona?tipo=listar" excludedParams="tipo" id="lista">
	               		 			<display:setProperty name="basic.msg.empty_list">
	               		 				<div class="alert alert-warning" role="alert">No se existe personas registradas</div>
	               		 			</display:setProperty>                  		 				               		 			
	               		 			<display:column title="Item" sortable="false"  >
										<input type="checkbox" name="cod[]" value="${lista.codigo}">
	               		 			</display:column>
	               		 			<display:column title="Apellidos y nombres" sortable="false">
	               		 				${lista.apaterno} ${lista.amaterno} , ${lista.nombre}
	               		 			</display:column>
									
									<display:column property="email" title="Email" sortable="false"/>	
									<display:column title="Sexo" sortable="false">
										${lista.sexo == 'M' ? '<span> Masculino </span>' : '<span> Femenino </span>'}
									</display:column>
									<display:column  title="Estado" sortable="false">
										${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
									</display:column>
									<display:column title="Acciones" sortable="false" media="html" >
											<div class="text-center">
							               		<a class="btn btn-primary" href="ServletEvento?tipo=suscribirPersona&codevento=<%= codigoEquipo %>&modalidad[]=${lista.codigo}"><i class="fa fa-plus" aria-hidden="true"></i>
							               			Agregar
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
								    <li><a href="#" id="seleccion">Agregar seleccionados</a></li>
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
  <jsp:include page="../_footer.jsp" flush="true" />
