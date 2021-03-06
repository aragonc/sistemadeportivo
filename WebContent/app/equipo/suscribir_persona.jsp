<%@page import="java.util.ArrayList"%>
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
	String title = null;
	String data = request.getParameter("personas");
	EquipoDTO obj = (EquipoDTO)request.getAttribute("equipo");
	
	List<PersonaDTO> actual = obj.getJugadores();
	
	String genero = null;
	if(obj.getModalidad().getGenero()==1){
		genero = "Varones";
	} else if(obj.getModalidad().getGenero()==2){
		genero = "Mujeres";
	} else {
		genero = "Mixto";
	}
	
	String action = (String)request.getAttribute("accion");
	if(action.equals("agregar")){
		title = "Agregar jugadores ";
	} else {
		title = "Actualizar jugadores ";
	}
	
	ArrayList<String> xactual = new ArrayList<String>();
	for(PersonaDTO item : actual){
		xactual.add(item.getCodigo()+"");
		System.out.println("jugador: " + item.getCodigo());
	}
	
	String modalidad = obj.getModalidad().getDisciplina().getNombre() + " " + obj.getModalidad().getCategoria().getNombre() +  " - " + genero;
%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 <c:set var="total" value="<%= obj.getModalidad().getNumJugadores() %>"/>
 <c:set var="man" value="<%= obj.getModalidad().getNumVarones() %>"/>
 <c:set var="woman" value="<%= obj.getModalidad().getNumMujeres() %>"/>
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Equipo
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
	              <h3 class="box-title"><%= title %> <span class="valor"><%= obj.getNombre() %></span> en la modalidad <span class="valor"><%= modalidad %></span></h3>
	        </div>
        	<div class="box-body">
            	<div class="col-md-12">
            		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if(obj.getCodigo()!=0) { %>
		              	<div class="alert alert-success lista" role="alert">
		              		
		        			<ul class="lista-jugadores">
		        				<li class="criterio">Cantidad de jugadores a registrar: </li>
		        				<li id="numtotal" class="cantidad">
		        					<%= obj.getModalidad().getNumJugadores() %>
		        				</li>
		        				<li class="criterio">
		        					<img alt="Varones" title ="Varones" src="${pageContext.request.contextPath}/images/icons/32/boy.png">
		        				</li>
		        				<li id="numvarones" class="cantidad">
		        					<%= obj.getModalidad().getNumVarones() %>
		        				</li>
		        				<li class="criterio">
		        					<img alt="Mujeres" title ="Mujeres" src="${pageContext.request.contextPath}/images/icons/32/girl.png">
		        				</li>
		        				<li id="nummujeres" class="cantidad">
		        					<%= obj.getModalidad().getNumMujeres() %>
		        				</li>
		        			</ul>
		              		
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
						        
            				</div>
            				
            				<div class="col-md-9">
	            				
            				</div>
            			</div>
			       	</div>
		              <div class="box-body">
		              	<form class="form-horizontal" action="ServletEquipo?tipo=suscribirPersona" method="post" id="formlista">
		              		<input type="hidden" name="accion" value="<%= action %>">
		              		<input type="hidden" name="evento" value="<%= obj.getCodigo() %>">
		               		<div class="table-responsive">
		               			<display:table name="personas" class="table table-bordered" requestURI="ServletPersona?tipo=listar" excludedParams="tipo" id="lista">
	               		 			<display:setProperty name="basic.msg.empty_list">
	               		 				<div class="alert alert-warning" role="alert">No se existe personas registradas</div>
	               		 			</display:setProperty>                  		 				               		 			
	               		 			<display:column title="Item" sortable="false"  >
	               		 				
	               		 				<c:choose>
										    <c:when test="${lista.sexo == 1 }">
										        <input type="checkbox" id="people_${lista.codigo}" class="man" name="jugador[]" value="${lista.codigo}">
										    </c:when>    
										    <c:otherwise>
										        <input type="checkbox" id="people_${lista.codigo}" class="woman" name="jugador[]" value="${lista.codigo}">
										    </c:otherwise>
										</c:choose>
										
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
					         	<div class="btn-actions">
								  
								<button type="button" id="seleccion" class="btn btn-success">
						  			<i class="fa fa-plus" aria-hidden="true"></i>
						    		<%= title %>
						  		</button>
								  
								  <script type="text/javascript">
								  
								  $(document).ready(function(){
									  var total = ${total};
									  var varones = ${man};
									  var mujeres = ${woman};
									  var count = 0;
									  var countchecked_v = 0;
									  var countchecked_m = 0;
									  
									  var actual = <%= xactual %>;
							       		if(actual.length >= 0 ){
								       		console.log(actual);
								       		for ( var i = 0, l = actual.length; i < l; i++ ) {
								    			$("#people_"+actual[i]).prop('checked',true);
								    		}
							       		}
									  
									  $("table#lista input.man[type=checkbox]").click(function(){
										    countchecked_v = $("table#lista input.man[type=checkbox]:checked").length;
										    
										    if(countchecked_v >= varones) 
										    {
										    	
										        $('table#lista input.man[type=checkbox]').not(':checked').attr("disabled",true);
										    }
										    else
										    {
										    	
										    	$('table#lista input.man[type=checkbox]').not(':checked').attr("disabled",false);
										        
										    }
										    $("#numvarones").html(varones-countchecked_v);
										});
									  
									  $("table#lista input.woman[type=checkbox]").click(function(){
										    countchecked_m = $("table#lista input.woman[type=checkbox]:checked").length;

										    if(countchecked_m >= mujeres) 
										    {
										        $('table#lista input.woman[type=checkbox]').not(':checked').attr("disabled",true);
										    }
										    else
										    {
										        $('table#lista input.woman[type=checkbox]').not(':checked').attr("disabled",false);
										    }
										    $("#nummujeres").html(mujeres-countchecked_m);
										});
									  
									  document.getElementById("seleccion").onclick = function() {

										  	if((countchecked_v + countchecked_m) == 0 ){
										  		
										  		alert("Seleccionar la cantidad indicada");
										  		
										  	} else if(confirm('Por favor, confirme su elecci�n')){
									  			document.getElementById("formlista").submit();
									  		} else {
									  			false;
									  		}  
										}
								  });
								  
								  	
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
