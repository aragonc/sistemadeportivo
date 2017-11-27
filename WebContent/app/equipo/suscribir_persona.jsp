<%@page import="beans.EquipoDTO"%>
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
	String data = request.getParameter("data");
	EquipoDTO obj = (EquipoDTO)request.getAttribute("equipo");
%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Equipo
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
	              <h3 class="box-title">Asignar jugadores a equipo <span class="valor"><%= obj.getNombre() %></span></h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-12">
            		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if(obj.getCodigo()!=0) { %>
		              	<div class="alert alert-info" role="alert">
		              		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              		Acabas de crear un equipo a continuaci�n procede a asignar a sus <strong>JUGADORES </strong>
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
	            				
            				</div>
            			</div>
			       	</div>
		              <div class="box-body">
		              	<form class="form-horizontal" action="ServletEquipo?tipo=suscribirPersona" method="post" id="formlista">
		              		<input type="hidden" name="evento" value="<%= obj.getCodigo() %>">
		               		<div class="table-responsive">
		               			<display:table name="data" class="table table-bordered" requestURI="ServletPersona?tipo=listar" excludedParams="tipo" id="lista">
	               		 			<display:setProperty name="basic.msg.empty_list">
	               		 				<div class="alert alert-warning" role="alert">No se existe personas registradas</div>
	               		 			</display:setProperty>                  		 				               		 			
	               		 			<display:column title="Item" sortable="false"  >
										<input type="checkbox" name="jugador[]" value="${lista.codigo}">
	               		 			</display:column>
	               		 			
	               		 			<display:column title="Foto" sortable="false">
	               		 				<c:choose>
										    <c:when test="${lista.avatar != null }">
										        <img width="40px" src="${pageContext.request.contextPath}/uploads/${lista.avatar}" class="img-thumbnail">
										    </c:when>    
										    <c:otherwise>
										        <img width="40px" src="${pageContext.request.contextPath}/images/avatar.jpg" class="img-thumbnail">
										    </c:otherwise>
										</c:choose>
	               		 				
	               		 			</display:column>
	               		 			
	               		 			<display:column title="Apellidos y nombres" sortable="false">
	               		 				${lista.apaterno} ${lista.amaterno} , ${lista.nombre}
	               		 			</display:column>
									<display:column title="N� DNI">
										${lista.numdocumento}
									</display:column>
									<display:column property="email" title="Email" sortable="false"/>	
									<display:column title="Sexo" sortable="false">
										${lista.sexo == '1' ? '<span> Masculino </span>' : '<span> Femenino </span>'}
									</display:column>
									<display:column  title="Estado" sortable="false">
										${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
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
								    <li><a href="#" id="seleccion">Agregar seleccionados</a></li>
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
